package containerFactory;

import container.FifoBag;
import container.IBag;
import container.LifoBag;
import container.RandomBag;

public class BagFactory implements IBagFactory {

	  private static BagFactory instance = new BagFactory();

	  private BagFactory() {
	  }

	  public static BagFactory getInstance() {
	    return instance;
	    
	  }

	  @Override
	  public IBag makeBag(String type) {
	    
		  switch(type) {
		  case "Random":
			  return new RandomBag();
			  
		  case "Fifo":
			  return new FifoBag();
			  
		  case "Lifo":
			  return new LifoBag();
			  
			  default:
				  return null;
		  }
		  
	  }
	}