package mis586_project;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;

/**
 * @author Yusuke Yamamoto - yusuke at mac.com
 * @since Twitter4J 2.1.7
 */
public class GetHomeTimeline {
    /**
     * Usage: java twitter4j.examples.timeline.GetHomeTimeline
     *
     * @param args String[]
     */
    public static void main(String[] args) {
    	ConfigurationBuilder cb = new ConfigurationBuilder();
    	cb.setDebugEnabled(true)
    	  .setOAuthConsumerKey("BK51tFzaQMpUOxlkqVlF0Yavy")
    	  .setOAuthConsumerSecret("25egEBzQjDG6Mt3lWBOZle1U8MqZrpg3Lq12KpoBWXU7etdlLb")
    	  .setOAuthAccessToken("138051557-YYkZQMYSVWd6FoKTQVj4K7h0CzCsocxsaLjMbw5g")
    	  .setOAuthAccessTokenSecret("jMM04wzOXCs26oEzZKTFFduFg5NHsn0bMvcCHIMqIBOZ5")
    	  .setJSONStoreEnabled(true);
    	TwitterFactory tf = new TwitterFactory(cb.build());
        // gets Twitter instance with default credentials
    	Twitter twitter = tf.getInstance();
    	
        try {
        	
            //User user = twitter.verifyCredentials();
            List<Status> statuses = twitter.getUserTimeline(2408520852L);
            //System.out.println("Showing @" + user.getScreenName() + "'s home timeline.");
            for (Status status : statuses) {
                System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
            }
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to get timeline: " + te.getMessage());
            System.exit(-1);
        }
    }
}