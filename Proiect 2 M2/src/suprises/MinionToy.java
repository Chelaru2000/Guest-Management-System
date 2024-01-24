package suprises;

import java.util.ArrayList;
import java.util.Arrays;

public class MinionToy implements ISurprise{

//	private static final String[] names = { "Dave", "Carl", "Kevin", "Stuart", "Jerry", "Tim" };
	private static final ArrayList<MinionToyType> minions = new ArrayList<MinionToyType>(Arrays.asList(
			new MinionToyType("Dave"), 
			new MinionToyType("Carl"), 
			new MinionToyType("Kevin"),
			new MinionToyType("Stuard"),
			new MinionToyType("Jerry"),
			new MinionToyType("Tim"))); 

	  private String name;
	  private static int contor = 0;

	  public MinionToy(String name) {
	    this.name = name;
	  }

	  @Override
	  public void enjoy() {
		  System.out.println("You got a minion named" + this.name + " !");
	  }

	  @Override
	  public String toString() {
	    return "[Minion] name = " + this.name;
		  
	  }

	  public static MinionToy generate() {
	   
		 MinionToyType index = MinionToy.minions.get(contor % minions.size());
		 contor++;
		 return new MinionToy(index.getName());
		 
	  }
	  
	  
}
