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

public class GetFriends7 {

	public static void main(String a[]) throws UnknownHostException, NumberFormatException
	{
		MongoClient mongoClient = new MongoClient( "localhost" );
		DB db = mongoClient.getDB( "bigdata" );
		DBCollection coll = db.getCollection("pr2_coreusers");
		DBCollection friendsList = db.getCollection("friendsList");
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
    	cb.setDebugEnabled(true)
    	  .setOAuthConsumerKey("BK51tFzaQMpUOxlkqVlF0Yavy")
    	  .setOAuthConsumerSecret("25egEBzQjDG6Mt3lWBOZle1U8MqZrpg3Lq12KpoBWXU7etdlLb")
    	  .setOAuthAccessToken("138051557-YYkZQMYSVWd6FoKTQVj4K7h0CzCsocxsaLjMbw5g")
    	  .setOAuthAccessTokenSecret("jMM04wzOXCs26oEzZKTFFduFg5NHsn0bMvcCHIMqIBOZ5")
    	  .setJSONStoreEnabled(true);
    	TwitterFactory tf = new TwitterFactory(cb.build());
    	Twitter twitter = tf.getInstance();
		String[] ids = {"490808869","167434488","2322651270","54008772","1952836374","14639500","610700309","2265324883","2440641931","28477224","30044262","2313732494","477583514","35860455","40742821","2193616844","46049980","24222556","25456180","2157362647","2286545720","1854401","123428539","20833","1019653598","6853442","250980843","2215079746","7032912","5728962"};
		String[] screen_names = {"theblonde82","TheCryptoReport","TheLordofBTC","therohitmittal","TheScottRob","thomas_quinlan","timoncc","TLeonardBC","tokyobitcoiner","tomwilcoxen","Trekgirl7of9","TrueBitcoinGirl","trutherbot","TurntableKittah","TuurDemeester","twobitidiot","tylermevans","tylerwinklevoss","ummjackson","victoriavaneyk","VictorMertz","VinnyLingham","virtuallylaw","waterhousephd","webpreneur23","willobrien","winklevoss","Wrgrv_dogecoin","yrashk","zedlander"}; 
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
