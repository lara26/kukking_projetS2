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

  public void demandeAccesAdministrateur() {
  }

  /**
   * valide ou non le mdp rentré
   */
  public boolean valider() {
  }

  private ReceiptsList listeFavoris;

  private IHM_User user;

  private IHM_Administrator admin;

  private ReceipsList liste_Favoris;

  private Recipe recetteCourante;

  /**
   * permet d'indentifier l'admin
   */
  public Identifier() {
  }

}
