package kukking;


/**
 * User interface
 */
interface IHM_User {
  /**
   * Ne s'effectue seulement si c'est un utilisateur qui est à la base de la recherche
   */
  int demandeNombrePersonne() ;

  char demandeMdp() ;

  /**
   * Est réalisée à condition que le mot de passe renvoyé par l'utilisateur soit valide
   */
  void affichePartieAdministrateur() ;

  void afficheElementsRecette(Recipe recetteAAfficher) ;

  /**
   * affiche la liste des recettes (seulement les noms)
   */
  void afficheListeRecettes(Recipe listeRecettes) ;

}
