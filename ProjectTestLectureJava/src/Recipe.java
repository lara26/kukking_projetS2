import java.io.File; 
import java.io.IOException;

import jxl.*;
import jxl.read.biff.BiffException;

public class Recipe{
	
	
	private Cell title;
	private Cell ingredientTitle;
	private Cell categoryTitle;
	private Cell preparationTimeTitle;
	private Cell cookingTimeTitle;
	private Cell termostatOvenTitle;
	private Cell costTitle;
	private Cell preparationTitle;
	private Cell firstIngredient;
	private Cell ingredient;
	private Cell preparationTime;
	private Cell preparationTimeHour;
	private Cell ingredientQTE;
	private Cell ingredientmeasure;
	private Cell cookingTimeHour;
	private Cell cookingTime;
	private Cell termostatOven;
	private Cell termostatOvenDegre;
	private Cell cost;
	
	/**
	 * permet d'obtenir chaque position de case pour chaque titre(pour l'istant apres tout) des categorie des recettes
	 * @param numberSheetRecipe feuille de recette que l'on souhaite afficher
	 * @throws BiffException
	 * @throws IOException
	 */
	public Recipe(int numberSheetRecipe)throws BiffException, IOException
	{
		Workbook workbook = Workbook.getWorkbook(new File("Recettes\\recettes_plat.xls"));
		Sheet sheet = workbook.getSheet(numberSheetRecipe);
		
		title(sheet);
		indregientTitle(sheet);
		this.ingredient = sheet.getCell(0,5);
		this.ingredientQTE = sheet.getCell(1,5);
		this.ingredientmeasure = sheet.getCell(2,5);
		String Ingredient = ingredient.getContents() + " " + ingredientQTE.getContents() + " " + ingredientmeasure.getContents()  ;
		int i =6;
		while( ingredient.getContents() !=""){
			System.out.println(Ingredient);
			this.ingredient = sheet.getCell(0,i);
			this.ingredientQTE = sheet.getCell(1,i);
			this.ingredientmeasure = sheet.getCell(2,i);
			Ingredient = ingredient.getContents() + " " + ingredientQTE.getContents() + " " + ingredientmeasure.getContents();
			i ++;
		}
		
		catedoryTitle(sheet);
		
		preparationTimeTitle(sheet);
		this.preparationTime = sheet.getCell("F5");
		this.preparationTimeHour = sheet.getCell("G5");
		String PreparationTime = preparationTime.getContents() + " " + preparationTimeHour.getContents();
		System.out.println(PreparationTime);
		
		cookingTimeTitle(sheet);
		this.cookingTime = sheet.getCell("F6");
		this.cookingTimeHour = sheet.getCell("G6");
		String CookingTime = cookingTime.getContents() + " " + cookingTimeHour.getContents();
		System.out.println(CookingTime);
		
		termostatovenTitle(sheet);
		this.termostatOven = sheet.getCell("F7");
		this.termostatOvenDegre = sheet.getCell("G7");
		String TermostatOven = termostatOven.getContents() + " " +termostatOvenDegre.getContents();
		System.out.println(TermostatOven);
		
		costTitle(sheet);
		this.cost = sheet.getCell("F8");
		String Cost = cost.getContents() + " €";
		System.out.println(Cost);
		
		preparationTitle(sheet);
		String prepa = sheet.getCell(4,15).getContents();
		int p=16;
		while(prepa != ""){
			System.out.println(prepa);
			prepa = sheet.getCell(4,p).getContents();
			p++;	
		}
		

		
	}


	private void preparationTitle(Sheet sheet) {
		this.preparationTitle = sheet.getCell("D15");
		String PrepaTitle = preparationTitle.getContents();
		System.out.println(PrepaTitle);
	}


	private void costTitle(Sheet sheet) {
		this.costTitle = sheet.getCell("E8");
		String CostTitle = costTitle.getContents();
		System.out.println(CostTitle);
	}


	private void termostatovenTitle(Sheet sheet) {
		this.termostatOvenTitle = sheet.getCell("E7");
		String TermostatTitle = termostatOvenTitle.getContents();
		System.out.println(TermostatTitle);
	}


	private void cookingTimeTitle(Sheet sheet) {
		this.cookingTimeTitle = sheet.getCell("E6");
		String CookingTimeTitle = cookingTimeTitle.getContents();
		System.out.println(CookingTimeTitle);
	}


	private void preparationTimeTitle(Sheet sheet) {
		this.preparationTimeTitle = sheet.getCell("E5");
		String PrepaTimeTitle = preparationTimeTitle.getContents();
		System.out.println(PrepaTimeTitle);
	}


	private void catedoryTitle(Sheet sheet) {
		this.categoryTitle = sheet.getCell("D5");
		String CategTitle = categoryTitle.getContents();
		System.out.println(CategTitle);
	}


	private void indregientTitle(Sheet sheet) {
		this.ingredientTitle = sheet.getCell("A5");
		String IngredientTitle = ingredientTitle.getContents();
		System.out.println(IngredientTitle);
	}


	private void title(Sheet sheet) {
		this.title = sheet.getCell("D1");
		String Title = title.getContents();
		System.out.println(Title);
	}


	/**
	 * Transforme toutes les données du tableau excel en String
	 */
/*	public void transformationToString() {
		String Title = title.getContents();
		System.out.println(Title);
		String IngredientTitle = ingredientTitle.getContents();
		System.out.println(IngredientTitle);
		String CategTitle = categoryTitle.getContents();
		System.out.println(CategTitle);
	    String PrepaTimeTitle = preparationTimeTitle.getContents();
		System.out.println(PrepaTimeTitle);
		String CookingTimeTitle = cookingTimeTitle.getContents();
		System.out.println(CookingTimeTitle);
		String TermostatTitle = termostatOvenTitle.getContents();
		System.out.println(TermostatTitle);
		String CostTitle = costTitle.getContents();
		System.out.println(CostTitle);
		String PrepaTitle = preparationTitle.getContents();
		System.out.println(PrepaTitle);
	}*/

}
