package pos;

import java.util.Vector;

// Abstract class representing a Customer
abstract class Customer {
    private String id;
    private String name;
    private String phone;
    private String email;
    private String billAddress;
    private String shipAddress;
    private String bank;
    private String city;

    // Constructor
    public Customer(String id, String name, String phone, String email,
                    String billAddress, String shipAddress, String bank, String city) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.billAddress = billAddress;
        this.shipAddress = shipAddress;
        this.bank = bank;
        this.city = city;
    }

    // Abstract methods to be implemented by subclasses
    public abstract void save();
    public abstract void update();
    public abstract void delete();   
    public abstract Vector<Vector<String>> search(String searchText); 


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getBillAddress() {
        return billAddress;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public String getBank() {
        return bank;
    }

    public String getCity() {
        return city;
    }

}
