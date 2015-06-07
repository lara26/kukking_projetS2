package kukking;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConnectionPage extends JPanel{

	private static final long serialVersionUID = 1L;
	JFrame kukkingFrame;
	
	public ConnectionPage(JFrame kukkingFrame){
		this.kukkingFrame = kukkingFrame;
		JPanel connectionPage = this;
		JLabel kukkingLogo = new JLabel(new ImageIcon("kukkinglogo.png"));
		JLabel connectionTitle = new JLabel(" Connexion en tant qu'administrateur");
		connectionTitle.setFont(new Font("Dom", Font.PLAIN, 50));
		JLabel login = new JLabel("Entrez votre login");
		JTextField loginTextArea = new JTextField("Entrez votre login ici");
		JLabel passWord = new JLabel("Entrez votre mot de passe");
		JTextField passWordTextArea = new JTextField("Entrez votre mot de passe ici");
		JButton connection = new JButton("Se connecter");
		JButton returnHomePage = new JButton("Retour à la page d'accueil");	
		
		
		Box title = Box.createHorizontalBox();
		title.add(kukkingLogo);
		title.add(connectionTitle);
		
		Box data = Box.createVerticalBox();
		data.add(login);
		data.add(loginTextArea);
		data.add(passWord);
		data.add(passWordTextArea);
		data.add(connection);
		data.add(returnHomePage);
		
		
		Box connectionPageBox = Box.createVerticalBox();
		connectionPageBox.add(title);
		connectionPageBox.add(data);
		
		connectionPage.add(connectionPageBox);
		
		loginTextArea.addFocusListener(new FocusAdapter() {
		   public void focusGained(FocusEvent onclic){
		    loginTextArea.setText("");
		   }
		  });
		
		passWordTextArea.addFocusListener(new FocusAdapter() {
			   public void focusGained(FocusEvent onclic){
			    passWordTextArea.setText("");
			   }
			  });
	
	}
	
	public class GoToHomePage implements ActionListener{
		public void actionPerformed(ActionEvent clic){
			ChangePanel(homePage);
		}
	}
	
	
}
