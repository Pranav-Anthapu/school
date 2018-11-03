package school;

import java.util.ArrayList;
import java.util.List;

public class Student {
	String name;
	int grade;
	List<Subject> subjects = new ArrayList<>();
	public Student(String name, int grade) {
		this.name=name;
		this.grade=grade;
	}
	public void addSubject(Subject subject) {
		subjects.add(subject);
	}
	public Subject getSubject(String name) {
		for(Subject sub: subjects) {
			if(sub.getName().equals(name)) {
				return sub;
			}
		}
		return null;
	}
	public String getName() {
		return name;
	}
	public int getGrade() {
		return grade;
	}
	public List<Subject> getSubjects() {
		return subjects;
	}
	

}
