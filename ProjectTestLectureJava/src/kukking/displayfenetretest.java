package kukking;

import java.awt.Dimension;

import javax.swing.JFrame;

import kukking.IHM.RecipeDisplay;

public class displayfenetretest implements Runnable {

	@Override
	public void run() {
		JFrame fenetre = new JFrame();
		fenetre.setTitle("Kukking");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setSize(600, 600);
		
		RecipeDisplay recipe;
		recipe = new RecipeDisplay(new Recipe("Galette des rois"));
		recipe.setPreferredSize(new Dimension(600,600));
		fenetre.getContentPane().add(recipe);
		
		fenetre.setVisible(true);
		
		
	}

}
