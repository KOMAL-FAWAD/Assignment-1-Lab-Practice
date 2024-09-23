class Artist{
	private String name;
	
	//Default constructor

	Artist(){
		
		this.name = "Unknown";
	}

	//Parameterized constructor

	Artist(String name){
	
		this.name = name;

	}

	//Copy constructor

	Artist(Artist artist){
	
		this.name = artist.getName();

	}

	public void setName(String name){
		
		this.name = name;
	}

	public String getName(){

		return name;
	}
}

class Artwork{

	private String title;
	private int year;
	private Artist artist;

	//copy constructor 

	Artwork(Artwork aw){

		this.title = aw.getTitle();
		this.year = aw.getYear();
		this.artist = aw.getArtist();//shallow copy
		this.artist = new Artist(aw.getArtist().getName());//Deep copy	
	}

	//parameterized constructor

	Artwork(String title, int year, Artist artist){

		this.title = title;
		this.year = year;
		this.artist = artist;
	}
	 
	Artwork(String title, int year){

		this.title = title;
		this.year = year;
		this.artist = new Artist("Unknown");		
	}
	//Methods

	public void setTitle(String title){
	
		this.title = title;
	}

	public String getTitle(){
	
		return title;
	}

	public void setYear(int year){
	
		this.year = year;
	}

	public int getYear(){
	
		return year;
	}

	public void setArtist(Artist artist){
	
		this.artist = artist;
	}

	public Artist getArtist(){
	
		return artist;
	}

	public void DisplayArtwork(){

		System.out.println("Title : " +title);
		System.out.println("Year : " +year);	
		System.out.println("Artist name : "+artist.getName());
	}

	public Artwork Deepcopy(Artwork aw1){

		Artwork art1 = new Artwork(aw1.getTitle(), aw1.getYear(), new Artist(aw1.getArtist().getName()));
		return art1;
	}

	public Artwork Shallowcopy(Artwork aw2){

		Artwork art2 = new Artwork(aw2.getTitle(), aw2.getYear(), aw2.getArtist());
		return art2;
	}
	

}


public class Demo{

	public static void main(String arg[]){

		Artist a1 = new Artist();

		Artwork w1 = new Artwork("The Palace", 2020, new Artist("Komal"));

		Artwork w2 = new Artwork("The Grey Area", 2021);
		
		System.out.println("");
                System.out.println("With Unknown Artist");
     		System.out.println("");
		w2.DisplayArtwork();

		System.out.println("");
		System.out.println("For Shallow copy (Before Modification)");
		System.out.println("");

	        System.out.println("Original :- \n");
      	        w1.DisplayArtwork();

		Artwork w3 = w1.Shallowcopy(w1);
		System.out.println("\nShallow Copy:- \n");
                w3.DisplayArtwork();
		
	        System.out.println("");
     	        System.out.println("After Modification ");
     		System.out.println("");

		w1.getArtist().setName("Alex");
		System.out.println("Original :- \n");
                w1.DisplayArtwork();

		System.out.println("\nShallow Copy:- \n");
		w3.DisplayArtwork();

	        System.out.println("");
      		System.out.println("For Deep Copy (Before Modification)");
      		System.out.println("");

                System.out.println("Original :- \n");
		w1.DisplayArtwork();

		System.out.println("\nDeep Copy\n");
		Artwork w4 = w1.Deepcopy(w1);
		w4.DisplayArtwork();

		System.out.println("");
       		System.out.println("After Modification");
       		System.out.println("");

		w1.getArtist().setName("Jason");

		System.out.println("\nOriginal:- \n"); 
                w1.DisplayArtwork(); 
		
	}
}