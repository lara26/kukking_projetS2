import java.util.Scanner;



public class TestSearch
{
	Scanner sc = new Scanner(System.in);
	String search=sc.nextLine();
	int numberOfFiles;
	int roam;
	String resultSearch[];
	int indic=0;
	
	
	public void getNumberOfFiles(int numberOfFiles)
	{
		this.numberOfFiles=numberOfFiles;
	}
	
	
	public String searchUser(String search)
	{
	for(roam=0;roam<=numberOfFiles;roam++)
	{
		if(search == Cell.title || search == Cell.categoryTitle)
		{
			resultSearch[indic]=search;
			indic++;
		}

	}
}