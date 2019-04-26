import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class Input extends JFrame {

	public Input(){
		JLabel id = new JLabel("ID");
		JLabel name = new JLabel("Name");
		JLabel bir = new JLabel("Birth");
		JLabel gen = new JLabel("Gender");
		JTextField id2 = new JTextField();
		JTextField name2 = new JTextField();
		JTextField bir2 = new JTextField();
		JRadioButton man = new JRadioButton("man",false);
		JRadioButton woman = new JRadioButton("woman",true);
		ButtonGroup gen2 = new ButtonGroup();
		gen2.add(woman);
		gen2.add(man);
		JPanel p2 = new JPanel();
		p2.add(woman);
		p2.add(man);
		JButton submit = new JButton("Submit");
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(4,2));
		p.add(id);
		p.add(id2);
		p.add(name);
		p.add(name2);
		p.add(bir);
		p.add(bir2);
		p.add(gen);
		p.add(p2);
		p.setBorder(new EmptyBorder(10, 10, 10, 10));
		this.setLayout(new BorderLayout());
		this.add(p,BorderLayout.NORTH);
		this.add(submit,BorderLayout.CENTER);

		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = id2.getText();
				String name = name2.getText();
				String birth = bir2.getText();
				boolean gen = true;
				if(man.isSelected()){
					gen=false;
				}
				Student s = new Student(Integer.parseInt(id),name,birth,gen);
				boolean flag = StudentManager.addStudent(s);
				if(flag){
					Message m = new Message("插入成功！");
				}else{
					Message m = new Message("插入失败！");
				}
				dispose();
			}
		});

		this.setTitle("Input");
		this.setSize(300,300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Input m = new Input();
		//m.setTitle("666");
		//m.setSize(300,300);
		//m.setLocationRelativeTo(null);
		//m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//m.setVisible(true);
	}

}
