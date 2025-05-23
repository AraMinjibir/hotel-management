import java.util.ArrayList;

public class Guest {
   private String id;
    private  String name;
    private String phone;



    public Guest(String id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;

    }

    public String getPhone() {
        return phone;
    }
    private void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }
    private void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }
    private void setId(String id) {
        this.id = id;
    }

}
