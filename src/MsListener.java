import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MsListener extends MouseAdapter {
	
	private static int allreadySelect = -1;
	private static int checkSelect;
	
	public MsListener() {
	}
	
	
	public void mousePressed(MouseEvent event) {
		//checkSelect = Gui.list.locationToIndex(event.getPoint());
		checkSelect = Gui.list.getSelectedIndex();
		
		System.out.println(checkSelect);
		System.out.println(allreadySelect);
		
		if(allreadySelect!=checkSelect) {
			allreadySelect=checkSelect;
		}else if(allreadySelect==checkSelect) {
			Gui.list.clearSelection();
			allreadySelect=-1;
		}
		
		if(Gui.list.getSelectedIndex()!=-1) {
			Gui.btnDelete.setEnabled(true);
			Gui.btnPrioritize.setEnabled(true);
		}else {
			Gui.btnDelete.setEnabled(false);
			Gui.btnPrioritize.setEnabled(false);
		}
		
		if(Gui.list.getSelectedIndex()==0) {
			Gui.btnPrioritize.setEnabled(false);
		}
		
	}


	public static void setAllreadySelect(int allreadySelect) {
		MsListener.allreadySelect = allreadySelect;
	}
	
}
