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

public class GetFriends6 {

	public static void main(String a[]) throws UnknownHostException, NumberFormatException
	{
		MongoClient mongoClient = new MongoClient( "localhost" );
		DB db = mongoClient.getDB( "bigdata" );
		DBCollection coll = db.getCollection("pr2_coreusers");
		DBCollection friendsList = db.getCollection("friendsList");
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
    	cb.setDebugEnabled(true)
    	  .setOAuthConsumerKey("aZsQEQeFQHWCy0C3BXnLpAYQm")
    	  .setOAuthConsumerSecret("s2A8XOIpyRScFGPVv3AfWDT8HLrn2Bp4cZTdHBttO1X1925xYe")
    	  .setOAuthAccessToken("2302249867-o17bO1uhLhWwvbZkGBHwKkYJpcM1mQXFpjnrkGY")
    	  .setOAuthAccessTokenSecret("yxYp1uyMA4cCGfFQW3Kyg7VCEXhw9ls6Lb7Lq0jooiyV4")
    	  .setJSONStoreEnabled(true);
    	TwitterFactory tf = new TwitterFactory(cb.build());
    	Twitter twitter = tf.getInstance();
		String[] ids = {"2305240296","787844576","562528312","2229216301","2689023841","2782033982","2371416066","553739686","1380668570","2540159659","2451790056","2502488994","2492145560","2360000756","2341065978","824474348","2617674924","2419978476","703887217","2520477696","2586166273","2378920603","2716463415","45262762","2710292634","2481125340","2358408494","2303740286","1702556936","2315396556","2398699393","2486268930","2364531068","2421060391","2557558945","2225665009","2729900496","2755434649","2401711752","2311342813","2461409760","2551078531","2597001463","1634763686","366416875","484246702","2282159640","2369566232","2605946708","2338685696","2216875122","2380223512","2598834794","2251809168","2731552124","2780163768","904394119","2330112218","2231989126","1205438846","2758918686","2263283688","2454529639","2163263144","2460655843","2400793777","2221162260","2382818695","1672537927","1432199401","2540564839","2434518667","2304642186","2446683656","2549066636","2381669698","2259539354","2593793604","125021075","361197966","2342862659","2548610760","2157605768","2254095980","2546813922","2351002838","2537884219","2246284412","2694145825","2278109438","2281158286","2501102947","2176315502","2544219884","2502019158","2671238497","2603875892","2279544342","2445893306","2377259172","381194635","2381582605","2564585275","2318463763","2332064072","2234147078","2481574266","2234577642","2358027398","2687162407","757661912","2319586002","2326472581","2646544086","2236847672","2227627926","2520263178","114088389","167513229","2411231845","2308914133","2504260644","2347718839","19166222","2527850911","2494771262","2563591080","2383910636","2655088121","2520368894","2447626974","2474101494","2377572788","2360993832","2579841626","2375799074","2365546160","2669554807","2213048922","389073053","2786926213","2394748488","2478641340","2530305500","2265661213","443274585","225140617","2593113584","2556813492","2341714579","1368829213","150835348","2358408834","2666722334","2602860650","2331707000","49121910","2495841841","71004808","2303831490","2755711470","2401691773","2538779838","2338608973","2607245824","2468321700","2410766376","2422633369","2450571625","2456883114","2575874887","2486206734","2344506336","2327107322","2562164832","1351515140","2317164289","2242822141","390673456","2467221769","2320101866","2538944449","2504217439","2267175300","2383138038","1521226429","2755527802","2325512516","493768882","2300678989","2308743470","1549169335","1320735764","2458281061","2400131444","2319951979","2352647981","91043173","2460305862","2245992760","2349675902","2391737364","2575018724","2476718914","2446359385","2258022498","2734450361","2183823248","2287518452","2269057424","2301855728","2766116876","2586173112","715282257","118151039","2434685724","1247856660","2342774750","17756947","2235134816","125852521","2367320131","458006746","65438848","2382807384","2344678586","23074277","171122092","14150736","114700046","22239939","235264269","86169677","1973993323","225219595","17022895","2678362098","2382469303","2718436676","2397310722","2780838278","91011913","33833377","23557976","1181054101","2616525776","2610006361","1536493502","2438156940","15367107","502617138","291882711","2472086557","2295180433","209956083","738102121","2388040519","2371902156","2722291440","6385752","2498900858","2277504115","1617272850","2727087523","593216977","2532335257","246441011","1714292588","46035815","2275761822","2375702366","1376581021","2511491366","32404156","2305477867","211257989","148901385","2569872806","135946019","357651617","22943422","178935085","2421329556","2374763724","2812269373","2494036584","2277916130","2326903412","2354248447","2347482602","2240752064","546169950","2248680842","2275117484","2345575831","2322916387","2361157956","2387886324","2253253196","2272268753","2256110856","2244564234","2456889396","2758261987","2340949507","2244789265","2312190788","2265555342","2348518205","2232368590","2264249696","2264279324","2348152278","2485875991","2355150806","2360482283","2320401222","2314784833","2329265280","2439471554","2284265803","2449401740","2615931386","723118812","2343233958","2328091482","2350730300","2457523846","2287494823","2345825287","1591956090","2409298736","2251883880","2449562978","2257214592","2611655840","2671774418","2312628032","2563069464","2158705529","240830872","2189478018","2488540957","338545114","284582937","868421618","1199561838","719813833","111773615","2653311896","116831337","27593440","157693215","2319451238","561548979","2288689717","2468343926","2497925100","2312074182","2413284450","2313146917","2570081293","2314254565","1551561192","15335141","2705923009","418681302","2326112988","2195232076","2663718686","209069532","2472022268","2664286004","376626032","2317867033","7340502","2485236936","2701545344","2469175266","516090819","236715628","90518027","48696300","18458617","116000892","2772428497","2355170412","2294525558","2646365696","49124173","2335845217","2321344057","2313043393","2425985270","2807711293","2393059117","21391703","2476817708","2427018368","2668852699","2388043333","2619653683","317392698","2319402030","606140111","2815973706","2704466074","2554039452","2393630334","2331619315","2483919229","2316097478","20594746","1591974199","406706544","266674920","272602325","2408983159","1445123089","2275657610","2592496957","1959417482","2352826555","12499692","325081167","2772341275","67894942","425507202","17128214","2532978360","2301835002","486330030","1687880563","2459564161","2286199508","2446260258","2551202168","2371912280","283754143","304249649","2517082622","308208103","2725046647","2307226388","2353755313","2265746540","2595862436","2332281331","2354977411","60668652","1405882722","2782463155","284207247","2611162591","995945551","2601980000","2492875280","29738240","15112674","2456644097","2377268899","2778124602","2611189142","2559378241","2266036934","2499500923","1317411182","17346447","2783475318","1478115931","269529341","363480826","2479907448","2420602193","23079960","2414778026","1185137407","2343988034","2482133257","2229490681","2223796068","1729530252","15902212","1360115612","2757766945","1043906124","2429842596","2350454928","2282668082","249077256","253749851","2433009277","317394050","2554351700","2305622750","2498817020","2252185436","189804415","2393107628","31060768","358095135","1132073676","2513814313","2213202848","27863753","17598846","8605462","28122828","15324254","2410014384","2685463855","2697040094","3203211","2573602856","17326968","2438727073","2362842319","270981896","318285684","1321019592","2303815729","1179598783","2485627898","2798635471","2375433463","1393912069","1396211695","2349663512","2457320724","14701529","1613752544","2246046948","2255329768","1709397132","1090509469","2290086613","16868144","397997369","263117643","2573105995","810626845","2388038802","352912537","2716593161","2327748092","2579393959","531119855","21893656","2441637817","2377002870","80892527","2364365516","2360741251","2341980560","2461133137","15220785","537145328","2334139459","2582290665","2231957916","14272379","21328656","630361381","2349011156","2571455400","309042746","2346292292","541279050","359872725","2446280065","2563457888","1961695603","381224685","567007741","147842910","2716696571","2242065145","2350586586","711435846","2200840800","2397207396","2599851434","1001501100","2782560685","2239427683","2399359027","240927915","2430941479","2516963558","2331297668","2340669583","1271057383","147008716","313563037","2600791250","2595393427","2443272380","2481766602","1524164186","294682376","2739414590","2664193465","2551126135","2583464990","13137612","7087642","147628339","224389431","119071459","351707589","7032982","42436982","27710209","14147716","177832134","322023816","2455970953","2411313732","2745279742","2229500025","33682309","2424353342","882839082","535893262","2343015078","86542717","2562246906","203687765","35191251","211662918","15732685","548743983","20195342","2309426400","298840428","116066419","438800656","2338404890","2628708126","305819763","1950640170","23102962","1878001","276134265","163613370","2317476708","15891229","874302758","129392637","35507675","2168002448","17746914","16986724","253299009","33237172","16874657","16849854","16100760","2348872952","112942401","2589163190","1252077991","80649773","111155232","99057454","23345515","1225636459","431752746","411966013","423825777","2294170506","29063989","2723062264"};
		String[] screen_names = {"corgicoin","coryjoelmaynor","cosinescines","Coyaa71","crackheadcrypto","CraigsCoin","Crazy_pumper","CreAtiveCrypto","CreditBitCoin","critick_io","Crobitsorg","CrowdDice","crowd_salt","CrunchHarder","crymarketcap","CRYMarketPlace","crypt0in","Crypt0Ticker","Crypt0Trader","CryptCoinTeam","cryptcointrade","Crypthunter666","crypticious","cryptlocal","crypto1492","crypto2299","crypto4nation","CryptoAce","CryptoAdvisor","_CryptoAnarchy_","CryptoAnony","CryptoAuctions","cryptobang","cryptobased","CryptoBatman","CryptoBayUS","Cryptobeats","CryptoBigbooty","CryptoBillon","cryptobitchicks","CryptoBit_Info","crypto_blog","CryptoBoh","cryptobourse","CryptoBTCFan","CryptoBucket","cryptocanard","cryptocap","CryptoCatCncpts","CryptoCatTrader","Cryptochicken","cryptochris2013","CryptoChrisG","cryptoclone","CryptoCloudHost","Cryptoclouseau","cryptocnews","CryptoCoda","CryptoCoin888","cryptocoinage","CryptoCoinApp","cryptocoinchart","cryptocoindevs","crypto_coiner","cryptocoinstrad","CryptocoinTools","CryptoCoinValue","CryptocoinWorld","CryptoCommunity","CryptoComs","cryptoconnecta","CryptoConsultor","Cryptocrash","cryptocrusader","Cryptocurrency4","CryptocurrencyL","CryptoCurve","CryptoDaimyo","CryptoDaniel","cryptodeath","CryptoDevs","CryptoDiggers","Cryptodoctor","CryptoDoge","CryptoDomainer","CryptoDough","CryptoDuke","CryptoDustin","cryptofactsheet","cryptoFellows","cryptogallactic","Crypto_Games","cryptogeld","CryptoGermanBro","CryptoGiant","CryptoGinge","CryptoGirl92","CryptoGiveaway","cryptoglow","CryptoGnosys","CryptoGuruu","CryptoHoldings","Cryptoholic11","CryptoHyde","cryptoID_info","CryptoIExchange","cryptoinflames","Crypto_Investor","CRYPTOJACK","crypto_jacko","CryptoJan","Crypto_Jay","crypto_jazz","CryptoJohn78","Crypto___","Crypto_Keeper","CrypTokens","CryptokerEnth","CryptoKevin","cryptokiosk","Crypto_Kiwi","CryptoKlingon","CryptoKnights","cryptokraken","CryptoKubrick","CryptoLahey","Cryptolandinfo","CryptoLaunchNet","CryptoLeak","Cryptolebowski","Cryptolix","CryptoLobbyist","CryptoMarketing","crypto_master","CryptoMcFly","CryptoMETH","crypto_mifune","CryptoMinersUK","CryptoMinerX","Cryptomizer","CryptoMofo","CryptoMoms","cryptoMoneda","CryptoMonkam","Cryptomonnaie","CryptoMotion","CryptoMrkt","CryptoMudder","Crypton1te_","cryptonatorcom","cryptonews_biz","cryptonext","CryptoniousMonk","CryptonomyRep","cryptonostradam","cryptoonit","CryptoOTC","CryptoOz","CryptoPartyDFW","CryptoPedro","cryptopenoze","CryptoPharaoh","cryptopinion","CryptoPLGuru","CryptoPrincess","CryptoProTrader","CryptoPumba","CryptoPumpInfo","cryptopumpshark","cryptopumpwhale","CryptoRacer","cryptoredd","Crypto_Reporter","CryptoRiver","CRYPTORULES","cryptory","CryptoSamurai","cryptosbitcoin","CryptoSean","cryptoseo","Cryptoslayer","CryptoSloth","CryptoSpare","cryptoSqueeze","CryptoStar","cryptostart","CryptoStewpid","CryptoStu","CryptoSucks","cryptotechguy","cryptothinktank","cryptothrift","cryptotrade","CryptoTrader86","Crypto_Trading","CryptoTradr","CryptoTree","CryptoTube","CryptoTweaker","CryptoVault","CryptoVend","Cryptovillain","cryptowatchman","CryptoWhaleMan","CryptoWolves","CryptoZakBrayan","CryptRadio","cryptradr","Cryptstarter","CryptsyBump","CryptsyMegaPump","CrytpoCrypto","CSCoinTeam","Curecoingirl","Currency24x7","CurrencyProject","currencysetups","CurrencyTalk14","currensee","currly_com","cvramen","cybersecboardrm","DaBitcoinGuy","dadpages","DahlmanDerek","DailyFreeBits","DailyFX","danajeremy","dangoodin001","DanielJonss","daniel_rafique","dannywettreich","danoprey","danubiasoturi","daralect","darencox","DarkCashCoin","darkcoinnews","darkfoxcoin","darknewsshow","DarkNote_XDN","DaveAchkar","Dave_Aiello","DavidJSong","DavosBTC","ddygii1970","dealinbit","de_bitcoin","decntrlbang","deezthugs","Dehlia81","DeMoiss","DenariusCoin","denfucoin","DenisNecheporen","Denis_Pavel","DesertRShibe","Destinia_BTC","DevasCoin","dieguito","DIEMCOIN","DieterDreherBTC","DigableFab","digifinancegirl","DigiMoneyPromo","DigitalCurrenc","DigitalCurrLA","_digit_","dir4bc","DirectBetEU","discoverbitcoin","distresser","distrocoin","djbooth007","djdogecoin","DjowIsGreat","djshibe","dlfpdkqk","DmTooL","DNyC3215","DocJamesSmith","DoctorMattBrown","Doge4SKPA","Doge4water","DogeAllDay","DogeBetz","Dogeboard","doge_bot","DogeBrewingCo","dogebucket","DogeChain","dogecoinallday","dogecoin_bot","DogecoinFAN","DogecoinForGood","DogecoinGames","DogecoinGer","DogecoinJokes","DogeCoinNews","DogecoinNL","dogecoinpark","dogecoinprice","DogecoinRaiser","DogecoinSexy","DOGECOINSHOP","dogecoins","dogecoin_spain","dogecoinspain","dogecoin_value","Dogecoinvalue","dogecoinwallet","DogecoinWallets","DogecoinWOW","dogecorn","DogeDirectory","dogedonate","dogedoor","DogeDrift","DogeEarth","doge_exchange","dogefaucetcom","DogeFr","DogeMoonman","dogenubtc","dogeoutlet","DogePos","DogePromotions","DogerainApp","dogereward","DOGESHOP","DogeTheDog","DOGEtuz","Dogewallet","Donationcoin","DonkeyKoin","dont_spend_btc","Doom_coin","dopecoindude","DoTAforXBCfans","dozkah","dqms_output","Dr_Bitcoin","dreamcoinDRM","_drouin","DSchlichter","DtjeOver","DTOU_Blog","dudeiligence","Duhaimes_AML","DulorCoin","dumbthumbs","dynomania","eaglemw300","EarnFreeCryptos","EarnTheBitcoin","EarthCoinNews","EarthDollar","EasyMiners1","EatSleepTrade","eatsweetmoney","EBTcoin","eCoinIncome","ecryptocurrency","Ecrypton","edebohls","EdenDice","e_ducat","Educoin_Crypto","efxtradermoney","eheb02033","EitanJan","ElDogeSeeker","EliteCoinDevs","eljuangalt","elqntdotcom","ElwinWitzke","eMarketCoins","Emerald_Crypto","energycoin","Enigmaisland","eNumbered","eobot","EricGrill","EricLarch","EricLStromberg","EricyuanY","eriecoin","esotrader","ESportsCoinTeam","ethanflower","EtherEx_Crypto","eTokenBTC","eTOKGarden","eurobitcoin","eurocex","EuroKoin","euromoney","EuropeCoinERC","EuroShibe","EvaProsvirina","excelVBAmaster","ExchanBter","ExchBitcoins","experiencecoin","expert_btc","expresscoinDOGE","exysaCam","EzraShani1","ezzone00","failcoin","FAILCommunity","FalconGlobalCap","fbrenneis","FeatherCoinNews","FeedZeBirds","FeVoe","ffgarrish","FFreebitcoin","FiatLiberty","fidotip","FirecoinX15","FireFlyCoin","Fitcoins","flashpunk","flexcoin","Flexiblecoin","FlipaCoinBeats","floatfloatboat","flyingmongoose","Football_Coin","forexcoin","ForexMinuteNews","forexrelvo","formosacoin","ForTheDoge","fox__kyu","fractalcoin","FranceDogecoin","frankkane","Frank_leTanque","FreeBitcoin4You","FreeBitcoins","FreeBTC2U","FreeCoinage","FreeMintCoin","FreezeBitcoin","FreshCoin1","FreshPrinceBTC","Friendshipcoin","FRobertsV","frugalingorg","fryptgames","ftarrio","ftecx","fuckiluvbitcoin","FuelTeam1","FujiCoin","fyrstikken","_g3ist","G8Coin","Gaelcoin","gaia_coin","galamova200481","Galaxy_Bit","Gamecoin_GME","gangsta_coins","GarettSchulte","garywheeler","GAWHashlet","GBBGBitbillions","gdassori","GDIJOB","GDN_Frillyozz","genie_currency","gentrysherrill","geobitio","GetBitcoinBlog","getfreecrypto","getgemsorg","_getonthetrain","Getrealbitcoins","Getrealbits","giaglis","giftcardbtc","GirlBitcoin","GldSlvBtc","GlideraInc","globalcryptos","Gnarltusk","gobitcoin","goblynnmusic","GoddessCoin","goldentags","GoldReserveCoin","GOODCoinNews","GoodCryptoNews","GoodShibe","goosenoble","GordonAntDavis","gouda_coin","GPacHQ","Grandma_Bitcoin","GraniteCoin","GreekMiner","GregGeoghegan","gregjarrett","Greg","gregmikeFX","GregMolter","GroinCoin","GROUPCoindev","_gryfx","guaka","GuerillaCoin","Guerin","gzerozerod","H2Ocoin","Hahnbo","halfcab123","HalMBundrick","happydogeshop","HardBTC","hashing_cloud","HashletGenesis","Hashop_io","hashrates","HashRateStore","HashReport","HawaiiAltcoins","HeatherPark","HelloBitcoin","HelpcoinDE","hermis2008","hero18688","HiddenBitcoin","HiDogeCoin","HierMagHetWel","_hightek","hikacoin","hippocryptes","HiresPetr","hiro_coin","hiroshi_02","hizecatDa","hjon0000","HODORCOIN","hodsta","HostFat","HotcoinTeam","HotCoinTk","Hot_Kitchen","HourlyBitcoin","hourlybtcvalue","HucGames","HuskyCoinHC","hxn","i3ambiiman","IAMAHAL9000","iamaltcoin","I_am_SerFraust","Ian_Sun","IBDinvestors","icbit_se","Icebear06_","Icebergcoin","i_cress","IDCoin","ideahq","idsey","IFCFoundation","iFlappyCoin","igobono","iGoForCrypto","iGotcom","iheartubuntu","ihijoxeq","iMoCuCorp","ImpCoin","impolitecoin","indobtc","InessBTC","InfiniteCrypto7","infobitcoin","Inscyw","insidebtc","instantri_ch","INT_DebtCollect","InvestEsoteric","InvolutionDC","ipoMiner","IrishCoin","Ironhammer5","isamusaldana","iseebitcoins","isiscoinisis","isiscoin","Isracoin_Media","italiantrader","Italicizer","Itsjoeco","I_Want_MCC","izojj63","jackpotcoiner","JackPumpp","jackwang","jakamele","Jake_Shake","Jakob_Z","JamesGMorgan","JamesKeyfur","jamie247","JanMiranda","Jared_Reptar","jaromil","jasoncarleski","jasonDeCosta1","JayDotbit","JazzTorrance","JBcrypto","JCPaik","jeffjaygo","JeffreyRFike","jellytuck13","JengoOnCrypto","JennaDogecoin","JennaHannon","JessyCoin","jewjitsu101","jfgallas","jhaand","jja0","jk1087","jkozan","jlbitcoin","JLpers","jmcorgan","jmschechter","Jobs4Dogecoins","jobsforbitcoin","Jodlar91","joebitcoinorg","JoelKruger","joelmoney","JoeMathews27","joeroxor","johannesacu","JohBa","johnhann74","John_Kenney","johnmcd3","JohnVictorino_","jolingkent","jonathansolomon","JonathanVaage","jordanbaucke","jordankelley","jorilallo","jprichardson","j_tk12","jtotoole","JudgeCoin","juliaapatterson","julien_trottier","JunoWallet","Jvowens","Jwomers","jypark04070","kaankant","KarileeD","KarlChappe","katarzyna_sw","KatObermeyer","kavalerige"}; 
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
