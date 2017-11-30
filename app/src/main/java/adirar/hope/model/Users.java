package adirar.hope.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hp on 10/10/2017.
 */
public class Users implements ModelInterface {
    private String address, email, name, password, phone;

    public Users() {
        name = "";
        password= "";
        phone= "";
        address= "";
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("name", name);
        result.put("password", password);
        result.put("address", address);
        result.put("email", email);
        result.put("phone", phone);
        return result;
    }
}
