package model;

public class Question {
	private String question;
	private String[] answers;
	private Category category;
	
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String[] getAnswers() {
		return answers;
	}

	public void setAnswers(String[] answers) {
		this.answers = answers;
	}

	public Question(String question, Category category, String[] answers) {
		this.question = question;
		this.answers = answers;
		this.category = category;
	}

	public Boolean isCorrectAnswer(String givenAnswer) {
		if (answers[0].equals(givenAnswer)) {
			return true;
		}
		return false;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
