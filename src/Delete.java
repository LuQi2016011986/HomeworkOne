import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
public class Delete extends JFrame {

	public Delete() {//删除指定学生信息的方法
		JLabel s = new JLabel("Please enter the name of the person you want to delete :");
		JTextField n = new JTextField();
		JButton d = new JButton("Delete");//创建按钮
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(3, 1));
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
				if (flag) {//删除的逻辑判断
					Message m = new Message("删除成功！");
				} else {
					Message m = new Message("删除失败！");
				}
				dispose();
			}
		});

		setTitle("Delete");
		setSize(360, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Delete d = new Delete();
	}

}
