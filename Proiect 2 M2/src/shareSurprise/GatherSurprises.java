package shareSurprise;

import java.util.ArrayList;
import java.util.Random;

import suprises.Candies;
import suprises.FortuneCookie;
import suprises.ISurprise;
import suprises.MinionToy;

public final class GatherSurprises {

	private static final Random randomGenerator = new Random();
	private static final int surpriseTypes = 3;

	private GatherSurprises() {
	}

	public static ArrayList<ISurprise> gather(int n) {
		ArrayList<ISurprise> surprisesArray = new ArrayList<ISurprise>(n);
		for(int i = 0; i < n; i++) {
			surprisesArray.add(GatherSurprises.gather());
		}
		return surprisesArray;
	}

	public static ISurprise gather() {
		switch(randomGenerator.nextInt(surpriseTypes)) {
		case 0:
			return FortuneCookie.generate();
		case 1:
			return Candies.generate();
		case 2:
			return MinionToy.generate();
		}
		return null;
	}
}
