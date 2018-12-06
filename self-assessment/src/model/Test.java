package model;

import java.util.ArrayList;

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

}
