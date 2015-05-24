package kukking;

import java.io.IOException;
import java.util.ArrayList;

class ReceiptsList {
	
	Application application;
	
	ArrayList <Recipe> list = new ArrayList<Recipe>();

	/**
	 * Ne s'effectue que si l'utilisateur a valider la suppression
	 * @throws IOException 
	 */
	public void deleteRecipe(Recipe recipeToDelete) throws IOException {
		if (application.getAdmin().ok(recipeToDelete))
			permanentlyDeleteRecipe(recipeToDelete);
			
	}

	public void permanentlyDeleteRecipe(Recipe recipeToDelete) {
		this.list.remove(recipeToDelete);
	}

	public void addRecipe() throws IOException
	{
		Recipe recipeToAdd = application.getAdmin().formAddRecipe();
		this.list.add(recipeToAdd);
	}

}
