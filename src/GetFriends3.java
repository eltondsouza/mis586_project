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
		String[] ids = {"712881733","27023307","19724036","2299554823","1190256253","7396822","2343836600","287769673","289564880","2435694072","2742020989","2200708910","96396125","201387364","2342402455","2309818874","2518784544","39066951","1647081858","163051182","2485427205","2721621668","1379130169","963241754","2338907259","1380695610","367743069","469330646","2235136754","2616318362","134411372","21558596","1384955754","1210952893","1325629370","2623464418","2423211476","14928942","15119529","385562752","1268291780","1327769568","1393174363","1379072365","2226830395","475106078","2759564242","106124522","609091503","2200360908","1523185238","54598980","143977123","1223385103","227418944","17588600","2366303126","1338191270","813883412","2608353780","8432752","95994080","2384363672","2216237670","29762963","353813389","2455300670","14763764","455699696","13244152","16451932","2409710738","103019186","2437368144","25127035","18160134","2604429991","2334920414","871107427","14279462","2611725756","9863612","488536612","15320102","14427338","2352743983","1402032307","222531597","549304757","33149849","35865236","17591742","196044151","1628642976","2382833052","2455746828","8289702","252569527","2228144390","1478663665","824060377","14638841","217503506","106234268","433518591","10739992","52340418","619303","9103922","21122421","386588359","295862357","2295803233","2320443654","2312008597","2363896933","301731542","2482090896","2575007138","2220287622","2402032692","1466189700","2314227612","2320404222","1129116216","2180526523","2214916674","1979449668","2667670064","1567096106","46869914","36033287","730086612","1870417183","16179805","15364687","2482963466","22162666","2715312378","1045007220","71787994","282552417","165190014","1893890754","2645327969","2224075856","2319494958","27422071","102784774","92281665","40586273","20929072","1325282202","2363586666","2343566634","2400183606","2653394250","2248110146","2228862812","2322494803","2320806962","2396894258","2417542227","2387827116","14418873","802702237","2328351174","2328807065","2154512879","52335744","2218547448","13325762","376172658","179461935","37417270","1878595094","361666014","1585932799","25052903","2426280816","1354739114","2478439963","2532954854","460584564","113061083","130471189","24723897","559797807","92279996","18634281","2492130176","119365950","1704878910","40182630","15174692","15232850","71291767","1020203322","14326675","15855616","941182304","152460986","2272208143","1370444665","418803165","709294406","2292281622","6015932","1733867336","4034031","1591747004","2455304028","2178858974","24546521","2420979416","1729661822","85868590","14684626","1960439930","36477638","343902575","260146304","2313072698","777220598","2280289681","2430969794","15134307","2676288085","537570342","18185614","164628863","2584595419","1274469684","2161995060","2241456800","388579395","2433648590","2365613563","86508614","85726089","43514030","2161496719","381185553","606286599","286728598","335311525","239871798","1527962941","52160722","612458670","2465184583","2532881881","16670774","110075039","2279681898","2480548052","2313671966","2320852861","2723492052","2585736660","1492819644","2743312900","213829067","2323493340","2600194316","2603955661","59307142","1344389899","2150123534","2340647486","14199521","14763980","1223938794","1315790306","20588098","2303650739","872738546","1901611970","89429647","17811957","38270714","2674226202","2419465506","765007633","2211174856","183816474","2260789034","1293548664","2276194537","917655432","19240388","2278542824","2244257760","316809023","2801347050","2355533382","1736280751","36081258","1077965228","27557141","2576848693","2585829824","2574819667","2574828552","2574721470","2576846984","2575007623","2573084024","2574845166","2574957176","2576864514","2576965832","2574985188","1975454844","1920655710","27583645","10446482","2239885255","2243862290","2360654905","2328704769","2502162932","2302018777","13697","859226797","487696298","814667","264828029","2314224984","2288771270","15885871","519800095","38392573","2445396642","16912671","32356246"};
		String[] screen_names = {"kymmer7691","LADLynn","lafetaylor","LaMaisonDuBTC","LamassuBTC","langer_hans","la_porca","Larry_OBrien1","LasVegasBitcoin","LatiumCoin","LatiumFan","LaunchCoin","lauragales","Laurie_Rice_","LazyCoins","leafcoin","LeagueCoin","leahmilner","learnbitcoinUK","lee_boyce","lekingdlabeach","lemurcoin","LenklaHudakova","LeoFromH3ll","letsgetbitcoin","LetsTalkBitcoin","Liam_Duff1","libcoin","libertyteller","LibrexCoin","licuende","lifeboathq","lifeonbitcoin","lightcoin","lilbitcoin","LillyBitcoinSol","linhlan966","lisacheng","lisafleisher","litecoin","LitecoinMining","LiteCoinNews","LitecoinProject","LitecoinRates","Lite_Coins","LitecoinWatch","lloyd_felisa","loboscoinsure","LocalBitcoins","LogoDesign4BTC","LondonBTCMeetUp","LondonMarathon","Lord_Ashdrake","Lorenzo_Money","LorenzTrader","lovemoney_com","LoveseatBlog","LTCBTC","LTCWatch","luckysatoshi","lukestokes","Lukewearechange","lurkerAKAJesse","M4niAK_","maartented","MaBetschart","machinist_gitju","maciejolpinski","mad_etf","MadMoneyMachine","MadMoneyOnCNBC","MadPotCoins","magaFirst","_Magicaltux","Magoo","mahingupta","MajningMaster","MajorMiners","MakeNDAAfamous","makevoid","MalibuBitcoin","mandiees","mannypr1m3","maranh","maraoz","marcoaaronk","marcoporretto","MarkAthertonTim","markdavidlamb","markhamthomson","markkevtaylor","MarkLyford","markwoodsaz","MarquisDonatien","MarshallHayner","MarteXcoin","martindale","MartinSLewis","MastermindBTC","masterofmyself2","MasterZeus2012","matshenricson","MattdeCourcelle","matthew_d_green","Matthewkenahan","MatthewRoszak","matt_innes","mattmatt","MattPRD","matt_tuzzolo","Mauri_Wowie","mawueli","MaxCoinDice","MaxCoin_nl","maxcoinproject","MaxcoinWorld","MaxMoyle","MaxPromote","mayorofshytcoin","MazaCoin","mazatalk","MBitcoin","mBTCPizpie","McCluskyJoe","meetpays","mega_coin","MegaCoinTrader","MentasoBitcoin","MerchantCoin","Metaballo","metacurrency","metaquestions","MetaTrades","Mexbt","mhluongo","miaoux","microdesic","MidasMarni","MidasPay","MidgeGaunt","mids106","MiguelCuneta","miguelproulx","mihcomih","mikecrypto","Mike_Crypto","mikegeister","mikegogulski","mikehogan_","mikejcasey","mike_maloney","mikerotman","MikeSweeneyBit","MileCoins","mimcoin","MineCryptoCoins","MineFilecoin","MinerDealer","MintBTC","MintcoinTeam","MintPalExchange","mintpal_pumper","MintPumps","MintTip","MironLulic","MissDanielleToU","MissSatochi","MisterCrypto","MITBitcoinClub","mittsdaki","MJKCurrency","mlrichard","mmeijeri","m_murfy","mobilemoneyafr","MobileMoneyZA","MobilesWanted","mochi_wsj","MoiraONeill","_monayen_","moneeroHQ","monerocurrency","MonetaVerde","money2020","money2themasses","Money_Advice","moneyandmedia","Moneyandtech","MoneyfactsNews","Moneymagpie","MoneyMikeOnline","MoneyObserver","MoneyPennySF","MoneySavingExp","moneyStrands","MoneySupermkt","moneysuperPR","MoneyTelegraph","moneywatch","MonicaLongSF","monimobile","MonoMesa","moolah_io","MostlyBitcoin","mperklin","Mr_anonymousJR","MrCrypto_owlman","mrebola","MrKryptoKnight","mrmx","Mr_PlNK","mrsbitcoin","msantoriESQ","MSBCompliance","MScDigital","MSCProtocol","MSE_GuyAnker","msnmoney","msteph_matthew","Mtal","mtgoxalerts","MtGox","MuchCryptoKing","munoz233","Murraycoin","MurrayOverboard","musha68k","musicformoon","Mut_Coin","muxiaoliang","mvidallopez","MWL4Money","MyBitX","MyBTCNinja","mydogecoin","MyMoneyPlatform","MyPumpAcc","myriadcoin","n00shinm","nachoorozcog","nadam9","NakamotoInst","NamecoinCable","NamecoinDotInfo","Namecoin","NatarrshaRSmith","natdebtline","NateTripleB","nathanielpopper","nathanwosnack","Nautiluscoin","NavajoCoin","nbougalis","nealstephenson","needacoin","NeedForBitcoin","nemcoin","NeoandBee","NeosCoin","nestcoin","netagio","Netcurrency","Neurotraveller1","NewBitcoinToday","NewKoreCoin","NewsAltcoin","NewsAndChat","News_Bitcoin","newsbtc","NewtOnCrypto","NEXUSBITCOIN","niccary","nicegfc","nicekidd0","nicholaslovell","nickjachelson","nicoamorescom","nielsnnn","nigelverdon","Nightwolf42","nil8tor","NimbusCoin","Nixecom","nkwsy","nlbosna","nmachijidenma","nnbitmob","NobelCode","NobleCoin","NoCashFee2Trade","noel_llopis","NoFiatCoin","NoirbitsCoin","nomaxpi","Noobgettinrich","NotoriousBTC","NowellAssociate","nozomimagine","nsch0481BITCOIN","NTmoney","NuBills_ar","NuBills_at","NuBills_ch","NuBills_es","NuBills_fr","NuBills_hk","NuBills_my","NuBillsNews","NuBills_nl","NuBills_nz","NuBills_se","NuBills_ua","NuBills_za","NukMark","numistat","Nuseii","nvk","NXTCoin","NxtCommunity","Nxt_e","Nxter_org","nycbtcpros","nzcrypto","obeattie","ObscureJelly","OccupyTeaTent","octal","odoudin","Official_Florin","official_utc","ofirbeigel","ofnumbers","oib9","OKCoinBTC","oleganza","omnik"}; 
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
						   
						   //create DBObject				   
						   BasicDBObject doc = new BasicDBObject("id", Long.parseLong(id))
					        .append("screen_name", screen_name)
					        .append("friends", FriendsIDsLong);
						   
						   //insert the DBObject
						   friendsList.insert(doc);
					   
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
