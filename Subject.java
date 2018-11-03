package school;

import java.util.ArrayList;
import java.util.List;


public class Subject {
	List<Test> tests = new ArrayList<>();
	String name;
	String key;
	
	public Subject(String name) {
		this.name=name;
	}
	public void addTest(Test test) {
		tests.add(test);
	}

	
	public double averageScore() {
		double total = 0;
		int index=0;
		for(Test test: tests) {
			total+=test.getScore();
			index++;
		}
		double average = total/index;
		if(index==0) {
			average = 0;
		}
		System.out.println(average);
		return average;
	}
	
	public double passingAvg() {
		double total = 0;
		int index=0;
		for(Test test: tests) {
			if(test.getGrade()!='F') {
				total+=test.getScore();
				index++;
			}
		}
		if(index==0) {
			return 0;
		}
		double average = total/index;
		return average;
	}
	
	public double gradeAvg(char grade) {
		double total = 0;
		int index=0;
		for(Test test: tests) {
			if(test.getGrade()==grade || grade=='Z') {
				total+=test.getScore();
				index++;
			}
			
		}
		if(index==0) {
			return 0;
		}
		double average = total/index;
		return average;
	}
	public double gradeMin(char grade) {
		double smallest_value = 100;
		for(Test test: tests) {
			if(test.getGrade()==grade) {
				if(smallest_value>test.getScore()) {
					smallest_value=test.getScore();
				}
			}
			
		}
		if(smallest_value==100) {
			return 0;
		}
		return smallest_value;
	}
	
	public double gradeMax(char grade) {
		double largest_value = 0;
		for(Test test: tests) {
			if(test.getGrade()==grade) {
				if(largest_value<test.getScore()) {
					largest_value=test.getScore();
				}
			}
			
		}
		if(largest_value==0) {
			return 0;
		}
		return largest_value;
	}
		
	public List<Test> getTests() {
		return tests;
	}
	public String getName() {
		return name;
	}
	

}
