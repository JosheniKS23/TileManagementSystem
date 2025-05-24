package hackathon;
import java.util.*;

class InsufficientStock extends Exception {
	
	public InsufficientStock(String message) {
		
		super(message);
		
	}
	
}

class InvalidTileType extends Exception {
	
	public InvalidTileType(String message) {
		
		super(message);
		
	}
	
}

abstract class Tile {
	
	int stockAvailable;
	
	static float profit;
	
	float cost;
	
	float basePrice;
	
	String finish;
	
	double durabilityRating;
	
	String applicationArea;
	
	int area;
	
	float sellingPrice;
	
	abstract float sale(int Area) throws InsufficientStock;
	
	abstract void display();
	
}

class CeramicTile extends Tile {
	
	CeramicTile() {
		
		stockAvailable=10000;
		basePrice=1000;
		finish="Smooth";
		area=2;
		durabilityRating=3.5;
		applicationArea="Interior";
		sellingPrice=basePrice+20/100*basePrice;
		
	}

	
	
	@Override
	float sale(int Area) throws InsufficientStock{
		
		if(stockAvailable==0) {
			
			System.out.println("No stock left in this tile type!!!");
			return 0;
			
		}
		
		int totarea=stockAvailable*area;
		int afsale=totarea-Area;
		
		if (Area>totarea) throw new InsufficientStock("Error: Insufficient stock for ceramic");
		if(Area>totarea*0.5)
			System.out.println("Warning: Large Order detected");
		
		int stavail=afsale/area;
		this.stockAvailable=stavail;
		int tilbought=Area/area;
		float cost=tilbought*sellingPrice;
		profit += 0.2*cost;
		
		System.out.println("Profit For this Sale: "+0.2*cost);
		System.out.println("Profit For this day: "+profit);
		System.out.println("Cost for this sale to be Paid: "+cost);
		return cost;
		
	}

	@Override
	void display() {
		
		System.out.println("\nTile Type: Ceramic");
		System.out.println("Area per tile: " + area);
		System.out.println("Finish: " + finish);
		System.out.println("Durability Rating: "+durabilityRating);
		System.out.println("Application Area: " + applicationArea);
		System.out.println("Tiles Remaining: "+stockAvailable);
		System.out.println("Profit for the day: " + profit);
		
	}
}

class VitrifiedTile extends Tile {
	
	VitrifiedTile() {
		
		stockAvailable=20000;
		basePrice=100;
		finish="Rough";
		area=1;
		durabilityRating=4.5;
		applicationArea="Exterior";
		sellingPrice=basePrice+20/100*basePrice;
	}
	
	@Override
	float sale(int Area) throws InsufficientStock{
		
		if(stockAvailable==0) {
			
			System.out.println("No stock left in this tile type!!!");
			return 0;
			
		}
		
		int totarea=stockAvailable*area;
		int afsale=totarea-Area;
		
		if (Area>totarea) throw new InsufficientStock("Error: Insufficient stock for Vitrified");
		if(Area>totarea*0.5)
			System.out.println("Warning: Large Order detected");
		
		int stavail=afsale/area;
		this.stockAvailable=stavail;
		int tilbought=Area/area;
		float cost=tilbought*sellingPrice;
		profit += 0.2*cost;
		
		System.out.println("Profit For this Sale: "+0.2*cost);
		System.out.println("Profit For this day: "+profit);
		System.out.println("Cost for this sale to be Paid: "+cost);
		return cost;
		
	}
	
	@Override
	void display() {
		
		System.out.println("\nTile Type: Ceramic");
		System.out.println("Area per tile: " + area);
		System.out.println("Finish: " + finish);
		System.out.println("Durability Rating: "+durabilityRating);
		System.out.println("Application Area: " + applicationArea);
		System.out.println("Tiles Remaining: "+stockAvailable);
		System.out.println("Profit for the day: " + profit);
		
	}
	
}

class MarbleTile extends Tile {
	
	MarbleTile() {
		
		stockAvailable=5000;
		basePrice=2000;
		finish="V.Smooth";
		area=5;
		durabilityRating=4.8;
		applicationArea="Interior";
		sellingPrice=(float) (basePrice+0.2*basePrice);
	}
	
	@Override
	float sale(int Area) throws InsufficientStock{
		
		if(stockAvailable==0) {
			
			System.out.println("No stock left in this tile type!!!");
			return 0;
			
		}
		
		int totarea=stockAvailable*area;
		int afsale=totarea-Area;
		
		if (Area>totarea) throw new InsufficientStock("Error: Insufficient stock for Marble");
		if(Area>totarea*0.5)
			System.out.println("Warning: Large Order detected");
		
		int stavail=afsale/area;
		this.stockAvailable=stavail;
		int tilbought=Area/area;
		float cost=tilbought*sellingPrice;
		profit += 0.2*cost;
		
		System.out.println("Profit For this Sale: "+0.2*cost);
		System.out.println("Profit For this day: "+profit);
		System.out.println("Cost for this sale to be Paid: "+cost);
		return cost;
		
	}
	
