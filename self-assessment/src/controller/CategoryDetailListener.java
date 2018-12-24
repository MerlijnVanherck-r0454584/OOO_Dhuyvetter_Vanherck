package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Category;
import model.Subcategory;
import view.panels.AssesMainPane;
import view.panels.CategoryDetailPane;

public class CategoryDetailListener implements EventHandler<ActionEvent> {

	private CategoryDetailPane cdPane;
	private AssesMainPane borderPane;

	public CategoryDetailListener(CategoryDetailPane categoryDetailPane, AssesMainPane borderPane) {
		cdPane = categoryDetailPane;
		this.borderPane = borderPane;
	}

	@Override
	public void handle(ActionEvent event) {
		Category category;
		if (event.getSource() == cdPane.getBtnOK()) {
			if (cdPane.getCategoryField() == null) {
				category = new Category(cdPane.getTitleFieldContents(), cdPane.getDescriptionFieldContents());
			} else {

				category = new Subcategory(cdPane.getTitleFieldContents(), cdPane.getDescriptionFieldContents(),
						cdPane.getController().getCategoryFromName(cdPane.getCategoryField()));
			}

			cdPane.getController().getCategories().add(category);

		}

		cdPane.emptyFields();
		borderPane.switchCategoryTab();

	}

}
