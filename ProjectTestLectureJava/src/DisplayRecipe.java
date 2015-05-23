import java.io.IOException;

import java.io.ObjectInputStream.GetField;

import jxl.*;
import jxl.read.biff.BiffException;

public class DisplayRecipe {

	public static void main(String[] args) {
		
		/*
		 * On affiche la recette selon sa feuille (avec le nom en paramètre)
		 * à partir du type recette defini
		 */
		try {
			Recipe recipe = new Recipe("PouletMielBalsamique");
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
