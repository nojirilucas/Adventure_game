package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import object.SuperObject;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable{
	
	//SCREEN SETTIGS 
	final int originalTilesSize = 16 ;//16x16
	final int scale = 3;
	
	public final int tileSize = originalTilesSize *scale; //48x48 tile
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 12;
	public final int screenWidth = tileSize * maxScreenCol; //768 pixels
	public final int screenHeight = tileSize * maxScreenRow; //576 pixels
	
	//WOLRD SETTINGS 
	public final int maxWorldCol = 46;
	public final int maxWorldRow = 45;
	public final int worldWidth = tileSize * maxWorldCol;
	public final int worldHeight = tileSize * maxWorldRow;
	//FPS
	int FPS = 60;
	
	TileManager tileM = new TileManager(this);
	KeyHandler keyH = new KeyHandler ();
	Thread gameThread;
	public CollisionChecker cChecker = new CollisionChecker(this);
	public AssetSetter aSetter = new AssetSetter(this);
	public Player player = new Player(this, keyH);
	public SuperObject obj[] = new SuperObject[10];
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	
	public void setupGame() {
		aSetter.setObject();
	}
	
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	@Override
//	public void run() { //loop
//		
//		double drawInterval = 1000000000/FPS; //0.016666 seconds
//		double nextDrawTime = System.nanoTime() + drawInterval;
//		
//		while(gameThread != null) {
//			//1 UPADATE:update information such as character positions
//			//2 DRAW: draw the screen whit update information	
//			update();
//			
//			repaint();
//			
//			try {
//				double remainingTime = nextDrawTime -System.nanoTime();
//				remainingTime = remainingTime/1000000;
//				
//				if(remainingTime < 0) {
//					remainingTime = 0;
//				}
//				
//				Thread.sleep((long) remainingTime);
//				
//				nextDrawTime += drawInterval; 
//			} 
//			catch (InterruptedException e) {
//				e.printStackTrace();
//			}	
//		}
//		
//	}
public void run() { //loop
		
		double drawInterval = 1000000000/FPS; //0.016666 seconds
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;
		while(gameThread != null) {
			currentTime = System.nanoTime();
			delta+= (currentTime - lastTime)/drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			if(delta >= 1) {
				update();
				repaint();
				delta --; 
				drawCount++;
			}
			if(timer >= 1000000000) {
				System.out.println("FPS:"+ drawCount);
				drawCount = 0;
				timer = 0;
			}
		}
}
	public void update() {
		player.update();
	}
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		//TILE
		tileM.draw(g2);
		
		//OBJECT
		for(int i = 0; i< obj.length; i++) {
			if(obj[i] != null) {
				obj[i].draw(g2, this);
			}
		}
		
		//PLAYER
		player.draw(g2);
		
		g2.dispose(); //boa pratica
	}
}
