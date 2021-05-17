package classes;

import java.util.concurrent.ThreadLocalRandom;

public class Shoe {
	String id;
	String name;
	String category;
	String releaseDate;
	Integer price;
	
	Shoe(String category, String name, String releaseDate, Integer price) {
		this.id = generateRandom();
		this.name = name;
		this.category = category;
		this.releaseDate = releaseDate;
		this.price = price;
	}
	
	String generateRandom() {
		String Id = "SH";
		for(int i = 0; i < 3; i++) {
			Integer rand = ThreadLocalRandom.current().nextInt(0, 10); 
			Id += rand.toString();
		}
		
		return Id;
	}

}
