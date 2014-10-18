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
		String[] ids = {"546382113","2307230179","2251914116","545099162","2412406796","2375407375","2549330797","21308504","873675942","2199528138","2321362874","24602177","2720116212","2384532642","2264204664","2352157759","2246578802","2378261498","1956528072","294552788","2398320246","2268690198","20302047","1419245461","2355712477","2782868852","11957802","2514541536","2216302500","2651713308","213236426","25535926","34055382","330592497","164688517","27383634","160853869","2575425650","546875533","2345982576","2555870456","14005492","65619999","2573583518","31168433","1617846902","140295500","221496969","42515761","2357130775","2435951124","244700064","2159099744","2349169513","73956951","1340639119","2509966249","32425033","474983217","69360421","53089954","60956169","567542345","2259310381","1036508786","2587903573","14620139","2258136452","1056637586","450072786","194657365","244390117","1941220446","591832391","2565981289","2523867962","2571306662","2327234359","2650812589","2305905038","761741244","2275141800","2373819572","2649124466","2585334690","11492932","2334261176","2177071759","2353448474","381207498","587387971","1945063886","2214473941","2328674407","2209272032","2325079344","2222048700","2218386410","2448449612","2489696113","2666862498","2381898038","2430224136","2228054370","2377104967","2252913685","2451053864","2229852678","2238504192","2203291571","2153256288","2352196339","2236717045","2690524664","2240534257","563125343","2322928862","2728382414","2234070631","2438036449","2236178910","2585876432","236065904","68074146","2492095741","15407105","1474553502","165934859","552881588","24801813","226340380","18971151","19844311","14254182","15146117","855444446","58765745","1551509718","2445078722","539844104","1717348572","230527949","2727445014","15503210","2341266895","514923997","1216193492","2289276960","2343554078","2417374764","2538210566","233485015","2333422069","2707086931","2709638712","16738523","267485701","177563611","211648960","2226348194","766296164","20626144","2477516670","1702516213","2530053457","23175488","77353707","495974881","587898186","1734273182","2213180172","2312902531","2302854312","2185876682","2414296374","1853739961","1362854106","2445525588","7441202","2232256129","955524900","627449668","2432329153","42231043","342645141","14054999","2359751150","2256123019","39574300","2491929121","1969405566","381191667","2585565697","2382828494","396045469","2578091251","533143173","618332049","11690462","2221340467","38757299","14518666","30505804","23542618","47346306","2585967517","2573093233","181026511","2216427900","2317027969","101313519","2364782185","396627950","51173758","229089859","34872179","2379355442","2291777390","2318948863","2697382273","2436967585","2291990360","2377233282","1375964778","2594113993","76773950","2431483585","2376411612","2690581038","2293584774","2254554986","896141","182960865","30699048","14165170","1702168231","1176878437","2460750546","1601122278","2265486572","1658625265","1729578210","281895688","592857477","1542077892","1694807629","1320489344","1387578740","2253392420","2651675677","2296472342","1343721079","1464431888","565392262","1147502875","1656276878","2321628201","2222424702","2314789616","2506567069","2183391169","309528352","2281314234","1684292413","2408520852","2358838944","2293267616","1470772549","272343501","1862665472","2320469935","2320684119","2200230558","344728613","1363931383","1620115130","2255064307","2348577824","296954422","2359376016","2247941894","2278222638","2281472096","1268304721","2578504578","2483491644","569423754","228247535","1688798832","1326141062","2359114214","2293384250","148243590","28867412","2721670283","260318791","1376408935","2219424121","2193304890","2745497126","2748860318","2258231305","361769415","2203747308","2222000168","2260912466","317794342","580200257","1357048897","2239761224","2362506584","2236253064","2724205764","2324022344","2556759666","231726008","1268759210","2794582430","1581171644","2271503325","227094643","2378051617","538730516","2282118576","1643500784","434653101","2402434130","1307968542","2207930881","2236538389","2266263206","2208288600","1456862796","2294109367","1378887414","2333408605","1424193091","862865527","2307110064","1359907256","2388011826","2756064867","2330500770","2174821902","319260455","1314532914","2288484104","1588043708","2569499598","1123499653","1779603914","1369059181","268702954","1377328752","2338070737","324030109","2301564007","2409822272","2273488347","217551750","1423870044","1376392219","2259584719","2279440566","1444466221","2279353240","420989725","2752389559","1355460984","2355748657","361289499","2191512781","50993844","1939511798","1342014481","1700563260","2276435240","2209677878","2186806183","2377826948","1368749462","2568886163","1690941254","2229073848","2515622970","2252833814","529705522","1297482212","1648635552","1344636102","1700634031","2798100253","2230071774","1168261224","2614168116","1386585607","708541129","197776953","2220294078","134707175","2155219346","423940083","1350231306","2422808521","2425760006","1400737837","776597306","2289709292","2761436460","1206908791","272707360","2361146024","2317801904","2601084013","623752780","2453688451","2411389507","1243391461","1330225399","314669871","2312652793","1681906322","1691278088","2228663384","237553121","1672449637","296749702","2540720304","2224617715","24769795","2457165914","2177957228","341925873","2291207785","325752059","231729689","851668080","2295175279","2394402734","1267409424","346387098","2273572789","1495851074","2784323828","1138892754","1220646085","220172127","2685652304","48095529","1431204614","2440462257","1548901218","1641165696","2248014252","1327139984","1000155368","2191511023","2222947436","1374457657","2194944286","2597052200","2382847062","2379014838","1427796218","1389006715","2719072650","2197377873","2437294214","2409692293","1364685914","2272498056","1670399954","2419025934","1582321856","2697682010","1601388050","386992544","2433567654","2528229661","1316054317","2616273906","2384162762","886832413","700438687","2310341449","312312760","2445008112","1630577059","2294954370","2587517977","2303086927","753750018","1325353254","776824056","90135167","2269859917","1363677223","1544141916","2493635792","2288951377","365797267","2699265745","2222914789","273746596","1375416505","314762910","2737520396","2456906899","2561125710","1598709350","2304261787","1199152406","915465450","2188471765","2381302812","1658726238","1607510312","1275836588","2300965736","2339878250","1497660594","294376526","2398580893","1576639459","2279449182","1461347160","2670162336","2303710514","2760552737","2349166026","2354667003","1257242263","352518189","2428684346","89494196","1667759496","554251798","1392001614","2242401187","1530689216","2355206780","2493729918","1898706644","1120251200","2175120708","2469883092","2466108456","2444278363","2445629988","2434800834","2402372732","2399043229","2372303670","921688218","312425905","2606129916","2264204071","2518838491","2256561481","370708942","2482518024","2474379908","2644003632","220428765","2363487990","2429587243","125304737","2358580725","2495566675","2302528312","2299278827","2326047914","2684414804","2410801646","2688975696","92503500","6661012","2374354472","2393233027","2314255350","118154050","2462142680","632735641","580376124","20745781","12503922","1516674386","2400795530","2691493129","2762954665","43264740","513467907","468583769","14103421","715351310","246911146","2608615459","636291360","574207605","2283877213","2312887512","2258034260","2719351057","89144105","14379660","28813427","3586271","15365853","22585953","19337489","352982521","26792583","19480057","167401415","2565342164","15050549","13366","1864153224","2572509896","2387227850","2213414816","2258530171","2621349582","2562781854","2199847292","745687860","2467204448","1670339808","2403620577","2451112201","2366354707","9880182","2290197408","2735813746","2251041373","2258403433","2596186036","2299617536","2409218864","2240058816","2721198895","2338229497","1499548657","1534428422","2330646421","2225300413","352245144","2294834533","2206659073","1671239640","2353394140","2400511722","2304146718","707471022","2353813610","1660660554","2236125852","2382846655","1051804416","372364547","381201897","2478575828","376565719","2498306462","824476477","274706827","1423461919","2764597404","2316704490","2647543806","2360600863","297046747","371934393","1859620855","2351042719","2331688646","2409962490","187992149","1850322144","1229736559","2779358226","2586862430","263936619","2278700532","2289196172","1362058093","2317438183","1323280062","291041299","2164822478","2694311868","2257976450","1415406679","2362059150","2467960632","1440661586","1477541142","1078037029","2257211911","2282713568","2261759419","1671301014","2373709957","2490944009","1371209732","1360075472","2181601622","365654638","2311015915","576666003","2182939896","61775603","305854715","1347506222","2173116042","2769537696","79085984","450947924","2284315896","2393106025","2510084300","618709104","2276767032","241209437"};
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
					   
					   do{
						
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
					   }   
					   while ((twitterCursor = FriendsIDs.getNextCursor()) != 0);
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
