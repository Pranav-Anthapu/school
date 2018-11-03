package school;

import java.util.Date;

public class Test {
	Date date;
	double score;
	char grade;
	String comments;
	public Test(double score, Date date) {
		this.score=score;
		this.date=date;
		this.grade=toGrade(score);
	}
	public char toGrade(double score) {
		char grading;
		if (score>=90) {
			grading= 'A';
		}
		else if (score>=80) {
			grading = 'B';
		}
		else if (score>=70) {
			grading = 'C';
		}
		else if(score>=60){
			grading = 'D';
		}
		else{
			grading = 'F';
		}
		
		return grading;
	}
	
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Date getDate() {
		return date;
	}
	public double getScore() {
		return score;
	}
	public char getGrade() {
		return grade;
	}
	

}
