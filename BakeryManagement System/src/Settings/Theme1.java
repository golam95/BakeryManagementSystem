package Settings;
import javax.swing.plaf.*;
import javax.swing.plaf.metal.*;
public class Theme1 extends DefaultMetalTheme {

	public String getName() {

		return "Olive";
	}
	// greenish colors
	private final ColorUIResource primary1 = new ColorUIResource (255,255,255);
	private final ColorUIResource primary2 = new ColorUIResource (255,255,255);
	private final ColorUIResource primary3 = new ColorUIResource(128,128,0);

	protected ColorUIResource getPrimary1() { return primary1; }
	protected ColorUIResource getPrimary2() { return primary2; }
	protected ColorUIResource getPrimary3() { return primary3; }

}
