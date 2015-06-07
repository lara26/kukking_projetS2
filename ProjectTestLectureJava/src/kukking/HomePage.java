package kukking;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;


public class HomePage extends JPanel{

	private static final long serialVersionUID = 1L;
	JButton connection = new JButton("Connexion");
	JButton search = new JButton("Lancer une recherche");
	KukkingDisplay kukkingFrame;
	
	
	public HomePage(KukkingDisplay kukkingFrame){
		this.kukkingFrame = kukkingFrame;
		JPanel favoris = new JPanel();
		JPanel recettes = new JPanel();
		
		JLabel kukkingLogo = new JLabel(new ImageIcon("kukkinglogo.png"));;
		JLabel kukking = new JLabel("Bienvenue sur Kukking !");
		kukking.setFont(new Font("Dom", Font.PLAIN, 50));
		
		favoris.setBorder(new TitledBorder("Favoris"));
		favoris.setPreferredSize(new Dimension(450,400));
		
		recettes.setBorder(new TitledBorder("Recettes"));
		recettes.setPreferredSize(new Dimension(450,400));
		
		Box button = Box.createHorizontalBox();
		button.add(search);
		button.add(Box.createHorizontalStrut(10));
		button.add(connection);
		
		Box homePageTot = Box.createVerticalBox();
		
		Box kukkingHead = Box.createHorizontalBox();
		kukkingHead.add(kukkingLogo);
		kukkingHead.add(Box.createHorizontalStrut(50));
		kukkingHead.add(kukking);
	
		Box homePageBody = Box.createHorizontalBox();
		homePageBody.add(favoris);
		homePageBody.add(Box.createHorizontalStrut(200));
		homePageBody.add(recettes);
	
		homePageTot.add(kukkingHead);
		homePageTot.add(Box.createVerticalStrut(20));
		homePageTot.add(button);
		homePageTot.add(Box.createVerticalStrut(20));
		homePageTot.add(homePageBody);
		this.add(homePageTot);
		
		connection.addActionListener(kukkingFrame);
		search.addActionListener(kukkingFrame);
		
	}


}
