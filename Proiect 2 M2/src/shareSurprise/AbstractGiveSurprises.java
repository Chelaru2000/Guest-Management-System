package shareSurprise;

import java.util.concurrent.TimeUnit;

import container.IBag;
import containerFactory.BagFactory;
import suprises.ISurprise;

public abstract class AbstractGiveSurprises {

	private IBag container;
	private BagFactory bagFactory;
	private int waitTime;

	public AbstractGiveSurprises(String type, int waitTime) {

		this.bagFactory = BagFactory.getInstance();
		this.container = bagFactory.makeBag(type);
		this.waitTime = waitTime;
		
	}

	public void put(ISurprise newSurprise) {		  
		this.container.put(newSurprise);
	}

	public void put(IBag surprises) { 
		this.container.put(surprises);
	}

	public IBag getContainer() {
		return this.container;
	}

	public int getTime() {
		return this.waitTime;
	}

	public void give() {
		if(this.getContainer().isEmpty()) {
			System.out.println("The container is empty");
		}

		this.getContainer().takeOut().enjoy();
	}

	public void giveAll() {
		while(!this.getContainer().isEmpty()) {
			ISurprise nextSurprise = this.getContainer().takeOut();
			nextSurprise.enjoy();
			this.giveWithPassion();
			try {
				TimeUnit.SECONDS.sleep(10); // number of seconds to sleep
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}

	public boolean isEmpty() {
		return this.container.isEmpty();
	}

	abstract void giveWithPassion();
}
