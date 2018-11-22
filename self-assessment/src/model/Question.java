package model;

public class Question {
	private String[] answers;
	
	public String[] getAnswers() {
		return answers;
	}

	public void setAnswers(String[] answers) {
		this.answers = answers;
	}

	public Question(String[] answers) {
		this.answers = answers;
	}

	public Boolean isCorrectAnswer(String givenAnswer) {
		if (answers[0].equals(givenAnswer)) return true;
		return false;
	}
}
