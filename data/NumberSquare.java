import java.util.Scanner;

/**
 * NumberSquare
 */
public class NumberSquare {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input Number: ");
        int n = sc.nextInt();
        int i, j;
        if (n >= 3) {
            for (i = 1; i <= n; i++) {
                for (j = 1; j <= n; j++) {
                    if (i == 1 || i == n || j == 1 || j == n) {
                        System.out.print(n);
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        } else {
            System.out.println("Wrong Input");
            System.exit(0);
        }
    }
}