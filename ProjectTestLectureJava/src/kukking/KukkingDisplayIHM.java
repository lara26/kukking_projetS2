package kukking;

public class KukkingDisplayIHM{

		public static void main(String[] args) {
		
			KukkingDisplay kukking = new KukkingDisplay();
			kukking.setVisible(true);
			kukking.searchPage.faible.setSelected(true);
			System.out.println(kukking.searchPage.getCost());
			System.out.println(kukking.searchPage.getTypeCuisine());
			System.out.println(kukking.searchPage.getTypePlat());
			System.out.println(kukking.searchPage.getTempsPrepaMax());
		}

}
