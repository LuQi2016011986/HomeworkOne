import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StudentManager {
	static List<Student> stu = new ArrayList<Student>();
	
	public static boolean addStudent(Student s) {// ����ѧ������Ϣ
		
		try {
			stu.add(s);
			return true;
		} catch (Exception e) {

			// TODO: handle exception
		}
		return false;

	}

	public static Student findStudentByName(String name)// ����ѧ������Ϣ
	{
		Student student = new Student();
		try {
			if (stu.size() == 0) {
				return null;
			} else {
				boolean flag = false;
				for (int i = 0; i < stu.size(); i++) {
					if (stu.get(i).getName().equals(name)) {
						student = stu.get(i);
						flag=true;
						break;
					}
				}
				if(flag)
				{
					return student;
				}
			}
			return null;

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}

	public static boolean deleteStudent(String name) {// ɾ��ѧ������Ϣ
		int size = stu.size();
		try {
			for (int i = 0; i < size; i++) {
				if (stu.get(i).getName().equals(name)) {
					stu.remove(i);
					return true;
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return false;
	}



	public static List<Student> getAllStudent() {// �������ѧ������Ϣ
		try {
			List<Student> result = stu.stream().sorted((a, b) -> a.getId() - b.getId()).collect(Collectors.toList());
			return result;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}

	public static void App(){//APP����
		Major m = new Major();
	}
	
	/*public Student update(String name){
		StudentManager s1= new StudentManager();
		
	}*/
	
	

	/*public static void main(String[] args) {//֮ǰ�Ĳ���

		StudentManager m = new StudentManager();
		Scanner in = new Scanner(System.in);
		
		while(true){
			System.out.print("������1-6����еĲ�����");
			int n = in.nextInt();
			
			switch (n) {
			case 1:          //����ѧ��ѧ�š��������������ڡ��Ա�
				System.out.print("������ѧ����Ϣ��");
				Student s = new Student();
				s.setId(in.nextInt());
				s.setName(in.next());
				s.setBirDate(in.next());
				String sex = in.next();
				boolean sgender;
				if (sex.equals("��")) {
					sgender = false;
				} else {
					sgender = true;
				}
				s.setGender(sgender);
				boolean a = m.addStudent(s);
				if (a) {
					System.out.println("����ɹ�");
				} else {
					System.out.println("����ʧ��");
				}

				break;
			case 2:      //����ѧ���������в���ѧ����Ϣ
				System.out.print("������Ҫ���ҵ�������");
				String sname=in.next();
				if (m.findStudentByName(sname) != null) {
					Student p = m.findStudentByName(sname);
					String ss = " ";
					if (p.getGender()) {
						ss = "Ů";
					} else {
						ss = "��";
					}
					System.out.println("ѧ��ID: " + p.getId() + "ѧ��������" + p.getName() + "ѧ���������ڣ�" + p.getBirDate() + "ѧ���Ա�" + ss);
				} else {
					System.out.println("����ʧ��");
				}
				break;
			case 3:     //����ѧ����������ѧ����Ϣ��ɾ��
				System.out.print("������Ҫɾ����ѧ��������");
				String sname1=in.next();
				boolean b = m.deleteStudent(sname1);
				if (b) {
					System.out.println("ɾ���ɹ�");
				} else {
					System.out.println("ɾ��ʧ��");
				}
				break;
			case 4:     //����ѧ����������ѧ����Ϣ�������޸�
				System.out.print("������Ҫ�޸ĵ�ѧ��������");
				String name=in.next();
				Student stu1=m.findStudentByName(name);
				if(stu1==null){
					System.out.println("�޴�ѧ����Ϣ");
				}else{
					System.out.println("ѧ��ԭ��ϢΪ��");
					
					Student p = m.findStudentByName(name);
					String ss = " ";
					if (p.getGender()) {
						ss = "Ů";
					} else {
						ss = "��";
					}
					System.out.println("ѧ��ID: " + p.getId() + "ѧ��������" + p.getName() + "ѧ���������ڣ�" + p.getBirDate() + "ѧ���Ա�" + ss);
					
					
					m.deleteStudent(name);
					
					System.out.println("�������޸ĺ�ĸ�����Ϣ��");
					
					Student s2 = new Student();
					s2.setId(in.nextInt());
					s2.setName(in.next());
					s2.setBirDate(in.next());
					String sex2 = in.next();
					boolean sgender2;
					if (sex2.equals("��")) {
						sgender2 = false;
					} else {
						sgender2 = true;
					}
					s2.setGender(sgender2);
					boolean flag2=m.addStudent(s2);
					if (flag2) {
						System.out.println("�޸ĳɹ�");
					} else {
						System.out.println("�޸�ʧ��");
					}
					
					
				}
			
				break;
			case 5:  //����ѧ��˳��������е�ѧ����Ϣ

				List<Student> result = m.getAllStudent();
				if(result.size()>0){
					for (int i = 0; i < result.size(); i++) {
						String ss = " ";
						if (result.get(i).getGender()) {
							ss = "Ů";
						} else {
							ss = "��";
						}
						System.out.println("ѧ��ID: " + result.get(i).getId() + "ѧ��������" + result.get(i).getName() + "ѧ���������ڣ�"
								+ result.get(i).getBirDate() + "ѧ���Ա�" + ss);
					}
				}else{
					System.out.println("��������");
				}
				
				break;
			case 6:  //�˳�����
				break;

			default:
				break;
			}
			if(n==6){
				System.out.println("���򼴽��˳�����л����ʹ��");
				break;
				
			}
				
			
		}
		

}
