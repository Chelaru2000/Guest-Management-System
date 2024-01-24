package suprises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class FortuneCookie  implements ISurprise{


	 private String message;
	 private static final String[] quotes = {
		      "Cand vei fi multumit sa fii pur si simplu tu insuti si sa nu te compari cu ceilalti, toti te vor respecta. (Lao Tse)",
		      "Odata ce ai ales speranta, totul este posibil. (Christopher Reeve)",
		      "Am invatat tacerea de la cei vorbareti, toleranta de la cei intoleranti si bunatatea de la cei rai. (Khalil Gibran)",
		      "Cel ce n-are nici un merit invidiaza intotdeauna meritele altora. (Francis Bacon)",
		      "Cea mai inalta masura a valorii o dai de fapt in timpul confruntarilor la care te supune viata. (Anonim)",
		      "Am descoperit ca daca iubesti viata, si viata te va iubi pe tine. (Arthur Rubinstein)",
		      "Fiecare experienta de viata, fiecare lectie pe care o invat este cheia spre viitorul meu. (Clark Gable)",
		      "Prima conditie pentru a fi fericit este sa n-ai timp sa te gandesti la nefericire. (George Bernard Shaw)",
		      "Da tot ce ai mai bun in tine, intrucat totul din viata ta iti apartine numai tie. (Ralph Waldo Emerson)",
		      "Nebun este cine traieste in propria-i lume. (Paulo Coelho)",
		      "Pentru orice rau exista doua leacuri: timpul si tacerea. (Alexandre Dumas)",
		      "In viata lucrurile se fac usor, doar ideea gresita ca ar fi greu ne opreste sa fim extraordinari. (Marian Rujoiu)",
		      "S-ar putea ca actiunea sa nu-ti ofere fericire, dar nu exista fericire in lipsa actiunii. (William James)",
		      "Nu vad niciodata ce s-a facut. Vad doar ce mai e de facut. (Buddha)",
		      "Nu-ti pierde timpul batand intr-un perete sperand ca il vei transforma intr-o usa. (Coco Chanel)",
		      "Ataseaza-te de cei care te pot face mai bun si primeste-i pe cei care, la randul tau, ii poti face mai buni. (Seneca)",
		      "Mai bine sa te consumi decat sa ruginesti. (Denis Diderot)",
		      "Intelept este acela care traieste in fiecare zi ca si cum in fiecare zi si in fiecare ceas ar putea sa moara. (Francisco Gomez de Quevedo)",
		      "Toti avem in noi o nestiuta rezerva de energie care izbucneste cand viata ne pune la incercare. (Isabel Allende)",
		      "Stelele nu pot straluci fara intuneric. (Anonim)"
	
};
	 private final static Random randomGenerator = new Random();
	 
	 private final static ArrayList<String> quotesList = new ArrayList<>(Arrays.asList(quotes));
	 
	 
	  public FortuneCookie(String message) {
	    this.message = message;
	  }

	  @Override
	  public void enjoy() {
	    System.out.println("You got a fortune cookie! \n " + this.message);
	  }

	  @Override
	  public String toString() {
	    return "[FortuneCookie] message = " + this.message;
	  }

	  public static FortuneCookie generate() {
		  
		  int randomIndex = FortuneCookie.randomGenerator.nextInt(FortuneCookie.quotesList.size());

		  return new FortuneCookie(FortuneCookie.quotesList.get(randomIndex));
		  
	  }
	  
}

