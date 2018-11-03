package school;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import school.Student;
import school.Subject;
import school.Teacher;
import school.Test;

public class GradeTester {
//	static List<Student> students = new ArrayList<>();
	static HashMap<String, Student> studentsMap = new HashMap<>();
	static HashMap<String, Teacher> teachersMap = new HashMap<>();
	
	public static void addStudent(Student student) {
		studentsMap.put(student.getName(), student);
	}
	
	public static void addTeacher(Teacher teacher) {
		teachersMap.put(teacher.getName(), teacher);
	}
	
	public static Student getStudent(String studentsname) {
		return studentsMap.get(studentsname);	
	}
	
	public static Teacher getTeacher(String teachersname) {
		return teachersMap.get(teachersname);	
	}

	public static void main(String[] args) {
		//TODO Auto-generated method stub
		
		try {
			String teacherFile = args[0];
			String gradesFile = args[1];
			Teacher teacher = null;
			String line;
			FileReader fr = new FileReader(teacherFile);
			BufferedReader reader = new BufferedReader(fr);
			while( (line = reader.readLine()) != null ) {
				StringTokenizer tokens = new StringTokenizer(line, ",");
				String teachername = tokens.nextToken().trim();
				String studentname = tokens.nextToken().trim();
				String subjectname = tokens.nextToken().trim();
				teacher = getTeacher(teachername);
				if(teacher == null) {
					teacher = new Teacher(teachername);
					addTeacher(teacher);
				}
				
				Student student = getStudent(studentname);
				if(student==null) {
					student = new Student(studentname, 9) ;
					addStudent(student);
					Subject subject = student.getSubject(subjectname);
					if(subject==null) {
						subject = new Subject(subjectname);
					}
					student.addSubject(subject);
					teacher.setSubject(subjectname);
				}
				if(teacher.getStudent(studentname) == null) {
					teacher.addStudent(student);
				}
			}
			Student student = null;
			fr = new FileReader(gradesFile);
			reader = new BufferedReader(fr) ;
			while( (line = reader.readLine()) != null ) {
				StringTokenizer tokens = new StringTokenizer(line, ",");
				String studentname = tokens.nextToken().trim();
				String subjectname = tokens.nextToken().trim();
				String dateStr = tokens.nextToken().trim();
				String scoreStr = tokens.nextToken().trim();
				student = getStudent(studentname);
				if(student == null) {
					student = new Student(studentname, 9);
					addStudent(student);
				}
				student.addSubject(new Subject(subjectname));
				Subject subject = student.getSubject(subjectname);
				if(subject!=null) {
					Date date = new Date(dateStr);
					double score = Double.parseDouble(scoreStr);
					Test test = new  Test(score, date);
					subject.addTest(test);
				}
			}
			Scanner input = new Scanner(System.in);
			System.out.println("Enter teacher name:");
			String teachername = input.nextLine().trim();
			teacher = getTeacher(teachername);
			List<Student> students = teacher.getStudents();
			double total = 0;
			int counter = 0;
			for(Student student1 : students) {
				Subject subject = student1.getSubject(teacher.getSubject());
				total+=subject.averageScore();
				counter++;
			}
			double currentbest = 0;
			String bestNow = null;
			for (Student bestStudent : students) {
				Subject subject = bestStudent.getSubject(teacher.getSubject());
				List<Test> tests = subject.getTests();
				for (Test test: tests) {
					double score = test.getScore();
					if (score > currentbest) {
						currentbest = score;
					}
				}
				
			}
			double currentaverage = 0;
			for(Student bestStudent:students) {
				Subject subject = bestStudent.getSubject(teacher.getSubject());
				if(subject.averageScore()>currentaverage) {
					currentaverage = subject.averageScore();
					bestNow = bestStudent.getName();
				}
			}
			double teacherperc = 0;
			String teacherBest = null;
			for(Teacher bestTeacher:teachersMap.values()) {
				if(bestTeacher.passAvg()>teacherperc) {
					teacherperc=bestTeacher.passAvg();
					teacherBest = bestTeacher.getName();
				}
			}
			System.out.println("The average of all the scores is: " + total/counter);
			System.out.println("The best average belongs to: " + bestNow + " and the score is: " + currentbest);
			System.out.println("The teacher's percentage of passing students is:" + teacher.passAvg());
			System.out.println("The teacher who has the most number of students passing is:" + teacherBest);
			System.out.println("What subject's analysis do you want?");
			String mysubject = input.nextLine();
			Subject subject = student.getSubject(mysubject.trim());
			List<Test> tests = subject.getTests();
			for(Test test: tests) {
				System.out.println("Date: " + test.getDate()+", Score: " + test.getScore());	
			}
			System.out.println("The average of all the scores is: "+subject.gradeAvg('Z'));
			System.out.println("The average of all the passing scores is: "+subject.passingAvg());
			System.out.println("The average of all the A scores is: "+subject.gradeAvg('A'));
			System.out.println("The average of all the B scores is: "+subject.gradeAvg('B'));
			System.out.println("The average of all the C scores is: "+subject.gradeAvg('C'));
			System.out.println("The average of all the D is: "+subject.gradeAvg('D'));
			System.out.println("The average of all the failing scores is: "+subject.gradeAvg('F'));
			System.out.println("The minimum of all the A scores is: "+subject.gradeMin('A'));
			System.out.println("The minimum of all the B scores is: "+subject.gradeMin('B'));
			System.out.println("The minimum of all the C scores is: "+subject.gradeMin('C'));
			System.out.println("The minimum of all the D is: "+subject.gradeMin('D'));
			System.out.println("The minimum of all the failing scores is: "+subject.gradeMin('F'));
			System.out.println("The maximum of all the A scores is: "+subject.gradeMax('A'));
			System.out.println("The maximum of all the B scores is: "+subject.gradeMax('B'));
			System.out.println("The maximum of all the C scores is: "+subject.gradeMax('C'));
			System.out.println("The maximum of all the D is: "+subject.gradeMax('D'));
			System.out.println("The maximum of all the failing scores is: "+subject.gradeMax('F'));			
			
		
		}catch(Exception e) {
			e.printStackTrace();
		}


	}


}
