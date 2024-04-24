import java.util.ArrayList;
import java.util.Scanner;

class BusBooking {
    static ArrayList<Integer> availableSeats = new ArrayList<>();

    public static void main(String[] args) {
        initializeSeats();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Bus Booking System");

        while (true) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Book Ticket");
            System.out.println("2. Check Available Seats");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    bookTicket(scanner);
                    break;
                case 2:
                    checkAvailableSeats();
                    break;
                case 3:
                    System.out.println("Thank you for using the Bus Booking System.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    static void initializeSeats() {
        for (int i = 1; i <= 40; i++) {
            availableSeats.add(i);
        }
    }

    static void bookTicket(Scanner scanner) {
        if (availableSeats.isEmpty()) {
            System.out.println("Sorry, no seats available.");
            return;
        }

        System.out.print("Enter number of seats to book: ");
        int numSeats = scanner.nextInt();

        if (numSeats > availableSeats.size()) {
            System.out.println("Sorry, only " + availableSeats.size() + " seats are available.");
            return;
        }

        System.out.print("Enter seat number(s) to book (comma-separated): ");
        String input = scanner.next();
        String[] seatNumbers = input.split(",");
        ArrayList<Integer> selectedSeats = new ArrayList<>();

        for (String seatNumber : seatNumbers) {
            int seat = Integer.parseInt(seatNumber.trim());
            if (availableSeats.contains(seat)) {
                selectedSeats.add(seat);
            } else {
                System.out.println("Seat " + seat + " is not available.");
            }
        }

        if (selectedSeats.size() == numSeats) {
            System.out.println("Ticket(s) booked successfully. Seat(s) booked: " + selectedSeats);
            availableSeats.removeAll(selectedSeats);
        } else {
            System.out.println("Failed to book ticket(s). Please try again.");
        }
    }

    static void checkAvailableSeats() {
        System.out.println("Available seats: " + availableSeats);
    }
}
