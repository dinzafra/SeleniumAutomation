package common;

import org.apache.commons.io.FileUtils;
import java.io.*;

import org.openqa.selenium.*;

public class CaptureScreenshot extends BaseTest {
	
	public static String screenshotLocation = (System.getProperty("user.dir") + "/screenshots/");
	
	public static void getScreenshot(String methodName) {
		
	        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        try {
				FileUtils.copyFile(scrFile, new File(screenshotLocation +methodName + ".png"));
			} catch (IOException e) {
	            e.printStackTrace();
			}
	    
	}
	
	  public static void deleteScreenshotFolder() throws Exception {
	        File screenshotFolder = new File(screenshotLocation);

	        // Check if the folder exists
	        if (screenshotFolder.exists() && screenshotFolder.isDirectory()) {
	            // Delete the folder and its contents
	            FileUtils.deleteDirectory(screenshotFolder);
	        } 
	    }
}
