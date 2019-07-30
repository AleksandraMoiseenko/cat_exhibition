package cat_exhibition;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Cat {
	private String name;
	private String food;
	private String breed;
	private HashSet<Human> owners;

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public HashSet<Human> getOwners() {
		return owners;
	}

	public void setOwners(HashSet<Human> owners) {
		this.owners = owners;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void printfood() {
		System.out.println("Cat's food: " + this.getFood());
	}

	public void printbreed() {
		System.out.println("Cat's breed: " + this.getBreed());
	}

	public void printname() {
		System.out.println("Cat's name: " + this.getName());
	}

	public void printowner() {
		for (Human owner : this.getOwners()) {
			owner.printhumaninfo();
		}
	}

	public static void writeUsingOutputStream(String info) throws IOException {
		FileOutputStream fileOutputStream = new FileOutputStream(
				"/Users/svetlanamoiseenko/Desktop/cat_exhibition_output.txt", true);
		String lineSeparator = System.getProperty("line.separator");
		fileOutputStream.write(info.getBytes());
		fileOutputStream.write(lineSeparator.getBytes());
		fileOutputStream.flush();
		fileOutputStream.close();
	}

	public static void writeUsingInputStream() throws IOException {
		FileInputStream fileInputStream = new FileInputStream(
				"/Users/svetlanamoiseenko/Desktop/cat_exhibition_input.txt");

		BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream, 200);

		int i;

		while ((i = bufferedInputStream.read()) != -1)

			System.out.print((char) i);

	}

	public void printcatinfo() {
		System.out.println("Cat's name :" + this.getName());
		System.out.println("Cat's breed :" + this.getBreed());
		System.out.println("Cat's food :" + this.getFood());
		System.out.println("Cat's owners: ");
		for (Human owner : owners) {
			owner.printhumaninfo();
		}

	}

	public static void searchbyid(HashMap<Integer, Cat> catlist, int id) throws IOException {// search cat by cat
																								// exhibition number
		for (Map.Entry<Integer, Cat> cat : catlist.entrySet()) {
			if (cat.getKey() == id) {
				cat.getValue().printcatinfo();
				writeUsingOutputStream(cat.getValue().getName());
				writeUsingOutputStream(cat.getValue().getBreed());
				writeUsingOutputStream(cat.getValue().getFood());
				for (Human owner : cat.getValue().getOwners()) {
					writeUsingOutputStream(owner.getName());
					writeUsingOutputStream(owner.getLast_name());
					writeUsingOutputStream(owner.getAddress());
				}
			}
		}
	}

	public static void searchbyname(HashMap<Integer, Cat> catlist, String name) throws IOException {// search cat info
																									// by it's name
		for (Map.Entry<Integer, Cat> cat : catlist.entrySet()) {
			if (cat.getValue().getName().equals(name)) {
				System.out.println("Exhibition number: " + cat.getKey());
				cat.getValue().printcatinfo();
				writeUsingOutputStream("Exhibition number: " + cat.getKey());
				writeUsingOutputStream(cat.getValue().getName());
				writeUsingOutputStream(cat.getValue().getBreed());
				writeUsingOutputStream(cat.getValue().getFood());
				for (Human owner : cat.getValue().getOwners()) {
					writeUsingOutputStream(owner.getName());
					writeUsingOutputStream(owner.getLast_name());
					writeUsingOutputStream(owner.getAddress());
				}
			}
		}
	}

	public static void searchbylast_name(HashMap<Integer, Cat> catlist, HashSet<Human> owners) throws IOException {// search
																													// cat
																													// by
																													// it's
																													// list
																													// of
																													// owners
		for (Map.Entry<Integer, Cat> cat : catlist.entrySet()) {
			if (cat.getValue().getOwners().equals(owners)) {
				System.out.println("Exhibition number: " + cat.getKey());
				cat.getValue().printcatinfo();
				writeUsingOutputStream("Exhibition number: " + cat.getKey());
				writeUsingOutputStream(cat.getValue().getName());
				writeUsingOutputStream(cat.getValue().getBreed());
				writeUsingOutputStream(cat.getValue().getFood());
				for (Human owner : cat.getValue().getOwners()) {
					writeUsingOutputStream(owner.getName());
					writeUsingOutputStream(owner.getLast_name());
					writeUsingOutputStream(owner.getAddress());
				}
			}
		}
	}

	public static void searchbybreed(HashMap<Integer, Cat> catlist, String breed) throws IOException {// search cat info
																										// by breed
		for (Map.Entry<Integer, Cat> cat : catlist.entrySet()) {
			if (cat.getValue().getBreed().equals(breed)) {
				System.out.println("Exhibition number: " + cat.getKey());
				cat.getValue().printcatinfo();
				writeUsingOutputStream("Exhibition number: " + cat.getKey());
				writeUsingOutputStream(cat.getValue().getName());
				writeUsingOutputStream(cat.getValue().getBreed());
				writeUsingOutputStream(cat.getValue().getFood());
				for (Human owner : cat.getValue().getOwners()) {
					writeUsingOutputStream(owner.getName());
					writeUsingOutputStream(owner.getLast_name());
					writeUsingOutputStream(owner.getAddress());
				}
			}
		}
	}

	public static void searchbyfood(HashMap<Integer, Cat> catlist, String food) throws IOException {// search cat info
																									// by food
		for (Map.Entry<Integer, Cat> cat : catlist.entrySet()) {
			if (cat.getValue().getFood().equals(food)) {
				System.out.println("Exhibition number: " + cat.getKey());
				cat.getValue().printcatinfo();
				writeUsingOutputStream("Exhibition number: " + cat.getKey());
				writeUsingOutputStream(cat.getValue().getName());
				writeUsingOutputStream(cat.getValue().getBreed());
				writeUsingOutputStream(cat.getValue().getFood());
				for (Human owner : cat.getValue().getOwners()) {
					writeUsingOutputStream(owner.getName());
					writeUsingOutputStream(owner.getLast_name());
					writeUsingOutputStream(owner.getAddress());
				}
			}
		}
	}

	public static HashMap<Integer, Cat> updateCatName(HashMap<Integer, Cat> catlist, int id, String newCatName)
			throws IOException {// update
		// cat
		// name
		// by
		// id
		HashMap<Integer, Cat> updateCatList = new HashMap<Integer, Cat>();
		for (Map.Entry<Integer, Cat> cat : catlist.entrySet()) {
			if (cat.getKey() == id)
				cat.getValue().setName(newCatName);
		}
		updateCatList.putAll(catlist);
		for (Map.Entry<Integer, Cat> cat : updateCatList.entrySet()) {
			System.out.println("Exhibition number: " + cat.getKey());
			cat.getValue().printcatinfo();
			writeUsingOutputStream("Exhibition number: " + cat.getKey());
			writeUsingOutputStream(cat.getValue().getName());
			writeUsingOutputStream(cat.getValue().getBreed());
			writeUsingOutputStream(cat.getValue().getFood());
			for (Human owner : cat.getValue().getOwners()) {
				writeUsingOutputStream(owner.getName());
				writeUsingOutputStream(owner.getLast_name());
				writeUsingOutputStream(owner.getAddress());
			}
		}
		return updateCatList;
	}

	public static HashMap<Integer, Cat> updateCatFood(HashMap<Integer, Cat> catlist, int id, String newCatFood)//update cat food by id
			throws IOException {
		HashMap<Integer, Cat> updateCatList = new HashMap<Integer, Cat>();
		for (Map.Entry<Integer, Cat> cat : catlist.entrySet()) {
			if (cat.getKey() == id)
				cat.getValue().setFood(newCatFood);

		}
		updateCatList.putAll(catlist);
		for (Map.Entry<Integer, Cat> cat : updateCatList.entrySet()) {
			System.out.println("Exhibition number: " + cat.getKey());
			cat.getValue().printcatinfo();
			writeUsingOutputStream("Exhibition number: " + cat.getKey());
			writeUsingOutputStream(cat.getValue().getName());
			writeUsingOutputStream(cat.getValue().getBreed());
			writeUsingOutputStream(cat.getValue().getFood());
			for (Human owner : cat.getValue().getOwners()) {
				writeUsingOutputStream(owner.getName());
				writeUsingOutputStream(owner.getLast_name());
				writeUsingOutputStream(owner.getAddress());
			}
		}
		return updateCatList;
	}
	
	public static HashMap<Integer, Cat> updateCatOwnersName(HashMap<Integer, Cat> catlist, int id,
			HashSet<Human> owners, String last_name, String name) throws IOException {// update cat owners by id(if cat was bought after the exhibition)
		HashMap<Integer, Cat> updateCatList = new HashMap<Integer, Cat>();
		for (Map.Entry<Integer, Cat> cat : catlist.entrySet()) {
			for (Human owner : owners) {
				if (cat.getKey() == id)
					owner.setName(name);
				owner.setLast_name(last_name);
			}
		}
		updateCatList.putAll(catlist);
		for (Map.Entry<Integer, Cat> cat : updateCatList.entrySet()) {
			System.out.println("Exhibition number: " + cat.getKey());
			cat.getValue().printcatinfo();
			writeUsingOutputStream("Exhibition number: " + cat.getKey());
			writeUsingOutputStream(cat.getValue().getName());
			writeUsingOutputStream(cat.getValue().getBreed());
			writeUsingOutputStream(cat.getValue().getFood());
			for (Human owner : cat.getValue().getOwners()) {
				writeUsingOutputStream(owner.getName());
				writeUsingOutputStream(owner.getLast_name());
				writeUsingOutputStream(owner.getAddress());
			}
		}
		return updateCatList;
	}

	public static HashMap<Integer,Cat> updateCatAddress(HashMap<Integer, Cat> catlist, int id, String newAddress)
			throws IOException {// update
		// cat
		// address
		// by
		// cat's
		// id
		HashMap<Integer, Cat> updateCatList = new HashMap<Integer, Cat>();
		for (Map.Entry<Integer, Cat> cat : catlist.entrySet()) {
			for (Human owner : cat.getValue().getOwners()) {
				if (cat.getKey() == id)
					owner.setAddress(newAddress);
			}
		}
		updateCatList.putAll(catlist);
		
		for (Map.Entry<Integer, Cat> cat : updateCatList.entrySet()) {
			System.out.println("Exhibition number: " + cat.getKey());
			cat.getValue().printcatinfo();
			writeUsingOutputStream("Exhibition number: " + cat.getKey());
			writeUsingOutputStream(cat.getValue().getName());
			writeUsingOutputStream(cat.getValue().getBreed());
			writeUsingOutputStream(cat.getValue().getFood());
			for (Human owner : cat.getValue().getOwners()) {
				writeUsingOutputStream(owner.getName());
				writeUsingOutputStream(owner.getLast_name());
				writeUsingOutputStream(owner.getAddress());
			}
		}
		return updateCatList;
	}

	public static void deletecat(HashMap<Integer, Cat> catlist, int id) throws IOException {//delete cat from list
		catlist.remove(id);
		for (Map.Entry<Integer, Cat> cat : catlist.entrySet()) {
			System.out.println("Exhibition number: " + cat.getKey());
			cat.getValue().printcatinfo();
			writeUsingOutputStream("Exhibition number: " + cat.getKey());
			writeUsingOutputStream(cat.getValue().getName());
			writeUsingOutputStream(cat.getValue().getBreed());
			writeUsingOutputStream(cat.getValue().getFood());
			for (Human owner : cat.getValue().getOwners()) {
				writeUsingOutputStream(owner.getName());
				writeUsingOutputStream(owner.getLast_name());
				writeUsingOutputStream(owner.getAddress());
			}
		}
	}

	public Cat(String name, String food, String breed, HashSet<Human> owners) {
		this.name = name;
		this.food = food;
		this.breed = breed;
		this.owners = owners;

	}

}
