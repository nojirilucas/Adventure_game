package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Potion extends SuperObject {
		
	public OBJ_Potion() {
			setName("Potion");
			try {
				setImage((ImageIO.read(getClass().getResourceAsStream("/objects/potion.png"))));
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
}
