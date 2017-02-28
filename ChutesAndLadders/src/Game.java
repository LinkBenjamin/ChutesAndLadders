import java.util.List;
import java.util.Scanner;

/**
 * @author Ben Link
 * 
 * Play Chutes & Ladders.
 *
 */
public class Game {
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
        
        // Acquire player information
        List<Player> players = getPlayerInfo(console);
        
        // Set up the board
        
        // do
        
        for(Player player: players){
            // take a turn
            
            // evaluate whether this player won
            // if so, set weHaveAWinner and break
            // if not, next player
        }
        
        
        // while not weHaveAWinner
        
        // announce winner and congratulate them        
    }

    /**
     * getPlayerInfo() assembles a list of players for the current round.  
     * It will at some point need to get their names from the user.
     * 
     * @param console The input device.     * 
     * @return a List of Players who are going to play this round.
     */
    private static List<Player> getPlayerInfo(Scanner console) {
        // TODO Auto-generated method stub
        return null;
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
}
