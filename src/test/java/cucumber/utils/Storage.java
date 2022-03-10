package cucumber.utils;

import cucumber.model.Specification;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Map<String, Specification> specificationMap = new HashMap<String, Specification>();
    public static void addSpecification(String key, Specification specification){
        specificationMap.put(key,specification);
    }
    public static Specification getSpecification(String key){
       return specificationMap.get(key);
    }
}
