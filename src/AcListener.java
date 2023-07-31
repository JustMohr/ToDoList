
public class AcListener extends Gui{
	
//Variablen
	private static String newItem;
	private static int selectItem;
	
	
	public AcListener() {
		
	}
	
//Buttons-------------------	
	static void add() {
		newItem = textField.getText();
		
		if(newItem.length()>=3) {
			List.creatList();
			Gui.textField.setText("");
		}
		MsListener.setAllreadySelect(-1);
		Gui.textField.requestFocus();
	}
	
	
	static void delete() {
		selectItem = list.getSelectedIndex();
		//System.out.println(selectItem);
		if(selectItem >=0) {
			List.deleteItem();
		}
		MsListener.setAllreadySelect(-1);
		Gui.btnDelete.setEnabled(false);
		Gui.btnPrioritize.setEnabled(false);
	}
	
	static void prioritize() {
		//list.clearSelection();
		selectItem=list.getSelectedIndex();
		if(selectItem>=1) {
			List.prioritizeItem();
		}
		MsListener.setAllreadySelect(-1);
		Gui.btnDelete.setEnabled(false);
		Gui.btnPrioritize.setEnabled(false);
	}
	
	

//getter--------------------
	public static String getNewItem() {
		return newItem;
	}

	public static int getSelectItem() {
		return selectItem;
	}
	
//setter----------------------
	public static void setNewItem(String newItem) {
		AcListener.newItem = newItem;
	}

}
