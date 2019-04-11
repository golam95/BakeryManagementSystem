package Settings;

import javax.swing.plaf.*;
import javax.swing.plaf.metal.*;

public class Theme2 extends DefaultMetalTheme {

	public String getName() {

		return "LightBlue";

	}

	private final ColorUIResource primary1 = new ColorUIResource(192, 192, 192);
	private final ColorUIResource primary2 = new ColorUIResource(192, 192, 192);
	private final ColorUIResource primary3 = new ColorUIResource(173, 216, 230);

	protected ColorUIResource getPrimary1() {
		return primary1;
	}

	protected ColorUIResource getPrimary2() {
		return primary2;
	}

	protected ColorUIResource getPrimary3() {
		return primary3;
	}

}
