import java.io.File;
import java.io.IOException;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class RecipeLight {
	
	private Cell title;
	private Cell ingredient;
	private Cell ingredientQTE;
	private Cell ingredientmeasure;
	private Cell preparationTime;
	private Cell preparationTimeMin;
	private Cell cookingTime;
	private Cell cookingTimeMin;
	private Cell termostatOven;
	private Cell cost;
	private Cell nbPeople;
	private Cell categoryType;
	private Cell preparation;
	private String recipe;
	
	
	
	/**
	 * Constructor for new recipe	
	 * @param recipeName name of recipe was chose
	 * @throws BiffException
	 * @throws IOException
	 */
	public RecipeLight(String recipeName) throws BiffException, IOException{
		Workbook workbook = Workbook.getWorkbook(new File("Recettes\\recettes_plat.xls"));
		this.recipe= recipeName;
		Sheet sheet = workbook.getSheet(this.recipe);
		
		this.title = sheet.getCell("D1");
		this.nbPeople = sheet.getCell("F3");
		this.preparationTime = sheet.getCell("F5");
		this.preparationTimeMin = sheet.getCell("G5");
		this.cookingTime = sheet.getCell("F6");
		this.cookingTimeMin = sheet.getCell("G6");
		this.termostatOven = sheet.getCell("F7");
		this.cost = sheet.getCell("F8");

	}
	
	/**
	 * methode pour renvoyer la liste des ingredients sous forme de String
	 * @param recipe la recette crée
	 * @return ingredients String contenant la liste des ingredients
	 * @throws BiffException
	 * @throws IOException
	 */
	public String displayIngredient(Recipe2 recipe) throws BiffException, IOException{
		Workbook workbook = Workbook.getWorkbook(new File("Recettes\\recettes_plat.xls"));
		Sheet sheet = workbook.getSheet(this.recipe);
		this.ingredient = sheet.getCell(0,5);
		this.ingredientQTE = sheet.getCell(1,5);
		this.ingredientmeasure = sheet.getCell(2,5);
		String ingredients = ingredient.getContents() + " " + ingredientQTE.getContents() + " " + ingredientmeasure.getContents();
		int i =6;
		while( ingredient.getContents() !=""){	
			this.ingredient = sheet.getCell(0,i);
			this.ingredientQTE = sheet.getCell(1,i);
			this.ingredientmeasure = sheet.getCell(2,i);
			i ++;
			ingredients +="\n" +  ingredient.getContents() + " " + ingredientQTE.getContents() + " " + ingredientmeasure.getContents();
		}
		return ingredients;
	}

	/**
	 * methode pour renvoyer la liste des catégories sous forme de String
	 * @param recipe la recette crée
	 * @return categories String contenant la liste des catégories
	 * @throws BiffException
	 * @throws IOException
	 */
	public String displayCategories(Recipe2 recipe) throws BiffException, IOException{
		Workbook workbook = Workbook.getWorkbook(new File("Recettes\\recettes_plat.xls"));
		Sheet sheet = workbook.getSheet(this.recipe);
		this.categoryType = sheet.getCell(3,5);
		String categories = categoryType.getContents();
		int c=6;
		while (categoryType.getContents() != ""){
			this.categoryType= sheet.getCell(3, c);
			c ++;
			categories += "\n" + categoryType.getContents();
		}
		
		return categories;
		
	}
	
	/**
	 * methode pour retourner la liste des étapes de préparations sous forme de String
	 * @param recipe la recette crée
	 * @return preparations String contenant toutes les étapes de préaparation
	 * @throws BiffException
	 * @throws IOException
	 */
	public String displayPreparations(Recipe2 recipe) throws BiffException, IOException{
		Workbook workbook = Workbook.getWorkbook(new File("Recettes\\recettes_plat.xls"));
		Sheet sheet = workbook.getSheet(this.recipe);
		this.preparation = sheet.getCell(4,15);
		String preparations = preparation.getContents();
		int p=16;
		while(preparation.getContents() != ""){
			this.preparation = sheet.getCell(4,p);
			p++;
			preparations += "\n" + preparation.getContents();
		}

		return preparations;
	}
	
	//------------------------ Getter for title, preparation time and cooking time : return String ------------------------//
	public String getRecipe() {
		return recipe;
	}
	
	public String getTitle() {
		return title.getContents();
	}

	public String getPreparationTimeTitle() {
		return "Temps de préparation";
	}

	public String getCookingTimeTitle() {
		return "Temps de cuisson";
	}

	public String getPreparationTime() {
		return preparationTime.getContents();
	}

	public String getCookingTime() {
		return cookingTime.getContents();
	}


	public String getPreparationTimeMin() {
		return preparationTimeMin.getContents();
	}

	public String getCookingTimeMin() {
		return cookingTimeMin.getContents();
	}
//---------------------------------------------------------------------------//

	public String toString(){

		String recipe = title.getContents();
		recipe += "\n" + nbPeople.getContents() + " personnes";
		recipe += "\nTemps de préparation : " + preparationTime.getContents() + " " + preparationTimeMin.getContents();
		recipe += "\nTemps de cuisson : " + cookingTime.getContents() + " " + cookingTimeMin.getContents();
		recipe += "\nCout " + cost.getContents();
		recipe += "\nCatégories";
		try {
			recipe += "\n" + displayCategories(new Recipe2(getRecipe()));
		} catch (BiffException | IOException e1) {
			e1.printStackTrace();
		}
		recipe += "Ingredients";
		try {
			recipe += "\n" + displayIngredient(new Recipe2(getRecipe())) ;
		} catch (BiffException | IOException e) {
			e.printStackTrace();
		}
		recipe += "\nTermostat four : " + termostatOven.getContents() + " °C";
		recipe += "\nPréparations";
		try {
			recipe += "\n" + displayPreparations(new Recipe2(getRecipe()));
		} catch (BiffException | IOException e) {
			e.printStackTrace();
		}
		
		return recipe;	
	}

}
