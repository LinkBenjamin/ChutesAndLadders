import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Ben Link
 * 
 * Play Chutes & Ladders.
 *
 */
public class Game {
	private final static int WINNING_SQUARE = 100;
	private final static int SPINNER_MAX = 6;
	
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        boolean gameContinues = true;
        
        // Game loop.  Keep going until we say we don't wanna anymore.
        do{
            playGame(console);
            gameContinues = askUserBoolean("Play again? (y/n): ", console);
        } while(gameContinues);
        
        console.close();
    }
    
    /**
     * playGame() is how you play one round.
     * 
     * @param console The input device.
     */
    private static void playGame(Scanner console) {
        // TODO Play the game Chutes & Ladders.
    	boolean weHaveAWinner = false;
    	Spinner spinner = new Spinner(SPINNER_MAX);
    	
    	Player winner = new Player();
        
    	winner.setName("Nobody");
        // Acquire player information
        List<Player> players = getPlayerInfo(console);
        
        do{
        
	        for(Player player: players){
	            // take a turn
	        	spinner.spin();
	        	player.move(spinner.getCurrentValue());
	            
	            // evaluate whether this player won
	        	if(player.getCurrentSquareNumber() == WINNING_SQUARE){
		            // if so, set weHaveAWinner, the winner object, and break
	        		weHaveAWinner = true;
	            	winner = player;
	            	break;
	            }
	        }
	    
        } while (!weHaveAWinner);
        
        // announce winner and congratulate them
      	congratulate(winner);
    }

    /**
     * getPlayerInfo() assembles a list of players for the current round.  
     * It will at some point need to get their names from the user.
     * 
     * @param console The input device.     * 
     * @return a List of Players who are going to play this round.
     */
    private static List<Player> getPlayerInfo(Scanner console) {
    	List<Player> response = new ArrayList<Player>();
    	int playerCount = 0;
    	
    	do{
    		Player newPlayer = new Player();
    		
    		newPlayer.setName(askUserString("Enter player " + ++playerCount + "'s name: ", console));
    		
    		response.add(newPlayer);
    		
    	} while (askUserBoolean("Add another player? (y/n):", console));
    	
    	return response;
    }

    /**
     * Ask the user a question.  Get a yes or no answer.
     * 
     * @param prompt  What are you asking?
     * @param console The input object
     * @return True = yes, False = no.
     */
    private static boolean askUserBoolean(String prompt, Scanner console) {
        
        boolean response = false;
        boolean valid = false;
        
        System.out.print(prompt);
        
        do{
            String value = console.next();
        
            switch(value.charAt(0)){
                case 'y':
                case 'Y':
                        response = true;
                        valid = true;
                    break;
                case 'n':
                case 'N':
                        response = false;
                        valid = true;
                    break;
                default:
                    System.out.print("Hey. Doofus.  Yes or No only, please? :");
                    valid = false;
                    break;
            }
                    
         } while(!valid);
            
        return response;
    }

    /**
     * Ask the user a question.  Get a String response
     * 
     * @param prompt  What are you asking?
     * @param console The input object
     * @return a String.
     */
    private static String askUserString(String prompt, Scanner console) {
        
        System.out.print(prompt);
        
        return console.next();
    }
    /**
     * congratulate is the method that prints out the person who won.
     * 
     * @param winner Who won the game.
     */
    private static void congratulate(Player winner){
    	System.out.print("Winner, winner, chicken dinner! " + winner.getName() + " has won the game.");
    }
}
