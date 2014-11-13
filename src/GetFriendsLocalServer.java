
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
import twitter4j.api.FriendsFollowersResources;

public class GetFriendsLocalServer {
	 public static void main(String[] args) throws IOException{
	        try {
	        	ConfigurationBuilder cb = new ConfigurationBuilder();
	        	cb.setDebugEnabled(true)
	        	  .setOAuthConsumerKey("5at9oIC6aqWOGYE635Cw8dX8z")
	        	  .setOAuthConsumerSecret("ACvypDRJWO5Ni2HDQxYvm9Z4uSD3MZhxVou92gFJvLg1MOO2wG")
	        	  .setOAuthAccessToken("39952747-IcSqsSoPphTWaLoIwYaUITWQ5PmeyV40bQHgkTf4C")
	        	  .setOAuthAccessTokenSecret("Nn4NEH9XE9xIb6QXu3R8kOdocncplz67Cq8RZlrOZlyOu")
	        	  .setJSONStoreEnabled(true);
	        	TwitterFactory tf = new TwitterFactory(cb.build());
	        	Twitter twitter = tf.getInstance();
	        	//Twitter twitter = new TwitterFactory().getInstance();
	            
	            IDs ids;
	            
	        	new File("new_friends_list").mkdir();
	        	
				IDs friendsIDsObj = twitter.getFriendsIDs(2777354556L,-1);
				long[] friendsIDs = friendsIDsObj.getIDs();
				String friendsJSON = TwitterObjectFactory.getRawJSON(friendsIDsObj);
				String friendsListFile = "friendsList.json";
				storeJSON(friendsJSON, friendsListFile);
				//ids = twitter.getFriendsIDs(cursor);
				
	            
	                
	                int i = 0;
	                int counter = 0;
	                for (long id : friendsIDs) {
	                	long cursor = -1;
	                	User currUser = null;
	                	
	                	boolean exists = true;
	                	try{
	                	currUser = twitter.showUser(id);
	                    
	                	}
	                	catch(TwitterException te)
	                	{
	                		if(te.getStatusCode()==404)
	                		{
	                			exists = false;
	                			System.out.println("Could not find specified user");
	                			continue;
	                		}
	                		
	                		else if(te.getStatusCode()==429)
	                		{
	                			System.out.println("Waiting...");
	                			Thread.sleep(15*60*1000);
	                			currUser = twitter.showUser(id);
	                		}
	                		
	                		else
	                		{
	                			System.out.println("Something went wrong. Trying to continue");
	                			continue;
	                		}
	                	}
	                	if(exists==true)
	                	{
		                	do{
		                		ids = null;
		                		try{
		                		ids = twitter.getFriendsIDs(id,cursor);
		                		
		                		}
		                		catch(TwitterException te)
			                	{
			                		if(te.getStatusCode()==404)
			                		{
			                			exists = false;
			                			System.out.println("Could not find specified user");
			                			continue;
			                		}
			                		
			                		else if(te.getStatusCode()==429)
			                		{
			                			System.out.println("Waiting...");
			                			Thread.sleep(15*60*1000);
			                			ids = twitter.getFriendsIDs(id,cursor);
			                		}
			                		
			                		else
			                		{
			                			System.out.println("Something went wrong. Trying to continue");
			                			continue;
			                		}
			                	}
		                		String rawJSON = TwitterObjectFactory.getRawJSON(ids);
			                    String fileName = "new_friends_list/" + currUser.getScreenName() + "_friends_"+cursor+".json";
			                    storeJSON(rawJSON, fileName);
			                    System.out.println("JSON no. "+counter++);
		                	}
		                	while ((cursor = ids.getNextCursor()) != 0);
	                	}
	                	
	                    
	                }
	            
	        } catch (TwitterException te) {
	            te.printStackTrace();
	            System.out.println("Failed to get friends' ids: " + te.getMessage());
	            
	            System.exit(-1);
	        } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    private static void storeJSON(String rawJSON, String fileName) throws IOException {
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
