// TO ADD JSON INTO EXISTING FILE

package Practise2;

import com.sun.security.jgss.GSSUtil;

import javax.json.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Properties;

public class Practise {
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("config.properties");     // config.properties MUST be placed in the TOP directory of this project
        prop.load(fis);
        System.out.println("SmartHome System is running now.");
        String sensorData = "data";
        String sensorFilePath = prop.getProperty("filepath") + File.separator + sensorData + ".json";
        File sensorFile = new File(sensorFilePath);
        System.out.println("Sensor data has been loaded.");
        InputStream inputStream = new FileInputStream(sensorFile);
        JsonReader jsonReader = Json.createReader(inputStream);
        JsonObject jsonObject = jsonReader.readObject();
        JsonArray jarray = (JsonArray) jsonObject.get("book");
        JsonObject jobj1  = jarray.getJsonObject(1);



//
//        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
//
//// Add existing key-value pairs to the new builder
//        for (Map.Entry<String, JsonValue> entry : jobj1.entrySet()) {
//            jsonObjectBuilder.add(entry.getKey(), entry.getValue());
//        }
//
//
//// Add the new key-value pair
//        jsonObjectBuilder.add("KDKD", "KDKDKD");
//
//// Build the updated JSON object
//        JsonObject updatedJsonObject = jsonObjectBuilder.build();
//
//        System.out.println(updatedJsonObject);
//
//        String newFilePath = "new_data.json"; // Provide the path to the new file
//
//        try {
//            // Convert the JSON object to a string
//            String jsonContent = updatedJsonObject.toString();
//
//            // Write the JSON content to the new file
//            Files.write(Paths.get(newFilePath), jsonContent.getBytes(StandardCharsets.UTF_8));
//
//            System.out.println("JSON data has been written to " + newFilePath);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//        =====================================================================================================
// Create a new JsonObject for the object you want to add
        JsonObjectBuilder newObjectBuilder = Json.createObjectBuilder();
        newObjectBuilder.add("name", "Charlie");
        newObjectBuilder.add("age", 25);
        JsonObject newObject = newObjectBuilder.build();

// Parse the existing JSON array
        JsonArray existingArray = Json.createReader(new StringReader(jarray.toString())).readArray();

// Create a new JsonArrayBuilder and add the existing objects
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        arrayBuilder.add(existingArray);

// Add the new JsonObject to the JsonArrayBuilder
        arrayBuilder.add(newObject);

// Build the updated JSON array
        JsonArray updatedArray = arrayBuilder.build();

        String newFilePath = "new_data2.json"; // Provide the path to the new file
//
        try {
            // Convert the JSON object to a string
            String jsonContent = updatedArray.toString();

            // Write the JSON content to the new file
            Files.write(Paths.get(newFilePath), jsonContent.getBytes(StandardCharsets.UTF_8));

            System.out.println("JSON data has been written to " + newFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

// Convert the updated JSON array to a string
        String updatedJson = updatedArray.toString();

// Now, 'updatedJson' contains the JSON array with the new object added
        System.out.println(updatedJson);


//















    }}
