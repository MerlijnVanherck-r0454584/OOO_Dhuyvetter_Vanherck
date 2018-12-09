package model;

public class Test {

	public Test(CategoryList categories) {
		this.categories = categories;
	}
	
	private CategoryList categories;
	
	public CategoryList getCategories() {
		return categories;
	}

	public void setCategories(CategoryList categories) {
		this.categories = categories;
	}
	
	public int[] getTotalScore() {
		int[] score = new int[2];
		score[0] = 0;
		score[1] = 0; //maxScore
		
		for (Category category : categories.getCategories()) {
			score[0] += category.getScore();
			score[1] += category.getQuestions().size();
		}
		
		return score;	
	}
	
	public int[] getScoreForCategory(Category category) {
		int[] score = new int[2];		
		score[0] = category.getScore();
		score[1] = category.getQuestions().size();
		
		return score;	
	}
	
	public Boolean isQuestionCorrect(Category category, Question question, String givenAnswer) {
		if (!category.getQuestions().contains(question)) throw new IllegalArgumentException("question must be from the category given as parameter");
		
		if (question.isCorrectAnswer(givenAnswer)) {
			category.increaseScore();
			return true;
		}
		return false;
			
	}

}
