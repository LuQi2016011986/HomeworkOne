import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class EditSearch extends JFrame{
    public EditSearch(){//修改学生信息界面
        JLabel s = new JLabel("Please enter the person you want to modify :");
        JTextField n = new JTextField();
        JButton sea = new JButton("Search");

        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(3,1));
        jp.add(s);
        jp.add(n);
        jp.add(sea);
        jp.setBorder(new EmptyBorder(10, 10, 10, 10));
        add(jp);

        sea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = n.getText();
                Student ans = StudentManager.findStudentByName(name);
                if(ans != null){
                    Edit ed = new Edit(ans.getId()+"",ans.getName(),ans.getBirDate(),ans.getGender());
                    StudentManager.deleteStudent(ans.getName());
                }else{
                    Message m = new Message("查无此人！");
                }
                dispose();
            }
        });

        setTitle("EditSearch");
        setSize(360,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public class Edit extends JFrame {
        public Edit(String theId, String theName, String theBir, boolean gender) {
            JLabel id = new JLabel("ID");
            JLabel name = new JLabel("Name");
            JLabel bir = new JLabel("Birth");
            JLabel gen = new JLabel("Gender");
            JTextField id2 = new JTextField(theId);
            JTextField name2 = new JTextField(theName);
            JTextField bir2 = new JTextField(theBir);
            JRadioButton man;//= new JRadioButton("man",false);
            JRadioButton woman;// = new JRadioButton("woman",true);
            if (gender) {
                man = new JRadioButton("man", false);
                woman = new JRadioButton("woman", true);
            } else {
                man = new JRadioButton("man", true);
                woman = new JRadioButton("woman", false);
            }
            ButtonGroup gen2 = new ButtonGroup();
            gen2.add(woman);
            gen2.add(man);
            JPanel p2 = new JPanel();
            p2.add(woman);
            p2.add(man);
            JButton submit = new JButton("Submit");

            JPanel p = new JPanel();
            p.setLayout(new GridLayout(4, 2));
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
            this.add(p, BorderLayout.NORTH);
            this.add(submit, BorderLayout.CENTER);

            submit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String id = id2.getText();
                    String name = name2.getText();
                    String birth = bir2.getText();
                    boolean gen = true;
                    if (man.isSelected()) {
                        gen = false;
                    }
                    Student s = new Student(Integer.parseInt(id), name, birth, gen);
                    boolean flag = StudentManager.addStudent(s);
                    if (flag) {
                        Message m = new Message("修改成功！");
                    } else {
                        Message m = new Message("修改失败！");
                    }
                    dispose();
                }
            });

            this.setTitle("Edit");
            this.setSize(300,300);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.setVisible(true);
        }
    }
}

