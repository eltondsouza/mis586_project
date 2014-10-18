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

public class GetFriends2 {

	public static void main(String a[]) throws UnknownHostException, NumberFormatException
	{
		MongoClient mongoClient = new MongoClient( "localhost" );
		DB db = mongoClient.getDB( "bigdata" );
		DBCollection coll = db.getCollection("pr2_coreusers");
		DBCollection friendsList = db.getCollection("friendsList");
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
    	cb.setDebugEnabled(true)
    	  .setOAuthConsumerKey("vMytLV6bzG4otGS07Jw4G5QzM")
    	  .setOAuthConsumerSecret("p5JFK69yjllevlo1Swp6SwFkjieRSjEQruzYJcV7k84wrl5eOs")
    	  .setOAuthAccessToken("2502815221-a1nA1rJFCY50AqUIWtPYeRGBKqC7RYXwrB2M8pV")
    	  .setOAuthAccessTokenSecret("gAtrqkZagEf3kvmZgx3EpLJVXIiu58hbaYFUUv1b45eM7")
    	  .setJSONStoreEnabled(true);
    	TwitterFactory tf = new TwitterFactory(cb.build());
    	Twitter twitter = tf.getInstance();
		String[] ids = {"584199171","240827371","2590141398","77925062","2517255841","327577694","501976813","2424695659","22961942","2241505099","2614614258","1616644764","544979369","19902826","24725800","2252657876","2617660668","2715319927","1863504378","2378128652","20064603","2393258556","315764180","2441803513","2440991282","259000450","17718814","16100489","831963385","1920515281","2226037886","2593810105","2393154212","6438","6550222","96239664","22682896","42731691","2577220537","16141991","2672943956","1075531380","18154412","1518938623","6658762","2236753543","48947925","23137860","7782442","2706627234","2456443002","2463940681","347678763","2151686839","20356625","13285182","74110152","2294267941","19441810","2509222064","421975095","14149992","389281846","2674510040","2423761008","1341469944","1267233378","1118373612","15065375","1365655548","16184358","2238288025","555215636","193093810","359642639","2692865550","2697502717","1172707032","1458005406","2438427380","2198390371","2690250380","2332481491","2319408132","2398407836","2367504330","1703240870","2332842072","2342495588","574032254","2212051490","386263972","2361179618","1466726246","2452127865","2701451581","2420855804","2647219033","2399915394","2582914267","2601630428","2545504358","2480497886","2561073732","1481722987","2327942047","2535347246","1978406809","1333467482","2313379038","1512005262","2302030848","2419521381","1430981724","1902922477","1105795165","2398658898","2235622382","2290807038","2330483317","2399433313","2559894493","1416282756","1527017959","1537887786","1599380390","2501820794","2548777740","1129728541","2338865839","2307770395","2319848474","2206108249","2348087750","2306171096","2277074592","981273865","1426204208","365761759","2178180668","2272294980","2260491445","2474586013","1406917494","1423233990","2201421109","2219770692","2232163009","1710927229","1963976948","2234450148","1674504678","2490414211","2345145002","2737686289","757821493","2395977493","2228542561","2338087238","2254504825","2211429601","2226509130","262683177","1610664336","1700879791","2486772820","1196956998","2296009579","1379386514","1484651623","2262331846","287350085","2401331364","2352838376","1631252028","2335273189","2576099707","2619999080","2624999660","2279768305","2235218431","1949161208","2273391840","2352274284","2462527430","1685625979","1865180844","2521932686","2207129125","1422566208","2300506278","2596731175","1493592943","569953061","2296383162","2368681057","2413162011","2310986355","1670923477","2495642714","1416245712","2319029696","2760706404","2263738520","1421275063","2269664563","2332076899","386600115","14456539","15378138","2379624572","2480235020","2262634886","2443864880","2332462670","1458574586","2413444550","38129556","2544777312","19805098","2310847538","2174732077","2467204447","2336321130","6798592","141395357","2375529043","196601199","2298769327","1682967854","2607948882","2293045254","976034137","2368341397","1596402054","2318072534","2322846201","2395733234","2405896598","2399059885","44279796","2199095514","2396896344","2187436049","2346806455","1393865996","2790030462","2350970786","2469446510","2542617157","2329290331","2368961174","2282988859","2301641876","2310472259","2615551112","2494237843","2602700654","2226561180","2287149931","2677442358","1860483781","2451225236","2596272643","24852276","2728618266","2464641332","2452745850","2312455356","393722501","1852357741","1099796888","2411936816","2425518595","1422335670","1677650622","2502358383","2552436770","303823825","2459956231","2342902970","1528177268","2308370653","2346044533","2347368960","1394496090","2304183664","2338731320","2182962445","2358311520","2596226534","1430468916","2301895027","2462393748","1660359212","2288293826","2460115938","2228935254","2416023134","2367376711","1862215608","1856523530","1414582549","2308093620","1627275259","2605131546","2395503710","1429437746","2422531939","2373921949","2363194152","381212639","1462323200","28234503","2466485911","2337379322","2302163059","2360306029","2435734063","191767033","2301367044","2409803270","2232729908","2293341602","2317594316","2238979286","1958433596","19073422","2245179020","2328769301","2741323054","1329988598","1361039118","2319362556","1450143883","1677615949","2367271502","2455855003","1521011041","1356174493","2226200089","2290144747","2335266072","2537237557","2488283222","2246334331","2591054760","2304513398","1629218946","2308589126","2389253808","2520888308","2379591920","2498938130","2214630456","2489451596","2542000201","416650125","92592782","1898583763","2453589074","2422713289","769535858","2379091686","2409137940","524992411","138523137","2484704827","2294431609","2275544384","2333024468","2561531706","2276940194","2705075796","467544214","2616874256","2357587387","2305782554","2492324845","2409402703","2247145022","2486687870","2400496460","2602903938","2219901158","2340848875","2417687492","2446024556","2263229827","116966175","2428965361","2308409648","609468038","2367670062","1329957756","2316993811","2297292997","2275013662","2242465158","1657943804","2435420810","2248449816","1444241532","2575015087","2200147865","1600370540","2573387736","2312625338","1652307524","2781030986","387861733","2463142351","773773628","2433432126","1522357730","2721998404","632363961","2763589483","232194286","2433370358","2444609490","2228738394","2219192521","2287447208","2356688198","1424086592","2612600022","2330528036","220646136","2407504556","2556755965","2446824480","2331304999","2243073415","165633902","2809242392","2342324238","2231431141","2456191308","2319408763","2473926210","2302212254","2291935088","2228501803","2153022625","2420801809","2344255323","2212061141","239822603","485882339","2548598234","2414545644","2450815056","2784462954","2321345647","2596681850","2598336504","2384222786","558018978","221071894","1866298082","1593801920","2262964464","1551747199","2576242316","2278088154","2460897080","2433337028","2733006991","2595835519","18068353","2384155158","2692625562","2279701020","2461030028","2329560908","1377089258","1963300418","2238091633","2411568205","2572006086","2476650397","1489350230","2336803157","2704170858","2423135832","2235107900","2310297636","2258355798","2468508330","21693060","2760644162","436080611","260316814","243088415","2319314552","536167980","30477563","47968683","2387164681","256088045","707119819","144386924","2451986930","2246018504","2298296796","2475742609","2461754790","2402070984","15264964","4339041","16309899","7920922","27452535","20635008","16524343","385162204","19586905","975787016","2634274458","15029927","14098669","2321350494","2338506822","26499336","2407161257","2220138374","260923971","548531623","1353278066","2731006566","411539821","614261017","26768561","179980928","31701010","49028284","2544862219","1464679609","2265071515","1625791447","181591420","75974998","310425936","2592741468","2170217153","2395367155","343356359","23656945","220974701","187978594","961098271","2583258872","372589495","2324397774","186472450","251254199","2463812988","20681763","2337997597","2683571196","2396607745","376195685","2266631022","2290681818","46587787","28090367","2324092309","583959346","1310721","818306821","2178242827","731196890","299867631","37390040","2365132326","1375719751","17186834","1729492500","2326070900","130876609","2204153172","2432882095","87194694","205801132","257023889","1584350917","431007776","2366942234","2484721741","2294202321","2364829015","2792502001","2310066967","2235729541","2269078292","2353822842","2386403768","2345210598","2798532566","2221010713","5663192","2292972858","2182945104","851708503","2743141165","61989169","35125949","2477083290","80131438","264405254","19643545","1114255788","438829074","209126114","19387126","1489581","1662202914","119926952","18633731","9615352","16207302","213185539","7091112","720092996","2325928813","2472238814","1890607178","1701308766","30624405","38907891","83466368","2376985614","2445508370","246616450","2348244595","16420229","86830328","162323929","1877857849","113386943","1155585566","226974029","109545789","713319740","2366835468","19000224","399412477","248362449","331850858","472783940","62269239","2541927152","1916826175","2759538227","134891802","1344645140","2416428684","2450478554","11166282","2417856962","2414594850","2377115558","961088954","249278452","2498748548","2671246585","97435591","2376024072","361554867","2254927386","2263656044","2723104925","52082542","206583584","1896567750","1909197750","56789605","1609928042","31460217","1328350513","2665388569","2400055351","2645516504","34372258","392225137","2456453575","2414061198","2664945139","2351040798","2396394860","22385904","1702682312","2723318012","2596232539","222471144","497995255","469730102","2191536853","106985950","265991923","2564623844","1728854642","316983139","392384741","2155750167","2510260668","494067493","475630454","1457614386","2356107468","315991624","84606546","196139605","599049977","45401607","1686003068","1373856847","2719244960","2235753703","236663818","1702178599","220971012","135980373","297897603"};
		String[] screen_names = {"cal_abel","CaliCrypto","CalleBitcoin","callum_wilson","CalmNinja","CampBX","canadianbitcoin","CannabisCoins","Capitalist4life","CaptainScio","CaraluzzoCarlo","CARMAnation","carmeldanib","CarterD","casacup","CasaDeCambioBTC","Casheer2","CasheerApp","CashhMachine","CashPumps","CashQuestions","Cataloniacoin","CAVIRTEX","CCFRussia","CCNProject","cecilebaird","cedquist","CElston","Cercamia","cex_io","cha_andrews","ChadCrypto","ChainRadio","charley","charlie","charliekiser","CharlieShrem","chartouche","chatcoins","chdolar","Checkcoincc","cheftnb","cherapple","ChickenCoin","chijs","ChinaFairPump","chnchapters","chrislarsensf","christinelu","chrysophylax69","CinniCoin","CinniTeam","CipherLaw","circlebits","cisary","ciscoguru","CitywireMoney","CivicCentreMan","clareefrancis","claritycurrency","clark_alastair","clarkmoody","ClayTheBearded","CleanCoinDev","Clipono","Cloudbet","cloudhashing","Clvnthbld","cmgustavo83","cmshindi","CNNMoney","coaex","codinginmysleep","COdomainnames","Coinabul","CoinAcademy","coinadopt","CoinAid","Coinality","CoinAlliance","coinalytics","coinanalizer","Coinano","coin_artist","CoinATMRadar","CoinAurora","CoinAxis","CoinBaron","CoinbaseAPI","coinbase","CoinBeyond","coinbits","CoinBlack","Coinboard","Coinboy2","CoinbredCom","CoinBrief","coinbux","CoinCadence","CoinCap_io","coincenter","CoinCloak","CoinCongress","CoinCorner","CoinCrunch","coincrypt_","coinculture","CoinDeskBPI","coindesk","CoinDigest","CoinDominion","CoinDotCo","_coined_","CoinedUp","CoinEnablers","coineron","CoinexGateway","CoinFeedApp","coinffeine","CoinFinance_Com","coinfinityco","CoinFireBlog","Coinfloor","CoinForest","coinfreedom","CoinFXcom","coingambling","CoinGateway","coingig","CoinGorilla","CoinHydrant","Coinigy","coiniqs","_coinist","CoinJabber","coinjoin","coin","Coinkite","coinlab","CoinMarketing","CoinMeInfo","CoinMKTCap","CoinMktExchange","coinmkt","CoinMover","CoinNEO","coinnext","coinok","coinomat","Coinometrics","Coinosphere","CoinPaymentsNET","CoinPocket","Coinprism","Coin_Promotion","Coin_Prophet","coinproz","coinpumpd","coinpunkapp","CoinPursuit","coinregime","CoinRegulations","CoinReport","CoinRevolution","coinrobot","CoinRocket","coinscrum","Coinsecure","Coin_Seeker","coins_e","coinsepa","coinsetter","CoinsForLaptops","CoinsiderNews","CoinsiderThis","CoinSimple","CoinsisCard","CoinsKingdom","CoinSlumIt","CoinSourceUS","CoinsSource","coinstackr","coinstester","Coinstructor","CoinStrype","COINSULT","coinsummit","CoinSuper","CoinTelegraph","cointerra","Cointopay","cointradefloor","CointraderX","coinurl","CoinUSDE","CoinVaultATM","CoinViking","CoinViral","Coinvoice","CoinVox","CoinWarz","coinwave","coinwizard","coinwrite","coinxinc","CoinyeCoin","CoinzStats","ColeColdwater","ColinTulloch","colkito","CollegeCrypto","ColonelCrypto","COMKORTcom","Community_Coin","CommunityWhaleX","compra_bitcoin","compucoin","conniegallippi","Conspiracy_Coin","coolbearcjs","CopyCoinRev","corkket","cornerstonecoin","countmycrypto","cowboy","Cpzhao","crabcoins","crainbf","CreevesBTC","CriptoInfo","CriptoPay","CRN_Coin","Croboy19","CrossCoin","CrowdCurity","CrowdWhale","crunchpool","CrypCoinsultant","Crypt0d00d","Crypt0genesis","Crypt0Mom","crypt0queen","CryptAxe","cryptc78","CryptexCard","cryptfolio","CryptGeek","Cryptiv","CryptKeeperBTT","crypto0wl","CryptoAdvice","cryptoadviser","Crypto_Advisor","cryptoALTeX","cryptoaltinvest","CryptoAnalytic","crypto_angel","CryptoAnnounce","CryptoArman","CryptoArticles","CryptoAsura","Cryptoauction","CryptoBarbarian","CryptoBattles","CryptoBetting","cryptobillboard","cryptobitnews","cryptobizmag","CryptoBrah","CryptoBrett","CryptoBruce","CryptoBuarque","crypto_bull","CryptoBurgundy","Cryptocables","CryptoCamel","CryptoCanary","CryptoCashFlo","cryptocatapp","CryptoCayce","CryptoCc","CryptoChangecom","CryptoCharts","Cryptock","CryptoCoin2","Cryptocoinbiz","CryptoCoinBoss","CryptoCoinCal","cryptocoinchat","CryptoCoinDaily","CryptoCoinEra","CryptoCoiners","CryptoCoinFreak","CryptoCoinPromo","CryptoCoinPumpR","CryptoCoinRank","CryptoCoinRevo","cryptocoinr","CryptoCoinRush","CryptoCoinsBlog","Crypto_Coins","CryptoCoinsNews","cryptocointalk","cryptocointoday","CryptoCoinUser","CryptoColbert","Cryptocon","CryptoConnectz","CryptoCorleone","CryptoCorp","cryptocounselor","CryptoCountess","CryptoCourtney","cryptocoutts","crypto_creative","CryptoCrimson","CryptoCrowley","cryptocruise","CryptoCryptics","CryptoCryptoCry","CryptoCurrEncyX","CRYPTO_CURRENT","cryptocw","CryptoCzar","CryptoDabbler","CryptoDaRock","CryptoDealer","crypto_design","CryptoDirect","Cryptodoctor42","CryptoDreams","cryptoeconomist","CryptoEthan","CryptoEvents","cryptoexpo","CryptoFact","CryptoFactor","CryptoFlips","cryptoflood","cryptofolio","CryptoForex","CryptoForexTeam","CryptoFrenzy","CryptoFungus","cryptogalaxies","Cryptogeeks","CryptoGekko","CryptoGeneral","CryptogenicBull","cryptoGIR","CryptoGod247","Crypto_God","cryptogo","CryptoGotti","cryptoguru","CryptoHamm3r","CryptoHomePage","CryptoHungry","CryptoIcahn","CryptoInd","CryptoInstitute","cryptoinvester","CryptoInvest","cryptoinvestor1","cryptoinvestort","Cryptoioda","CryptoIsSexy","CryptoJauregui","cryptojay","cryptojesus","CryptoJeweler","CryptoJoin","cryptokeepa","cryptokiely","cryptoKorba","cryptokrill","cryptolachat","cryptolaunch","CryptoLiberty","Cryptolina","CryptoLovers","CryptoLuminati","CryptoMadoff","cryptoman33","Cryptomaniacs","CryptoMarkets_","Cryptomatic_ES","Cryptomayne","Cryptomayn","Cryptomeorg","cryptomerchants","cryptomessenger","CryptoMidas","CryptoMinepit","cryptominer_net","Cryptomist","CryptoMiyagi","CryptoMobiles","cryptomojo","CryptoMommy","cryptomonet","CryptoMoneyXchg","CryptoNews_","CryptoNewsPump","cryptonic27","CryptonInvest","Crypto_nita","Crypto_Nite","cryptonit_net","CryptonomicsTV","cryptonomist","CryptoP2Pool","cryptoparty","Cryptopathic","cryptopay","cryptoPI","CryptoPioneer","CryptoPlainview","Cryptopoly","cryptoporn","CryptOprah","CryptoPros","cryptopumper","CryptoPumpGroup","CryptoPumpUp","CryptoPusher","cryptoquestion","CryptoRafiki","CryptoRally","CryptoRemmah","cryptorewards","Crypto_Robin","CryptoRogue","CryptorTrust","cryptorune","CryptoRusty","CryptoSandwich","CryptoSaw","CryptoScalper","Cryptoshine","cryptoshoppers","CryptoShortNews","CryptoSlut","CryptoSnoop","CryptoSpain","CryptoSpy","cryptostartupsh","CryptoSterling","cryptostick","CryptoStoner","cryptos_trader","CryptoSuge","CryptoTader","CryptoTattoo","Crypto_Tech","CryptoTherapist","cryptoticks","CryptoTimes","Crypto_Tips","cryptotipz","CryptoToYachts","Crypto_Trade","CryptoTradeKid","crypto_trader","CryptoTrap","cryptotraveler","CryptoTrollBox","CryptoTwitt","cryptotycoons","cryptoupdate","cryptovagabond","CryptoWars","CryptoWave","cryptoweather","cryptoweekly","cryptowho","Cryptowhore","crypto_wizard","cryptowomen","CryptoWyS","CryptoZap","crypto_zen","cryptrader","cryptrch","CryptScout","cryptsyisdead","CryptsyKen","cryptsypumper","cryptsypumps","CrytpoWolf","cschweitz","CT__Brotherhood","CTurlica","currency_cloud","currencyhacker","cuttlefish_btc","cyaadz","cyim","_cypherpunks_","D2_Santu","DaBrowne","DadiCharles","Dahabshil","dailyblackcoin","DailyDogeCoin","DailyDogeNews","dailyfreebtc","DailyPumpGroup","DanDarkPill","DanGodwinYo","danielilett","danielmcclure","DanielMorgan","danielpbarron","Danilovich","DannyBoc","dan_pantera","DanPlant","DanRyanSkinner","DanSpuller","darakaye2","daranda","DarbyOGill_","DarkcoinOrg","darkip","DarktrixCryptos","Datacoininfo","DataTranslator","Datavetaren","DatCryptoRally","davaron691","DavidBudworth1","davidscalais","DavidSilvaSmith","davidwolman","davidzmorris","dayreiner","DCCCertified","dcmagnates","DCW_one","dealcoin","DeArmasGroup","_deepaktiwari","deepbit_net","Deepcoin","deepwebmovie","defunctec","delfresnic","delitzer","delta_DNA","Dennahz","deonopperman6","DerekReith","DesignerCrypto","DgexExchange","dholmesf5","DHQNgo","DiamondDoge","dianacbiggs","diariobitcoines","DiceDaysCom","dicelitecoin","dienhobitha","DigiByteCoin","DigibyteNews","DigiLibertarian","digitaltonic","DIME_Foundation","DineroNuevo","dionyziz","DirectPayNet","Disruptepreneur","Diy_Maria","djilesy","djkinkle","djmc222","DJNorbz","djspang","DJThistle01","dknotboy","dmdcoin","DNSChain","Dobbscoin","docBTC","DocHex","docmikekeen","DoctorBitcoin","DO_EAT","Dog3Report","dogecoin4all_ly","dogecoin4ever","DogecoinBerlin","DogecoinDark","DogecoinDigest","dogecoin","DogeIsDead","dogeonomics","DogesGoneWild","dogestylz","DollarBitsCoin","dollero_","dominic_w","doradalechuga","douevenbitcoin","d_plusk","DrCoinMD","drei4u","drewbreyer","drewmikb","DrLaserfalcon","Dr_Revelator","Druminfected","drustanuss","d_seaman","DSLRVideoGuy","DugCampbell","duivestein","DunningKruger_","duomark","dusktrader","dwr","dynomighty","E8808","eagle8","ealfskillz","earnbitcoinhere","EarningBitcoin","EatCoin","EAVGR","ebepark","ecalouro","ecb","eccoin","ECFExchange","ecogex","ecoinfund","Edbowsher","EdgarAllenPurr","edmac78","EdmundCMoy","edthisismoney","effectsToCause","efolch","EFPLP","e_frankl","einsteiniumcoin","ejacobhansen","el33th4xor","elainedtaylor","elBitcoin","elbitcoinlatino","electricwings","electroncoin","ElectrumWallet","EliciaWesson","ellie_ancap","elliptic","Elmer__FUD","elthaas","ematiu","EMC2Foundation","EMC2Whale","EmeraldCrypto","emivelazquez6","Emma_SBP_money","EMPHATIK247","_emschwartz","enej_p","epawncoin","epaymentsnut","epicenterbtc","equalpumps","ereorsakw","EricSchreyer","ernest_blogger","e_rossiello","esenciabitcoin","eServiZes","ESimplybusiness","estebs","EsthiemDota","Ethancoin","EtherCasts","EtherCoins","etimarcus","etploshay","eulersidentity1","Europex_","eUtopium","EvanAlanEvans","EveryThBitcoin","ewpaisley","ExchangeBitcoi1","exchangebtcinfo","ExclusivePump","exiledsurfer","exillon1","ExithO_o","expresscoin","fabfederici","Fabio_Labra","FairLaunch","FairProof","fairpumps","FakeEStott","fancyabit","fantomcoin","FatFingeredFred","FATFNews","Feathercoin","FeedYourMiner","FEhrsam","fernand0x","fernandoulrich","f_forough","FGMR","FiatMoneyEnd","FibonacciNews","fibrecoin","financialbtc","FineArtGiclee","FinEdTv","fionason","firstecache","fizzyphillips"}; 
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
