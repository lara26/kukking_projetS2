package kukking;

import java.util.ArrayList;

class ReceiptsList {
	
	Application application;
	
	ArrayList <Recipe> list = new ArrayList<Recipe>();

	/**
	 * Ne s'effectue que si l'utilisateur a valider la suppression
	 */
	public void deleteRecipe(Recipe recipeToDelete) {
		if (application.getAdmin().ok(recipeToDelete))
			permanentlyDeleteRecipe(recipeToDelete);
			
	}

	public void permanentlyDeleteRecipe(Recipe recipeToDelete) {
		this.list.remove(recipeToDelete);
	}

	public void addRecipe()
	{
		Recipe recipeToAdd = application.getAdmin().formAddRecipe();
		this.list.add(recipeToAdd);
	}

}
