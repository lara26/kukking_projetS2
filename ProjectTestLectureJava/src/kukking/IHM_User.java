package kukking;


/**
 * User interface
 */
interface IHM_User {
  /**
   * Ne s'effectue seulement si c'est un utilisateur qui est � la base de la recherche
   */
  int demandeNombrePersonne() ;

  char demandeMdp() ;

  /**
   * Est r�alis�e � condition que le mot de passe renvoy� par l'utilisateur soit valide
   */
  void affichePartieAdministrateur() ;

  void afficheElementsRecette(Recipe recetteAAfficher) ;

  /**
   * affiche la liste des recettes (seulement les noms)
   */
  void afficheListeRecettes(Recipe listeRecettes) ;

}
