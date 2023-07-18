package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {
	GamePanel gp;
	KeyHandler keyH;
	
	public final int screenY;
	public final int screenX;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		
		this.gp = gp;
		this.keyH = keyH;
		
		screenX = gp.screenWidth/2 -  (gp.tileSize/2);
		screenY = gp.screenHeight/2 - (gp.tileSize/2);
		
		solidArea =  new Rectangle();
		solidArea.x = 8;
		solidArea.y = 16;
		solidArea.width = 32;
		solidArea.height = 32;
		
		setDefaultValues();
		getPlayerImage();
	}
	public void setDefaultValues() {
		setWorldX (gp.tileSize *23);
		setWorldY( gp.tileSize *21);
		setSpeed(10);
		setDirection("down");
	}
	public void getPlayerImage() {
		
		try {
			setUp0(ImageIO.read(getClass().getResourceAsStream("/player/up_0.png")));
			setUp1(ImageIO.read(getClass().getResourceAsStream("/player/up_1.png")));
			setUp2(ImageIO.read(getClass().getResourceAsStream("/player/up_2.png")));
			setUp3(ImageIO.read(getClass().getResourceAsStream("/player/up_3.png")));
			setDown0(ImageIO.read(getClass().getResourceAsStream("/player/down_0.png")));
			setDown1(ImageIO.read(getClass().getResourceAsStream("/player/down_1.png")));
			setDown2(ImageIO.read(getClass().getResourceAsStream("/player/down_2.png")));
			setDown3(ImageIO.read(getClass().getResourceAsStream("/player/down_3.png")));
			setLeft0(ImageIO.read(getClass().getResourceAsStream("/player/run_a0.png")));
			setLeft1(ImageIO.read(getClass().getResourceAsStream("/player/run_a1.png")));
			setLeft2(ImageIO.read(getClass().getResourceAsStream("/player/run_a2.png")));
			setLeft3(ImageIO.read(getClass().getResourceAsStream("/player/run_a3.png")));
			setRight0(ImageIO.read(getClass().getResourceAsStream("/player/run_d0.png")));
			setRight1(ImageIO.read(getClass().getResourceAsStream("/player/run_d1.png")));
			setRight2(ImageIO.read(getClass().getResourceAsStream("/player/run_d2.png")));
			setRight3(ImageIO.read(getClass().getResourceAsStream("/player/run_d3.png")));
			
		}catch(IOException e) {
			e.printStackTrace();
		} 
	}
	public void update() {
		
		if(keyH.upPressed == true || keyH.downPressed == true ||
				keyH.leftPressed == true || keyH.rightPressed == true) {
			if(keyH.upPressed == true) {
				setDirection ("up");
				
			}
			else if(keyH.downPressed == true) {
				setDirection("down");
				
			}
			else if(keyH.leftPressed == true) {
				setDirection("left");
			
			}
			else if(keyH.rightPressed == true) {
				setDirection("right");
				
			}
			
			//CHECK TILE COLLISION
			setCollisionOn(false);
			gp.cChecker.checkTile(this);
			//IF COLLISION IS FALSE, PLAYER CAN MOVE
			if(isCollisionOn() == false) {
				switch (getDirection()) {
				case "up":
					setWorldY(getWorldY() - getSpeed());
					break;
				case "down":
					setWorldY(getWorldY() + getSpeed());
					break;
				case "left":
					setWorldX(getWorldX() - getSpeed());
					break;
				case "right":
					setWorldX(getWorldX() + getSpeed());
					break;
				}
			}
			
			setSpriteCounter(getSpriteCounter() + 1);
			if(getSpriteCounter() > 12) {
				if(getSpriteNum() == 1) {
					setSpriteNum(2);
				}
				else if(getSpriteNum() == 2) {
					setSpriteNum(3);
				}
				else if(getSpriteNum() == 3) {
					setSpriteNum(4);
				}
				else if(getSpriteNum() == 4) {
					setSpriteNum(1);
				}
				setSpriteCounter(0);
			}
		}
		else {setSpriteNum(1);}
	}
	public void draw(Graphics2D g2) {
		
//		g2.setColor(Color.white);
//		g2.fillRect(x, y, gp.tileSize, gp.tileSize);
		
		BufferedImage image = null;
		
		switch(getDirection()) {
		case "up":
			if(getSpriteNum() == 1) {image = getUp0();}
			if(getSpriteNum() == 2) {image = getUp1();}
			if(getSpriteNum() == 3) {image = getUp2();}
			if(getSpriteNum() == 4) {image = getUp3();}
			break;
		case "down":
			if(getSpriteNum() == 1) {image = getDown0();}
			if(getSpriteNum() == 2) {image = getDown1();}
			if(getSpriteNum() == 3) {image = getDown2();}
			if(getSpriteNum() == 4) {image = getDown3();}
			
			break;
		case "left":
			if(getSpriteNum() == 1) {image = getLeft0();}
			if(getSpriteNum() == 2) {image = getLeft1();}
			if(getSpriteNum() == 3) {image = getLeft2();}
			if(getSpriteNum() == 4) {image = getLeft3();}
			
			break;
		case "right":
			if(getSpriteNum() == 1) {image = getRight0();}
			if(getSpriteNum() == 2) {image = getRight1();}
			if(getSpriteNum() == 3) {image = getRight2();}
			if(getSpriteNum()== 4) {image = getRight3();}
			
			break;
		}
		g2.drawImage(image,screenX, screenY, gp.tileSize, gp.tileSize, null);
		
	}
}
