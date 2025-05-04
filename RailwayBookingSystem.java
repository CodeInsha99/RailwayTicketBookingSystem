import java.util.*;

class RailwayTicket {
    String name, coach;
    long mob_no;
    int totalAmt;
    static int baseFare = 500;
    static int pnrCounter = 1001;
    int pnr;

    void accept(Scanner sc) {
        System.out.print("Enter Name: ");
        name = sc.nextLine();
        System.out.print("Enter Coach (First_AC / Second_AC / Third_AC): ");
        coach = sc.nextLine();
        System.out.print("Enter Mobile No: ");
        mob_no = sc.nextLong();
        sc.nextLine(); // consume newline
        calculateFare();
        pnr = pnrCounter++;
    }

    void calculateFare() {
        switch (coach) {
            case "First_AC":
                totalAmt = baseFare + 700;
                break;
            case "Second_AC":
                totalAmt = baseFare + 500;
                break;
            case "Third_AC":
                totalAmt = baseFare + 250;
                break;
            default:
                totalAmt = baseFare;
        }
    }

    void display() {
        System.out.println("\n--- Ticket Details ---");
        System.out.println("PNR No: " + pnr);
        System.out.println("Name: " + name);
        System.out.println("Coach: " + coach);
        System.out.println("Mobile No: " + mob_no);
        System.out.println("Total Fare: " + totalAmt);
    }
}

public class RailwayBookingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<RailwayTicket> tickets = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n--- Railway Ticket Booking Menu ---");
            System.out.println("1. Book Ticket");
            System.out.println("2. Show All Tickets");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    RailwayTicket ticket = new RailwayTicket();
                    ticket.accept(sc);
                    tickets.add(ticket);
                    System.out.println("Ticket booked successfully!");
                    break;
                case 2:
                    if (tickets.isEmpty()) {
                        System.out.println("No tickets booked yet.");
                    } else {
                        for (RailwayTicket t : tickets) {
                            t.display();
                        }
                    }
                    break;
                case 3:
                    System.out.println("Thank you for using the system!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 3);

        sc.close();
    }
}
