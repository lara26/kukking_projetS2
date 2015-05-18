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
				/* R�cup�ration de la feuille excel*/
				workbook = Workbook.getWorkbook(new File("C:\\ficheexcel.xls"));
				
				/* Un fichier excel est compos� de plusieurs feuilles*/
				Sheet sheet = workbook.getSheet(0); //et getSheet(1) pour la feuille 1!//
				
				/*cellules avec la m�thode getCell(indiceColonne, indiceLigne) */
				Cell a1 = sheet.getCell(0,0); 
				
				/*ou avec getCell(nomCellule) */
				//Cell c5 = sheet.getCell("C5");
				
				/* r�cup�rer le contenu d'une cellule en utilisant la m�thode getContents() */
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
					/* On ferme le worbook pour lib�rer la m�moire */
					workbook.close(); 
				}
			}
		}
}
