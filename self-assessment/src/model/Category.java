package model;

public class Category {
	public String name;
	public String description;
	
	
	private String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	private String getDescription() {
		return description;
	}

	private void setDescription(String description) {
		this.description = description;
	}

	public Category(String name, String description) {
		this.name = name;
		this.description = description;
	}
}
