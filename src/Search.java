import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Search extends JFrame {//��ѯָ��ѧ����Ϣ

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
				if(ans != null){//��ѯ���ˣ��������ѯ������Ϣ
					String out = "";
					out += "ID:"+ans.getId()+"\nName:"+ans.getName()+"\nBirth:"+ans.getBirDate()+"\nGender:";
					if(ans.getGender()){
						out += "Ů";
					}else{
						out += "��";
					}
					Message m = new Message(out);
				}else{//����������ѯ����
					Message m = new Message("���޴��ˣ�");
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
