package model;

public class Question {
	private String questionName;
	private String[] answers; //index 0 is correct answer
	private String category; //helper string for view

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String name) {
		this.questionName = name;
	}

	public String[] getAnswers() {
		return answers;
	}

	public void setAnswers(String[] answers) {
		this.answers = answers;
	}

	public Question(String questionName, String[] answers, String category) {
		this.questionName = questionName;
		this.answers = answers;
		this.category= category;
	}

	public Boolean isCorrectAnswer(String givenAnswer) {
		if (answers[0].equals(givenAnswer)) {
			return true;
		}
		return false;
	}

	public String getCategory() {
		return category;
	}

}
