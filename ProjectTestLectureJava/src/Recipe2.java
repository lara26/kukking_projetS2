import java.io.File; 
import java.io.IOException;

import jxl.*;
import jxl.read.biff.BiffException;

public class Recipe2 {
	
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
	private Cell ingredientQTE;
	private Cell ingredientmeasure;
	private Cell cookingTime;
	private Cell termostatOven;
	private Cell termostatOvenDegre;
	private Cell cost;
	private Cell people;
	private Cell nbPeople;
	private Cell preparationTimeMin;
	private Cell cookingTimeMin;
	private Cell categoryType;
	private Cell prepa;

		
	public Recipe2(String recipeName) throws BiffException, IOException{
		Workbook workbook = Workbook.getWorkbook(new File("Recettes\\recettes_plat.xls"));
		Sheet sheet = workbook.getSheet(recipeName);
		
		this.title = sheet.getCell("D1");
		this.people = sheet.getCell("F3");
		this.nbPeople = sheet.getCell("G3");
		this.preparationTimeTitle = sheet.getCell("E5");
		this.preparationTime = sheet.getCell("F5");
		this.preparationTimeMin = sheet.getCell("G5");
		this.cookingTimeTitle = sheet.getCell("E6");
		this.cookingTime = sheet.getCell("F6");
		this.cookingTimeMin = sheet.getCell("G6");
		this.ingredientTitle = sheet.getCell("A5");
		this.ingredient = sheet.getCell(0,5);
		this.ingredientQTE = sheet.getCell(1,5);
		this.ingredientmeasure = sheet.getCell(2,5);
		/*int i =6;
		while( ingredient.getContents() !=""){
			
			this.ingredient = sheet.getCell(0,i);
			this.ingredientQTE = sheet.getCell(1,i);
			this.ingredientmeasure = sheet.getCell(2,i);
			i ++;
		}*/
		this.categoryTitle = sheet.getCell("D5");
		this.categoryType = sheet.getCell(3,5);
		/*int c=6;
		while (categoryType.getContents() != ""){
			this.categoryType= sheet.getCell(3, c);
			c ++;
		}*/
		this.termostatOvenTitle = sheet.getCell("E7");
		this.termostatOven = sheet.getCell("F7");
		this.termostatOvenDegre = sheet.getCell("G7");
		this.costTitle = sheet.getCell("E8");
		this.cost = sheet.getCell("F8");
		this.preparationTitle = sheet.getCell("D15");
		this.prepa = sheet.getCell(4,15);
		int p=16;
		while(prepa.getContents() != ""){
			this.prepa = sheet.getCell(4,p);
			p++;	
		}
	
		
	}

	public String toString(){

		String recipe = title.getContents();
		recipe += "\n" + people.getContents() + " " + nbPeople.getContents();
		recipe += "\n" + preparationTimeTitle.getContents() + " : " + preparationTime.getContents() + " " + preparationTimeMin.getContents();
		recipe += "\n" + cookingTimeTitle.getContents() + " : " + cookingTime.getContents() + " " + cookingTimeMin.getContents();
		recipe += "\n" + costTitle.getContents() + " " + cost.getContents();
		recipe += "\n" + ingredientTitle.getContents();
		recipe += "\n" + ingredient.getContents() + " " + ingredientQTE.getContents() + " " + ingredientmeasure.getContents();
		recipe += "\n" + termostatOvenTitle.getContents() + " : " + termostatOven.getContents() + " " + termostatOvenDegre.getContents();
		recipe += "\n" + preparationTitle.getContents();
		recipe += "\n" + prepa.getContents();
		
		
		
		return recipe;
		
	}



}
