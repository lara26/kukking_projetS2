import java.io.IOException;
import jxl.read.biff.BiffException;


public class AffichageRecette {

	public static void main(String[] args) {
		
		/*
		 * On affiche la recette selon sa feuille (0 pour la feuille 1,  1 pour la feuille 2 ...)
		 * � partir du type recette defini
		 */
		try {
			Recette recette = new Recette(0);
			System.out.println(recette);
		}
		catch (BiffException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
	}

}
