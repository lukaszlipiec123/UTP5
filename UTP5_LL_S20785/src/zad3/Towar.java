package zad3;

public class Towar {
	static int howManyCreated = 0;
	private int id;
	private int weight;
	
	Towar(String line){
		String [] tab = line.split(" ");
		this.id = Integer.parseInt(tab[0]);
		this.weight = Integer.parseInt(tab[1]);
		this.howManyCreated++;
	}
	
	int getWeight(){
		return this.weight;
	}
}
