package kukking;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;


public class HomePage extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	JButton connection = new JButton("Connexion");
	JButton search = new JButton("Lancer une recherche");
	JFrame kukkingFrame = new JFrame();
	ConnectionPage connectionPage = new ConnectionPage(kukkingFrame);
	SearchPage searchPage = new SearchPage(kukkingFrame);
	
	
	public HomePage(JFrame test){
		kukkingFrame = test;
		JPanel homePage = this;
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
		homePage.add(homePageTot);
		
		connection.addActionListener(this);
		search.addActionListener(this);
		
	}
	

	
	
	public void actionPerformed(ActionEvent clic){
		JButton source = (JButton)clic.getSource();
		if (source.getText().equals("Connexion")){
			ChangePanel(connectionPage);
		}
		else if (source.getText().equals("Lancer une recherche")){
			ChangePanel(searchPage);
		}
			
	}
	
	
	public void ChangePanel(JPanel panel){
			
		kukkingFrame.setContentPane(panel);
		kukkingFrame.revalidate();
	}


}
