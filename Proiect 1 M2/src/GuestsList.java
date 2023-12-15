import java.util.ArrayList;
import java.util.List;


public class GuestsList {

	private int guestsCapacity;
	private ArrayList<Guest> participantsList;
	private ArrayList<Guest> waitingList;

	public GuestsList(int guestsCapacity) {
		this.guestsCapacity = guestsCapacity;
		this.participantsList = new ArrayList<Guest>();
		this.waitingList = new ArrayList<Guest>();

	}

	/**
	 * Add a new, unique guest to the list.
	 *
	 * @param g the guest to be added
	 * @return '-1' if the guest is already present, '0' if he is a guest, or the
	 *         number on the waiting list
	 */
	public int add(Guest g) {

		if(isOnMainList(g)) {
			return -1;
		}
		if(!isOnMainList(g) && participantsList.size() < guestsCapacity) {
			participantsList.add(g);
			System.out.println( g.fullName() + " Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");
			return 0;
		}
		waitingList.add(g);
		System.out.println("Te-ai inscris cu succes in lista de asteptare si ai primit numarul de ordine " + (waitingList.indexOf(g)+1) 
		+ ". Te vom notifica daca un loc devine disponibil.");
		return waitingList.indexOf(g);
	}

	/**
	 * Check if someone is already registered (either as a guest, or on the waiting
	 * list).
	 *
	 * @param g the guest we are searching for
	 * @return true if present, false if not
	 */
	private boolean isOnTheListAlready(Guest g) {
		return isOnMainList(g) || isOnWaitingList(g);
	}

	private boolean isOnMainList(Guest g) {
		if(participantsList.contains(g)) {
			return true;
		}
		return false;
	}

	private boolean isOnWaitingList(Guest g) {
		if(waitingList.contains(g)) {
			return true;
		}
		return false;
	}

	/**
	 * Search for a guest based on first and last name. Return the first result.
	 *
	 * @param firstName first name of the guest
	 * @param lastName  last name of the guest
	 * @return the guest if found, null if not
	 */
	public Guest search(String firstName, String lastName) {
		for(int i = 0; i < participantsList.size(); i++) {
			Guest var = participantsList.get(i);
			if(var.getFirstName().equals(firstName) && var.getLastName().equals(lastName)) {
				return var;
			}
		}
		for(int i = 0; i < waitingList.size(); i++) {
			Guest wait = waitingList.get(i);
			if(wait.getFirstName().equals(firstName) && wait.getLastName().equals(lastName)) {
				return wait;
			}
		}
		return null;
	}

	/**
	 * Search for a guest based on email or phone number. Return the first result.
	 *
	 * @param opt   option to use for searching: 2 for email, 3 for phone number
	 * @param match the match we are searching for
	 * @return the guest if found, null if not
	 */
	public Guest search(int opt, String match) {
		switch(opt) {
		case 2:
			for(Guest guest : this.participantsList) {
				if(guest.getEmail().equals(match)) {
					return guest;
				}
			}
			for(Guest pendingGuest : this.waitingList) {
				if(pendingGuest.getEmail().equals(match)) {
					return pendingGuest;
				}
			}
			break;

		case 3: 
			for(Guest guest : this.participantsList) {
				if(guest.getPhoneNumber().equals(match)) {
					return guest;
				}
			}
			for(Guest pendingGuest : this.waitingList) {
				if(pendingGuest.getPhoneNumber().equals(match)) {
					return pendingGuest;
				}
			}
			break;

		default:
			return null;
		}
		return null;
	}

