package suprises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Candies implements ISurprise {
		
	private int num; 
	private String type;
	
	private final static ArrayList<CandyType> candies = new ArrayList<CandyType>(Arrays.asList(
														new CandyType(7, "chocolate"), 
														new CandyType(9, "jelly"), 
														new CandyType(5, "fruits"),
														new CandyType(8, "vanilla"))); 
	private final static Random randomGenerator = new Random();
	
	  public Candies(int num, String type) {
	    this.num = num;
	    this.type = type;
	  }

		@Override
		public void enjoy() {	
			System.out.println("You received " + this.num + " " + this.type + " candies.");
			
		}
		
	  @Override
	  public String toString() {
	    return "[Candies] number = " + this.num + ", type = " + this.type;
	  }

	  
	  public static Candies generate() {
		  
//		  int number = Candies.random.nextInt(Candies.candies.size());
//		  int type = Candies.random.nextInt(Candies.candies.size());
//		  CandyType candyType = Candies.candies.get(number);
//		  CandyType candyNumber = Candies.candies.get(type);
//		  
//		  if(number == 0) {
//			  number++;
//		  }
//		  
//		  return new Candies(candyNumber.getNum(), candyType.getType());
		 int randomCandiesIndex = Candies.randomGenerator.nextInt(candies.size());
		 
		 return new Candies(Candies.candies.get(randomCandiesIndex).getNum(), 
				 				  Candies.candies.get(randomCandiesIndex).getType());
	  }

}
