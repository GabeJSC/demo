import java.util.Scanner;
import java.lang.Math;
import java.util.Random;

/***
 * Lab 3 Partner 10
 * Description: This program is a combined effort that will have the user play a game of rock, paper, scissors created by Gabriel Salinas-Carter
 * or try their luck in a guessing game created by Anthony Sieling
 * @author Gabriel Salinas-Carter
 * @author Anthony Sieling
 * @since 03/19/25
 */

public class guess {

    /**
     * /Welcome message that welcomes user to and explains program
     */

    public static void welcome(){
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Welcome! thank you for choosing our program.");
        System.out.println("You will be given the choice to play either a guessing game or rock, paper, scissors.");
        System.out.println("Please choose which one you would like and play for as long as you want.");
        System.out.println("Good luck and have fun!");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
    }

    /**
     * Method containing game of rock, paper, scissors and loops until user inputs to stop
     */

    public static void rockPaperScissors() {
        boolean playAgain = true;
        while (playAgain) {
            Scanner scanner = new Scanner(System.in);//Creates scanner object for user input
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Please pick a number");//User options for Rock,Paper, Scissors
            System.out.println("1. Rock");
            System.out.println("2. Paper");
            System.out.println("3. Scissors");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
            int userChoice = scanner.nextInt();

            Random random = new Random();//Generates Computers choice at random
            int computerChoice = random.nextInt(3) + 1;//Bounds it to 1-3

            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("You chose " + choiceToString(userChoice));//Displays users choice
            System.out.println("Computer chose " + choiceToString(computerChoice));//Displays Computers choice
            String result = winner(userChoice, computerChoice);
            System.out.println(result);
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Would you like to play again? (yes/no)");
            while (true) {//Looped to allow continous games until user chooses to exit
                String playAgainChoice = scanner.next().toLowerCase();//User inputs if they would like to play again

                if (playAgainChoice.equals("yes")) {
                    playAgain = true;//Plays again if user chooses yes
                    break;//Exits loop and plays again
                }
                else if (playAgainChoice.equals("no")) {
                    playAgain = false;//Ends game if user chooses no
                    System.out.println("Thank you for playing!");
                    break;//Exits loop and ends the game
                } else {
                    System.out.println("Invalid choice! Please type yes or no.");//Error message if invalid input
                }
            }
        }
    }

    /**
     * Converts int choice to string
     * @param choice
     * @return returns choice to string
     */

    public static String choiceToString(int choice) {
        switch (choice) {
            case 1:
                return "Rock";
            case 2:
                return "Paper";
            case 3:
                return "Scissors";
            default:
                return "Invalid choice";
        }
    }

    /**
     * Compares users choice to computers choice to see who wins
     * @param userChoice
     * @param computerChoice
     * @return Outcome of come
     */

    public static String winner(int userChoice, int computerChoice) {
        if (userChoice == computerChoice) {
            return "Tie";
        } else if ((userChoice == 1 && computerChoice == 3) || //Rock beats Paper
                (userChoice == 2 && computerChoice == 1) || //Paper beats rock
                (userChoice == 3 && computerChoice == 2)) { // Scissors beat paper
            return "You win!";
        } else {
            return "You lose!";
        }
    }

    /** Sets varaibles then begins a loop that continues a number guessing game until the user wants to stop
     * @author Anthony Sieling
     */
    public static void numberGuess() {


        Scanner input = new Scanner(System.in);
        int guessCount = 0;
        int numG = 0;
        int magicNum = 5;
        int hazardWarn = 0;
        String option =  "Y" ;


        magicNum = (int) (Math.random()*100);
        do {

            if (guessCount == 0 && hazardWarn == 0) {
                System.out.println("I'm thinking of a number between 1 and 100");
                System.out.println("Guess what it is. You have 5 tries:");
            }
            hazardWarn = 0;

            if (input.hasNextInt())
                numG= (int) input.nextDouble();
            else {
                input.next();
                System.out.println("Invalid Guess try again");
                hazardWarn = 1;
                guessCount = guessCount -1;
            }

            input.nextLine();
            guessCount ++;

            if (numG < magicNum &&  (guessCount < 5) && hazardWarn == 0){
                System.out.println("Nope too Low Try again (" + (5 - guessCount) + " tries left)");
            }
            if (numG > magicNum &&  (guessCount < 5 && hazardWarn == 0)){
                System.out.println("Nope too high Try again (" + (5 - guessCount) + " tries left)");
            }
            if (numG == magicNum){
                System.out.println("Congrats you Guessed correctly");
                System.out.println("Do you want to play again (y/n) ");

                option = input.nextLine();
                guessCount = 0;
                magicNum = (int) (Math.random()*100);
            }
            else if (guessCount == 5){
                System.out.println("no but nice try the number was "+magicNum);
                System.out.println("Enter Y to play again ");

                option = input.nextLine();

                guessCount = 0;
                magicNum = (int) (Math.random()*100);

            }


        }while (option.equalsIgnoreCase("y")) ;
    }

    /**
     * main method
     * @param args
     */

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int option;
        boolean playAgain = true;
        while (playAgain){
            welcome();
            System.out.println("Please choose one of the games:");
            System.out.println("1. Rock, Paper, Scissors");
            System.out.println("2. Guessing game");
            System.out.println("3. Quit");
            option = in.nextInt();
            switch (option) {
                case 1:
                    rockPaperScissors();
                    break;
                case 2:
                    numberGuess();
                    break;
                case 3:
                    playAgain = false;
                    break;
                case 4:
                    System.out.println("Invalid input! Please choose an option!");
                    break;
            }
        }
    }
}



