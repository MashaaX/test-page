import java.util.Scanner;

/**
 * HourGlass
 */
public class HourGlass {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input Number: ");
        int n = sc.nextInt();
        int i;
        for (i = n; i >= 1; i--) {
            for (int j = n; j > i; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k < (i * 2); k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (i = 2; i <= n; i++) {
            for (int j = i; j < n; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k < (i * 2); k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

}