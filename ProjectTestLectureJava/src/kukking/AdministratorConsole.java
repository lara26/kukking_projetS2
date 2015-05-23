package kukking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class AdministratorConsole implements IHM_Administrator {

	@Override
	public boolean ok(Recipe recipeToDelete) throws IOException {
		System.out.println("Etes vous sûr de vouloir supprimer la recette :"+ recipeToDelete.getNameRecipe());
		BufferedReader entree = new BufferedReader (new InputStreamReader(System.in));
	    if (entree.readLine()=="0") return true;
		return false;
	}

	@Override
	public Recipe formAddRecipe() throws IOException {
		System.out.println("Titre de la recette ?");
		BufferedReader entree = new BufferedReader (new InputStreamReader(System.in));
		String title = entree.readLine();
		System.out.println("Nombre de personnes ?");
		int nbPers = Integer.parseInt(entree.readLine());
		System.out.println("Temps de préparation (en min) ?");
		int preparationTime = Integer.parseInt(entree.readLine());
		// TODO (Robin) suit of request elements and return Recipe
	}

}
