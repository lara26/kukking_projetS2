package kukking;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class HomePage extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public HomePage(){
		JPanel homePage = this;
		JPanel favoris = new JPanel();
		JPanel recettes = new JPanel();
		JLabel kukkingLogo = new JLabel("futur image");
		JLabel kukking = new JLabel("Bienvenue sur Kukking !");
		kukking.setFont(new Font("Curlz MT", Font.PLAIN, 30));
		
		favoris.setBorder(new TitledBorder("Favoris"));
		favoris.setPreferredSize(new Dimension(500,500));
		
		recettes.setBorder(new TitledBorder("Recettes"));
		recettes.setPreferredSize(new Dimension(500,500));
		
		Box homePageTot = Box.createVerticalBox();
		
		Box kukkingHead = Box.createHorizontalBox();
		kukkingHead.add(kukkingLogo);
		kukkingHead.add(Box.createHorizontalStrut(50));
		kukkingHead.add(kukking);
		kukkingHead.setPreferredSize(new Dimension(100,100));
	
		Box homePageBody = Box.createHorizontalBox();
		homePageBody.add(favoris);
		homePageBody.add(Box.createHorizontalStrut(200));
		homePageBody.add(recettes);
	
		homePageTot.add(kukkingHead);
		homePageTot.add(homePageBody);
		
		homePage.add(homePageTot);
		
	    
	}
		
	
}
