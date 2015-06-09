package kukking;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import jxl.Workbook;
import jxl.Sheet;
import jxl.read.biff.BiffException;

public class ReceiptsList {
	
	private Application application;
	
	public ArrayList <Recipe> list;

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

	public ReceiptsList(Application application, boolean favoris) {
		this.application=application;
		this.list = new ArrayList<Recipe>();
		try {
			Workbook workbook = Workbook.getWorkbook(new File(Recipe.sourcePath));
			for (Sheet currentSheet: workbook.getSheets())
			{
				if (!favoris || currentSheet.getCell("D2").getContents().equals("Favoris"))
				{
					this.list.add(new Recipe(currentSheet.getName()));
				}
			}
		} catch (BiffException e) {e.printStackTrace();} catch (IOException e) {e.printStackTrace();}
	}

	public Recipe getRecipeWithName(String recipeToSearch)
	{
		for (Recipe recipe: list)
		{
			if (recipe.getNameRecipe().equals(recipeToSearch)) return recipe;
		}
		return null;
	}
}
