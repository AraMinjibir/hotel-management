import java.util.ArrayList;

public class Rooms {
    private String roomNumber;
    private String type;
    private String price;
    private boolean isAvailable;


    public Rooms(String id, String type, boolean isAvailable, String price) {
        this.roomNumber = id;
        this.type = type;
        this.isAvailable = isAvailable;
        this.price = price;


    }

    public boolean getAvailable() {
        return isAvailable;
    }
    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    public String getPrice() {
        return price;
    }
    private void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }
    private void setType(String type) {
        this.type = type;
    }

    public String getRoomNumber() {
        return roomNumber;
    }
    private void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
}
