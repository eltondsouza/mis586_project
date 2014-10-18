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

public class GetFriends5 {

	public static void main(String a[]) throws UnknownHostException, NumberFormatException
	{
		MongoClient mongoClient = new MongoClient( "localhost" );
		DB db = mongoClient.getDB( "bigdata" );
		DBCollection coll = db.getCollection("pr2_coreusers");
		DBCollection friendsList = db.getCollection("friendsList");
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
    	cb.setDebugEnabled(true)
    	  .setOAuthConsumerKey("pA8ZUBi1ibxwY1ph9rhhwxXqt")
    	  .setOAuthConsumerSecret("p1keRMUhDQQ0Eh0ChFHBOz8b4jCieSYoDySscUg8E1LXe8Jofi")
    	  .setOAuthAccessToken("2777354556-7aqiunZ0EKgsNullr8OUzYMMvEcOYI0PD8DPRbt")
    	  .setOAuthAccessTokenSecret("aReQrdpx9c6jrL7QqGOja7ZOIyXTHM5gKPTfOhtBqhSaO")
    	  .setJSONStoreEnabled(true);
    	TwitterFactory tf = new TwitterFactory(cb.build());
    	Twitter twitter = tf.getInstance();
		String[] ids = {"187159007","2766533336","423054879","14355360","2727844965","1617216024","15388626","20081422","397412762","2430476497","1677743695","1958281585","589049943","441778203","1371517404","2430646849","28908648","304073299","2507304073","2567534563","2594023975","2379307224","2742656736","2220497298","2363384586","119515587","2484517976","2696024060","2556960799","2767052599","205105745","2309081972","2381154594","2560215828","2426605205","2480284962","2414932969","703992108","1607946302","2281586934","599202537","2419884512","2549296975","1296351739","2618716969","169738826","2812152942","2409806682","2678216233","1633493863","380664281","2385944899","2493012272","122723274","145255437","758477588","1641971","1040586732","2286602634","211348209","2512013754","16951397","22424260","2548542391","83567424","442625719","15499924","2502044215","2473310989","2692555033","517205925","2725072795","2650651477","2664607675","2317707439","99112169","95234999","1708488996","9138082","45543623","123961043","2531935465","1587781616","2457206179","2273416417","1463591982","2754268678","393982431","2547246549","1406401279","2148169854","2663532660","1316976745","1397458164","1255940504","2326572234","2310725059","2752422246","2777191290","22955227","264984219","49883428","162841720","2536830438","2716639442","24209114","93298375","2617373005","166020448","2461034030","2419053642","617358557","2242964546","71342078","111740241","2547488486","2557228190","14436017","291671164","30622819","2358862736","174015863","2790325568","1389203360","2363652140","2350124630","14589854","133487687","483918617","1939543586","16160809","26467595","2285571372","2796303020","2431826928","2534851441","2370355171","1557840163","2489872219","1428390084","2578094158","2669826883","2380550576","2655095978","244973361","1573680914","2337907934","2509211513","2246020056","1040565404","2587179576","297568444","1978991959","2324854088","420537247","1245232406","2502749876","2345522682","1285676882","2380392938","52487900","1196815730","1692226934","2215343491","1912018675","1394213984","310293564","1308037717","2432682018","231565740","2220388111","403441615","314574498","1424680274","2478029634","1702801530","2241329875","2168683008","967721263","2584112227","2152077415","2315554417","2436775362","1032624211","330622772","2202623893","923797338","1229732168","2699067027","2231341320","307795150","871216279","1340720053","37888532","284037986","1320706825","2302791792","306127388","2169475742","2463342536","2211415581","2611894398","1402635151","2282577320","2364122017","744901326","333731125","326917085","1966027772","203537637","2300494987","355402143","920146856","942790596","2510379420","2192368312","1098206576","2412653581","2222325217","314760967","1347964062","712186806","893012234","2227436731","1123770114","2327730247","618387171","2233433298","2230488068","2737873792","2466476857","1062987019","2498447523","2566188661","315731591","1003164037","1025160871","2214054802","1124950782","301334724","2753142620","2176893362","2202290414","1124494686","2372097445","2334843785","1232077897","2296606922","2463544362","2162966126","2453504778","2217809383","1153732693","2472977100","1585394168","1455978174","2798965376","368097004","444511554","2226658662","2729800633","937523652","1588273466","1271064271","1343102108","1125663272","763398216","2489119208","2364365618","1275776370","1877257982","1072402520","290709769","2285068692","2258721882","968519448","2422194630","313180294","903228692","2292940068","747996427","1153480183","2713514846","1672468687","612810589","217628409","1355055006","1330480411","2407795754","192022349","2559537806","2396722351","1928059495","2256587928","2474356940","1077779486","2494947284","1318353630","2175939378","2437077295","359451941","2535797624","2344179492","2512838227","620289651","1329787554","396049318","2414576671","374368659","413546628","342896524","481491632","936338192","2438286846","339282535","2185077866","276988610","320651582","1170521084","366306993","942032772","1480640862","1288246597","1260150438","2516928954","2390188770","966711192","2686003172","2714540334","1384487000","366280020","1347362516","2226867176","319592642","1196109452","1350543810","2755029923","1630546573","910981116","1048766539","2660368982","993294463","840222319","381191249","1653015306","2507147930","1445170512","464464876","185512672","2440677170","2558714826","1959618559","374349772","360905292","1075113240","1318948164","1352736463","2743178911","968955744","1294237494","2573709666","33301758","1283304714","1895099845","2214770768","553117776","1277038010","292836428","622858505","820895960","2431700634","2318317340","942753494","473716500","2286506490","2168553738","2428998564","985486939","2225033930","1272304616","1330799580","1059429242","744166753","1465996994","1268756504","2430662736","2691289556","2318213418","2773494026","2278180339","1150215859","2227492056","42983510","2467022124","2286566749","2398707920","2549993258","2597151457","2590254877","352006562","216098889","2390799241","2396594216","1672927699","1034267430","2315264368","1657611834","2177936300","2366140464","2454286406","1150082958","2342231024","2188945260","1509879360","1262121716","2545749140","2328100908","2421972430","381224814","2291623532","2492168516","2594797585","2337216289","2206353751","2355326180","365772438","15039075","512120095","2797531674","2511529496","5845842","311430228","210856867","103839711","2290312260","2239532809","2267498036","281090214","476232625","103986874","488055800","1279894650","2531213809","231885539","111302660","2289919124","189394427","21546368","2225853768","2296010218","2339001019","2281506702","17958179","474114045","55232688","90565003","16014585","2413305702","454669156","549514800","449795491","2661779899","2334187722","2519578730","2649237534","381171090","2600887122","287121965","2492385890","316011405","1351977522","2528174766","2281962128","2361754280","312725845","2282237282","1934772522","1312448552","1684304156","373508176","2234815058","2509810398","2352140443","2332743313","2500097240","2556776600","1441272607","1954471566","2559503598","1361206674","297199737","895899019","2391778712","2357511908","262896814","2441206391","2262054721","2425586605","2498285516","315868913","2474275867","2250098930","2736501218","313026780","2766455714","1703064764","2387382506","2649805414","928545860","353722571","1859373714","2543756148","2225637589","1065684536","2218527686","2212311782","1930490335","1295879491","2242653655","2349204913","1244433355","1261108250","2401971696","516037756","1676081935","973447008","2737028137","2350654962","1347409297","2416717488","2721675346","2490180301","26894518","2561719807","1373829019","2374146852","945185365","2279137177","2774511265","2299934760","2474218272","837257324","2213907936","2570251214","2397062533","2560899606","239026022","2412419202","1266745693","502290509","2265309684","2444335592","2545315130","429091183","2414923982","1942484395","2546343708","2651077997","2718023316","2733023694","2298351216","1534167900","25734069","2397097070","2333233063","1568586666","2749731934","170709002","102243107","2713995578","1291076396","2492063724","149370826","2307000668","460501591","2489595865","560331550","2491714968","2363757276","46804450","2648818831","470048506","25049491","2346602154","2716224576","147204853","16491902","2311051836","2383676012","1664012648","10400672","299437634","317992307","20580736","14101921","2386010875","2729196715","2729126538","575553641","79099132","2289036295","2767440608","220725386","42216022","16732770","2459924112","2661586610","2294931050","2615652517","2595088758","1643668705","2494943822","2212133738","2266875225","2336609294","2656752410","2237767532","2660397212","2368271647","481014933","2375195724","2484549594","2318775709","2764336666","2715914965","2709811436","2300634288","2481067225","478216128","2293155433","2744219536","2627236152","1265122512","1702136568","42993082","2247326191","1301220516","2560769328","2318371555","2238694082","1268384779","2493619724","2415131058","1278545173","2377687916","2439350839","2431828394","2441907684","2319124673","2538973626","2400533251","2176078014","2305395314","2322700969","2275028744","2340149479"};
		String[] screen_names = {"ahmeetertugrul","AIIAboutBitcoin","ajasquared","ajbeal","akafimesa","AKCoinMiner","Alain","AlanWalker","AlexCarbou","AlexPanacea_","all4btc","AllanElaine","AllBitCoinPools","AlmaPicks","AlphaPointLive","AltAccept","AltAdviceDaily","Altadviser","altcoinagent","AltcoinArnold","AltcoinChatter","AltCoinGraphs","altcoinhawk","AltCoinInformer","AltcoinInvest1","AltcoinLive","AltcoinMadness","AltcoinMurderer","ALTcoinNavy","AltcoinNewbie","altcoinplayer","AltcoinPriceBot","AltCoin_Profits","AltcoinRambo","AltCoinRush","AltCoinsARMY","AltcoinsInvest","AltcoinsWorld","Altcointees","AltCoinTracker","AltCoinTrader","AltCoinValue","altcoinwow","altcpumps","AltCryptoHunter","althelper","AltNinjaCoin","altrush","AltStamp","AlydianCo","AlyseKilleen","AlysiaSarkisian","AmadeusCrypto","AmagiMetals","anarcoin","ancaprevolution","anders94","AndersH20140609","andymh51","andyphillipson","Angelina1Wood","angelmonkey5","anildaggarwal","AnneCrypto","AnnPettifor","Anonibet","AnsonZeall","Anunakee","apbtc","apple_bitcoin","AppleCoreHost","ArAltcoin","AR_Coin","arcointeam","argakiig","AricoinCurrency","ArielAlns","armory","arsydotorg","arthurbouquet","ArthurTCorry","Ascentcoin","AsiaBitcoin","AsiaCoinPrice","AskCrypto","AskSatoshi","Assembloid","astreegoguen","AtheistCoin","Atlas_ATS","ATMBitcoin","a_tol1kxxx777","atonra7","ausbitbank","ausbitcoins","AussieBitcoiner","AustinGlobalX","Avocyn","AwesomistPump","awrigh01","AWrightIV","axeljoe","axiomfinity","AxisCoin","axlcrypto","ayaLAN","AZ33MKHAN","AZheludeva","b94451130","Balancepumps","BAMM_Coins","BankMyBitcoin","bapao83","Barbatos__","batalles","bbbbbcoin","BCoinSimpletons","BeanDip4All","BeardDroid","beaugiannini","Beaverslayer1","BebopVox","BeCrypto","Beetcoin","beijingbitcoins","BeMining","benjaminmbrown","BenjaminMLopez","benoitboutry","Ben_Pousty","ben_turas","benyoung","bestptctop3","BetaShareX","betbybitcoins","BetByCoin","Beyond_Bitcoin","bibliobit","bidcoind","BidForCoin","BigBallsCrypto","BIGBullion2014","BigcoinMe","BioCoinDev","bioRICE","BitAdCo","Bitailers","BitBakersfield","BitBillion","bitboledo","BitBrazil2014","BitBrew","BitChangeClub","BitCivic","Bitcoin100","Bitcoin101","Bitcoin32","bitcoin42","bitcoin_4_all","bitcoin4sale","bitcoinace","BitcoinAfrica","BitcoinAgency","bitcoinAK","bitcoinandmore","BitcoinArabia","BitcoinAR","BitcoinArt","bitcoinassay","bitcoinassoc","Bitcoin_Austria","BITCOINbalkan","BITCOIN_BANK","BitcoinBarrel","BitcoinBeeper","bitcoinbelgium","bitcoinbill","bitcoin_bolsa","BitcoinBookie","bitcoinbounties","BitcoinBrains","bitcoinBrighton","BitcoinBulls","bitcoincard","BitcoinCat","BitcoinCCA","BitCoinCenter_","BitcoinChain","bitcoinchick","bitcoinclan","bitcoincodes","BitcoinCoffee","bitcoincog","BitcoinColin","bitcoincomes","BitcoinCompany","BitcoinConfRu","bitcoinconnect","bitcoin_corp","BitcoinCorp_","Bitcoin_Crypto","BitcoinDark","BitcoinDayTrade","bitcoin_daytrad","BitcoinDeadsea","bitcoindealer","BitcoinDeals","bitcoin_de","BitcoinDigest","bitcoindir","BitcoinDogecoin","BitcoinDomain","BitcoinDomains","BitcoinDraw","BitcoinDummies","bitcoindunyasi","BitcoinEAST","BitcoinEcho","bitcoineers","bitcoine","BitCoinEmotions","bitcoinerr","bitcoiner_site","Bitcoinerz","bitcoinfaucet","Bitcoin_Faucet","Bitcoin_Feed","bitcoinfeednews","bitcoinffm","bitcoinfirm","Bitcoinflux","bitcoinfly","BitcoinFob","BitcoinForArt","BitcoinForum","BitcoinFRA","bitcoin_fridge","BitCoinFriends","bitcoin_fr","BitcoinFR","bitcoinfunder","BitcoinGalaxyBg","BitcoinGBP","BitcoinGem","Bitcoingenue","bitcoingeoff","BitcoinGet","bitcoinglobalr","BitcoinGodd","BitcoinGoGo","BitcoinGood","bitcoin_gratuit","BitcoinGuru","BitCoinGypsy","BitcoinHK","BitcoinHosting","bitcoinhyiporg","bitcoinica","bitcoinijojo","bitcoin_index","bitcoin_india","bitcoinin","BitcoinInstitut","BitcoinInt","bitcoinist","BitCoin_It","BitcoinJake","bitcoinjedi","bitcoinje","BitcoinJesus","bitcoinjp","bitcoinJPY","bitcoinjs","__BITCOIN","BitcoinKenya","bitcoinkiez","BitcoinLille","bitcoinlistings","bitcoinlotus","Bitcoin_Magic","BitcoinManiacs","BitcoinMaster","bitcoinmegamart","BitcoinMENA","BitcoinMiner1","bitcoinminer","BitcoinMN","BitCoinMoneyBom","BitcoinMstrMind","bitcoinmx","BitcoinMythsExp","bitcoinnewsarab","Bitcoin_News_","BitcoinNe_ws","bitcoinnewsweek","BitcoinNLeu","BitcoinNooz","bitcoinologist","Bitcoinomie","BitcoinOp","Bitcoin_Org_UK","BitcoinPage","BitcoinPaul","BitcoinPeak","BitcoinPiraten","bitcoinplaats","Bitcoin_Police","BitcoinPolska","BitcoinPool","bitcoinportail","BitcoinPortugal","BitcoinPR1","BitcoinPride","BitCoinPro100","bitcoinproducts","BitcoinPsychic","bitcoinpt","BitCoinQA","Bit_Coin_Queen","BitcoinQuestion","BitcoinRoad","BitcoinRoll","Bitcoin_Rumors","BitCoinRunner","Bitcoinsallday","BitcoinSARAH","BitcoinSbS","BitcoinsCard","bitcoinschannel","Bitcoinseeds","BitcoinSE","BitcoinService","bitcoin_sm","bitcoinspot","BitcoinStatue","BitcoinSteve","bitcoinst","bitcoinstuffUK","BitcoinSuite","BitcoinsUK","BitCoinSusan","BitcoinSushi","BitcoinSverige","Bitcoin_Tech1","BitcoinTheCrowd","Bitcoin_thefilm","bitcoin_times","BitcoinTitan","bitcointocard","BitcoinTodaynws","bitcoin_tothemo","BitcoinTour","Bitcoin_Trader","BitcoinTravel","BitcoinTree","Bitcoin_Trends","BitCoinTR","Bitcoin_Truth","BitcoinTurkiye","BitCoinTurk","BitcoinTurtle","bitcoinusername","bitcoinvalue","BitcoinVerband","BitCoinVista","bitcoin_wallet","bitcoinwallet","BitcoinWatch","bitcoinweb","Bitcoinwhore","Bitcoinwikiorg","bitcoinwine","BitcoinWinning","bitcoinXnews","BitcoiNXT","bitcoinyyc","BitcoinZebra","BitConcierge","BitconfusedOrg","BitcoPlay","Bitcorati","Bit_Data","BitDrawLottery","BitEdProject","bit_els","BitexIRL","bitForecasts","bitgearhq","BitGenv4","BitGurl","BitHitsInfo","BitinvestBR","bit_ita","BitJane","BitkoinMama","BitLeu","bitlioncoin","BitLovers","Bitmags","bitme","Bit__Money","BitNewsfeed","bitoasis","Bit_Orca","Bitparency","Bitprint_ca","BitQuickco","Bitrageur","bitraise","BitRichard","Bit_scrow","BitStarsCasino","Bitstickersnet","_Bittox","BitTrading","bittrexcoins","BitTutor","BjorkmanJesper","BlackcoinShibee","BlackGoldCoin","BlakeBitcoin","Blawpaw","blendedbitcoins","blockchainbot","BlockChainTek","BlockZombie","bluedroplet","BlueMeanie4","blueplanetcoin","bnkzh","boazeb","bobbyclee","bodskibod","bombcult","bonafide_io","Bonavest","BondInvestCorp","Bonita_cherries","BoogiedownAnon","Boomsling","boppdavid","botsofbitcoin","BoulderBitcoinT","boyszone_dev007","bpdesign_fr","BQCBaron","br0nevik","BradJOz","BradleyPlus_inc","brainspinky2014","brasildogecoin","brelly1978","brennannovak","BrianFalther","brianprost","BrittanyErstad","brocktice","brotherbitcoin","BrownleeMathew","BruteGeek","BTC4Revolution","BTCAffiliates","BTCandG","BTCBazar","BTCBeautyShop","BTCBestTrading","BTCBlue","Btcboogie","btcbos","btcbuy","BTCcliks","BtcCloud","btccoinwolf","BtcCollege","BTCcommodities","BTCConsultant","BTC_de_Blog","btcdefender","BTC_ebooks","BTCeINSIDER","BTCETrollbox1","btc_feed","BTCFreak","btcgate","BTCGHS","btcharvest","BTChip","BTCinvestigator","Btc_IT_audit","BTCLAG","btcLottery_com","BtcLucky","BTCmacroecon","BTCMarketsNews","btcmine","BTCMinerSupply","BTCMotherFucker","BTCnewsBot","btcoinhardware","BTConomics","BTC_Partners","Btcplace","BtcPong","btcprice","BTCPriceLive","BTCPuertoRico","btc_report","BtcRobinHood","BTCRoulette","btcsec","BtcSmoke","BTC_SocietyDave","BTC_Solutions_","BtcSource","BTCstoreEU","BTCTips1","btctopp","BTCtoUSD","BTCTracker","BTCtradepost","btctrends","BtcTrip","BTCtuz","BTCtweetzer","btcVacations","BTCVideoCasino","Btc_Vs_Gov","btcw1","BTCWorldNews","btcz75","btczin","BumbleExchange","bunnymacey","BurnerCoin","Burzhuinet","buy4crypto","BuyBitcoinByCC","BuyBitcoinPH","buyCoinDomains","BuyDogecoin","BuyGHS","BuySellBitcoin","BuySellBitcoinR","BWmagAFRICA","BWmagRU","BWmagSE","bySamRo","byte_shopper","cafebitcoin","CakeBet","canadaanon_anon","canadacoin147","CancersofCrypto","capaday79","CapitalistCoin","CapnCrypto","Captain_Crypto","CAPTcoin","CarbonCanada","CarboncoinTrade","cardforcoin","Carl_C_Icahn","CarlienRoodink","carpediemcoin","cascrypto","CashIntoCoins","cashwasher","CassavaChicago","cbassthefish","ccnex","CephasSerhat","_CFour_","cgcardona","cgminer1","champbronc2","chancecoin","charpentierarn1","chccoin","Check__it__Out","ChicagoFed","ChickenSesame","ChinBTC","chloregy","CHMinePeer","chocobo56","choctaw7473","chrisbrunner","ChristaMClark","Chromawallet","ChronoKings","chulini","Cioccari_US","cjdcosta","ck9","clarkminor","CleanWaterCoin","ClearingHouseIO","clearwallet","clesaege","CleverTrade","Cloak_coin","cloudhashbtc","ClubAlpaca","CMBSilver","CNBCFastMoney","CNEXEU","coaspinener1984","CodeAPay","Coffee_Coin","coin43com","Coinada","CoinAgenda","CoinApparel","coinarbitrageur","Coinarch","CoinBrainery","Coincamp","CoinCards","CoinCartel","coinchief","CoinClip_cc","Coin_Cool","coin_craze","coin_crazy","CoinCrystal","CoinDarts","coindera","coindextrous","CoinDL","CoinDomains","CoinDork","coinevolve","coinexpo","CoinexPW","coinforumcanada","coinfreaks","CoinFunder","CoinGalVal","Coingrl80","coinhako","CoinHarvest","coinHEATindex","CoinJelly","coinjockey","CoinJoint","COINKINGio","CoinmachineSi","CoinMagi","coinmaker321","CoinMammoth","coinmanual","CoinMap","CoinMarketio","CoinMinePW","CoinMyne","Coin_Ninja"}; 
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
