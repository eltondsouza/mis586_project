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
import com.mongodb.MongoException;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static java.util.concurrent.TimeUnit.SECONDS;

public class GetFriends7 {

	public static void main(String a[]) throws UnknownHostException, NumberFormatException
	{
		MongoClient mongoClient = new MongoClient( "localhost" );
		DB db = mongoClient.getDB( "bigdata" );
		DBCollection userColl = db.getCollection("missingIDs");
		DBCollection friendsList = db.getCollection("newFriendsList");
		
		
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
  	  .setOAuthConsumerKey("OYeNYvnFToMjtV0XwVgGcm1Zw")
  	  .setOAuthConsumerSecret("Od2iGwFvxnDj0M9CW2olJQUKbzi8IthGE8PpzbV8D1TRBs5Xlu")
  	  .setOAuthAccessToken("2319838854-wzymzSoeDst85eVZAqGBwmthSZizWjXbFzTOhoW")
  	  .setOAuthAccessTokenSecret("1SGRk1KAioGsoveRZbpAarEGRH10hm89s6y9IqlFGswLT")
  	  .setJSONStoreEnabled(true);
    	TwitterFactory tf = new TwitterFactory(cb.build());
    	Twitter twitter = tf.getInstance();
		
    	DBCursor  userCursor = userColl.find();
		userCursor.addOption(com.mongodb.Bytes.QUERYOPTION_NOTIMEOUT);
    	
		ArrayList<String> ids = new ArrayList<String>();
		ArrayList<String> screen_names = new ArrayList<String>();
		while(userCursor.hasNext())
		{
			ids.add((String)userCursor.next().get("id"));
			//screen_names.add((String)userCursor.curr().get("screen_name"));
		}
		
    	//String[] ids = {"2230083151","2241329875","1268759210","2333408605","1423870044","2209677878","2155219346","299952246","2390188770","2197377873","2616036566","2828426172","90135167","2309637680","2175120708","2314255350","12503922","14379660","28813427","19337489","217081909","2273578802","90565003","29468585","19132398","2201220235","1387081490","901796180","22682896","443484148"};
		//String[] screen_names = {"BitcoinBelle","bitcoinbill","BitcoinDoc","BitcoinFather","BitCoinKid","bitcoinmom","bitcoinpotato","BitCoinReporter","BitcoinSARAH","Bitcoinwoman","BitcoinzMan","BitcoinzWoman","bitjson","BittrexExchange","bitxbitxbitcoin","blondebitcoin","bodil","brian_armstrong","briancartmell","BrianKellyBK","BrianSantoshi","BrighamC","BrittanyErstad","brockpierce","brucefenton","BryceWeiner","btcdrak","btcven","CharlieShrem","ChekaZ_"}; 
		//DBCursor mongo_cursor = coll.find();
		int counter = 0;
		
		
			   for(int i = 0;i<ids.size();i++) 
			   {
			      
			       
				    String id = ids.get(i);
				    //String screen_name = screen_names.get(i);
				    System.out.println(id);
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
	            			System.out.println("Could not find user "+id);
	            			
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
			            			System.out.println("Could not find user "+id);
			            			
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
			            				System.out.println("Could not find friends for "+id);
			            				System.out.println(g.getErrorCode()+" "+g.getErrorMessage());
			            				noFriends = true;
			            			}
							   }
							   
							   else
							   {
								   System.out.println("Could not find friends for "+id);
								   System.out.println(e.getErrorCode()+" "+e.getErrorMessage());
								   e.printStackTrace();
								   noFriends = true;
							   }
						   }
						   
						   if(noFriends==true)
							   continue;
						   
						   //get Friends IDs as an array of long
						   long[] FriendsIDsLong = FriendsIDs.getIDs();
						   ArrayList<String> FriendsIDsString = new ArrayList<String>();
						   for(int j=0;j<FriendsIDsLong.length;j++)
						   {
							   FriendsIDsString.add(String.valueOf(FriendsIDsLong[j]));
							   
						   }
						   
						   //create DBObject				   
						   BasicDBObject doc = new BasicDBObject("id", Long.parseLong(id)).append("id_str",id )
					        .append("screen_name", id)
					        .append("friends", FriendsIDsLong).append("friendsString", FriendsIDsString);
						  // friendsList.insert(doc);
						   
						DBCursor x = userColl.find(new BasicDBObject("id_str",id));
						
						if(x.count()==0)
					   {   
						   try{
							   friendsList.insert(doc);
							   }
						   catch(MongoException m)
						   {
							   System.out.println(m.getCode()+m.getMessage());
						   }
					   
						   System.out.println("User no: "+counter++);
					   }
				    
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
