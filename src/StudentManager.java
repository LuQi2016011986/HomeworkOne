import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentManager {
	static List<Student> stu = new ArrayList<Student>();// 创建一个student类型集合

	public static boolean addStudent(Student s) {// 插入学生的信息

		try {// 使用try-catch块很好的进行了规范，有利于异常的捕获和程序的健壮性
			stu.add(s);
			return true;
		} catch (Exception e) {

			// TODO: handle exception
		}
		return false;

	}

	public static Student findStudentByName(String name)// 查找学生的信息方法
	{
		Student student = new Student();
		try {
			if (stu.size() == 0) {// 使用if-else很好的判断了查找可能出现的各种情况
				return null;
			} else {
				boolean flag = false;
				for (int i = 0; i < stu.size(); i++) {
					if (stu.get(i).getName().equals(name)) {
						student = stu.get(i);
						flag = true;
						break;
					}
				}
				if (flag) {
					return student;
				}
			}
			return null;

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}

	public static boolean deleteStudent(String name) {// 删除学生的信息
		int size = stu.size();
		try {
			for (int i = 0; i < size; i++) {//遍历集合进行寻找
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

	public static List<Student> getAllStudent() {// 输出所有学生的信息
		try {
			List<Student> result = stu.stream().sorted((a, b) -> a.getId() - b.getId()).collect(Collectors.toList());
			return result;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}

	public static void App() {// APP方法
		Major m = new Major();
	}

	/*
	 * public Student update(String name){ StudentManager s1= new
	 * StudentManager();
	 * 
	 * }
	 */

	/*
	 * public static void main(String[] args) {//之前的测试
	 * 
	 * StudentManager m = new StudentManager(); Scanner in = new
	 * Scanner(System.in);
	 * 
	 * while(true){ System.out.print("请输入1-6想进行的操作："); int n = in.nextInt();
	 * 
	 * switch (n) { case 1: System.out.print("请输入学生信息："); Student s = new
	 * Student(); s.setId(in.nextInt()); s.setName(in.next());
	 * s.setBirDate(in.next()); String sex = in.next(); boolean sgender; if
	 * (sex.equals("男")) { sgender = false; } else { sgender = true; }
	 * s.setGender(sgender); boolean a = m.addStudent(s); if (a) {
	 * System.out.println("插入成功"); } else { System.out.println("插入失败"); }
	 * 
	 * break; case 2: System.out.print("请输入要查找的姓名："); String sname=in.next(); if
	 * (m.findStudentByName(sname) != null) { Student p =
	 * m.findStudentByName(sname); String ss = " "; if (p.getGender()) { ss =
	 * "女"; } else { ss = "男"; } System.out.println("学生ID: " + p.getId() +
	 * "学生姓名：" + p.getName() + "学生出生日期：" + p.getBirDate() + "学生性别：" + ss); }
	 * else { System.out.println("查找失败"); } break; case 3:
	 * System.out.print("请输入要删除的学生姓名："); String sname1=in.next(); boolean b =
	 * m.deleteStudent(sname1); if (b) { System.out.println("删除成功"); } else {
	 * System.out.println("删除失败"); } break; case 4:
	 * System.out.print("请输入要修改的学生姓名："); String name=in.next(); Student
	 * stu1=m.findStudentByName(name); if(stu1==null){
	 * System.out.println("无此学生信息"); }else{ System.out.println("学生原信息为：");
	 * 
	 * Student p = m.findStudentByName(name); String ss = " "; if
	 * (p.getGender()) { ss = "女"; } else { ss = "男"; } System.out.println(
	 * "学生ID: " + p.getId() + "学生姓名：" + p.getName() + "学生出生日期：" + p.getBirDate()
	 * + "学生性别：" + ss);
	 * 
	 * 
	 * m.deleteStudent(name);
	 * 
	 * System.out.println("请输入修改后的各项信息：");
	 * 
	 * Student s2 = new Student(); s2.setId(in.nextInt());
	 * s2.setName(in.next()); s2.setBirDate(in.next()); String sex2 = in.next();
	 * boolean sgender2; if (sex2.equals("男")) { sgender2 = false; } else {
	 * sgender2 = true; } s2.setGender(sgender2); boolean
	 * flag2=m.addStudent(s2); if (flag2) { System.out.println("修改成功"); } else {
	 * System.out.println("修改失败"); }
	 * 
	 * 
	 * }
	 * 
	 * break; case 5:
	 * 
	 * List<Student> result = m.getAllStudent(); if(result.size()>0){ for (int i
	 * = 0; i < result.size(); i++) { String ss = " "; if
	 * (result.get(i).getGender()) { ss = "女"; } else { ss = "男"; }
	 * System.out.println("学生ID: " + result.get(i).getId() + "学生姓名：" +
	 * result.get(i).getName() + "学生出生日期：" + result.get(i).getBirDate() +
	 * "学生性别：" + ss); } }else{ System.out.println("暂无数据"); }
	 * 
	 * break; case 6: break;
	 * 
	 * default: break; } if(n==6){ System.out.println("程序即将退出，感谢您的使用"); break;
	 * 
	 * }
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * /* Student s = new Student(8, "卢笨蛋", "2018-11-11", true); Student s1 =
	 * new Student(4, "卢笨蛋2", "2018-11-11", true); Student s2 = new Student(9,
	 * "卢笨蛋3", "2018-11-11", false);
	 * 
	 * StudentManager m = new StudentManager(); boolean a = m.addStudent(s);
	 * m.addStudent(s2); if (a) { System.out.println("插入成功"); } else {
	 * System.out.println("插入失败"); } boolean b1 = m.addStudent(s1); if (b1) {
	 * System.out.println("插入成功"); } else { System.out.println("插入失败"); }
	 * 
	 * List<Student> result=m.getAllStudent(); for(int i=0;i<result.size();i++){
	 * String ss = " "; if (result.get(i).getGender()) { ss = "女"; } else { ss =
	 * "男"; } System.out.println("学生ID: " + result.get(i).getId() + "学生姓名：" +
	 * result.get(i).getName() + "学生出生日期：" + result.get(i).getBirDate() +
	 * "学生性别：" + ss); }
	 */

	/*
	 * if (m.findStudentByName("卢笨蛋") != null) { Student p =
	 * m.findStudentByName("卢笨蛋"); String ss = " "; if (p.getGender()) { ss =
	 * "女"; } else { ss = "男"; } System.out .println("学生ID: " + p.getId() +
	 * "学生姓名：" + p.getName() + "学生出生日期：" + p.getBirDate() + "学生性别：" + ss); }
	 * else { System.out.println("查找失败"); }
	 */

	/* } */

}