	@Override
	void display() {
		
		System.out.println("\nTile Type: Ceramic");
		System.out.println("Area per tile: " + area);
		System.out.println("Finish: " + finish);
		System.out.println("Durability Rating: "+durabilityRating);
		System.out.println("Application Area: " + applicationArea);
		System.out.println("Tiles Remaining: "+stockAvailable);
		System.out.println("Profit for the day: " + profit);
		
	}
	
}



public class Question {

	public static void main(String[] args) throws InvalidTileType {
		
		Scanner scan = new Scanner(System.in);
		
		CeramicTile c = new CeramicTile();
		
		VitrifiedTile v = new VitrifiedTile();
		
		MarbleTile m = new MarbleTile();
		
		int  ch;
		
		do {
			System.out.println("-----------------------------------------------------------");
			System.out.println("Enter\n 1.For sale\n 2.Stock Modification\n 3.Display");
			
			ch = scan.nextInt();
			switch(ch) {
			
			case 1:
				
				System.out.println("Enter Area of required!!!");
				int ar=scan.nextInt();
				System.out.println("Enter Tile preferred!!!");
				
				String z=scan.next();
				if (!(z.compareTo("Ceramic")==0||z.compareTo("ceramic")==0||z.compareTo("Vitrified")==0||z.compareTo("vitrified")==0||
						z.compareTo("Marble")==0||z.compareTo("marble")==0)) throw new InvalidTileType("Error: Tile Type not available.");
				
				if(z.compareTo("Ceramic")==0||z.compareTo("ceramic")==0) {
					try {
						
						c.sale(ar);
						
					} catch (InsufficientStock e) {
						
						e.printStackTrace();
						
					}
				}
				else if(z.compareTo("Vitrified")==0||z.compareTo("vitrified")==0) {
					try {
						
						v.sale(ar); 
					} catch (InsufficientStock e) {
						
						e.printStackTrace();
					}
				}
				else if(z.compareTo("Marble")==0||z.compareTo("marble")==0) {
					try {
						
						m.sale(ar); 
						
					} catch (InsufficientStock e) {
						
						e.printStackTrace();
					}
				}
				else {
					break;
				}
				
				break;
				
			case 2:
				System.out.println("Enter tile name accurately!!!");
				String x=scan.next();
				
				if (!(x.compareTo("Ceramic")==0||x.compareTo("ceramic")==0||x.compareTo("Vitrified")==0||x.compareTo("vitrified")==0||
						x.compareTo("Marble")==0||x.compareTo("marble")==0)) throw new InvalidTileType("Error: Tile Type not available.");
				
				if(x.compareTo("Ceramic")==0||x.compareTo("ceramic")==0) {
					
					c.display();
					System.out.println("\nEnter the newly available stock!!!");
					c.stockAvailable=scan.nextInt();
					System.out.println("Changed Successfully");
					System.out.println("Stock after changing");
					c.display();
					
				}
				else if(x.compareTo("Vitrified")==0||x.compareTo("vitrified")==0) {
					
					v.display();
					System.out.println("\nEnter the newly available stock!!!");
					v.stockAvailable=scan.nextInt();
					System.out.println("Changed Successfully");
					System.out.println("Stock after changing");
					v.display();
					
				}
				else if(x.compareTo("Marble")==0||x.compareTo("marble")==0) {
					
					m.display();
					System.out.println("\nEnter the newly available stock!!!");
					m.stockAvailable=scan.nextInt();
					System.out.println("Changed Successfully");
					System.out.println("Stock after changing");
					m.display();
					
				}
				else 
					break;
				
				break;
				
			case 3:
				System.out.println("Enter tile name accurately!!!");
				String y=scan.next();
				if (!(y.compareTo("Ceramic")==0||y.compareTo("ceramic")==0||y.compareTo("Vitrified")==0||y.compareTo("vitrified")==0||
						y.compareTo("Marble")==0||y.compareTo("marble")==0)) throw new InvalidTileType("Error: Tile Type not available.");
				
				if(y.compareTo("Ceramic")==0||y.compareTo("ceramic")==0) {
					c.display();
				}
				else if(y.compareTo("Vitrified")==0||y.compareTo("vitrified")==0) {
					v.display();
				}
				else if(y.compareTo("Marble")==0||y.compareTo("marble")==0) {
					m.display();
				}
				else {
					break;
				}
				break;
				
			default:
				System.out.println("Invalid choice");
				break;
				
			}
			
			
		}while(ch!=4);
		
		scan.close();
		
	}

}
