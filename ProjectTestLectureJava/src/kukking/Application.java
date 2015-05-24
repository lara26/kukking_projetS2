package kukking;

import java.io.IOException;


class Application {
	
	private IHM_User user;

	private IHM_Administrator admin;

	private ReceiptsList liste_Favoris;
	
	private ReceiptsList receiptsList;

	private Recipe recetteCourante;

	public Application()
	{
		this.user = new UserConsole();
		this.admin = new AdministratorConsole();
		this.receiptsList = new ReceiptsList(this);
	}
	
	public void supprimerFavori(Recipe recetteAAsupprimer) {
	}

	public void ajouterFavori(Recipe recetteAAjouter) {
	}

	public void afficheFavoris() {
	}

	/*public Recipe recalculRecette(Recipe recetteAAfficher, int nombrePersonnes) {
	}*/

	public void affichageRecette(Recipe recetteAAfficher) {
		user.afficheElementsRecette(recetteAAfficher);
	}

	/**
	 * ne s'effectue que si on n'est pas à la première page
	 */
	public void pagePrecedente() {
	}

	/**
	 * ne s'effectue que si on n'est pas à la dernière page.
	 */
	public void pageSuivante() {
	}

	public void rechercheRecettes(char typeCuisine, char typePlat, int tempsPrepaMax, char niveauCuisine, char[] listeIngredient) {
	}

	public void requestAdministrativeAccess() throws IOException
	{
		String password = user.requestPassword();
		if (valider(password))
			user.displayAdministrativePart();
	}

	/**
	 * valid or not password give in parameter
	 */
	public boolean valider(String password) {
		if (password.equals("amodifier")) return true;
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
