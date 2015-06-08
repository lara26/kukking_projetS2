package kukking;

import java.io.IOException;
import java.util.ArrayList;

import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import kukking.IHM.KukkingDisplay;


public class Application {
	
	public final static String[] logins = {"Martin","Laure","Robin","Maud","Alexandra"};
	public final static String[] passwords = {"AM","CA","EX","LA","LI"};
	
	private IHM_User user;

	private IHM_Administrator admin;
	
	private KukkingDisplay kukking;

	private ReceiptsList liste_Favoris;
	public ReceiptsList getListe_Favoris() {
		return liste_Favoris;
	}

	private ReceiptsList receiptsList;
	public ReceiptsList getReceiptsList() {
		return receiptsList;
	}

	private Recipe recetteCourante;

	private boolean accesAdmin;
	public boolean isAccesAdmin() {
		return accesAdmin;
	}

	public Application()
	{
		this.user = new UserConsole();
		this.admin = new AdministratorConsole();
		this.receiptsList = new ReceiptsList(this, false);
		this.liste_Favoris = new ReceiptsList(this, true);
		this.kukking = new KukkingDisplay(this);
		this.kukking.setLocationRelativeTo(null);
		this.kukking.setVisible(true);
	}
	
	public void supprimerFavori(Recipe recetteAAsupprimer) throws RowsExceededException, WriteException
	{
		recetteAAsupprimer.deleteFavoris();
		this.liste_Favoris.list.remove(recetteAAsupprimer);
	}

	public void ajouterFavori(Recipe recetteAAjouter) throws RowsExceededException, WriteException
	{
		recetteAAjouter.setFavoris();
		this.liste_Favoris.list.add(recetteAAjouter);
	}

	/*public void afficheFavoris() {
	}*/

	/*public Recipe recalculRecette(Recipe recetteAAfficher, int nombrePersonnes) {
	}*/

	public void affichageRecette(Recipe recetteAAfficher) {
		user.afficheElementsRecette(recetteAAfficher);
	}

	/**
	 * ne s'effectue que si on n'est pas � la premi�re page
	 */
	public void pagePrecedente() {
	}

	/**
	 * ne s'effectue que si on n'est pas � la derni�re page.
	 */
	public void pageSuivante() {
	}

	public ArrayList<Recipe> rechercheRecettes(int tempsPrepaMax, String typeCuisine, String typePlat, String cout)
	{
		ArrayList<Recipe> listWellReceipts = new ArrayList<Recipe>();
		for (Recipe currentRecipe: receiptsList.list)
		{
			if (tempsPrepaMax >= currentRecipe.getPreparationTime())
			{
				boolean typeCuisineValide = false;
				boolean typePlatValide = false;
				for (String categ: currentRecipe.getCategories())
				{
					if (categ.equals(typeCuisine)) typeCuisineValide = true;
					if (categ.equals(typePlat)) typePlatValide = true;
				}
				if (typeCuisine.equals("Tous type de recettes") || typeCuisineValide)
				{
					if (typePlat.equals("Tous les plats") || typePlatValide)
					{
						if (cout.equals("Variable") || cout.equals(currentRecipe.getCost()))
						listWellReceipts.add(currentRecipe);
					}
				}
			}
		}
		return listWellReceipts;
		
		/*Cette boucle est juste un test
		for(Recipe currentRecipe: listWellReceipts)
		{
			System.out.println (currentRecipe.getNameRecipe());
		}
		// Fin de la boucle test*/
	}

	/*public void requestAdministrativeAccess(String login, String password) throws IOException
	{
		if (valider(login, password))
			user.displayAdministrativePart();
	}*/

	/**
	 * valid or not password give in parameter
	 */
	public boolean valider(String login, String password) {
		int numLogin = 0;
		for (String currentLogin:logins)
		{
			if (login.equals(currentLogin)&&password.equals(passwords[numLogin]))
			{
				accesAdmin = true;
				return true;
			}
			numLogin++;
		}
		return false;
	}

	/**
	 * permet d'indentifier l'admin
	 */
	/*public Identifier() {
	}*/

	public IHM_Administrator getAdmin() {
		return admin;
	}
}
