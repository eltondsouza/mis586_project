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

public class GetFriends4 {

	public static void main(String a[]) throws UnknownHostException, NumberFormatException
	{
		MongoClient mongoClient = new MongoClient( "localhost" );
		DB db = mongoClient.getDB( "bigdata" );
		DBCollection coll = db.getCollection("pr2_coreusers");
		DBCollection friendsList = db.getCollection("friendsList");
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
    	cb.setDebugEnabled(true)
    	  .setOAuthConsumerKey("OYeNYvnFToMjtV0XwVgGcm1Zw")
    	  .setOAuthConsumerSecret("Od2iGwFvxnDj0M9CW2olJQUKbzi8IthGE8PpzbV8D1TRBs5Xlu")
    	  .setOAuthAccessToken("2319838854-wzymzSoeDst85eVZAqGBwmthSZizWjXbFzTOhoW")
    	  .setOAuthAccessTokenSecret("1SGRk1KAioGsoveRZbpAarEGRH10hm89s6y9IqlFGswLT")
    	  .setJSONStoreEnabled(true);
    	TwitterFactory tf = new TwitterFactory(cb.build());
    	Twitter twitter = tf.getInstance();
		String[] ids = {"334090417","10448732","223315248","9337702","301038559","2770511","41140413","16330402","2682395184","1562625614","818306821","1584350917","351306056","2438933293","2257350176","15227738","2353822842","16404277","73572217","1877857849","142515652","32841620","2278064736","14948062","295049967","14110443","16214322","527119125","572478728","15681800"};
		String[] screen_names = {"DarrenMan777","davidgilson","DavidShares","dbasch","Dean5mith","Devar","devnullius","dgcmagazine","DigitalCrypto","diiorioanthony","DirectPayNet","DoctorBitcoin","DoctorGoss","DogeCoinFiend","dogecoinisgreat","DogeCoinShibe","dogeonomics","drewcbarnard","Ed_Lemieux","EdmundCMoy","mineITforward","MJordan9","mklords","mohland","MrChrisEllis","muneeb","myazri","NagleMary","nejc_kodric","netscr1be"}; 
		//DBCursor mongo_cursor = coll.find();
		int counter = 1;
		
		
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
			            				
			            				System.out.println("Error code: "+e.getStatusCode()+" Could not find friends for "+screen_name);
			            				
			            				noFriends = true;
			            			}
							   }
							   
							   else
							   {
								   System.out.println("Error code: "+e.getStatusCode()+"Could not find friends for "+screen_name);
								   
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
