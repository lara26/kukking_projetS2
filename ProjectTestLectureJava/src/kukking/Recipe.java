package kukking;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

class Recipe {
	public final static String sourcePath = "./receipts.xls";
	private String nameRecipe;

	/**
	 * renvoie tous les éléments de la recette dans un tableau 
	 */
	public String obtenirElemsRecette() {
	}


	public String getNameRecipe() {
		return nameRecipe;
	}

	/**
	 * constructor when we create a new recipe
	 * @param title
	 * @param nbPers
	 * @param preparationTime
	 * @param cookingTime
	 * @param cost
	 * @param categories
	 * @param ingredients
	 * @param quantities
	 * @param units
	 * @param preparation
	 */
	public Recipe(String title, int nbPers, int preparationTime, int cookingTime, String cost, ArrayList<String> categories, ArrayList<String> ingredients, ArrayList<String> quantities, ArrayList<String> units, ArrayList<String> preparation)
	{
		this.nameRecipe = title;
		WritableWorkbook workbook = null;
		try {
			workbook = Workbook.createWorkbook(new File(sourcePath),Workbook.getWorkbook(new File(sourcePath)));

			WritableSheet recipe = workbook.createSheet(title, 0); 

			Label label = new Label(3,0, title);
			recipe.addCell(label);

			Number number = new Number(5, 2, nbPers);
			recipe.addCell(number);

			number = new Number(5, 4, preparationTime);
			recipe.addCell(number);
			
			number = new Number(5, 5, cookingTime);
			recipe.addCell(number); 
			
			label = new Label(5, 7, cost);
			recipe.addCell(label);
			
			for (int categorieNum=0;categorieNum<categories.size();categorieNum++)
			{
				label = new Label(3, 5+categorieNum, categories.get(categorieNum));
				recipe.addCell(label);
			}
			
			for (int ingredientNum=0;ingredientNum<ingredients.size();ingredientNum++)
			{
				label = new Label(0, 5+ingredientNum, ingredients.get(ingredientNum));
				recipe.addCell(label);
			}
			
			for (int quantityNum=0;quantityNum<quantities.size();quantityNum++)
			{
				label = new Label(1, 5+quantityNum, quantities.get(quantityNum));
				recipe.addCell(label);
			}
			
			for (int unitNum=0;unitNum<units.size();unitNum++)
			{
				label = new Label(2, 5+unitNum, units.get(unitNum));
				recipe.addCell(label);
			}
			
			for (int stepNum=0;stepNum<preparation.size();stepNum++)
			{
				label = new Label(4, 15+stepNum, preparation.get(stepNum));
				recipe.addCell(label);
			}
			
			
			/* On ecrit le classeur */
			workbook.write(); 

		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		catch (RowsExceededException e) {
			e.printStackTrace();
		}
		catch (WriteException e) {
			e.printStackTrace();
		}
		catch (BiffException e) {
			e.printStackTrace();
		}
		finally {
			if(workbook!=null){
				/* On ferme le worbook pour libérer la mémoire */
				try {
					workbook.close();
				} 
				catch (WriteException e) {
					e.printStackTrace();
				} 
				catch (IOException e) {
					e.printStackTrace();
				} 
			}
		}
	}

}
