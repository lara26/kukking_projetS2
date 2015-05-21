import java.io.File;
import java.io.IOException;

import jxl.*;
import jxl.read.biff.BiffException;
public class Recette{
	
	//Workbook workbook = null;
	
	
	Cell titre;
	Cell ingredientTitre;
	Cell categorieTitre;
	Cell tpsPreparationTitre;
	Cell tpsCuissonTitre;
	Cell termostatFourTitre;
	Cell coutTitre;
	Cell preparationTitre;
	
	/**
	 * permet d'obtenir chaque position de case pour chaque titre(pour l'istant apres tout) des categorie des recettes
	 * @param numFeuilleRecette feuille de recette que l'on souhaite afficher
	 * @throws BiffException
	 * @throws IOException
	 */
	public Recette(int numFeuilleRecette)throws BiffException, IOException
	{
		Workbook workbook = Workbook.getWorkbook(new File("Recettes\\recettes_plat.xls"));
		Sheet sheet = workbook.getSheet(numFeuilleRecette);
		this.titre = sheet.getCell("D1");
		this.ingredientTitre = sheet.getCell("A5");
		this.categorieTitre = sheet.getCell("D5");
		this.tpsPreparationTitre = sheet.getCell("E5");
		this.tpsCuissonTitre = sheet.getCell("E6");
		this.termostatFourTitre = sheet.getCell("E7");
		this.coutTitre = sheet.getCell("E8");
		this.preparationTitre = sheet.getCell("C15");
		
		transformationToString();
	}


	/**
	 * Transforme toutes les données du tableau excel en String
	 */
	public void transformationToString() {
		String Titre = titre.getContents();
		System.out.println(Titre);
		String IngredientTitre = ingredientTitre.getContents();
		System.out.println(IngredientTitre);
		String CategTitre = categorieTitre.getContents();
		System.out.println(CategTitre);
		String TpsPrepaTitre = tpsPreparationTitre.getContents();
		System.out.println(TpsPrepaTitre);
		String TpsCuissonTitre = tpsCuissonTitre.getContents();
		System.out.println(TpsCuissonTitre);
		String TermostatTitre = termostatFourTitre.getContents();
		System.out.println(TermostatTitre);
		String CoutTitre = coutTitre.getContents();
		System.out.println(CoutTitre);
		String PrepaTitre = preparationTitre.getContents();
		System.out.println(PrepaTitre);
	}

}
