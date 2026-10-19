import java.util.Random;
import java.util.Scanner;
public class Main {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int rollOne;
        int rollTwo;
        int firstRoll;
        int nthRolls;
        boolean done = false;
        boolean inPointPhase = false;
        do {
            rollOne = random.nextInt(1, 6);
            rollTwo = random.nextInt(1, 6);
            firstRoll = rollOne + rollTwo;
            if (firstRoll == 2 || firstRoll == 3 || firstRoll == 12) {
                System.out.printf("%s%s\n", "You crapped out!", " Values:");
                System.out.printf(" %d", rollOne);
                System.out.printf(" %d", rollTwo);
            }
            else if (firstRoll == 7 || firstRoll == 11) {
                System.out.println("You got a natural (you win)");
            }
            else {
                System.out.println("You didn't crap out or get a natural, on to the point phase");
                inPointPhase = true;
                do {
                    rollOne = random.nextInt(1, 6);
                    rollTwo = random.nextInt(1, 6);
                    nthRolls = rollOne + rollTwo;
                    if (nthRolls == firstRoll) {
                        inPointPhase = false;
                        System.out.printf("%s %d\n","You hit the point sum!", firstRoll);
                    } else if (nthRolls == 7) {
                        inPointPhase = false;
                        System.out.println("You made a 7, you lose");
                    }
                } while (inPointPhase);
            }
            System.out.print("Play again [Y/N] ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("y")) {
                continue;
            }
            else {
                done = true;
            }
        } while (!done);
    }
}