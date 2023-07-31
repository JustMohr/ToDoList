import java.io.FileWriter;
import java.util.ArrayList;

public class List extends AcListener{
	
	static ArrayList<String> aLS = new ArrayList<String>();
	
	public List() {
		
	}
	
//creatList------------------------------------------------------	
	static void creatList() {
		aLS.add(getNewItem());
		updateList();
		
		safeList();
		
		for(int i=0; i<aLS.size(); i++) {
			System.out.println(aLS.get(i));		
		}
		System.out.println();
		
	}
	

//removeItemFromList-----------------------------------------------
	static void deleteItem() {
		aLS.remove(getSelectItem());
		updateList();
		safeList();
	}
	
//prioritize
	static void prioritizeItem() {
		int prioPosMain =getSelectItem();
		int prioPos = prioPosMain-1;
		String prioStringMain;
		String prioString;
		
		prioStringMain= aLS.get(prioPosMain);
		prioString = aLS.get(prioPos);
		
		prioPos=prioPos+1;
		prioPosMain=prioPosMain-1;
		aLS.set(prioPos, prioString);
		aLS.set(prioPosMain, prioStringMain);
		
		updateList();
		safeList();
		
		//Gui.list.setSelectedIndex(prioPosMain);
		Gui.list.clearSelection();
	}
	
	
	
	
	
	
	
//update/refresh---------------------------------	
	static void updateList() {
		
		dLM.clear();
		int i=0;
		for(String load: List.aLS) {
			dLM.add(i, load);
			i++;
		}
	}
	
	static void safeList() {
		try {
			FileWriter writer = new FileWriter("/Users/justin/Documents/Eclipse/ToDoList/ListSave.txt"); 
			for(String str: aLS) {
			  writer.write(str + System.lineSeparator());
			}
			writer.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	

}








