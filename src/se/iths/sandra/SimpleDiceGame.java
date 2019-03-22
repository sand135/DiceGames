package se.iths.sandra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SimpleDiceGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Välkommen till 'simpleDiceGame' !");

        ArrayList<Player> players = initialize(sc);

            for (int i = 0; i < 5; i++) {
                takeTurn(players, sc);
                for (Player p : players) {
                    System.out.println(p.getName() + " poäng efter ronden: ");
                    System.out.println(p.getScore());
                }
            }

        DisplayWinners(players);
    }



    private static ArrayList<Player>initialize(Scanner sc) {
       System.out.println("Hur många spelare?");
       int amountOfPlayers = sc.nextInt();
       ArrayList<Player> players = new ArrayList<>();

       System.out.println("Hur många tärningar per spelare?");
       int dices = sc.nextInt();
       System.out.println("Hur många sidor per tärning?");
       int sides = sc.nextInt();
       sc.nextLine();
           for (int i = 0; i < amountOfPlayers; i++) {
               System.out.println("Namn på spelare " + (i+1) + "?");
               String name = sc.nextLine();
               players.add(new Player(name));
                   for (int j = 0; j < dices; j++) {
                       players.get(i).addDie(sides);
                   }
           }
       return players;
   }

    private static void takeTurn(ArrayList<Player> players, Scanner sc){

        for (Player p : players){
            System.out.println(p.getName() +", gissa vad du kommer att få...");
            int guess = sc.nextInt();
            System.out.println(p.getName() +" kastar: ");
            p.rollDice();
            checkForScores(p, guess);
        }
    }

    private static void checkForScores(Player p, int guess) {
        if(p.getDieValue() == guess){
            System.out.println("Du gissade rätt! Ett + poäng!");
            p.increasePlayerScore();
        }else{
            System.out.println("Du gissade fel...:( ");
        }
    }

    private static ArrayList<Player> getWinners(ArrayList<Player> players){
            ArrayList<Player>winners =new ArrayList<>();
            int maxScore = 0;
            for (int i=0; i<players.size(); i++) {
                if (players.get(i).getScore() == maxScore ){
                    winners.add(players.get(i));
                }
                else if(players.get(i).getScore() > maxScore ){
                    maxScore = players.get(i).getScore();
                    winners.clear();
                    winners.add(players.get(i));
                }
            }
            return winners;
        }

    private static void DisplayWinners(ArrayList<Player> players) {
        String s= "Grattis!";
        System.out.println("Vinnarlistan: ");
        for (Player p : getWinners(players)) {
            if (p.getScore() == 0) {
                s = "Noll poäng åt alla. Ingen vinner... :( ";
                break;
            } else {
                System.out.println(p.getName() + " med " + p.getScore()+ " poäng!");
            }
        } System.out.println(s);
    }

}
