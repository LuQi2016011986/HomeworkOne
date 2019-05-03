import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class Message extends JFrame {

	private JTextArea m = new JTextArea();
	//private String mes = "";
	
	public Message(String s){
		/*
		* 功能：接收提示信息，并将该提示信息显示到新窗口中。
		* 输入：一个包含提示信息的字符串。
		* 输出：一个包含提示信息的新窗口。
		* */
		m.setLineWrap(true);
		m.setWrapStyleWord(true);
		m.setText(s);
		m.setEditable(false);
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(1,1));
		p.setBorder(new EmptyBorder(10, 10, 10, 10));
		p.add(new JScrollPane(m));
		
		add(p);
		setTitle("Message");
		setSize(360,200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

}
