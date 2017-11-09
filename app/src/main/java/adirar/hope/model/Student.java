package adirar.hope.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hp on 10/1/2017.
 */
public class Student implements ModelInterface {
    private String name, password;

    public Student() {
    }

    public Student(String name, String password) {
        this.name = name;
        this.password = password;
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

    @Override
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("name", name);
        result.put("password", password);
        return result;
    }
}
