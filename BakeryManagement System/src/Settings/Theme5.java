package Settings;

import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.metal.DefaultMetalTheme;

public class Theme5 extends DefaultMetalTheme {

	public String getName() {

		return "Gray";
	}

	private final ColorUIResource primary1 = new ColorUIResource(255,218,185);
	private final ColorUIResource primary2 = new ColorUIResource(192,192,192);
	private final ColorUIResource primary3 = new ColorUIResource(128,128,128);

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