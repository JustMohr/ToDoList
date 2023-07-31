import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class DcListener implements DocumentListener{

	@Override
	public void insertUpdate(DocumentEvent e) {
		if(Gui.textField.getText().length()>=3) {
			Gui.btnAdd.setEnabled(true);
		}else {
			Gui.btnAdd.setEnabled(false);
		}
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		if(Gui.textField.getText().length()>=3) {
			Gui.btnAdd.setEnabled(true);
		}else {
			Gui.btnAdd.setEnabled(false);
		}		
	}
	
	@Override
	public void changedUpdate(DocumentEvent e) {
		System.out.println("stile changed");
		
	}

}
