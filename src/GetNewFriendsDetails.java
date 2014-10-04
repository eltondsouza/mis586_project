

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

import twitter4j.IDs;
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

public class GetNewFriendsDetails {
	public static void main(String[] args) throws TwitterException {
	    
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		  .setOAuthConsumerKey("5at9oIC6aqWOGYE635Cw8dX8z")
		  .setOAuthConsumerSecret("ACvypDRJWO5Ni2HDQxYvm9Z4uSD3MZhxVou92gFJvLg1MOO2wG")
		  .setOAuthAccessToken("39952747-IcSqsSoPphTWaLoIwYaUITWQ5PmeyV40bQHgkTf4C")
		  .setOAuthAccessTokenSecret("Nn4NEH9XE9xIb6QXu3R8kOdocncplz67Cq8RZlrOZlyOu")
		  .setJSONStoreEnabled(true);
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
		String userListFilePath = "user_json/orig_list.json";
    	
		long[] old_ids = new long[] {302202446L,2509966249L,91308344L,2268690198L,213236426L,213222099L,53089954L,1036508786L,2258136452L,2218386410L,2234070631L,19844311L,267485701L,396045469L,101313519L,776581L,5369302L,1449991944L,2324022344L,2226867176L,2241329875L,1268759210L,2333408605L,1423870044L,2209677878L,2155219346L,2390188770L,2197377873L,2828426172L,90135167L,2175120708L,2314255350L,12503922L,14379660L,28813427L,19337489L,2273578802L,90565003L,22682896L,2319408132L,2332842072L,38129556L,19805098L,2234577642L,2329290331L,1394496090L,1429437746L,2435734063L,625289155L,92592782L,2347718839L,2228501803L,243088415L,385162204L,26499336L,301038559L,16330402L,818306821L,1584350917L,2438933293L,15227738L,2353822842L,16404277L,73572217L,1877857849L,226974029L,1935681L,392225137L,392384741L,315991624L,218484333L,3241231L,143053926L,870835010L,210881916L,2252185436L,12137672L,513638693L,67452097L,20280065L,2206552629L,14601336L,2443570976L,1673570310L,2323068068L,32909917L,367486902L,232644888L,2240466703L,379400685L,56999514L,94274445L,17647739L,84049101L,85203198L,2178485677L,2607752989L,5624402L,2242726506L,50330199L,2253440382L,857998692L,277239629L,13383032L,29762963L,1389824700L,103019186L,1402032307L,2228144390L,9103922L,1151513358L,22713009L,92281665L,16214322L,15681800L,272871165L,167748570L,517813520L,22680719L,312789382L,124192816L,31395520L,2807317290L,22093237L,2375800382L,518228021L,207695851L,389340245L,115353954L,81456235L,176758255L,60176671L,2616345878L,392528324L,1142333346L,2188593098L,762324176L,2319698840L,15731156L,17498413L,22847791L,1911600073L,2186091102L,387976826L,18812868L,2759512869L,2255814462L,2759513277L,2424230918L,153823771L,319371528L,1332262141L,54008772L,610700309L,2265324883L,2440641931L,30044262L,477583514L,35860455L,40742821L,2193616844L,46049980L,24222556L,25456180L,2157362647L,1854401L,20833L,1019653598L,6853442L,250980843L,2215079746L,5728962L};
		
		
		IDs friendsIDsObj = twitter.getFriendsIDs(2777354556L,-1);
		ArrayList<Long> oldIDsList = new ArrayList<Long>();
		
		for(int i = 0; i<old_ids.length;i++)
		{
			oldIDsList.add(old_ids[i]);
		}
		
		
		long[] friendsIDs = friendsIDsObj.getIDs();
    	int newUsersCount = 0;
    	
    	for(int j=1;j<173;j++)
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
	    						
	    						User user = null;
	    						boolean exists = true;
	    						System.out.println("Here!");
		    					try{
		    					 user = twitter.showUser((Long)friendsList.get(i));
		    					}
		    					catch(TwitterException te){
		    						
		    						if(te.getStatusCode()==404)
		    						{
		    							exists = false;
		    							continue;
		    						}
		    						if(te.getStatusCode()==429)
		    						{
		    							System.out.println("Waiting.....");
		    							Thread.sleep(15*60*1000);
		    						}
		    					}
		    					
		    					if(exists==true)
		    					{
		    					String rawJSON = TwitterObjectFactory.getRawJSON(user);
		    					String fileName = "new_automated/" + user.getScreenName() + ".json";
		    					userList.add(user);
		    					storeJSON(rawJSON, fileName);
		    					System.out.println("Added user no."+(++newUsersCount));
		    					}
		    					
	    					}
	    				}
	    				
	
	    	}
	    	
	    	catch (FileNotFoundException ex) {
	    					System.out.println("1");
	    		            ex.printStackTrace();
	    		
	    		        } catch (IOException ex) {
	    		        	System.out.println("2");
	    		            ex.printStackTrace();
	    		
	    		        } catch (ParseException ex) {
	    		        	System.out.println("3");
	    		            ex.printStackTrace();
	    		
	    		        } catch (NullPointerException ex) {
	    		        	System.out.println("4");
	    		            ex.printStackTrace();
	
	    		        } catch (InterruptedException e) {
							// TODO Auto-generated catch block
	    		        	System.out.println("5");
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
