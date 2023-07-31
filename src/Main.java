import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[]args) {
		
		new Gui();
		
		try {
			Scanner s = new Scanner(new File("/Users/justin/Documents/Eclipse/ToDoList/ListSave.txt"));
			while (s.hasNextLine()){
			    List.aLS.add(s.nextLine());
			}
			s.close();
			
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		int i=0;
		for(String load: List.aLS) {
			Gui.dLM.add(i, load);
			i++;
			
		}	
		
	}
}
