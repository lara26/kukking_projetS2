package kukking;

import javax.swing.SwingUtilities;

public class displaytest {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new displayfenetretest());

		DisplayListOfRecipe liste = new DisplayListOfRecipe();
		liste.search(4, "f", "D");
		//System.out.println(liste);
	}

}
