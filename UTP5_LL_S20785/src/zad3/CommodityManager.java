package zad3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class CommodityManager {
	static List<Towar> list = Collections.synchronizedList(new ArrayList<Towar>());
	static int weightSum;
	static boolean isDone = false;
	static boolean readyForChunk = false;
	
	public CommodityManager() {

	}
	
	public synchronized void producer() {
		 try {
		      File f = new File("C:\\Users\\Woocash\\eclipse-workspace\\Towary.txt");
		      Scanner myReader = new Scanner(f);
		      while (myReader.hasNextLine()) {
		    	
		    	  while(readyForChunk) {
		  			try {
		  				wait(1);
		  			} catch (InterruptedException e) {
		  				e.printStackTrace();
		  			}
		  		}  
		    	  
		        String data = myReader.nextLine();
		        list.add(new Towar(data));
		        if (Towar.howManyCreated % 200 == 0) System.out.println("utworzono " + Towar.howManyCreated + " obiektów");
		        readyForChunk = true;
		      }
		      isDone = true;
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      e.printStackTrace();
		    }
	}
	
	public synchronized void counter() {
		int i = 0;
		while(!isDone) {
			
			while(!readyForChunk) {
				try {
					wait(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			weightSum += list.get(i).getWeight();
			i++;
			if(i % 100 == 0) System.out.println("policzono wage " + i + " obiektów");
			readyForChunk = false;
		}
		try {
			Thread.sleep(2000); // Chcemy wyświetlić informacje o wadze na końcu programu, trzeba zaczekać aż producer skończy działanie
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Sumaryczna waga wszystkich towarów wynosi: " + weightSum);
	}
	
}