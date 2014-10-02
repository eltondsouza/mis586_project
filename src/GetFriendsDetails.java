

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.TwitterObjectFactory;
import twitter4j.User;
import twitter4j.conf.ConfigurationBuilder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GetFriendsDetails {
	public static void main(String[] args) throws TwitterException {
	    
		ConfigurationBuilder cb = new ConfigurationBuilder();
    	cb.setDebugEnabled(true)
    	  .setOAuthConsumerKey("dstu8zdadkx2hf4CHpcegKTNy")
    	  .setOAuthConsumerSecret("64cCY6jjsdJFI0nwD5zfddSjfFgD3AqD3vBOSdHBw3T7ZAB11Z")
    	  .setOAuthAccessToken("2777354556-9QpSxTFiLRq4HXTpMrlQ06sCM0vxr7K5qyDSVY7")
    	  .setOAuthAccessTokenSecret("qvQhJBXdQEdavKgvNxnJyq5EnQYZk1SDNmSnMSjSkkJa1")
    	  .setJSONStoreEnabled(true);
    	TwitterFactory tf = new TwitterFactory(cb.build());
    	Twitter twitter = tf.getInstance();
    	String userListFilePath = "user_json/orig_list.json";
    	
    	
    	int newUsersCount = 0;
    	
    	for(int j=1;j<135;j++)
    	{
	    	String currentUserFriendListFilePath = "friends_list/"+j+".json";
	    	try{
	    	JSONParser jsonparser = new JSONParser();
	    	// read the json file
	    				FileReader reader1 = new FileReader(userListFilePath);
	    				JSONParser jsonParser = new JSONParser();
	    			
	    				JSONObject userListJsonObject = (JSONObject) jsonParser.parse(reader1);
	    				
	    				JSONArray userList = (JSONArray) userListJsonObject.get("ids");
	    				
	    				
	    				FileReader reader2 = new FileReader(currentUserFriendListFilePath);
	    				JSONObject currentUserFriendListJsonObject = (JSONObject) jsonParser.parse(reader2);
	    				JSONArray friendsList = (JSONArray) currentUserFriendListJsonObject.get("ids");
	
	    				//String[] keywords = {"Bitstamp","Bitcoin","Cryptocurrency","Kraken","Digital Currency","Justcoin","Litecoin","Alternative Currency","Coinbase","Peercoin","Electronic Money","Bitfinex","Mastercoin","Virtual Currency","MtGox","Darkcoin","BTC China","Dogecoin","BTC-e","Namecoin","Crypto","Krypto"};
	    				
	    				
	    				for(int i=0;i<friendsList.size();i++)
	    				{
	    					if(!userList.contains(friendsList.get(i)))
	    					{
		    					User user = twitter.showUser((Long)friendsList.get(i));
		    					String rawJSON = TwitterObjectFactory.getRawJSON(user);
		    					String fileName = "automated_users/" + user.getScreenName() + ".json";
		    					userList.add(user);
		    					storeJSON(rawJSON, fileName);
		    					System.out.println("Added user no."+(++newUsersCount));
		    					
		    					if((newUsersCount)%180==0)
			                    {
			                    	Thread.sleep(15*60*1000);
			                    }
	    					}
	    				}
	    				
	
	    	}
	    	
	    	catch (FileNotFoundException ex) {
	    		
	    		            ex.printStackTrace();
	    		
	    		        } catch (IOException ex) {
	    		
	    		            ex.printStackTrace();
	    		
	    		        } catch (ParseException ex) {
	    		
	    		            ex.printStackTrace();
	    		
	    		        } catch (NullPointerException ex) {
	    		
	    		            ex.printStackTrace();
	
	    		        } catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	
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
