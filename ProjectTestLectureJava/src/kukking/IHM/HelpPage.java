package kukking.IHM;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

public class HelpPage extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private KukkingDisplay kukkingFrame;
	private JLabel kukkingLogo;
	private JButton backToHome;
	
	public HelpPage(KukkingDisplay kukkingFrame)
	{
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.green);
		this.backToHome = new JButton("Retour à la page d'accueil");
		this.backToHome.addActionListener(kukkingFrame);
		this.kukkingFrame=kukkingFrame;
		this.kukkingLogo = new JLabel(new ImageIcon("kukkinglogo.png"));
		
		GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx=0;
			gbc.gridy=0;
		this.add(kukkingLogo,gbc);
		
			gbc.gridx=0;
			gbc.gridy=1;
		JLabel title = new JLabel("Bienvenue sur la page d'aide");
		title.setFont(new Font("Calibri", Font.BOLD, 27));
		this.add(title,gbc);
		
			gbc.gridx=0;
			gbc.gridy=3;
		this.add(backToHome,gbc);
	}
}
