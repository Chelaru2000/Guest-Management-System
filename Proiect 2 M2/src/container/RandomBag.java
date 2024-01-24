package container;

import java.util.ArrayList;
import java.util.Random;

import suprises.ISurprise;

public class RandomBag implements IBag{

	private final static Random randomSurprise = new Random();
	private final ArrayList<ISurprise> surprises;

	public RandomBag() {
		this.surprises = new ArrayList<ISurprise>();
	}

	// adds a surprise in the bag
	public void put(ISurprise newSurprise) {
		this.surprises.add(newSurprise);
	}

	// adds all the surprises from another IBag
	//   -> the 'bagOfSurprises' will be empty() afterwards
	public void put(IBag bagOfSurprises) {
		while(!bagOfSurprises.isEmpty()) {
			ISurprise surprise = bagOfSurprises.takeOut();
			this.put(surprise);
		}
	}

	// removes a surprise from the bag and returns it
	public ISurprise takeOut() {

		if(this.isEmpty()) {
			return null;
		}

		int index = randomSurprise.nextInt(this.surprises.size());
		ISurprise nextSurprise = this.surprises.get(index);
		surprises.remove(nextSurprise);
		return nextSurprise;
	}

	// Checks if the bag is empty or not
	public boolean isEmpty() {
		return surprises.isEmpty();
	}

	// Returns the number of surprises
	public int size(){
		return surprises.size();
	}

}
