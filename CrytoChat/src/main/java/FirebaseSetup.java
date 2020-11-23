/**
 * 
 */
import java.util.*;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import java.io.FileInputStream;
import java.io.InputStream;
/**
 *  @author M.NAVEEN
 *  RANDOM CODER'S
 *  Tech/Project Lead Android Club
 */

public class FirebaseSetup 
{
  public void setup()
  {
    try {
   FileInputStream serviceAccount =new FileInputStream("./serviceAccountKey.json");

   FirebaseOptions options = new FirebaseOptions.Builder()
  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
  .setDatabaseUrl("https://crytochat.firebaseio.com")
  .build();
   FirebaseApp.initializeApp(options);}
    catch(Exception e) {System.out.println(e.getClass().getName());}
   



  }
	public static void main(String[] args) 
	{
		
	}

}

