import java.net.UnknownHostException;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.TwitterObjectFactory;
import twitter4j.conf.ConfigurationBuilder;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.util.JSON;


public class GetStatuses {
	public static void main(String[] args) throws UnknownHostException {
		MongoClient mongoClient = new MongoClient( "localhost" );
		DB db = mongoClient.getDB( "bigdata" );
		DBCollection userColl = db.getCollection("pr2_coreusers");
		DBCollection tweetCollection = db.getCollection("tweets");
		
		DBCursor userCursor = userColl.find().skip(0).limit(1012);
		userCursor.addOption(com.mongodb.Bytes.QUERYOPTION_NOTIMEOUT);
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
    	cb.setDebugEnabled(true)
    	  .setOAuthConsumerKey("5at9oIC6aqWOGYE635Cw8dX8z")
    	  .setOAuthConsumerSecret("ACvypDRJWO5Ni2HDQxYvm9Z4uSD3MZhxVou92gFJvLg1MOO2wG")
    	  .setOAuthAccessToken("39952747-IcSqsSoPphTWaLoIwYaUITWQ5PmeyV40bQHgkTf4C")
    	  .setOAuthAccessTokenSecret("Nn4NEH9XE9xIb6QXu3R8kOdocncplz67Cq8RZlrOZlyOu")
    	  .setJSONStoreEnabled(true);
    	TwitterFactory tf = new TwitterFactory(cb.build());
    	Twitter twitter = tf.getInstance();
    	ResponseList<Status> statuses  = null;
    	
    	userCursor.next();
    	while(userCursor.hasNext())
    	{
    		String screenName = (String) userCursor.curr().get("screen_name");
    		boolean rateLimited = false;
	    	try {
	    		statuses =  twitter.getUserTimeline(screenName);
			} catch (TwitterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				if(e.getStatusCode()==429)
				{
	
					   System.out.println("Waiting...");
	     			try {
							Thread.sleep(15*60*1000);
							rateLimited = true;
						} 
	     			
	     			catch (InterruptedException f) 
	     			{
							// TODO Auto-generated catch block
							f.printStackTrace();
						}
				}
				
				
			}
	    	
	    	if(!rateLimited)
	    	{
				System.out.println("Got tweets for "+screenName);
	    		userCursor.next();
	    	}
	    	
	    	else
	    		continue;
	    	
	    	for (Status status : statuses) {
				String jsonAsString = TwitterObjectFactory.getRawJSON(status);
				DBObject doc = (DBObject) JSON.parse(jsonAsString);
				
				try{
					tweetCollection.insert(doc);
				}
				catch(MongoException e)
				{
					System.out.println(e.getMessage());
				}
			
			}
    	}
    	System.out.println(statuses.size());
	}
}
