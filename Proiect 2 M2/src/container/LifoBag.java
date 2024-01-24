package container;

import java.util.ArrayList;

import suprises.ISurprise;

public class LifoBag implements IBag{

	private final ArrayList<ISurprise> surprises;

	public LifoBag() {
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

		ISurprise nextSurprise = this.surprises.get(this.surprises.size()-1);
		surprises.remove(nextSurprise);
		return nextSurprise;
	}

	// Checks if the bag is empty or not
	public boolean isEmpty() {
		return surprises.isEmpty();
	}

	// Returns the number of surprises
	public int size() {
		return surprises.size();
	}
}
