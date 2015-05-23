import java.io.IOException;
import jxl.read.biff.BiffException;

public class DisplayRecipe {

	public static void main(String[] args) {
		
		/*
		 * On affiche la recette selon sa feuille (0 pour la feuille 1,  1 pour la feuille 2 ...)
		 * à partir du type recette defini
		 */
		try {
			Recipe recipe = new Recipe(0);
			System.out.println(recipe);
		}
		catch (BiffException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
	}

}
