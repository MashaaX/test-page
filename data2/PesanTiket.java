import java.util.Scanner;

/**
 * PesanTiket
 */
public class PesanTiket {

    static String[] menu = { " The Shawshank Redemption", "Ready Player One", "No Game NO Life ZERO",
            "Avanger Infinity War" };

    static String[] seatmenu = { "Special Ticket", "Executive Ticket" };

    static int[] price = { 50000, 35000 };

    static String[] timeShow = { "13.00 WIB", "15.00 WIB", "18.00 WIB", "20.00 WIB" };

    public static void main(String[] args) {

        do {
            register();
            ChooseMovie();
            OrderTicket();
            TimeChoose();
            ticketAmount();
        } while (repeat());
    }

    public static void register() {
        boolean status = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("________________________________________________");
        System.out.println("|                   WELCOME                     |");
        System.out.println("|               TO OUR PREMIERE                 |");
        System.out.println("|                GRAND THEATER                  |");
        System.out.println("|                                               |");
        System.out.println("|              YOUR SATISFACTION                |");
        System.out.println("|               IS OUR MISSION                  |");
        System.out.println("|                                               |");
        System.out.println("|                PLEASE LOGIN                   |");
        System.out.println("|            WE WANT TO KNOW YOU :)             |");
        System.out.println("|_______________________________________________|");
        System.out.println("");
        // just for input login, there are no username
        System.out.print("Your name: ");
        String username = sc.nextLine();
        System.out.println("\nHello " + username + "\n");
    }

    // for receipt
    static String[] judul = new String[2];

    static void title() {
        // choose the movie
        System.out.print("\nChoose Your Movie(1 - 5): ");
        Scanner sc = new Scanner(System.in);
        int clip = sc.nextInt();
        if (clip >= 1 && clip <= 4) {
            System.out.println("\n" + "\"" + menu[clip - 1] + "\"\n");
            judul[1] = menu[clip - 1];
        } else if (clip == 5) {
            System.exit(0);
        } else {
            System.out.println("\nPlease Input The RIGHT Amount");
            ChooseMovie();
        }
    }

    public static void ChooseMovie() {

        System.out.println("##############################################");
        System.out.println("#       1.The Shawshank Redemption           #");
        System.out.println("#       2.Ready Player One                   #");
        System.out.println("#       3.No Game NO Life ZERO               #");
        System.out.println("#       4.Avanger Infinity War               #");
        System.out.println("#       5.        EXIT                       #");
        System.out.println("##############################################");
        title();
    }

    // for receipt later
    static String[] duduk = new String[2];

    static int[] mainPrice = new int[2];

    public static void OrderTicket() {
        System.out.println("\n_________________");
        System.out.println("1.\"Special Ticket\"");
        System.out.println("2.\"Executive Ticket\"");
        System.out.println("`````````````````\n");
        System.out.print("\nChoose Your Seat (1 / 2): ");
        Scanner sc = new Scanner(System.in);
        int seat = sc.nextInt();
        if (seat >= 1 && seat <= 2) {
            System.out.println("\n" + seatmenu[seat - 1]);
            System.out.println("\nPrice per Ticket = Rp. " + price[seat - 1]);
            duduk[1] = seatmenu[seat - 1];
            // price for receipt
            mainPrice[1] = price[seat - 1];
        } else {
            System.out.println("\nPlease Input The RIGHT Amount");
            OrderTicket();
        }
    }

    // for receipt later
    static String[] waktu = new String[2];

    public static void TimeChoose() {
        System.out.println(" _____________");
        System.out.println("|1. 13.00 WIB |");
        System.out.println("|2. 15.00 WIB |");
        System.out.println("|3. 18.00 WIB |");
        System.out.println("|4. 20.00 WIB |");
        System.out.println("|-------------|");
        System.out.print("\nPLease Choose Your Time To Watch (1 - 4): ");
        Scanner sc = new Scanner(System.in);
        int time = sc.nextInt();
        if (time >= 1 && time <= 4) {
            System.out.println("\n" + timeShow[time - 1]);
            // to show the time at receipt
            waktu[1] = timeShow[time - 1];
        } else {
            System.out.print("\nPlease Input The RIGHT Amount\n");
            TimeChoose();
        }
    }

    // for receipt
    static int[] tiket = new int[2];

    public static void ticketAmount() {
        // Stock only available 20 because this is online mini cinema
        System.out.print("\nHow Many Tickets(1-20) : ");
        Scanner sc = new Scanner(System.in);
        int amount = sc.nextInt();
        if (amount > 0 && amount <= 20) {
            System.out.println("\nYour Total Ticket : " + amount);
            tiket[1] = amount;
        } else {
            System.out.println("Sorry Beyond Avaliable Tickets");
            ticketAmount();
        }
    }

    public static void receipt() {
        int i = 1;
        // receipt for title
        for (i = 1; i < judul.length; i++) {
            if (judul[i] != null) {
                System.out.println("\nYour Movie is\t\t\t: " + judul[i]);
            }
        }
        // receipt for seat type
        for (i = 1; i < duduk.length; i++) {
            if (duduk[i] != null) {
                System.out.println("Your Seat is\t\t\t: " + duduk[i]);
            }
        }
        // receipt for time
        for (i = 1; i < waktu.length; i++) {
            if (waktu[i] != null) {
                System.out.println("Your Time is\t\t\t: " + waktu[i]);
            }
        }
        // receipt for amount of ticket
        for (i = 1; i < tiket.length; i++) {
            if (tiket[i] != 0) {
                System.out.println("Your Time is\t\t\t: " + tiket[i]);
            }
        }
        // receipt for price
        for (i = 1; i < mainPrice.length; i++) {
            if (mainPrice[i] != 0) {
                System.out.println("Your Price per Ticket is\t:Rp" + mainPrice[i]);
                int totalPrice = mainPrice[i] * tiket[i];
                System.out.println("Total Price\t\t\t:Rp" + totalPrice);
                payment(totalPrice);
            }
        }
    }

    public static boolean repeat() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nGo To Payment?(Y/N) : ");
        String repeat = sc.nextLine();
        // choose go to payment or not
        if (repeat.equalsIgnoreCase("N")) {
            System.out.println("");
            ChooseMovie();
        } else if (repeat.equalsIgnoreCase("Y")) {
            receipt();
        } else {
            System.out.println("Invalid Input");
            repeat();
        }
        return repeat.equalsIgnoreCase("N");
    }

    // Last Payment
    public static void payment(int totalPrice) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Your Money\t\t\t:Rp");
        int pay = sc.nextInt();
        int change = pay - totalPrice;
        // for pay is repeated until the input is right
        if (change < 0) {
            System.out.println("Need More Money!!!");
            payment(totalPrice);
        } else {
            System.out.println("Your Change is\t\t\t:Rp" + change);
            System.out.println("\n|========================|");
            System.out.println("|THANKS TO BUY OUR TICKET|");
            System.out.println("|========================|\n");
        }
    }
}