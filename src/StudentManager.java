import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StudentManager {
	static List<Student> stu = new ArrayList<Student>();
	
	public static boolean addStudent(Student s) {// 插入学生信息
		
		try {
			stu.add(s);
			return true;
		} catch (Exception e) {

			// TODO: handle exception
		}
		return false;

	}

	public static Student findStudentByName(String name)// 查询学生信息
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

	public static boolean deleteStudent(String name) {// 删除学生信息
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



	public static List<Student> getAllStudent() {// 输出学生信息
		try {
			List<Student> result = stu.stream().sorted((a, b) -> a.getId() - b.getId()).collect(Collectors.toList());
			return result;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}

	
	


}
