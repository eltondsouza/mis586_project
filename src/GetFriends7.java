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
		String[] ids = {"2635897908","2744657538","2416758685","2248967124","16214322","302599484","2489534816","949856948","2663692746","2533379809","764368","2451711853","2409072902","916067227","126421592","2275133083","15633629","2345654862","1389813608","2396447095","2542046377","2529263353","2663509488","2275411410","2237660660","2485647109","1307916588","1971497084","2443106150","48865223","2230987669","2479167517","14217367","349582180","102974618","2396749237","41069035","2597726102","83477440","2631709828","2316998052","1694404249","5518812","305430740","2574945608","2588312497","141981165","1198362816","2269371258","2300353356","2310045240","2319543313","2292749149","2458406940","1149877135","2354572206","2729338809","2404876578","2309343738","462718836","636819492","43732439","2461188662","2327206913","2694266390","13241362","2281994839","1553738250","15260383","2252790079","18334582","330973452","2217141152","2725733064","504857531","2305150014","1629943104","2402296083","2683994778","2713067311","234029678","2191858315","2455570795","2335452505","1289081287","1399897543","408553930","2273358422","2352414061","2213964432","423834844","2223785934","2417616883","2493832087","2569078346","1583603071","2439880110","1668385598","2616841986","2320185134","952112852","2674814971","442587866","53087133","11755212","2268117290","124192816","252895560","242221174","5146141","33973843","1161082386","1710758653","2318580398","2667091934","2608930418","1437251966","116154256","2316408817","302891170","2610024690","2454223160","2666049174","2554732932","403207462","2352630522","426047336","2256099668","2741179116","2295443316","2650896810","2323162729","14741110","2433840470","2444397626","2603176778","2233367220","2773590272","951758514","2414748446","2807317290","2752692698","2454082958","2453968004","2344222885","2478769304","398204399","135764995","295786768","781955690","434677572","2458960759","2429026236","2465609665","2721957381","2375800382","1072533720","207695851","2402328186","497755150","845243322","2405550008","2658053534","2363239795","2427368287","25025409","2342884574","2334001867","2334655857","961799694","583201461","2412695418","389340245","2654336208","115353954","19280960","161774195","2191592691","2407332044","53293251","2438024414","2601066522","2685477972","2290741810","568914153","15588025","2381187606","263391190","11470302","2592252733","339891087","2305117220","849442146","536669156","242427461","1551882704","1227898040","85253884","49458064","49454356","111245074","2318406266","392528324","2460975432","2333442859","107680490","266007349","2262377581","743306018","2597053897","1002462271","2791897020","251299619","2521848295","2450414006","2293996238","91061988","367899405","2320808873","2444140231","2275448066","2717360850","43133926","17684875","2331914678","2627703649","431630929","2396471491","23973782","2676168042","127709998","2339432880","2299142984","2792317662","74924464","355506217","1239412674","2510584500","2576731352","2253225535","1629327594","2262379441","582677863","2250766224","2701568108","2437531926","196669584","2700992904","2784763466","199027735","2626656086","2590748240","2234694705","192671580","2385088772","17498413","508069085","1176787435","2367802921","14065447","113555434","2368765009","2369962958","2331238783","1869716084","1354884264","47313784","25631940","2373069935","102313626","2766382513","2446310894","1565249084","1969568100","2675894113","2590595364","308482945","36806342","2374055526","2478853338","19185330","1445817618","2597374686","1687529258","2275326770","2315162216","2356049424","18812868","44656109","2496082400","1203075367","504993350","296080440","2655669024","169726635","2407528358","2494520694","2712142232","22944094","2665938049","9272252","2214652488","2323183495","2430104215","384358112","2546848639","2766981258","132634672","723966313","2337295142","2283306266","2193164239","2608610090","2585482452","1976890536","2438277691","60741940","1286634349","2294457896","2811399918","2410227635","16478413","50498589","2503893062","2341179954","2398360147","256755545","2389662613","1181018858","2214632190","2786411280","2379244220","2344064461","2357110855","273697784","2547513904","2300399395","2321655650","2586748687","210491485","2445684978","2568564770","2555432016","1397359064","1869513535","2319106597","271495163","464658372","487387650","14587167","3985891","18712213","1488939264","2496905120","2752379155","2762501305","2321855654","2786269788","21953758","2361121","611842870","2238814908","41213831","1927467914","1403528683","73951647","2722594417","2251259442","2677946179","2620093706","2478149275","2707338241","79710995","2753000630","2309813817","1963804104","2506113326","22335498","923122490","2343997250","14701738","2691028346","213842895","1565265944","1346298716","2587635097","2528611544","2300448080","2728767838","2337938960","2513709500","2336989321","307455449","16477376","2337136418","324545385","2410009524","2448174673","7523232","17059594","210746120","2646745291","2775995436","2594587068","2662279915","2549585226","17746003","2431006866","418916329","2602441195","2742990007","2422376401","2719404147","76609847","607265795","2580795967","2409257226","2584015704","2662634342","1462530632","18027432","2795465947","1075134818","2526866762","105159244","64640385","14076736","1269099570","2482834646","2600550356","352260040","157241962","2219745723","239940634","2317907780","2252863056","2347049341","38737968","2291638782","325843123","2415069511","2494068258","2291523649","2341217690","35183945","35639692","321574387","2282659135","47548986","2407523575","2484702732","2396442385","2658578822","1019653598","434006861","2402198270","2552891245","2644118864","2525874050","2317077079","315783277","20949877","14826222","2493119408","2679343400","14587758","222838052","2812180506","2384373229","2507600996","14894061","2360135237","312570173","1119041982","2686547886","2507029290","2458830518","2698984921","2398084284","2215079746","2233087663","2598322682","2593026032","19910502","2326075723","2493581864","2774820738","2496862008","2728451653","14717442","224717630","2290661924","57450327","2435492749","2736697441","2590571196","2494919072","2239990213","6670582","21837313","2462880390","2599777526","2493175358","2562526117","2308969802","2335610137","81015422","2590220174","35878423","2348799374","1400785176","218685153","2181332800","2305171496","41616960","2670277466","2316690529","5728962","86948689","2337396314","2497311762","2800410739","546343664","1630892612","2699839326","2721540069"};
		String[] screen_names = {"multisigcoin","Multi_Wallet","MunitiCoin","MyAltCoins","myazri","myBitcoin","myfootballcoin","myfxcontest","myji17093","MyllzCrypto","nanok","NatSecCyberWonk","NaughtyCatzilla","NCSU_Panda","ndeet","NDLCoin","NealJiutai","Negotiumcoin","NeocashRadio","NetCoinage","NetcoinsCA","NetworkSilk","Neverhoodcoin","newdoeboy","NewMoneyFeed","NewQuarkbar","NewsBitcoin","news_crypto","NewYorkCoinNYC","Nexage","NextCoin","NickJordan_FX","nick_slaney","NikGoing4Gold","NikolausK","NipCoin","nkostov","Noahcoin_dev","NoEyeSquareGuy","notsofastcrypto","NoUseForACoin","NowBTC","npcraig","NRxNorth","NuBills_au","NuCoinGame","NuvoPos","nwbitcoin","NXTcoin_de","NxtcoinsNL","NXTCurrencyNews","NxtForge","Nxtgids","NYCRYPTO","Nysedaytraders","OctoCoin","odiandr","OfficialNuBits","OfficialTitcoin","OG_Ryder","OhDoges","ollekullberg","olympic_coin","Onscreenf","OnyxcoinX13","ookook","oPesetaCoin","optrader1001","organicoin","originaldoge","oxba","ozcoin","ozcryptos","OzzkePND","Paco_Ahlgren","paguecombitcoin","PaidInBitcoin","PakiCoin","PalestineCoin","palestinecoinpr","PaperclipRobot","ParadoxBTC","ParallaxCoin","PatCrypt","pavryzhkov","paybits","paytunia","pdxcoin","PeaceLoveDoge","Pecuniology","PeepBitcoin","PeercoinMarket","PeerPalco","PegasusCoinPEG","pemburucoin","PenguinBm","PenguinCasino","PentagonMining","PeoplesCurrenC","peoples_pumper","Pepe_BTC","pesa_cash","PesaPoint","petetown66","phillpafford","Philsabang","philvadala","phonikg","PickandPopovich","pierreneo","PipCzar","PizzaForCoins","pkeane4osu_paul","Playb0yl0ver","Play_Cryptopoly","PlutoniumRODS","pokemonbitcoin","ponli137","PopularCoin","PortalBitcoinBR","PosCoinDev","PotCoinCity","PotCoinNews","ppccoinwallet","pravin_bhudiya","preminer","priceofbitcoin","PriceOfDogecoin","PriceSpec_","PrinceOfDoge","PrismaCoin","prospercoin","prydie","PryptoGirl","psbitcoin","Pseudo_Coin","PTcrypto","PujiTarasen","pumpa007","Pump_Coins","PumpDumpTracker","Pumper_Ryan","PumpingAltcoin","PumpingCoin","pumpnetwork","PumpsArgentina","punk_money","PutraAlengka33","PynchonInPublic","Pyramining","qikcoin","qoracoin","qrkex","qumatru","quwelfer","Ragnarly","railcarhobo","randybrito","RaxeSoftware","RazDyer","RCasatta","rdcoin","RDDprice","realstackcoin","Rebecca4Liberty","RedBlurr","Reddcoinforum","RedditDogecoin","RedditVertcoin","rEdd_rEadEr","redmagegaymer","RedMoonDoge","RelaxationHappy","rescuecoin","rfc68","ricardoaba","RichardRougeau","RichCoin","RichCrypto","Riezamore","RimbitCom","riotcoindev","ripoffcoin","RippleSim","roasbeef","robbooker","RockSolidMiners","ronanlyn","ronhose","ROXCoin","RuanBeukes","RubyCoinOrg","rudarSRB","rugatu","RunToAnarchy","RUSHDANM","R_vanPelt","ryanmorse33","RyanMWalker","ryanpflynn","s_8_8","SacBitcoin","SaifAltimimi","sakcoin","sambacoin","samuelgoujon","SanderStevens1","santadoge","santirrio","SatoshiCloset","SatoshiNakamot0","SatoshiTree","Saturncoins","Scrypt_Mining","scryptsy","ScryptTrader","sdpenaloza","SealsWithClubs","SecretCoinTeam","SecuraCoin","SecurityDoge","Sell_altcoin","semothyjones","sergebonaparte","SergioSchout","SetiCoin","seventieweb","SFdogecoin","sfnuop","sfoxtrading","sge55","sh0lla","shadowdepo","shadowlordAD","shanevi","shant33_","shdelcg","SheffieldBTC","ShibecoinOn","ShibeMart","shibuyashadows","ShitcoinSachs","Shop_Loop","shopwithbitcoin","Shout4Coin","sidechains","sigitchow","SignCoin","SilentVault","silkcoinrevival","SingManager","SingularityCoin","SkeinCoin","slidestand","Slothcoin","SmartDogecoin","snuess","Sohale_KPU","SoManyCoins","songproducer","sp0rkyd0rky","SpainCoinDev","spartacoin","SpartanCoin","SPC_Bitcoin","Spelunkin","spencerlievens","Spikescreative","SqftCrowd","ssnehan","SSV_DevTeam","stabilityxsi","startupeddy","StatCoin","stephanieSingma","SterlingcoinSLG","StevenRemington","stile65","stockcoin","stormbosschaser","straatman","STVassileva","SuarezCoin","SuB25Eu","SuchDogeManyTip","SuchDogeNews","SuchPool","super3","SupeRav3n","supercoindev","supershares","Surelivebets","SwagPoker","SwallowTheCoin","swelenc","swift__mine","synclub","t15b_","t4t5","taap073","tabrischen","tadkis","TAKcoin","Takeoutcoin","talkb1nary","TalkcoinHQ","TallyCapital","talyellin","TapPayments","Taxi_Coin","TEAMPump_","TeamVoxa","TechcoinGroup","TechcoinProject","Tech_Journalism","TeddMarketing","tedgonder","terracointalk","TeslaCoins","TestingCrypto","the1mantis","TheBanksLife","TheBitcoinGuru","TheBitcoinRing","TheBitcoinTutor","TheBlakeCantrel","TheBlueMatt","thebtclawyer","TheBTCobserver","thecoinion","TheCoinMeister","TheCryptoGroup","thecryptonaut","TheCryptoOnion","TheDailyBitcoin","The_Day_Trader_","TheDogeAbides","TheDogecast","TheDogecoinFdn","TheDogecoin","TheDukeofCrypto","thefaucetlist","Themaltcoinstho","TheMissBitcoin","theneeds_money","thepumpproject","thestartupshirt","TheWhoNL","thinkcrypto","ThomasHessler","throughnothing","timolehtinen","TinkerCoin","tipbst","tipcld","tiplike","tipmona","tipripo","tljenson","tmcgove","TomasForgac","ToneLives","TonyColeby","TOPBESTCinema","topbitcoinnews","TopForexNewsCom","TopProFish","toprevenueshare","torcoins","TouchingBitCoin","trademebitcoin","TradeOfTheCrypt","trader1806","TraderCoin1","TradingCrypto","Transgendermams","treasurehuntcoi","Trevor_Sande","TripleBmining","trollcoinbase","troyd","truckcoin_v2","trucsdedev","truelitecoin","TrustBitcoin","TrustPlusCoin","Truth_Policy","TweetMyDoge","tygedprogo","tygerAC","UberPools","UFOCoins","ukBitCoin","ultimateboy","ultracoinnews","UnlovedMoney","UnNamedCoin","Unsub42","unusualbob","upandbeyond","UpstartCoffee","Urocointalk","uroex","usbcoinwallet","v1pjolu35204873","V4vdtY","vagroup","vanadiumcoin","vanyabios","vaultex_io","VCFundamentals","vcoinportal","vecocyzP","vegardtorvund","VegasCoinCo","Veilcoin_Team","vencoin","VeniVidiViciC","VENTcoin","VersoCards","VEscudero","VexCoin","Victor_nW","Viking_Coin","vikram_nikkam","villeohman","vincesamios","vintz13","VioletCoin","VirtaCoin","virtecoins","virtualfaqs","virtuosi07","VISTAPublisher","volabit","Vopemz","voxdotcom","vRobM","VTCPool","Vtechp","W2Coin","WalletGenerator","walletHQ","WampumCoin","warum07","wasabi521","waspoza","watcoin","WaveChecker","WavePumpCapital","weareneutrino","WeAreSatoshi","webcoinx14","webpreneur23","weekeeleaks","WeeklyBTC","_WhaleRider","WhaleStJournal","whalewallstreet","willa_pl","WillemKadijk","WILLMS_","willnavidson","WinBTC","Winecoins","_wini_","wirmola","Wise_Crypto_Guy","wmcbain","wolfdaddylistia","woloski","Women4BTC","WorkForBitcoin","Working4coins","worldbitnews","WorldCupCoinWCC","WorldFootballC","wormlessbird","WPCoin","Wrgrv_dogecoin","wyrdbitcoin","X14Coin","X15COIN","xangma","XBTConsulting","XCaliBitCoin","XCashcoin","XCurrency","XDoubleEagle","Xentagz","xH2Os","xnfcoins","XorrTGJ","XRPtuz","XuroCoin","xxxcoins","Y3llowb1ackbird","YACoinJoe","yahn","yeeehah","YellowCoinTeam","YellowCrypto","YellowPay","yesbitcoin","yestodoge","yes_we_coin","yoAnthonyB","yocrypto","yojasondotcom","YouMeAndBTC","yumcoin","yungrushin","yvg1900","ywgdogecoin","zachlark","ZapChain","ZedCoins","zedlander","zeligf","ZenBox_Kiosk","ZetacoinBerlin","ZEUSpumps","zigbs","zimbabwecoincom","ZIPCoinX13","zysuhySala"}; 
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
