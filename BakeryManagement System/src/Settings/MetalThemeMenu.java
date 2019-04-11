package Settings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.MetalTheme;

public class MetalThemeMenu extends JMenu implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MetalTheme[] themes;	//Program's Themes Array.

	//Constructor of Class.

	public MetalThemeMenu (String name, MetalTheme[] themeArray) {

		super (name);	//Setting the Theme Menu Name.

		themes = themeArray;
		ButtonGroup group = new ButtonGroup ();		//Creating the Themes Group.

		for (int i = 0; i < themes.length; i++) {	//Creating the Themes Menu.

			//Creating the Themes Radio Button by Getting their own Name.
			JRadioButtonMenuItem item = new JRadioButtonMenuItem (themes[i].getName());
			group.add (item);			//Adding theme into Group.
			add (item);
			item.setActionCommand (i + "");		//Setting the ActionCommand.
			item.addActionListener (this);		//Setting the theme's Action.
			if ( i == 0)
				item.setSelected (true);	//Setting the theme's Selection.

		}

	}

	//Action Performed by the Theme Menu.

	public void actionPerformed (ActionEvent e) {

	String numStr = e.getActionCommand ();					//Getting the Action Command.
	MetalTheme selectedTheme = themes [ Integer.parseInt (numStr) ];	//Converting the String into Integer.
	MetalLookAndFeel.setCurrentTheme (selectedTheme);			//Getting the Selected theme.

	try {		//Setting the Program's Look.
		UIManager.setLookAndFeel ("javax.swing.plaf.metal.MetalLookAndFeel");
	}
	catch (Exception ex) { }

	}

}
