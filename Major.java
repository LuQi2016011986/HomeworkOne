import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class Major extends JFrame {
	
	private JLabel explain = new JLabel("<html><body>***********************************<br>*                           1  插入                                  *<br>*                           2  查找                                  *<br>*                           3  删除                                  *<br>*                           4  修改                                  *<br>*                           5  输出                                  *<br>*                           6  退出                                  *<br>***********************************<body></html>");
	private JButton one = new JButton(" 1 ");
	private JButton two = new JButton(" 2 ");
	private JButton three = new JButton(" 3 ");
	private JButton four = new JButton(" 4 ");
	private JButton five = new JButton(" 5 ");
	private JButton six = new JButton(" 6 ");
	
	public Major(){
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(2,3));
		p1.add(one);
		p1.add(two);
		p1.add(three);
		p1.add(four);
		p1.add(five);
		p1.add(six);
		one.setSize(60, 40);
		two.setSize(60, 40);
		three.setSize(60, 40);
		four.setSize(60, 40);
		five.setSize(60, 40);
		six.setSize(60, 40);
		
		JPanel p2 = new JPanel();
		p2.setLayout(new BorderLayout(10,10));
		p2.add(explain,BorderLayout.NORTH);
		p2.add(p1,BorderLayout.CENTER);
		p2.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(p2,BorderLayout.CENTER);

		ButtonListener b = new ButtonListener();
		one.addActionListener(b);
		two.addActionListener(b);
		three.addActionListener(b);
		four.addActionListener(b);
		five.addActionListener(b);
		six.addActionListener(b);

		setTitle("Major");
		setSize(300,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			/*
			 * 功能：响应主页面上的点击事件，对不同的点击结果分别进行操作。
			 * 输入：事件响应对象ActionEvent e
			 * 输出：无
			 * */
			if(e.getSource() == one){
				Input in = new Input();
			}else if(e.getSource() == two){
				Search s = new Search();
			}else if(e.getSource() == three){
				Delete d = new Delete();
			}else if(e.getSource() == four){
				EditSearch es = new EditSearch();
			}else if(e.getSource() == five){
				List<Student> result = StudentManager.getAllStudent();
				String ans = "";
				if(result.size()>0){
					for (int i = 0; i < result.size(); i++) {
						String ss = " ";
						if (result.get(i).getGender()) {
							ss = "女";
						} else {
							ss = "男";
						}
						ans += "学生ID: " + result.get(i).getId() + "\n学生姓名：" + result.get(i).getName() + "\n学生出生日期："
								+ result.get(i).getBirDate() + "\n学生性别：" + ss+"\n";
					}
				}else{
					ans="暂无数据";
				}
				Message m = new Message(ans);
			}else{
				dispose();
				System.exit(0);
			}
		}
	}

	public JFrame getFrame(){
		return this;
	}

}
