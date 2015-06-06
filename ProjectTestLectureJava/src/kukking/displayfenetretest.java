package kukking;

import java.awt.Dimension;

import javax.swing.JFrame;

public class displayfenetretest implements Runnable {

	@Override
	public void run() {
		JFrame fenetre = new JFrame();
		fenetre.setTitle("Kukking");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setSize(600, 600);
		RecipeDisplay recipe;
		try {
			recipe = new RecipeDisplay(new Recipe("Poulet miel balsamique"));
			recipe.setPreferredSize(new Dimension(600,600));
			fenetre.getContentPane().add(recipe);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		fenetre.setVisible(true);
		
		
	}

}
