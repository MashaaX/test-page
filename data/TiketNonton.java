import java.util.Scanner;

/**
 * TiketNonton
 */
public class TiketNonton {

    static Scanner sc = new Scanner(System.in);

    static String[] titleMenu = new String[0];
    static int[] ticketList = new int[0];
    static int[] priceList = new int[0];

    static String[] menu = { " The Shawshank Redemption", "Ready Player One", "No Game NO Life ZERO",
            "Avanger Infinity War" };

    static String[] seatmenu = { "Special Ticket", "Executive Ticket" };

    static int[] stock = new int[] { 40, 40, 40, 40 };

    static int[] price = { 50000, 35000 };

    static String[] timeShow = { "13.00 WIB", "15.00 WIB", "18.00 WIB", "20.00 WIB" };

    public static void main(String[] args) {
        String repeat = "y";
        int totalTicket = 0;
        int countTicket = 0;
        home();
        register();
        while (repeat.equalsIgnoreCase("Y")) {
            showTitle();
            System.out.print("Choose Customer Movie(1-4): ");
            int chooseTitle = sc.nextInt();
            if (chooseTitle >= 1 && chooseTitle <= 4) {
                System.out.println("\n" + "\"" + menu[chooseTitle - 1] + "\"\n");
                showSeat();
                System.out.print("\nChoose Customer Seat: ");
                int chooseSeat = sc.nextInt();
                if (chooseSeat >= 1 && chooseSeat <= 2) {
                    System.out.println(seatmenu[chooseSeat - 1]);
                    System.out.println("Price per Ticket = Rp. " + price[chooseSeat - 1]);

                    showTime();
                    System.out.print("\nWhat Time Do You Want to Watch?(1-4)");
                    int time = sc.nextInt();
                    if (time >= 1 && time <= 4) {
                        System.out.println(timeShow[time - 1]);
                    }

                    System.out.print("\n How Many Ticket: ");
                    int amount = sc.nextInt();

                    ticketList = addTicketAmount(ticketList, amount);
                    if (amount > stock[chooseTitle - 1]) {
                        System.out.println("Sorry beyond our Stock");
                    } else {
                        totalTicket = totalTicket + totalPrice(0, amount, chooseTitle, chooseSeat);

                        titleMenu = addTicket(titleMenu, menu[chooseTitle - 1]);
                        priceList = addTicketprice(priceList, price[chooseSeat - 1]);
                    }
                    countTicket++;

                    System.out.println("Do you Want to Buy Ticket Again?(Y/N): ");
                    repeat = sc.nextLine();

                    if (repeat.equalsIgnoreCase("N")) {

                    }
                }
            }
        }
    }

    public static void home() {
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
        System.out.println(" ");
    }

    public static void register() {
        System.out.print("Your Name : ");
        String name = sc.nextLine();
    }

    public static void showTitle() {
        for (int i = 0; i < menu.length; i++) {
            System.out.println((i + 1) + ". " + menu[i]);
        }
    }

    public static void showSeat() {
        for (int i = 0; i < seatmenu.length; i++) {
            System.out.println((i + 1) + ". " + seatmenu[i]);
        }
    }

    public static void showTime() {
        for (int i = 0; i < timeShow.length; i++) {
            System.out.println((i + 1) + ". " + timeShow[i]);
        }
    }

    static int totalPrice(int total, int amount, int chooseTitle, int chooseSeat) {
        total = price[chooseSeat - 1] * amount;
        return total;
    }

    static String[] addTicket(String[] buyTicket, String newTicket) {
        int currentTitle = buyTicket.length;
        int newTitle = currentTitle + 1;

        String[] titleMenu = new String[newTitle];
        for (int i = 0; i < currentTitle; i++) {
            titleMenu[i] = buyTicket[i];
        }
        titleMenu[newTitle - 1] = newTicket;
        return titleMenu;
    }

    static int[] addTicketprice(int[] buyTicket, int newTicket) {
        int currentPrice = buyTicket.length;
        int newPrice = currentPrice + 1;

        int[] priceBookNew = new int[newPrice];
        for (int i = 0; i < currentPrice; i++) {
            priceBookNew[i] = buyTicket[i];
        }

        priceBookNew[newPrice + 1] = newPrice;
        return priceBookNew;
    }

    static int[] addTicketAmount(int[] buyTicket, int newTicket) {
        int currentAmount = buyTicket.length;
        int newAmount = currentAmount + 1;

        int[] amountTicketNew = new int[newAmount];
        for (int i = 0; i < currentAmount; i++) {
            amountTicketNew[i] = buyTicket[i];
        }

        amountTicketNew[newAmount + 1] = newAmount;
        return amountTicketNew;
    }
}