	/**
	 * Remove a guest based on first and last name. Remove the first result.
	 *
	 * @param firstName first name of the guest
	 * @param lastName  last name of the guest
	 * @return true if removed, false if not
	 */
	public boolean remove(String firstName, String lastName) {
		for(int i = 0; i < this.participantsList.size(); i++) {
			Guest part = participantsList.get(i);

			if(part.getFirstName().equals(firstName) && part.getLastName().equals(lastName)) {
				participantsList.remove(i);
				return true;
			}	
		}
		for(int i = 0; i < this.waitingList.size(); i++) {
			Guest wait = waitingList.get(i);

			if(wait.getFirstName().equals(firstName) && wait.getLastName().equals(lastName)) {
				waitingList.remove(i);
				return true;
			}	
		}


		return false;
	}

	/**
	 * Remove a guest based on email or phone number. Remove the first result.
	 *
	 * @param opt   option to use for searching: 2 for email, 3 for phone number
	 * @param match the match we are searching for
	 * @return true if removed, false if not
	 */
	public boolean remove(int opt, String match) {

		switch(opt) {
		case 2:
			for(int i = 0; i < this.participantsList.size(); i++) {
				Guest part = participantsList.get(i);
				if(part.getEmail().equals(match)) {
					participantsList.remove(i);
					return true;
				}
			}
			for(int i = 0; i < this.waitingList.size(); i++) {
				Guest wait = waitingList.get(i);
				if(wait.getEmail().equals(match)) {
					waitingList.remove(i);
					return true;
				}
			}
			break;

		case 3:
			for(int i = 0; i < this.participantsList.size(); i++) {
				Guest part = participantsList.get(i);
				if(part.getPhoneNumber().equals(match)) {
					participantsList.remove(i);
					return true;
				}
			}
			for(int i = 0; i < this.waitingList.size(); i++) {
				Guest wait = waitingList.get(i);
				if(wait.getPhoneNumber().equals(match)) {
					waitingList.remove(i);
					return true;
				}
			}
			break;
		}

		return false;
	}

	// Show the list of guests.
	public void showGuestsList() {
		System.out.println(participantsList.toString());
	}

	// Show the people on the waiting list.
	public void showWaitingList() {
		System.out.println(waitingList.toString());
	}

	/**
	 * Show how many free spots are left.
	 *
	 * @return the number of spots left for guests
	 */
	public int numberOfAvailableSpots() {
		return guestsCapacity - participantsList.size();
	}

	/**
	 * Show how many guests there are.
	 *
	 * @return the number of guests
	 */
	public int numberOfGuests() {
		return participantsList.size();
	}

	/**
	 * Show how many people are on the waiting list.
	 *
	 * @return number of people on the waiting list
	 */
	public int numberOfPeopleWaiting() {
		return waitingList.size();
	}

	/**
	 * Show how many people there are in total, including guests.
	 *
	 * @return how many people there are in total
	 */
	public int numberOfPeopleTotal() {
		return participantsList.size() + waitingList.size();
	}

	/**
	 * Find all people based on a partial value search.
	 *
	 * @param match the match we are looking for
	 * @return a list of people matching the criteria
	 */
	public List<Guest> partialSearch(String match) {

		String lowerCaseMatch = match.toLowerCase();
		List<Guest> arrayList = new ArrayList<Guest>();

		for(Guest participant : this.participantsList) {
			if(participant.getFirstName().toLowerCase().contains(lowerCaseMatch) || 
					participant.getLastName().toLowerCase().contains(lowerCaseMatch) ||
					participant.getEmail().toLowerCase().contains(lowerCaseMatch) ||
					participant.getPhoneNumber().toLowerCase().contains(lowerCaseMatch))
				arrayList.add(participant);
		}

		for(Guest participant : this.waitingList) {
			if(participant.getFirstName().toLowerCase().contains(lowerCaseMatch) || 
					participant.getLastName().toLowerCase().contains(lowerCaseMatch) ||
					participant.getEmail().toLowerCase().contains(lowerCaseMatch) ||
					participant.getPhoneNumber().toLowerCase().contains(lowerCaseMatch))
				arrayList.add(participant);
		}

		return arrayList;
	}



	@Override
	public String toString() {
		return Guest.class.toString();
	}
}
