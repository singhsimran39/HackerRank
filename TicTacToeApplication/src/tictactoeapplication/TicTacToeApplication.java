
package tictactoeapplication;

import java.util.Scanner;

public class TicTacToeApplication {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        boolean doYouWanaPlay = true;
        while(doYouWanaPlay) {

            System.out.println("Welcome. Enter your token");
            char playerToken = in.next().charAt(0);
            System.out.println("Enter my token");
            char aiToken = in.next().charAt(0);
            
            if(aiToken == playerToken) {
                System.out.println("Enter different tokens");
                continue;
            }

            TicTacToe game = new TicTacToe(playerToken, aiToken);
            AI ai = new AI();
            
            TicTacToe.printIndexBoard();
        
            while (game.gameOver().equals("notOver")) {                
                if(game.currentMarker == game.userMarker) {
                    System.out.println("Your turn. Enter number for token");
                    int spot = in.nextInt();
                    while (!game.playTurn(spot)) {                        
                        System.out.println("In valid, enter again.");
                        spot = in.nextInt();
                    }
                    System.out.println("You picked: " + spot + "!");
                } else {
                    System.out.println("My turn");
                    int aiSpot = ai.pickSpot(game);
                    game.playTurn(aiSpot);
                    System.out.println("I picked: " + aiSpot);
                }
                System.out.println();
                game.printBoard();
            }
            
            System.out.println(game.gameOver());
            System.out.println();
            
            System.out.println("Want to play again (Y/N)");
            char response = in.next().charAt(0);
            doYouWanaPlay = (response == 'Y');
        }
        
    }
    
}
