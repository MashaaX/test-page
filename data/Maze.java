
import java.util.Scanner;

/**
 * Maze
 */
public class Maze {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] maze = new char[][] { { '|', '|', '|', '|', '|', '|', '|', '|', '|', '|', '|', '|', '|', },
                { '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', '|', },
                { '|', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', '*', '|', ' ', '|', },
                { '|', ' ', ' ', '|', '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', },
                { '|', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', '|', },
                { '|', ' ', ' ', ' ', ' ', '|', '*', ' ', ' ', ' ', ' ', ' ', '|', },
                { '|', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', '|', },
                { '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*', '|', ' ', '|', },
                { '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', '|', },
                { '|', '|', '|', '|', '|', '|', '|', '|', '|', '|', '|', '|', '|', } };

        int poin = 0;

        int playerx = 1;
        int playery = 1;
        maze[playerx][playery] = 'o';
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }

        while (true) {
            System.out.println();
            System.out.print("Movement = ");
            String move = sc.nextLine();

            if (move.equalsIgnoreCase("W") || move.equalsIgnoreCase("A") || move.equalsIgnoreCase("S")
                    || move.equalsIgnoreCase("D")) {
                maze[playerx][playery] = ' ';
                if (move.equalsIgnoreCase("W")) {
                    playerx = playerx - 1;

                    if (maze[playerx][playery] == '|') {
                        playerx++;
                    }
                }
                if (move.equalsIgnoreCase("A")) {
                    playery = playery - 1;
                    if (maze[playerx][playery] == '|') {
                        playery++;
                    }
                }
                if (move.equalsIgnoreCase("S")) {
                    playerx = playerx + 1;
                    if (maze[playerx][playery] == '|') {
                        playerx--;
                    }
                }
                if (move.equalsIgnoreCase("D")) {
                    System.out.println();
                    playery = playery + 1;
                    if (maze[playerx][playery] == '|') {
                        playery--;
                    }
                }
                if (maze[playerx][playery] == '*') {
                    poin++;
                } else {
                    poin = poin;
                }
                System.out.println(" Your Points is : " + poin);
                maze[playerx][playery] = 'o';
                for (int i = 0; i < maze.length; i++) {
                    for (int j = 0; j < maze[i].length; j++) {
                        System.out.print(maze[i][j]);
                    }
                    System.out.println();
                }
                if (poin >= 4) {
                    System.out.println("Congratulations !");
                    System.exit(0);
                }
            } else {
                System.out.println("Wrong Input!");
            }
        }
    }
}