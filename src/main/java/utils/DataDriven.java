package utils;

import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Map;

public class DataDriven {
    public static Map<String, Object> readJson(String filePath) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(new File(filePath), Map.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to read JSON file", e);
        }
    }

}
