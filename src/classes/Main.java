package classes;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;

public class Main {
	
	Scanner scan = new Scanner(System.in);
	ArrayList<Shoe> shoes = new ArrayList<>();
	
	void viewShoe() {
		if(shoes.isEmpty()) {
			System.out.println("No shoes available..");
			System.out.print("Press enter to continue..");
			scan.nextLine();
		} else {
			for(int i = 0; i < shoes.size(); i++) {
				System.out.printf("%d %s-%s\n", i + 1, shoes.get(i).name, shoes.get(i).id);
				System.out.println("====================");
				System.out.println("Category: " + shoes.get(i).category);
				System.out.println("Release date: " + shoes.get(i).releaseDate);
				System.out.println("Price: " + shoes.get(i).price);
			}
			System.out.print("Press enter to continue...");
			scan.nextLine();
		}
		
	}
	
	void addShoe() {
		int price;
		String name, category, releaseDate;
		
		do {
			System.out.print("Input shoe's name[name ends with shoe, example: \"Fire Shoe\"]: ");
			name = scan.nextLine();
		} while (!checkName(name));
		
		do {
			System.out.print("Input shoe's category[Sneaker | Running | Boot] (case sensitive): ");
			category = scan.nextLine();
		} while (!checkCategory(category));
		
		do {
			System.out.print("Input shoe's release date [dd-mm-yyyy]: ");
			releaseDate = scan.nextLine();
		} while (!checkReleaseDate(releaseDate));
		
		do {
			System.out.print("Input shoe's price [more than or equals to 5000]: ");
			price = scan.nextInt();
			scan.nextLine();
		} while (!checkPrice(price));
		
		Shoe temp = new Shoe(category, name, releaseDate, price);
		shoes.add(temp);
		System.out.println("Shoe added!");
		System.out.print("Press enter to continue...");
		scan.nextLine();
	}
	
	boolean checkName(String name) {
		if(name.endsWith("shoe")) {
			return true;
		} 
		
		return false;
	}
	
	boolean checkCategory(String category) {
		if(category.equals("Sneaker") || category.equals("Running") || category.equals("Boot")) {
			return true;
		}
		
		return false;
	}
	
	boolean checkReleaseDate(String date) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			dateFormat.setLenient(false);
			dateFormat.parse(date);	
		} catch(ParseException e) {
			return false;
		}
		
		return true;
	}
	
	boolean checkPrice(int price) {
		if(price >= 5000) {
			return true;
		}
		
		return false;
	}
	
	void deleteShoe() {
		if(shoes.isEmpty()) {
			System.out.println("No shoes available..");
			System.out.print("Press enter to continue..");
			scan.nextLine();
		} else {
			viewShoe();
			int idx = -1;
			do {
				System.out.print("Choose shoe's number to delete[1.." + shoes.size() + "]: ");
				idx = scan.nextInt();
				scan.nextLine();
			} while (idx < 1 || idx > shoes.size());
			
			shoes.remove(idx - 1);
			System.out.print("Shoe removed!");
			scan.nextLine();
		}
	}
	
	void menu() {
		int choice = 0, end = 0;
		do {
			do {
				System.out.println("Shoe Shop");
				System.out.println("=========");
				System.out.println("1. View Shoes");
				System.out.println("2. Add Shoe");
				System.out.println("3. Delete Shoe");
				System.out.println("4. Exit");
				System.out.print(">> ");
				choice = scan.nextInt();
				scan.nextLine();
				
				if(choice < 1 || choice > 4) {
					System.out.print("Input must between 1 and 4");
					scan.nextLine();
				}
				
			} while (choice < 1 || choice > 4);
			
			switch(choice) {
			case 1:
				viewShoe();
				break;
			case 2:
				addShoe();
				break;
			case 3:
				deleteShoe();
				break;
			case 4:
				System.out.println("Thank you for using this application!");
				end = 1;
				break;
			}
			
			
		} while (end == 0);
	}
	
	public Main() {
		menu();
	}

	public static void main(String[] args) {
		new Main();
		
	}

}
