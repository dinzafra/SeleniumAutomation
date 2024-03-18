package testCases;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.Reader;


public class ReadJsonFile {
	
	
    public  MyDataObject getData() {
    	  
        try {
            // Specify the path to your JSON file
            String jsonFilePath = System.getProperty("user.dir") + "/src/test/resources/testdata.json";

            // Create a Gson object
            Gson gson = new Gson();

            // Create a FileReader to read the JSON file
            Reader reader = new FileReader(jsonFilePath);

            // Parse the JSON data into a Java object
            MyDataObject data = gson.fromJson(reader, MyDataObject.class);

            // Close the reader
            reader.close();
            
            return data;
        } catch (Exception e) {
            e.printStackTrace();
        }
		return null;
    }
}

