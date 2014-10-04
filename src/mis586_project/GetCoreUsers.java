package mis586_project;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import twitter4j.IDs;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.TwitterObjectFactory;
import twitter4j.User;
import twitter4j.conf.ConfigurationBuilder;

public class GetCoreUsers {
	public static void main(String arg[]) throws TwitterException{
	ConfigurationBuilder cb = new ConfigurationBuilder();
	cb.setDebugEnabled(true)
	  .setOAuthConsumerKey("5at9oIC6aqWOGYE635Cw8dX8z")
	  .setOAuthConsumerSecret("ACvypDRJWO5Ni2HDQxYvm9Z4uSD3MZhxVou92gFJvLg1MOO2wG")
	  .setOAuthAccessToken("39952747-IcSqsSoPphTWaLoIwYaUITWQ5PmeyV40bQHgkTf4C")
	  .setOAuthAccessTokenSecret("Nn4NEH9XE9xIb6QXu3R8kOdocncplz67Cq8RZlrOZlyOu")
	  .setJSONStoreEnabled(true);
	TwitterFactory tf = new TwitterFactory(cb.build());
	Twitter twitter = tf.getInstance();
	
	int counter = 1;
	new File("core_users").mkdir();
	
	IDs friendsIDsObj = twitter.getFriendsIDs(2777354556L,-1);
	long[] friendsIDs = friendsIDsObj.getIDs();
	try{
         for (long id : friendsIDs) {
             //System.out.println(id);
        	 User user = null;
         	try{
         		user = twitter.showUser(id);
         	}
         	catch(TwitterException e)
         	{
         		if(e.getStatusCode()==404)
         			System.out.println("Could not find user");
         		
         		else if(e.getStatusCode()==429)
         		{
         			System.out.println("waiting...");
         			Thread.sleep(15*60*1000);
         			user = twitter.showUser(id);
         		}
         	}
             String rawJSON = TwitterObjectFactory.getRawJSON(user);
             String fileName = "core_users/" + user.getScreenName() + ".json";
             //String fileName = "user_json/consolidated.json";
             storeJSON(rawJSON, fileName);
             System.out.println("Stored JSON no."+counter++);
//             System.out.println(fileName + " - " + status.getText());
         }
     
     
	} 
	/*catch (TwitterException te) {
     te.printStackTrace();
     System.out.println("Failed to get friends' ids: " + te.getMessage());
     System.exit(-1);
 } */catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	catch(InterruptedException e)
	{
		e.printStackTrace();
	}
}

public static void storeJSON(String rawJSON, String fileName) throws IOException {
 FileOutputStream fos = null;
 OutputStreamWriter osw = null;
 BufferedWriter bw = null;
 try {
     fos = new FileOutputStream(fileName);
     osw = new OutputStreamWriter(fos, "UTF-8");
     bw = new BufferedWriter(osw);
     bw.write(rawJSON);
     bw.flush();
 } finally {
     if (bw != null) {
         try {
             bw.close();
         } catch (IOException ignore) {
         }
     }
     if (osw != null) {
         try {
             osw.close();
         } catch (IOException ignore) {
         }
     }
     if (fos != null) {
         try {
             fos.close();	
         } catch (IOException ignore) {
         }
     }
 }
}
}
