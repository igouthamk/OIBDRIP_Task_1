import java.util.*;
public class NumberGuessingGame {
    static ArrayList<Integer> Score = new ArrayList<Integer>();

    public void task(ArrayList<Integer> Score) {
        NumberGuessingGame perform = new NumberGuessingGame();
        Scanner input = new Scanner(System.in);
        System.out.println("--------------------");
        System.out.println("Welcome to the number game");
        System.out.println("1) Play the Game");
        System.out.println("2) Score Board");
        System.out.println("3) Exit the game");
        System.out.println("--------------------");
        try {
            System.out.print("What action would you like to do from the above actions? ");
            int taskOption = input.nextInt();
            switch (taskOption) {
                case 1:
                    System.out.print("\n"+"What would you like the range of the numbers to be? ");
                    int numberRange = input.nextInt();
                    int randomNumber = perform.randomNumber(numberRange);
                    perform.guessNumber(randomNumber);
                    break;
                case 2:
                    perform.displayScore();
                    break;
                case 3:
                    System.out.println("\n"+"Thanks for playing the game!");
                    System.exit(1);
                    break;
                default:
                    throw new InputMismatchException("Invalid number entry.Could you please Try again later");
            }
        }catch(InputMismatchException e){
            System.err.println("\n"+e.getMessage() +"\n");
            task(Score);
        }
    }
    public int randomNumber(int numberRange) {
        Random random = new Random();
        int randomNumber = random.nextInt(numberRange) + 1;
        return randomNumber;
    }
    public void guessNumber(int randomNumber) {
        Scanner input = new Scanner(System.in);
        int userGuess;
        int guess = 0;
        do {
            System.out.print("Enter your guess number: ");
            userGuess = input.nextInt();
            guess++;
            if (userGuess > randomNumber) {
                System.out.println("Lower");
            } else if (userGuess < randomNumber) {
                System.out.println("Higher");
            }
        } while (randomNumber != userGuess);
        System.out.println(" ");
        if (guess == 1) {
            System.out.println("You answered number is right in " + guess + " try!");
        } else {
            System.out.println("You answered number is right in " + guess + " tries!");
        }
        Score.add(guess);
        System.out.println(" ");

        task(Score);
    }
    public void displayScore() {
        System.out.println("--------------------");
        System.out.println("Score Board");
        System.out.println("--------------------");
        Collections.sort(Score);
        System.out.println("Your fastest games today out of all tries is: " +Collections.min(Score)+"\n");
        for (Integer scores : Score) {
            System.out.println("Finished the number game in " + scores + " tries");
        }
        System.out.println(" ");
        task(Score);
    }
    public static void main(String[] args) {
        NumberGuessingGame perform = new NumberGuessingGame();
        perform.task(Score);
    }
}
