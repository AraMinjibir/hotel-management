import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean flag = true;
    private static List<Guest> guest = new ArrayList<>();
    private static List<Rooms> room = new ArrayList<>();
    private static Book book;
    private static HotelManager manager = new HotelManager();

    public static void main(String[] args) {
        while(flag){
            menu();
            System.out.print("Choose your option");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch(option){
                case 1:
                    addNewGuest();
                    break;
                case 2:
                    addNewRoom();
                    break;
                case 3:
                    bookRoom();
                    break;
                case 4:
                    removeBook();
                    break;
                case 5:
                    manager.displayBookedRooms();
                    break;
                case 6:
                    manager.displayAvailableRooms();
                    break;
                case 7:
                    manager.displayAllGuests();
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
                case 8:
                    flag = false;
                    System.out.println("Bye!... \n Have a nice Day.");

            }
        }

    }

    private static void menu(){
        System.out.println("\n===== Hotel Menu =====");
        System.out.println("1. Add Guest");
        System.out.println("2. Add Room");
        System.out.println("3. Book Room");
        System.out.println("4. Terminate Booking");
        System.out.println("5. Show All Booked Rooms");
        System.out.println("6. Show Available Rooms");
        System.out.println("7. Show Available Guests");
        System.out.println("8. Exit");
        System.out.print("Choose an option: ");
    }

    private static void addNewGuest(){
        System.out.println("Enter guest's id:");
        String id = scanner.nextLine();

        System.out.println("Enter guest's Name:");
       String name = scanner.nextLine();

        System.out.println("Enter guest's Contact:");
       String phone = scanner.nextLine();

        Guest newGuest = new Guest(id, name, phone);
        manager.addGuest(newGuest);
        System.out.println("Guest added successfully");

    }
    private static void addNewRoom(){
        System.out.print("Enter the Room Number:");
        String id = scanner.nextLine();

        System.out.print("Enter the Room Type:");
        String type = scanner.nextLine();

        System.out.print("Is the Room available? (True/False):");
        boolean isAvailable = Boolean.parseBoolean(scanner.nextLine());

        System.out.print("Enter the Room Pricer per day:");
        String price = scanner.nextLine();

        Rooms newRoom = new Rooms(id,type,isAvailable, price);
        manager.addRoom(newRoom);
        System.out.println("Room added Successfully");

    }
    private static void bookRoom(){
        System.out.print("Enter the Guest Id:");
        String guestId = scanner.nextLine();

        System.out.print("Enter the Room Id:");
        String roomId = scanner.nextLine();

        manager.bookRoom(guestId, roomId);
        System.out.println("Room booked Successfully");
        System.out.println("DEBUG: Booking created for guest " + guestId + " in room " + roomId);

    }
    private static void removeBook(){
        System.out.print("Enter the Guest Id:");
        String guestId = scanner.nextLine();

        System.out.print("Enter the Room Id:");
        String roomId = scanner.nextLine();
        manager.terminateBooking(guestId, roomId);
    }
}