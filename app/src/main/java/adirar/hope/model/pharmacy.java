package adirar.hope.model;

import java.util.ArrayList;
import java.util.List;


public class pharmacy {
   private String address,email,latitude,longitude,password,phone,name;
    private List<Data> Data = new ArrayList<>();

    public pharmacy() {
    }

    public pharmacy(String address, String email, String latitude, String longitude, String password, String phone, String name, ArrayList<Data> Data) {
        this.address = address;
        this.email = email;
        this.latitude = latitude;
        this.longitude = longitude;
        this.password = password;
        this.phone = phone;
        this.name = name;
        this.Data = Data;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Data> getMedicins() {
        return Data;
    }

    public void setMedicins(ArrayList<Data> Datas) {
        this.Data = Datas;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
