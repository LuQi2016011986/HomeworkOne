import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class Message extends JFrame {

	private JTextArea m = new JTextArea();
	//private String mes = "";
	
	public Message(String s){
		m.setLineWrap(true);
		m.setWrapStyleWord(true);
		m.setText(s);
		m.setEditable(false);
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(1,1));
		p.setBorder(new EmptyBorder(10, 10, 10, 10));
		p.add(new JScrollPane(m));
		//p.add(m);
		
		add(p);
		setTitle("Message");
		setSize(360,200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Message m = new Message("tishi\ntishi\ntishi\ntishi\ntishi\ntishi\ntishi\ntishi\ntishi\ntishi\n");
	}

}
