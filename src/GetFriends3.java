//Twitter4j imports
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

import com.mongodb.BasicDBList;
//Mongo imports
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static java.util.concurrent.TimeUnit.SECONDS;

public class GetFriends3 {

	public static void main(String a[]) throws UnknownHostException, NumberFormatException
	{
		MongoClient mongoClient = new MongoClient( "localhost" );
		DB db = mongoClient.getDB( "bigdata" );
		DBCollection coll = db.getCollection("pr2_coreusers");
		DBCollection friendsList = db.getCollection("friendsList");
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
    	cb.setDebugEnabled(true)
    	  .setOAuthConsumerKey("dstu8zdadkx2hf4CHpcegKTNy")
    	  .setOAuthConsumerSecret("64cCY6jjsdJFI0nwD5zfddSjfFgD3AqD3vBOSdHBw3T7ZAB11Z")
    	  .setOAuthAccessToken("2777354556-9QpSxTFiLRq4HXTpMrlQ06sCM0vxr7K5qyDSVY7")
    	  .setOAuthAccessTokenSecret("qvQhJBXdQEdavKgvNxnJyq5EnQYZk1SDNmSnMSjSkkJa1")
    	  .setJSONStoreEnabled(true);
    	TwitterFactory tf = new TwitterFactory(cb.build());
    	Twitter twitter = tf.getInstance();
		String[] ids = {"2319408132","2332842072","38129556","19805098","2381420407","2567934373","2234577642","2329290331","2315539361","2259434528","1394496090","40217798","1429437746","2435734063","625289155","92592782","2347718839","2768000832","2392531752","2309081983","2406505603","2505478057","2228501803","20737357","243088415","14200949","65923928","385162204","267344900","26499336"};
		String[] screen_names = {"coin_artist","CoinBaron","conniegallippi","coolbearcjs","crazy_crypto","cryptmidas","Crypto_Investor","CryptoAdvice","CryptoAsian","CryptoCobain","Cryptocoinbiz","CryptoCoinNL","CryptoConnectz","CryptoCryptics","CryptoCurrent","CryptoIcahn","CryptoKnights","Cryptology101","cryptomillion","CryptoOracle","CryptoPhantom","CryptoRox","CryptoSnoop","CT2Rox","currencyhacker","dadicool","damijanmerlak","dan_pantera","danicellero","darkip"}; 
		//DBCursor mongo_cursor = coll.find();
		int counter = 0;
		
		
			   for(int i = 0;i<ids.length;i++) 
			   {
			      
			       
				    String id = ids[i];
				    String screen_name = screen_names[i];
				    System.out.println(id+":"+screen_name);
					//System.out.println(counter);
					   
					boolean exists = true;
					User currUser = null;		   
					//check if user exists
					try {
						currUser = twitter.showUser(Long.parseLong(id));
					} 
					   
					catch (TwitterException te) {
					
						if(te.getStatusCode()==404)
	            		{
	            			exists = false;
	            			System.out.println("Could not find user"+screen_name);
	            			
	            		}
	
	            		else if(te.getStatusCode()==429)
	            		{
	            			System.out.println("Waiting...");
	            			try {
								Thread.sleep(15*60*1000);
							} 
	            			
	            			catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
	            			
	            			try {
	            				currUser = twitter.showUser(Long.parseLong(id));
							} 
	            			
	            			catch (TwitterException e) {
								if(te.getStatusCode()==404)
			            		{
			            			exists = false;
			            			System.out.println("Could not find user"+screen_name);
			            			
			            		}
							}
	            		}
						
					}
					   
					   if(exists==false)
						   continue;
						   
					   IDs FriendsIDs = null;
					   long twitterCursor = -1;
					   
					   
						
						   boolean noFriends = false;
						   try 
						    {
							    //get upto 5000 friends of currUser
								FriendsIDs = twitter.getFriendsIDs(Long.parseLong(id),twitterCursor,5000);
							} 
						
						   catch (TwitterException e) 
						   {
							   if(e.getStatusCode()==429)
							   {
								   System.out.println("Waiting...");
			            			try {
										Thread.sleep(15*60*1000);
										FriendsIDs = twitter.getFriendsIDs(Long.parseLong(id),twitterCursor,5000);
									} 
			            			
			            			catch (InterruptedException f) 
			            			{
										// TODO Auto-generated catch block
										f.printStackTrace();
									}
			            			catch(TwitterException g)
			            			{
			            				System.out.println("Could not find friends for "+screen_name);
			            				noFriends = true;
			            			}
							   }
							   
							   else
							   {
								   System.out.println("Could not find friends for "+screen_name);
								   noFriends = true;
							   }
						   }
						   
						   if(noFriends==true)
							   continue;
						   
						   //get Friends IDs as an array of long
						   long[] FriendsIDsLong = FriendsIDs.getIDs();
						   
						   ArrayList<String> FriendsIDsString = new ArrayList<String>();
						   for(int j=0;i<FriendsIDsLong.length;j++)
						   {
							   FriendsIDsString.add(String.valueOf(FriendsIDsLong[j]));
							   
						   }
						   
						   //create DBObject				   
						   BasicDBObject doc = new BasicDBObject("id", Long.parseLong(id)).append("id_str",id )
					        .append("screen_name", screen_name)
					        .append("friends", FriendsIDsLong).append("friendsString", FriendsIDsString);
					   
					   System.out.println("User no: "+counter++);
				    
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
