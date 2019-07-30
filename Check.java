package cat_exhibition;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Check {

	public static void main(String[] args) throws IOException {
		HashSet<Human> Kolesnikov = new HashSet<Human>();
		Kolesnikov.add(new Human("Kolesnikov", "Semen", "Moscow"));
		HashSet<Human> Cherepanov = new HashSet<Human>();
		Cherepanov.add(new Human("Alexey", "Cherepanov", "Moscow"));
		Cherepanov.add(new Human("Vika", "Cherepanova", "Moscow"));
		HashSet<Human> Levina = new HashSet<Human>();
		Levina.add(new Human("Levina", "Natasha", "NN"));
		HashSet<Human>Abramov=new HashSet<Human>();
		Abramov.add(new Human("Alisa","Abramova","Kalinigrad"));
		Abramov.add(new Human("Elena","Abramova","Kaliningrad"));
		HashSet<Human>Viktorov=new HashSet<Human>();
		Viktorov.add(new Human("Oleg","Viktorov","Saratov"));
		HashMap<Integer, Cat> cat_exh = new HashMap<Integer, Cat>();
		cat_exh.put(1, new Cat("Murphy", "purina", "siam", Cherepanov));
		cat_exh.put(2, new Cat("John", "proplan", "bengal", Kolesnikov));
		cat_exh.put(3, new Cat("Fluffy", "proplan", "wood cat", Levina));
		cat_exh.put(4,new Cat("Choco","proplan","australian mist",Abramov));
		cat_exh.put(5,new Cat("Mia","royal canin","abissin cat",Viktorov));
		for (Map.Entry<Integer, Cat> cat : cat_exh.entrySet()) {
			cat.getValue().printcatinfo();
		}
		Cat.searchbyid(cat_exh, 1);
		Cat.searchbyname(cat_exh, "John");
		Cat.searchbylast_name(cat_exh, Kolesnikov);
		Cat.searchbybreed(cat_exh, "siam");
		Cat.searchbyfood(cat_exh, "purina");
		Cat.searchbybreed(cat_exh, "bengal");
		Cat.updateCatName(cat_exh, 1, "Alex");
		Cat.updateCatName(cat_exh, 2, "Whilly");
		Cat.updateCatOwnersName(cat_exh, 3, Levina, "Mann", "Natasha");
		Cat.updateCatAddress(cat_exh, 2, "SPb");
		Cat.updateCatFood(cat_exh, 1, "Kittycat");
		// Cat.writeUsingInputStream();
		Cat.deletecat(cat_exh, 1);

		for (Map.Entry<Integer, Cat> cat : cat_exh.entrySet()) {
			cat.getValue().printcatinfo();
		}
	}

}
