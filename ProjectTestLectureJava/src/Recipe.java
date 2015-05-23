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
	private Cell nbPerson;
	private Cell person;
	
	/**
	 * methode qui affiche toute la recette sur la console (pour l'instant)
	 * @param numberSheetRecipe feuille de recette que l'on souhaite afficher (1ère feuille = 0)
	 * @throws BiffException
	 * @throws IOException
	 */
	public Recipe(/*int numberSheetRecipe*/String recipename)throws BiffException, IOException
	{
		Workbook workbook = Workbook.getWorkbook(new File("Recettes\\recettes_plat.xls"));
		Sheet sheet = workbook.getSheet(recipename/*numberSheetRecipe*/);


		title(sheet);
		People(sheet);
		indregientTitle(sheet);
		// on affiche le premier ingredient
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
		}// Tant qu'il y a des ingredients on les affiche
		
		categoryTitle(sheet);
		// on affiche la première categorie
		String Category = sheet.getCell(3,5).getContents();
		int c=6;
		while (Category != ""){
			System.out.println(Category);
			Category = sheet.getCell(3, c).getContents();
			c ++;
		}// Tant qu'il y a des categories on les affiche
		
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
		// on affiche la première instruction
		String prepa = sheet.getCell(4,15).getContents();
		int p=16;
		while(prepa != ""){
			System.out.println(prepa);
			prepa = sheet.getCell(4,p).getContents();
			p++;	
		}// Tant qu'il y a des instructions, on les affiche
		

		
	}
	/**
	 * methode pour l'affichage du nombre de personne
	 * @param sheet name of sheet
	 */
	private void People(Sheet sheet) {
		this.nbPerson = sheet.getCell("F3");
		this.person =sheet.getCell("G3");
		String Person = nbPerson.getContents() + " " + person.getContents();
		System.out.println(Person);
	}

	/**
	 * methode pour affiche le titre "Preparation"
	 * @param sheet name of sheet
	 */
	private void preparationTitle(Sheet sheet) {
		this.preparationTitle = sheet.getCell("D15");
		String PrepaTitle = preparationTitle.getContents();
		System.out.println(PrepaTitle);
	}

	/**
	 *  methode pour affiche le titre "Cout"
	 * @param sheet name of sheet
	 */
	private void costTitle(Sheet sheet) {
		this.costTitle = sheet.getCell("E8");
		String CostTitle = costTitle.getContents();
		System.out.println(CostTitle);
	}

	/**
	 *  methode pour affiche le titre "Termostat Four"
	 * @param sheet name of sheet
	 */
	private void termostatovenTitle(Sheet sheet) {
		this.termostatOvenTitle = sheet.getCell("E7");
		String TermostatTitle = termostatOvenTitle.getContents();
		System.out.println(TermostatTitle);
	}

	/**
	 *  methode pour affiche le titre "Tps de cuisson"
	 * @param sheet name of sheet
	 */
	private void cookingTimeTitle(Sheet sheet) {
		this.cookingTimeTitle = sheet.getCell("E6");
		String CookingTimeTitle = cookingTimeTitle.getContents();
		System.out.println(CookingTimeTitle);
	}

	/**
	 * methode pour affiche le titre "Preparation"
	 * @param sheet name of sheet
	 */
	private void preparationTimeTitle(Sheet sheet) {
		this.preparationTimeTitle = sheet.getCell("E5");
		String PrepaTimeTitle = preparationTimeTitle.getContents();
		System.out.println(PrepaTimeTitle);
	}

	/**
	 * methode pour affiche le titre "Categorie"
	 * @param sheet name of sheet
	 */
	private void categoryTitle(Sheet sheet) {
		this.categoryTitle = sheet.getCell("D5");
		String CategTitle = categoryTitle.getContents();
		System.out.println(CategTitle);
	}

	/**
	 * methode pour affiche le titre "Ingredient"
	 * @param sheet name of sheet
	 */
	private void indregientTitle(Sheet sheet) {
		this.ingredientTitle = sheet.getCell("A5");
		String IngredientTitle = ingredientTitle.getContents();
		System.out.println(IngredientTitle);
	}

	/**
	 * methode pour affiche le titre de la recette
	 * @param sheet name of sheet
	 */
	private void title(Sheet sheet) {
		this.title = sheet.getCell("D1");
		String Title = title.getContents();
		System.out.println(Title);
	}
	
	public String toString(){
		
		String Recette = title.getContents();
		Recette += "\n" + nbPerson.getContents() + " " + person.getContents();
		Recette += "\n" + preparationTimeTitle.getContents() + " : " + preparationTime.getContents() + " " + preparationTimeHour.getContents();
		Recette += "\n" + cookingTimeTitle.getContents() + " : " + cookingTime.getContents() + " " + cookingTimeHour.getContents();
		Recette += "\n" + ingredientTitle.getContents();
		Recette += "\n" + ingredient.getContents() + " " + ingredientQTE.getContents() + " " + ingredientmeasure.getContents();
		return Recette;
	}
}
