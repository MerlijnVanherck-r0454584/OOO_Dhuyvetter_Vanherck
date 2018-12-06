package model;

public class Question {
	private String[] answers;
	private Category category;
	
	public String[] getAnswers() {
		return answers;
	}

	public void setAnswers(String[] answers) {
		this.answers = answers;
	}

	public Question(String[] answers, Category category) {
		this.answers = answers;
		this.category = category;
	}

	public Boolean isCorrectAnswer(String givenAnswer) {
		if (answers[0].equals(givenAnswer)) {
			category.increaseScore();
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
