package kukking;

import java.io.IOException;
import java.util.ArrayList;


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

	public void rechercheRecettes(int tempsPrepaMax, String typeCuisine, String typePlat, String cout)
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
		
		//Cette boucle est juste un test
		for(Recipe currentRecipe: listWellReceipts)
		{
			System.out.println (currentRecipe.getNameRecipe());
		}
		// Fin de la boucle test
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
