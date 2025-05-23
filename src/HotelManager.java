import java.time.LocalDate;
import java.util.HashMap;

public class HotelManager {
    private HashMap<String, Guest> guests;
    private HashMap<String, Rooms> rooms;
    private HashMap<String, Book> books;


    public HotelManager() {
        guests = new HashMap<>();
        rooms = new HashMap<>();
        books = new HashMap<>();
    }

    public boolean addGuest(Guest guest) {
        if (guest == null || guest.getId() == null || guests.containsKey(guest.getId())) {
            System.out.println("Error: Guest ID already exists or is invalid.");
            return false;
        }
        guests.put(guest.getId(), guest);
        return true;
    }

    public boolean addRoom(Rooms room) {
        if (room == null || room.getRoomNumber() == null || rooms.containsKey(room.getRoomNumber())) {
            System.out.println("Error: Room number already exists or is invalid.");
            return false;
        }
        rooms.put(room.getRoomNumber(), room);
        return true;
    }

    public boolean bookRoom(String guestId, String roomId) {
        Guest guest = guests.get(guestId);
        Rooms room = rooms.get(roomId);

        if (guest == null || room == null) {
            System.out.println("Error: Guest or room does not exist.");
            return false;
        }

        if (!room.getAvailable()) {
            System.out.println("Error: Room is already booked.");
            return false;
        }

        LocalDate checkIn = LocalDate.now();
        LocalDate checkOut = checkIn.plusDays(2); // Default 2-day booking

        Book newBooking = new Book(guest, room, checkIn, checkOut);
        books.put(roomId, newBooking);
        room.setAvailable(false);

        System.out.println("Room booked successfully for " + guest.getName() + " (ID: " + guestId + ")");
        return true;
    }
    public boolean terminateBooking(String guestId, String roomId) {
        Book booking = books.get(roomId);
        if (booking == null || !booking.getGuest().getId().equals(guestId)) {
            System.out.println("Error: Booking not found or guest mismatch.");
            return false;
        }

        Rooms room = booking.getRoom();
        room.setAvailable(true);
        books.remove(roomId);

        System.out.println("Booking terminated successfully for room " + roomId);
        return true;
    }

    public void displayAvailableRooms() {
        if (rooms.isEmpty()) {
            System.out.println("No rooms registered in the system.");
            return;
        }

        boolean foundAvailable = false;
        for (Rooms room : rooms.values()) {
            if (room.getAvailable()) {
                System.out.printf(
                        "Room: %s | Type: %s | Price: %s%n",
                        room.getRoomNumber(), room.getType(), room.getPrice()
                );
                foundAvailable = true;
            }
        }

        if (!foundAvailable) {
            System.out.println("No vacant rooms available.");
        }
    }
    public void displayBookedRooms() {
        if (books.isEmpty()) {
            System.out.println("No rooms are currently booked.");
            return;
        }

        for (Book booking : books.values()) {
            Guest guest = booking.getGuest();
            Rooms room = booking.getRoom();
            System.out.printf(
                    "Room: %s (%s) | Guest: %s (ID: %s) | Dates: %s to %s%n",
                    room.getRoomNumber(), room.getType(),
                    guest.getName(), guest.getId(),
                    booking.getCheckIn(), booking.getCheckOut()
            );
        }
    }
    public void displayAllGuests() {
        if (guests.isEmpty()) {
            System.out.println("No guests registered.");
            return;
        }

        for (Guest guest : guests.values()) {
            System.out.printf(
                    "ID: %s | Name: %s | Phone: %s%n",
                    guest.getId(), guest.getName(), guest.getPhone()
            );
        }
    }
}
