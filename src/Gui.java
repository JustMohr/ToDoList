import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Gui extends JFrame{
	
	static DefaultListModel dLM = new DefaultListModel();
	
	
	static JPanel panelMitte;
	static JPanel panelOben;
	static JButton btnAdd;
	static JButton btnPrioritize;
	static JButton btnDelete;
	static JTextField textField;
	static JList list;
	static JScrollPane scrollPane;
	
	
	
	//font
	Font lsFont = new Font("", Font.PLAIN,12);
	
	public Gui() {

//refresh list-entry----------------------			
		dLM.clear();
		
		int i=0;
		for(String load: List.aLS) {
			dLM.add(i, load);
			i++;
		}	
		
		
//setup JFrame-----------------------------------		
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("ToDo list");
	
//List ScrollPane----------------------------------		
		list = new JList(dLM);
		scrollPane = new JScrollPane(list);
		scrollPane.setBounds(0, 0, 600, 400);
		
		//list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setFixedCellHeight(50);
		list.setCellRenderer(getRenderer());
		//list.setFont(lsFont);
		
		
//Oben---------------------------------------------		
		panelOben = new JPanel();
		panelOben.setBackground(Color.red);
		panelOben.setBounds(0,0, 600, 70);
		
			textField = new JTextField();
			textField.setBounds(10, 15, 210, 25);
			panelOben.add(textField);
			
			btnAdd= new JButton();
			btnAdd.setBounds(230, 15, 70, 25);
			btnAdd.setText("add");
			btnAdd.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					AcListener.add();			
				}			
			});
			
			
			btnDelete = new JButton();
			btnDelete.setBounds(310, 15, 70, 25);
			btnDelete.setText("done");
			btnDelete.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					AcListener.delete();	
				}
			});
		
			
			btnPrioritize = new JButton();
			btnPrioritize.setBounds(490, 15, 100, 25);
			btnPrioritize.setText("prioritize");
			
			btnPrioritize.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					AcListener.prioritize();					
				}				
			});
		
			
		panelOben.add(btnPrioritize);
		panelOben.add(btnAdd);	
		panelOben.add(btnDelete);	
		panelOben.setLayout(null);
		
		
		
		
//Mitte----------------------------------------------		
		panelMitte = new JPanel();
		panelMitte.setBackground(Color.blue);
		panelMitte.setBounds(0,70, 600, 400);
			panelMitte.add(scrollPane);			
		panelMitte.setLayout(null);
		
		
		add(panelOben);
		add(panelMitte);
		setLayout(null);
		setVisible(true);		
		
//remove Keylistener for JList-----------------------
		
		KeyListener[] keyListenerRemove = list.getKeyListeners();
		for(int ky=0; ky<keyListenerRemove.length; ky++) {
			System.out.println(keyListenerRemove[ky]);
			list.removeKeyListener(keyListenerRemove[ky]);
		}
		
//Button enable----------------------------------------
		btnAdd.setEnabled(false);
		btnDelete.setEnabled(false);
		btnPrioritize.setEnabled(false);
		
		
//add----------------------------------------------------
		list.addMouseListener(new MsListener());
		textField.getDocument().addDocumentListener(new DcListener());
		textField.addKeyListener(new KyListener());
	}
	
	
	//ListCellRenderer---------------------------------------------
	private ListCellRenderer<? super String> getRenderer() {
        return new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList<?> list,
                    Object value, int index, boolean isSelected,
                    boolean cellHasFocus) {
                JLabel listCellRendererComponent = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected,cellHasFocus);
                listCellRendererComponent.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,Color.BLACK));
                return listCellRendererComponent;
            }
        };
    }
	
	
}
