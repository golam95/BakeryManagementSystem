package Settings;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JComponent;
import javax.swing.SwingUtilities;

public class GetColorParent implements PropertyChangeListener {

	JComponent componentToSwitch;

	public GetColorParent (JComponent c) { 
		
		
		componentToSwitch = c; 
	}

	public void propertyChange (PropertyChangeEvent e) {

		String name = e.getPropertyName ();

		if (name.equals ("lookAndFeel")) {
			SwingUtilities.updateComponentTreeUI (componentToSwitch);
			componentToSwitch.invalidate ();
			componentToSwitch.validate ();
			componentToSwitch.repaint ();
		}

	}

}