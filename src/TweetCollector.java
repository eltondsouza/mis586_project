import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterResponse;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Properties;
public class TweetCollector {

	
	public static void main(String[] args) throws TwitterException {
	    
		ConfigurationBuilder cb = new ConfigurationBuilder();
    	cb.setDebugEnabled(true)
    	  .setOAuthConsumerKey("BK51tFzaQMpUOxlkqVlF0Yavy")
    	  .setOAuthConsumerSecret("25egEBzQjDG6Mt3lWBOZle1U8MqZrpg3Lq12KpoBWXU7etdlLb")
    	  .setOAuthAccessToken("138051557-YYkZQMYSVWd6FoKTQVj4K7h0CzCsocxsaLjMbw5g")
    	  .setOAuthAccessTokenSecret("jMM04wzOXCs26oEzZKTFFduFg5NHsn0bMvcCHIMqIBOZ5")
    	  .setJSONStoreEnabled(true);
    	TwitterFactory tf = new TwitterFactory(cb.build());
    	Twitter twitter = tf.getInstance();
    	
    	Query query = new Query("@actualadvicealt");
    	    QueryResult result = twitter.search(query);
    	    
    	    int counter = 0;
    	    
    	    for (Status status : result.getTweets()) {
    	        System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
    	        
    	        if(counter++ == 70)
    	        	System.exit(0);
    	        
    	    }
	}
}
