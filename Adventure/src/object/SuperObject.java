package object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class SuperObject {
	
	private String name; 
	private boolean colision = false;
	private int worldX, worldY;
	private BufferedImage image;
	
	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isColision() {
		return colision;
	}

	public void setColision(boolean colision) {
		this.colision = colision;
	}

	public int getWorldX() {
		return worldX;
	}

	public void setWorldX(int worldX) {
		this.worldX = worldX;
	}

	public int getWorldY() {
		return worldY;
	}

	public void setWorldY(int worldY) {
		this.worldY = worldY;
	}
	
	public void draw(Graphics2D g2, GamePanel gp) {
		
		int screenX = worldX - gp.player.getWorldX() + gp.player.screenX; 
		int screenY = worldY - gp.player.getWorldY() + gp.player.screenY; 
		
		if(worldX + gp.tileSize > gp.player.getWorldX() - gp.player.screenX &&
		   worldX - gp.tileSize < gp.player.getWorldX() + gp.player.screenX &&
		   worldY + gp.tileSize  > gp.player.getWorldY() - gp.player.screenY &&
		   worldY - gp.tileSize < gp.player.getWorldY() + gp.player.screenY) {
			
			g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
		}
	}
}
