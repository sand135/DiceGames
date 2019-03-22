package se.iths.sandra;

import java.util.ArrayList;
import java.util.Scanner;

public class PigGame {
    public static void main(String[] args) {
        System.out.println("Välkommen till 'PigGame' ");

        Scanner sc = new Scanner(System.in);
        ArrayList<Player> players = initialize(sc);

        while (true) {
            for (Player p : players) {
                playTurn(p, 0, sc);
            }
        }
    }


    private static ArrayList<Player> initialize(Scanner sc) {
        System.out.println("Hur många spelare?");
        int amountOfPlayers = sc.nextInt();
        ArrayList<Player> players = new ArrayList<>();
        sc.nextLine();
        for (int i = 0; i < amountOfPlayers; i++) {
            System.out.println("Namn på spelare " + (i + 1) + "?");
            String name = sc.nextLine();
            players.add(new Player(name));
            players.get(i).addDie();
        }
        return players;
    }

    private static void playTurn(Player p, int startPoints, Scanner sc) {

        int turnPoints = p.roll();
        int turnTotal = startPoints + turnPoints;
        int playerScore = p.getScore() + turnTotal;

        System.out.println(p.getName() + " kastar, och får: " + turnPoints);


            if (checkPointsForContinuation(p, turnPoints, playerScore) == false) {
                return;
            } else {
                System.out.println("Du har nu sammanlagt " + playerScore + " poäng.");
                System.out.println("vill du fortsätta? ja/nej");
                String answer = sc.nextLine();

                if (answer.equals("ja")) {
                    playTurn(p, turnTotal, sc);
                    return;

                } else if (answer.equals("nej")) {
                    p.increasePlayerScore(turnTotal);
                    System.out.println("Turen går vidare!");
                    return;
                }

            }
    }

    private static boolean checkPointsForContinuation(Player p,int turnPoints, int playerScore) {
        if (turnPoints == 1) {
            System.out.println("Turen går vidare");
            return false;
        } else if (playerScore >= 100) {
            System.out.println(p.getName()+" vann!");
            System.exit(0);
        }

        return true;
    }
}


