package kukking;


class Application {
  public void supprimerFavori(Recipe recetteAAsupprimer) {
  }

  public void ajouterFavori(Recipe recetteAAjouter) {
  }

  public void afficheFavoris() {
  }

  public Recipe recalculRecette(Recipe recetteAAfficher, int nombrePersonnes) {
  }

  public void affichageRecette(Recipe recetteAAfficher) {
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

  public void rechercheRecettes(char typeCuisine, char typePlat, int tempsPrepaMax, char niveauCuisine, char[] listeIngredient) {
  }

  public void requestAdministrativeAccess()
  {
	  String password = user.requestPassword();
	  if (valider(password))
		  user.displayAdministrativePart();
  }

  /**
   * valid or not password give in parameter
   */
  public boolean valider(String password) {
	  if (password=="amodifier") return true;
		  return false;
  }

  private IHM_User user;

  private IHM_Administrator admin = new AdministratorConsole();

  private ReceiptsList liste_Favoris;

  private Recipe recetteCourante;

  /**
   * permet d'indentifier l'admin
   */
  public Identifier() {
  }

  public IHM_Administrator getAdmin() {
	  return admin;
  }
}
