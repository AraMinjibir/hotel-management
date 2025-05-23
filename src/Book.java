import java.time.LocalDate;

public class Book {
    private Guest guest;
    private Rooms room;
    private LocalDate checkIn;
    private LocalDate checkOut;


    public Book(Guest guest, Rooms room, LocalDate checkIn, LocalDate checkOut) {
        this.guest = guest;
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }
    private void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }
    private void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public Rooms getRoom() {
        return room;
    }
    private void setRoom(Rooms room) {
        this.room = room;
    }

    public Guest getGuest() {
        return guest;
    }
    private void setGuest(Guest guest) {
        this.guest = guest;
    }


}