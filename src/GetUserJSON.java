/*
 * Copyright 2007 Yusuke Yamamoto
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import twitter4j.conf.ConfigurationBuilder;
import twitter4j.IDs;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;

/**
 * Lists friends' ids
 *
 * @author Yusuke Yamamoto - yusuke at mac.com
 */
 class GetUserJSON {
    /**
     * Usage: java twitter4j.examples.friendsandfollowers.GetFriendsIDs [screen name]
     *
     * @param args message
     */
    public static void main(String[] args) {
        try {
        	ConfigurationBuilder cb = new ConfigurationBuilder();
        	cb.setDebugEnabled(true)
        	  .setOAuthConsumerKey("dstu8zdadkx2hf4CHpcegKTNy")
        	  .setOAuthConsumerSecret("64cCY6jjsdJFI0nwD5zfddSjfFgD3AqD3vBOSdHBw3T7ZAB11Z")
        	  .setOAuthAccessToken("2777354556-9QpSxTFiLRq4HXTpMrlQ06sCM0vxr7K5qyDSVY7")
        	  .setOAuthAccessTokenSecret("qvQhJBXdQEdavKgvNxnJyq5EnQYZk1SDNmSnMSjSkkJa1");
        	TwitterFactory tf = new TwitterFactory(cb.build());
        	Twitter twitter = tf.getInstance();
        	//Twitter twitter = new TwitterFactory().getInstance();
            long cursor = -1;
            IDs ids;
            System.out.println("Listing following ids.");
            do {
                if (0 < args.length) {
                    ids = twitter.getFriendsIDs(args[0], cursor);
                } else {
                    ids = twitter.getFriendsIDs(cursor);
                }
                int i = 0;
                for (long id : ids.getIDs()) {
                    //System.out.println(id);
                	i++;
                	User user = twitter.showUser(id);
                    if (user.getStatus() != null) {
                        System.out.println("@" + user.getScreenName() + " - " + user.getLocation()+", Timezone - "+user.getTimeZone());
                        if (i%100==0)
                        	Thread.sleep(1000);
                        	
                    } else {
                        // the user is protected
                        System.out.println("@" + user.getScreenName());
                    }
                }
            } while ((cursor = ids.getNextCursor()) != 0);
            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to get friends' ids: " + te.getMessage());
            System.exit(-1);
        } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}