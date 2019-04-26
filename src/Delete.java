import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class Delete extends JFrame {

	public Delete(){
		JLabel s = new JLabel("Please enter the name of the person you want to delete :");
		JTextField n = new JTextField();
		JButton d = new JButton("Delete");
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(3,1));
		p.add(s);
		p.add(n);
		p.add(d);
		p.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(p);

		d.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = n.getText();
				boolean flag = StudentManager.deleteStudent(name);
				if(flag){
					Message m = new Message("É¾³ý³É¹¦£¡");
				}else{
					Message m = new Message("É¾³ýÊ§°Ü£¡");
				}
				dispose();
			}
		});

		setTitle("Delete");
		setSize(360,200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Delete d = new Delete();
	}

}
