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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import twitter4j.conf.ConfigurationBuilder;
import twitter4j.IDs;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.TwitterObjectFactory;
import twitter4j.User;

/**
 * Lists friends' ids
 *
 * @author Yusuke Yamamoto - yusuke at mac.com
 */
public final class GetUsersJSON {
    /**
     * Usage: java twitter4j.examples.friendsandfollowers.GetFriendsIDs [screen name]
     *
     * @param args message
     */
    public static void main(String[] args) throws IOException{
        try {
        	ConfigurationBuilder cb = new ConfigurationBuilder();
        	cb.setDebugEnabled(true)
        	  .setOAuthConsumerKey("dstu8zdadkx2hf4CHpcegKTNy")
        	  .setOAuthConsumerSecret("64cCY6jjsdJFI0nwD5zfddSjfFgD3AqD3vBOSdHBw3T7ZAB11Z")
        	  .setOAuthAccessToken("2777354556-9QpSxTFiLRq4HXTpMrlQ06sCM0vxr7K5qyDSVY7")
        	  .setOAuthAccessTokenSecret("qvQhJBXdQEdavKgvNxnJyq5EnQYZk1SDNmSnMSjSkkJa1")
        	  .setJSONStoreEnabled(true);
        	TwitterFactory tf = new TwitterFactory(cb.build());
        	Twitter twitter = tf.getInstance();
        	//Twitter twitter = new TwitterFactory().getInstance();
            long cursor = -1;
            IDs ids;
            System.out.println("Listing following ids.");
        	new File("user_json").mkdir();

            do {
            	
            	
            	
                if (0 < args.length) {
                    ids = twitter.getFriendsIDs(args[0], cursor);
                } else {
                    ids = twitter.getFriendsIDs(cursor);
                }
                
                long[] id_list = new long[] {1868074730L,140892663L,29468585L,61417559L,101580574L,1469101279L,62805324L,1435626302L,2201220235L,14698049L,34056134L,32841620L,2441910085L,2505478057L,2335741172L,2768000832L,572478728L,65923928L,1632855667L,443484148L,901796180L,2337886340L,1619086339L,527119125L,3496041L,473617692L,223315248L,14445920L,191932849L,97994396L,15387117L,10448732L,794532L,295049967L,782632L,11244372L,121486117L,17881672L,7032912L,15254730L,567059880L,9732512L,7718322L,2770511L,2278064736L,30744136L,18073651L,14200949L,267344900L,815803254L,334090417L,2421317989L,31208923L,15711635L,14910027L,804633782L,45184849L,8731752L,816509173L,14639500L,142515652L,2778320166L,2257350176L,14948062L,2321735011L,1390540460L,123428539L,351306056L,126916586L,2680350607L,2736952543L,1952836374L,2478756618L,217081909L,324539863L,233318165L,1562625614L,2392531752L,2406505603L,2381420407L,2315539361L,2257104332L,2287145203L,2286545720L,50609160L,2567934373L,2502466327L,2322651270L,2309637680L,1728667957L,916257050L,157759025L,41140413L,2326927580L,603147106L,490808869L,155440944L,167434488L,40217798L,2584810652L,20737357L,2259434528L,2379768630L,16489197L,162573283L,2309081983L,1387081490L,299952246L,1420795609L,307699453L,357312062L,1687931155L,1328406894L,1113937704L,1260416562L,2230083151L,1390214179L,458769926L,9337702L,15173724L,14338147L,2313732494L,576018898L,28477224L,14110443L,334161392L,735523747L,118917461L,19132398L,2366348178L,1004978042L,2616036566L,553389027L,2682395184L};
                
                
                int i = 0;
                for (long id : id_list) {
                    //System.out.println(id);
                	i++;
                	User user = twitter.showUser(id);
                	
                    String rawJSON = TwitterObjectFactory.getRawJSON(user);
                    String fileName = "user_json/" + user.getScreenName() + ".json";
                    storeJSON(rawJSON, fileName);
//                    System.out.println(fileName + " - " + status.getText());
                

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