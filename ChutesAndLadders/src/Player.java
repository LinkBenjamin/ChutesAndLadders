import java.util.Date;

public class Player {
    private String name;
    private int currentSquareNumber;
    
	public Player() {
		setName("Player_" + new Date().getTime());
		setCurrentSquareNumber(0);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCurrentSquareNumber() {
		return currentSquareNumber;
	}

	public void setCurrentSquareNumber(int currentSquareNumber) {
		this.currentSquareNumber = currentSquareNumber;
	}

	public void move(int currentValue) {
		System.out.println(getName() + " is on space #" + getCurrentSquareNumber() + ".");
		System.out.println(getName() + " has spun a " + currentValue);
		
		if((getCurrentSquareNumber() + currentValue) > 100){
			System.out.println(getName() + " cannot move this turn.");
		} else {
			setCurrentSquareNumber(getCurrentSquareNumber() + currentValue);
			
			evaluateBoard();
		}
		
		System.out.println(getName() + "'s turn has ended on space " + getCurrentSquareNumber());
	}

	private void evaluateBoard() {
		switch(getCurrentSquareNumber()){
		case 1:
			climb("plants a flower, causes allergic reactions in thousands", 38);
			break;
		case 4:
			climb("bakes a cake, contributes to American obesity", 14);
			break;
		case 9:
			climb("mows the lawn, earns some money to waste at the county fair", 31);
			break;
		case 21:
			climb("finds a spotted cat, locates leopard that escaped the zoo", 42);
			break;
		case 28:
			climb("finds a stray cat in a tree, Chinese for dinner tonight", 84);
			break;
		case 36:
			climb("eats healthy stuff, retches uncontrollably", 44);
			break;
		case 51:
			climb("cleans the house", 67);
			break;
		case 71:
			climb("snatches some chick's purse, buys an ice cream", 91);
			break;
		case 80:
			climb("starts a dogfighting ring, earns enough for college", 100);
			break;
		case 16:
			slide("engages in independent reading, gets unfairly punished", 6);
			break;
		case 47:
			slide("goes skating, falls in, files lawsuit", 26);
			break;
		case 49:
			slide("buys imported chocolates, finds they were past the expiration date", 11);
			break;
		case 56:
			slide("plays in the rain, pays the consequences", 53);
			break;
		case 62:
			slide("does chores that aren't age-appropriate, suffers abuse", 19);
			break;
		case 64:
			slide("tries to learn a new skill, fails", 60);
			break;
		case 87:
			slide("tries to get a quick snack, is punished for it", 24);
			break;
		case 93:
			slide("attempts to provide a splash of color, is unappreciated", 73);
			break;
		case 95:
			slide("finds a broken window while playing ball, offers to fix it", 75);
			break;
		case 98:
			slide("grabs a tiger by the tail, finds out that there are teeth in the other end", 78);
			break;
		default:
			break;
		}		
	}

	private void slide(String string, int newSpace) {
		System.out.println(getName() + " " + string + "! Sliding to space " + newSpace);
		setCurrentSquareNumber(newSpace);		
	}

	private void climb(String string, int newSpace) {
		System.out.println(getName() + " " + string + "! Climbing to space " + newSpace);
		setCurrentSquareNumber(newSpace);		
	}
    
}
