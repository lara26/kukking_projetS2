package kukking;

import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;



public class DisplayListOfRecipe
{
	/* Affiche la liste de toutes les recettes correspondant aux critères
	 * de l'utilisateur (juste les noms)
	 * quand clique sur le nom de la recette, affiche la recette
	 */

	private ArrayList<String> nameList = new ArrayList<String>();

	public final static String sourcePath = "./receipts.xls";




	public ArrayList<String> search(int nbPers, String typeCuisine, String typePlat)
	{


		// TODO : improve
		try {
			Sheet sheet;

			Workbook workbook = Workbook.getWorkbook(new File(sourcePath)); 
			int nbr = workbook.getNumberOfSheets();
			for (int i = 0; i < nbr; i++)
			{
				sheet = workbook.getSheet(i);

				int nbPerso = Integer.parseInt(sheet.getCell("F3").getContents());
				String contents = sheet.getCell("D1").getContents();

				
				if (nbPers == nbPerso)
				{
					nameList.add(contents);
				}
			}
			
			for(String elem: nameList)
			{

				System.out.println (elem);
			}
		}
		
		catch (BiffException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 


		return nameList;


	}


}
