package adirar.hope.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hp on 10/10/2017.
 */
public class items implements ModelInterface{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("name", name);
        return result;
    }
}
