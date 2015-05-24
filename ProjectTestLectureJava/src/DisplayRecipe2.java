import java.io.IOException;
import java.io.ObjectInputStream.GetField;

import jxl.*;
import jxl.read.biff.BiffException;

public class DisplayRecipe2 {
	public static void main(String[] args) {
	
	try {
		Recipe2 recipe = new Recipe2("PouletMielBalsamique");
		System.out.println(recipe);
	}
	catch (BiffException e) {
		e.printStackTrace();
	} 
	catch (IOException e) {
		e.printStackTrace();
	} 
}
}
