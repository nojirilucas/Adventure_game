package main;

import java.awt.RenderingHints.Key;

import object.OBJ_Axe;
import object.OBJ_Chest;
import object.OBJ_Diamond;
import object.OBJ_Door;
import object.OBJ_Key;
import object.OBJ_Potion;

public class AssetSetter {
	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	public void setObject() {
		
		gp.obj[0] = new  OBJ_Key();
		gp.obj[0].setWorldX(23*gp.tileSize);
		gp.obj[0].setWorldY(7 * gp.tileSize);
		
		gp.obj[1] = new  OBJ_Key();
		gp.obj[1].setWorldX(23*gp.tileSize);
		gp.obj[1].setWorldY(40 * gp.tileSize);
		
		gp.obj[2] = new  OBJ_Key();
		gp.obj[2].setWorldX(37*gp.tileSize);
		gp.obj[2].setWorldY(7 * gp.tileSize);
		
		gp.obj[3] = new  OBJ_Door();
		gp.obj[3].setWorldX(4*gp.tileSize) ;
		gp.obj[3].setWorldY(11 * gp.tileSize) ;
		
		gp.obj[4] = new  OBJ_Door();
		gp.obj[4].setWorldX(9*gp.tileSize);
		gp.obj[4].setWorldY(5 * gp.tileSize);
		
		gp.obj[5] = new  OBJ_Door();
		gp.obj[5].setWorldX (9*gp.tileSize);
		gp.obj[5].setWorldY (16 * gp.tileSize);
		
		gp.obj[6] = new  OBJ_Chest();
		gp.obj[6].setWorldX(22*gp.tileSize);
		gp.obj[6].setWorldY(40 * gp.tileSize);
		
		gp.obj[7] = new  OBJ_Diamond();
		gp.obj[7].setWorldX(4*gp.tileSize);
		gp.obj[7].setWorldY(13 * gp.tileSize);
		
		gp.obj[8] = new  OBJ_Potion();
		gp.obj[8].setWorldX(23*gp.tileSize);
		gp.obj[8].setWorldY(30 * gp.tileSize);
		
		gp.obj[9] = new  OBJ_Axe();
		gp.obj[9].setWorldX(5*gp.tileSize);
		gp.obj[9].setWorldY(12 * gp.tileSize);
		
	}
}
