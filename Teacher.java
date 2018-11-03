package school;

import java.util.ArrayList;
import java.util.List;

public class Teacher {
	String name;
	String subject;
	List<Student> students = new ArrayList<>();
	public Teacher(String name) {
		this.name=name;
	}
	public void addStudent(Student student) {
		students.add(student);
	}
	public Student getStudent(String name) {
		for(Student stu: students) {
			if(stu.getName().equals(name)) {
				return stu;
			}
		}
		return null;
	}
	public double passAvg(){
		double curnumpass = 0;
		double totalstudents = 0;
		for (Student student: students) {
			Subject subject1 = student.getSubject(subject);
			if(subject1==null) {
				subject1 = new Subject(subject);
			}
			double average = subject1.averageScore();
			totalstudents++;
			if(average>=60) {
				curnumpass++;
			}
		}
		return (curnumpass/totalstudents)*100;
	}
		
	public String getName() {
		return name;
	}
	public List<Student> getStudents() {
		return students;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
}
