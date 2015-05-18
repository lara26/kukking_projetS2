import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class TestLectureFichierExcel {
		
		public static void main(String[] args) {
			Workbook workbook = null;
			try {
				/* Récupération de la feuille excel*/
				workbook = Workbook.getWorkbook(new File("C:\\ficheexcel.xls"));
				
				/* Un fichier excel est composé de plusieurs feuilles*/
				Sheet sheet = workbook.getSheet(0); //et getSheet(1) pour la feuille 1!//
				
				/*cellules avec la méthode getCell(indiceColonne, indiceLigne) */
				Cell a1 = sheet.getCell(0,0); 
				
				/*ou avec getCell(nomCellule) */
				//Cell c5 = sheet.getCell("C5");
				
				/* récupérer le contenu d'une cellule en utilisant la méthode getContents() */
				String contenuA1= a1.getContents();
				//String contenuC5 = c5.getContents();
				
				/*imprimer les contenus*/
				System.out.println(contenuA1);
				//System.out.println(contenuC5);
			} 
			catch (BiffException e) {
				e.printStackTrace();
			} 
			catch (IOException e) {
				e.printStackTrace();
			} 
			finally {
				if(workbook!=null){
					/* On ferme le worbook pour libérer la mémoire */
					workbook.close(); 
				}
			}
		}
}
