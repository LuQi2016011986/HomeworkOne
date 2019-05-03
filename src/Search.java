import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Search extends JFrame {//查询指定学生信息

	public Search(){
		JLabel s = new JLabel("Please enter the name of the person you are looking for :");
		JTextField n = new JTextField();
		JButton sea = new JButton("Search");
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(3,1));
		p.add(s);
		p.add(n);
		p.add(sea);
		p.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(p);

		sea.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = n.getText();
				Student ans = StudentManager.findStudentByName(name);
				if(ans != null){//查询到人，输出所查询到的信息
					String out = "";
					out += "ID:"+ans.getId()+"\nName:"+ans.getName()+"\nBirth:"+ans.getBirDate()+"\nGender:";
					if(ans.getGender()){
						out += "女";
					}else{
						out += "男";
					}
					Message m = new Message(out);
				}else{//不存在所查询的人
					Message m = new Message("查无此人！");
				}
				dispose();
			}
		});
		setTitle("Search");
		setSize(360,200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Search s = new Search();
	}

}
