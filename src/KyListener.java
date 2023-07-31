import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KyListener implements KeyListener{
	
	public KyListener() {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getExtendedKeyCode()==KeyEvent.VK_ENTER) {
			AcListener.setNewItem(Gui.textField.getText());
			
			if(AcListener.getNewItem().length()>=3) {
				List.creatList();
				Gui.textField.setText("");
				MsListener.setAllreadySelect(-1);
			}
			Gui.textField.requestFocus();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
