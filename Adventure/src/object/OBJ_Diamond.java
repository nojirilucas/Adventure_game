package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Diamond extends SuperObject {
	public OBJ_Diamond() {
		setName("Diamante");
		try {
			setImage((ImageIO.read(getClass().getResourceAsStream("/objects/diamond.png"))));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
