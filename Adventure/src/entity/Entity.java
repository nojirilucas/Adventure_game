package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
	private int worldX, worldY;
	private int speed;
	
	private BufferedImage up0, up1, up2, up3, down0, down1, down2, down3;
	private BufferedImage left0, left1, left2, left3, right0, right1, right2, right3;
	private String direction;
	
	private int spriteCounter = 0;
	private int spriteNum = 1;
	
	public Rectangle solidArea; //invisible retagulo
	private boolean collisionOn = false;
	
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
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
	public BufferedImage getUp0() {
		return up0;
	}
	public void setUp0(BufferedImage up0) {
		this.up0 = up0;
	}
	public BufferedImage getUp1() {
		return up1;
	}
	public void setUp1(BufferedImage up1) {
		this.up1 = up1;
	}
	public BufferedImage getUp2() {
		return up2;
	}
	public void setUp2(BufferedImage up2) {
		this.up2 = up2;
	}
	public BufferedImage getUp3() {
		return up3;
	}
	public void setUp3(BufferedImage up3) {
		this.up3 = up3;
	}
	public BufferedImage getDown0() {
		return down0;
	}
	public void setDown0(BufferedImage down0) {
		this.down0 = down0;
	}
	public BufferedImage getDown1() {
		return down1;
	}
	public void setDown1(BufferedImage down1) {
		this.down1 = down1;
	}
	public BufferedImage getDown2() {
		return down2;
	}
	public void setDown2(BufferedImage down2) {
		this.down2 = down2;
	}
	public BufferedImage getDown3() {
		return down3;
	}
	public void setDown3(BufferedImage down3) {
		this.down3 = down3;
	}
	public BufferedImage getLeft0() {
		return left0;
	}
	public void setLeft0(BufferedImage left0) {
		this.left0 = left0;
	}
	public BufferedImage getLeft1() {
		return left1;
	}
	public void setLeft1(BufferedImage left1) {
		this.left1 = left1;
	}
	public BufferedImage getLeft2() {
		return left2;
	}
	public void setLeft2(BufferedImage left2) {
		this.left2 = left2;
	}
	public BufferedImage getLeft3() {
		return left3;
	}
	public void setLeft3(BufferedImage left3) {
		this.left3 = left3;
	}
	public BufferedImage getRight0() {
		return right0;
	}
	public void setRight0(BufferedImage right0) {
		this.right0 = right0;
	}
	public BufferedImage getRight1() {
		return right1;
	}
	public void setRight1(BufferedImage right1) {
		this.right1 = right1;
	}
	public BufferedImage getRight2() {
		return right2;
	}
	public void setRight2(BufferedImage right2) {
		this.right2 = right2;
	}
	public BufferedImage getRight3() {
		return right3;
	}
	public void setRight3(BufferedImage right3) {
		this.right3 = right3;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public int getSpriteCounter() {
		return spriteCounter;
	}
	public void setSpriteCounter(int spriteCounter) {
		this.spriteCounter = spriteCounter;
	}
	public int getSpriteNum() {
		return spriteNum;
	}
	public void setSpriteNum(int spriteNum) {
		this.spriteNum = spriteNum;
	}
	public boolean isCollisionOn() {
		return collisionOn;
	}
	public void setCollisionOn(boolean collisionOn) {
		this.collisionOn = collisionOn;
	}
	
}
