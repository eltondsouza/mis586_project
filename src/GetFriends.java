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

public class GetFriends {

	public static void main(String a[]) throws UnknownHostException, NumberFormatException
	{
		MongoClient mongoClient = new MongoClient( "localhost" );
		DB db = mongoClient.getDB( "bigdata" );
		DBCollection coll = db.getCollection("pr2_coreusers");
		DBCollection friendsList = db.getCollection("friendsList");
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
    	cb.setDebugEnabled(true)
    	  .setOAuthConsumerKey("5at9oIC6aqWOGYE635Cw8dX8z")
    	  .setOAuthConsumerSecret("ACvypDRJWO5Ni2HDQxYvm9Z4uSD3MZhxVou92gFJvLg1MOO2wG")
    	  .setOAuthAccessToken("39952747-IcSqsSoPphTWaLoIwYaUITWQ5PmeyV40bQHgkTf4C")
    	  .setOAuthAccessTokenSecret("Nn4NEH9XE9xIb6QXu3R8kOdocncplz67Cq8RZlrOZlyOu")
    	  .setJSONStoreEnabled(true);
    	TwitterFactory tf = new TwitterFactory(cb.build());
    	Twitter twitter = tf.getInstance();
		String[] ids = {"546382113","2307230179","2251914116","545099162","2412406796","2375407375","2549330797","21308504","873675942","2199528138","2321362874","24602177","2720116212","2384532642","2264204664","2352157759","2246578802","2378261498","1956528072","294552788","2398320246","2268690198","20302047","1419245461","2355712477","2782868852","11957802","2514541536","2216302500","2651713308","213236426","25535926","34055382","330592497","164688517","27383634","160853869","2575425650","546875533","2345982576","2555870456","14005492","65619999","2573583518","31168433","1617846902","140295500","221496969","42515761","2357130775","2435951124","244700064","2159099744","2349169513","73956951","1340639119","2509966249","32425033","474983217","69360421","53089954","60956169","567542345","2259310381","1036508786","2587903573","14620139","2258136452","1056637586","450072786","194657365","244390117","1941220446","591832391","2565981289","2523867962","2571306662","2327234359","2650812589","2305905038","761741244","2275141800","2373819572","2649124466","2585334690","11492932","2334261176","2177071759","2353448474","381207498","587387971","1945063886","2214473941","2328674407","2209272032","2325079344","2222048700","2218386410","2448449612","2489696113","2666862498","2381898038","2430224136","2228054370","2377104967","2252913685","2451053864","2229852678","2238504192","2203291571","2153256288","2352196339","2236717045","2690524664","2240534257","563125343","2322928862","2728382414","2234070631","2438036449","2236178910","2585876432","236065904","68074146","2492095741","15407105","1474553502","165934859","552881588","24801813","226340380","18971151","19844311","14254182","15146117","855444446","58765745","1551509718","2445078722","539844104","1717348572","230527949","2727445014","15503210","2341266895","514923997","1216193492","2289276960","2343554078","2417374764","2538210566","233485015","2333422069","2707086931","2709638712","16738523","267485701","177563611","211648960","2226348194","766296164","20626144","2477516670","1702516213","2530053457","23175488","77353707","495974881","587898186","1734273182","2213180172","2312902531","2302854312","2185876682","2414296374","1853739961","1362854106","2445525588","7441202","2232256129","955524900","627449668","2432329153","42231043","342645141","14054999","2359751150","2256123019","39574300","2491929121","1969405566","381191667","2585565697","2382828494","396045469","2578091251","533143173","618332049","11690462","2221340467","38757299","14518666","30505804","23542618","47346306","2585967517","2573093233","181026511","2216427900","2317027969","101313519","2364782185","396627950","51173758","229089859","34872179","2379355442","2291777390","2318948863","2697382273","2436967585","2291990360","2377233282","1375964778","2594113993","76773950","2431483585","2376411612","2690581038","2293584774","2254554986","896141","182960865","30699048","14165170","1702168231","1176878437","2460750546","1601122278","2265486572","1658625265","1729578210","281895688","592857477","1542077892","1694807629","1320489344","1387578740","2253392420","2651675677","2296472342","1343721079","1464431888","565392262","1147502875","1656276878","2321628201","2222424702","2314789616","2506567069","2183391169","309528352","2281314234","1684292413","2408520852","2358838944","2293267616","1470772549","272343501","1862665472","2320469935","2320684119","2200230558","344728613","1363931383","1620115130","2255064307","2348577824","296954422","2359376016","2247941894","2278222638","2281472096","1268304721","2578504578","2483491644","569423754","228247535","1688798832","1326141062","2359114214","2293384250","148243590","28867412","2721670283","260318791","1376408935","2219424121","2193304890","2745497126","2748860318","2258231305","361769415","2203747308","2222000168","2260912466","317794342","580200257","1357048897","2239761224","2362506584","2236253064","2724205764","2324022344","2556759666","231726008","1268759210","2794582430","1581171644","2271503325","227094643","2378051617","538730516","2282118576","1643500784","434653101","2402434130","1307968542","2207930881","2236538389","2266263206","2208288600","1456862796","2294109367","1378887414","2333408605","1424193091","862865527","2307110064","1359907256","2388011826","2756064867","2330500770","2174821902","319260455","1314532914","2288484104","1588043708","2569499598","1123499653","1779603914","1369059181","268702954","1377328752","2338070737","324030109","2301564007","2409822272","2273488347","217551750","1423870044","1376392219","2259584719","2279440566","1444466221","2279353240","420989725","2752389559","1355460984","2355748657","361289499","2191512781","50993844","1939511798","1342014481","1700563260","2276435240","2209677878","2186806183","2377826948","1368749462","2568886163","1690941254","2229073848","2515622970","2252833814","529705522","1297482212","1648635552","1344636102","1700634031","2798100253","2230071774","1168261224","2614168116","1386585607","708541129","197776953","2220294078","134707175","2155219346","423940083","1350231306","2422808521","2425760006","1400737837","776597306","2289709292","2761436460","1206908791","272707360","2361146024","2317801904","2601084013","623752780","2453688451","2411389507","1243391461","1330225399","314669871","2312652793","1681906322","1691278088","2228663384","237553121","1672449637","296749702","2540720304","2224617715","24769795","2457165914","2177957228","341925873","2291207785","325752059","231729689","851668080","2295175279","2394402734","1267409424","346387098","2273572789","1495851074","2784323828","1138892754","1220646085","220172127","2685652304","48095529","1431204614","2440462257","1548901218","1641165696","2248014252","1327139984","1000155368","2191511023","2222947436","1374457657","2194944286","2597052200","2382847062","2379014838","1427796218","1389006715","2719072650","2197377873","2437294214","2409692293","1364685914","2272498056","1670399954","2419025934","1582321856","2697682010","1601388050","386992544","2433567654","2528229661","1316054317","2616273906","2384162762","886832413","700438687","2310341449","312312760","2445008112","1630577059","2294954370","2587517977","2303086927","753750018","1325353254","776824056","90135167","2269859917","1363677223","1544141916","2493635792","2288951377","365797267","2699265745","2222914789","273746596","1375416505","314762910","2737520396","2456906899","2561125710","1598709350","2304261787","1199152406","915465450","2188471765","2381302812","1658726238","1607510312","1275836588","2300965736","2339878250","1497660594","294376526","2398580893","1576639459","2279449182","1461347160","2670162336","2303710514","2760552737","2349166026","2354667003","1257242263","352518189","2428684346","89494196","1667759496","554251798","1392001614","2242401187","1530689216","2355206780","2493729918","1898706644","1120251200","2175120708","2469883092","2466108456","2444278363","2445629988","2434800834","2402372732","2399043229","2372303670","921688218","312425905","2606129916","2264204071","2518838491","2256561481","370708942","2482518024","2474379908","2644003632","220428765","2363487990","2429587243","125304737","2358580725","2495566675","2302528312","2299278827","2326047914","2684414804","2410801646","2688975696","92503500","6661012","2374354472","2393233027","2314255350","118154050","2462142680","632735641","580376124","20745781","12503922","1516674386","2400795530","2691493129","2762954665","43264740","513467907","468583769","14103421","715351310","246911146","2608615459","636291360","574207605","2283877213","2312887512","2258034260","2719351057","89144105","14379660","28813427","3586271","15365853","22585953","19337489","352982521","26792583","19480057","167401415","2565342164","15050549","13366","1864153224","2572509896","2387227850","2213414816","2258530171","2621349582","2562781854","2199847292","745687860","2467204448","1670339808","2403620577","2451112201","2366354707","9880182","2290197408","2735813746","2251041373","2258403433","2596186036","2299617536","2409218864","2240058816","2721198895","2338229497","1499548657","1534428422","2330646421","2225300413","352245144","2294834533","2206659073","1671239640","2353394140","2400511722","2304146718","707471022","2353813610","1660660554","2236125852","2382846655","1051804416","372364547","381201897","2478575828","376565719","2498306462","824476477","274706827","1423461919","2764597404","2316704490","2647543806","2360600863","297046747","371934393","1859620855","2351042719","2331688646","2409962490","187992149","1850322144","1229736559","2779358226","2586862430","263936619","2278700532","2289196172","1362058093","2317438183","1323280062","291041299","2164822478","2694311868","2257976450","1415406679","2362059150","2467960632","1440661586","1477541142","1078037029","2257211911","2282713568","2261759419","1671301014","2373709957","2490944009","1371209732","1360075472","2181601622","365654638","2311015915","576666003","2182939896","61775603","305854715","1347506222","2173116042","2769537696","79085984","450947924","2284315896","2393106025","2510084300","618709104","2276767032","241209437"};;
		String[] screen_names = {"01101O10","1000btcpage","100KBTC","120unobtanium","18BitcoinCap","1BitOfficial","1_btc","1kiss","247CryptoNews","24xbtc","2c293","2drewlee","30thMedia","365CoinProject","37Coins","5000Satoshis","508TMoney","78f164e16bab481","aaahjoom","Abascual","abilliondoge","aBitcoinGirl","aboutaredhead","ABQBitcoins","AbrahamAltcoin","acointeam","acoolong","ActualAdviceALT","ActualAdviceBTC","ActuallyAndreas","adam3us","AdamAtlas","AdamDraper","adamhhofman","AdamJohnston_","adamschiffman","AdamUren","Adaptedx","adc555","addie_cc","AdmiralAltcoin","ADSactlyCrypto","aekym","aerocoin","aeturn","Afrikoin","agarwalsrox","Ahab_the_great","a_hotz","AidanWenzel","AidenCoin","aikordek","Airbitz","AItcoins","AJ","AKCoins","a_kerya","alandevos","AlannaPetroff","alanrycroft","alansilbert","alaricesoh","AlbertCLoo","AlertCoin","AlexanderHaxton","alexcrypto","alexdao","alexImmachill","AlexisAiono","AlexPreukschat","_alexrp_","AlexVPerl","alien_crypto","AlitFX","AlitinMintLLC","AllAltNews","AllBitcoinNews","AllCoinEx","allcoinvestor","AllenAltcoin","AllThingsBTC","alt_bit_coins","AltcoinAce","AltcoinAdam","AltcoinAlerts","AltcoinAnalysis","AltCoinCalendar","altcoincasino","AltcoinCrazy","Altcoin_Crypton","altcoinflipper","altcoinforums","altcoinguides","altcoinherald","altcoin_invest","AltcoinInvest","AltCoinInvestor","Altcoinity","AltcoinLocal","AltCoinMagazine","AltcoinPromo","AltcoinPromotor","AltcoinPumper","AltCoinPump","AltcoinReviews","altcoinsking","AltCoinSlam","AltCoinSpec","AltCoinsTrader","AltCoinsUK","altcointips","AltcoinTrader99","AltCryptCoins","AltCryptoFollow","Alternative_Ada","AlterWhite1","Altluminati","altmarketdotcom","AltMinerD","AltPumper","altpump","alylovesbitcoin","amexserve","AmreetaTweets","anarchoass","anazir","andrbe1","AndreBulatov","AndrewDubinsky","AndrewHires","andrewljohnson","andrew_oxlade","andrewtdesantis","Andy92","aneilbaboo","anjiecast","annaruddock","AnoncoinProject","AnonOnAMoose","AnonymousAds","anonymouscoin","AnonymousPress","Anti_Pump","Antiwarcom","antony_btc","Ant_Sal","AnushkaPetrova","anxbtc","AnyCoinLottery","anycoinme","APEX13coin","apolovald","Appcoininfo","ArcadeCoin","ARCHcoin","arfab","AriannaSimpson","ariataheri","ArmaanDorno","ashertn","Ashes_to_Snow","ashgoblue","AsiaCoin_","Asic_Tech","AskCoinNet","AskJames","asliceofmellon","asplinux","AT101ET","AtlantaBitcoin","AtlasPulse","AtomicTradeLLC","auroracoinIS","AusBitCash","AUSCoins","AustBitcoin","AustBitcoins","avatarBTC","AvatarX","avianxnf","avowzoneblog","AWeeSomeAltcoin","AwfulProgrammer","AyushNeupane","Azteco_","babushka99","Badbitcoinorg","BaderTheTrader","Baggot_Inn","BankCoin777","BankerWorstFear","BankMaBitcoin","banksycoin","BareCoins","barrysilbert","BAsiaPacific","BBCYourMoney","BCgamer01","bcurdy","BDBOn1","BeachDanny","beala","bearishtrader","BeatBullies","Beautyon_","Be_A_Whale2","Be_A_Whale","bechilandia","Beezy_Z","BellaCoin","BenIsgur","benookx","Ben_Poulson","bensonsamuel","Bentyn","b_erb","BerkeleyBitcoin","BestBitcoins","betarigs","Betbitcoininfo","Betcoiner","betterbitcoin","betXcoin","BexHQ","beyondBTC","bezkrovny","BFEduComm","Bibles4Bitcoins","BigBangCoin1","BIGbtc","Bigdaddybtc","billbarhydt","billgleim","BillyM2k","binarybits","BinaryFunds","bips","birthdaysuitFun","bit4coin","BitAccess","BitaloAG","BitAngelsdotco","bitbid_auctions","BitBidder","Bitbonds","BitBrochure","Bitc01n","bitcamo","BitCasinoIO","bitchampagne","Bitcoin10min","BitCoin13","Bitcoin2014","Bitcoin24com","Bitcoin24h","Bitcoin3D","bitcoin4bitcoin","bitcoin4biz","Bitcoin_4_Free","bitcoin502","BitCoinada","BitcoinAddict","BitcoinAgile","_bitcoinaire_","bitcoin_albania","BitcoinAlchemy","Bitcoin_Alerts","bitcoinalliance","BitcoinAnalyst","bitcoinatheist","BitcoinATMMap","bitcoinATMsg","bitcoinattack","BitcoinAU","BitcoinAustin","BitcoinAverage","BitcoinBarbie","bitcoinbase","BitcoinBash","Bitcoin_Bear","bitcoinbegger","BitcoinBeltway","BitcoinBigfoot","BitCoinBillion","BitcoinBlake","bitcoinblog_de","BitcoinBolt","BitcoinBonus","BitcoinBootcamp","BitcoinBox","Bitcoinbrain","bitcoinbranches","BitcoinBravo","BitcoinBreak","BitcoinBristol","BitcoinBulletin","bitcoinbundle","bitcoinbytes","BitcoinCable","Bitcoin__Casino","BitcoinCasinoVP","BitcoinCenterNY","Bitcoin_Central","BitcoinCEO","BitcoinCEX","BitcoinChan","BitcoinChannel","bitcoincloud","BitcoinCoach","BitcoinComic","BitcoinConf_UK","BitcoinCro","Bitcoincrowd","bitcoin_dad","bitcoinddengle","bitcoindia","BitcoinDoc","BitcoinDood","Bitcoineando","BitcoinEC","bitcoineconomy","BitcoinEdu","Bitcoinee","Bitcoineering","Bitcoin_Embassy","Bitcoiner1","BitcoinEsquire","BitcoinEuphoria","BitcoinEUR","BitcoinEvolutio","bitcoinexplore","BitcoinExpoCA","BitcoinExpo","BitcoinFair","BitcoinFast","BitcoinFather","BitcoinFeeds","Bitcoinference","BitcoinFight","Bitcoinfilm","bitcoinfirehose","BitcoinFire","BitCoin_Freedom","BitcoinFriday","BitcoinFS","bitcoinful","bitcoin_girl","BitcoinGirl","BitcoinGntlman","BitcoinGreece","BitcoinHawaii","BitcoinHR","bitcoininfo","BitcoinIRL","Bitcoinistnet","bitcoin_ita","BitcoinJobBoard","BitcoinJobFair","BitcoinJob","bitcoinjobs","BitCoinKid","BitcoinKinetics","BitcoinKingdom","BITCOINLADY","bitcoinlawyer","BitcoinLearning","BitcoinLIVE","Bitcoinlnfo","BitCoinLog","Bitcoin_Mafia","BitcoinMagazine","bitcoinmama","bitcoinmatin","BitcoinMex","BitcoinMinersUK","BitcoinMKE","bitcoinmodel","bitcoinmom","bitcoinmonk","bitcoinmp","BitcoinMuseum","BitcoinNairobi","BitcoinNew","BitcoinNews247","BitcoinNews24","BitcoinNewsBR","BitcoinNordic","BitcoinNotBombs","BitcoinNoticia","BitcoinNow","BitcoinOutpost","bitcoinparadox","BitcoinPayment","BitcoinPhil","bitcoinpilipina","BitCoinPK","Bitcoin_Plaza","bitcoinpoet","BitcoinPosse","Bitcoin_Post","bitcoinpotato","bitcoinprice","BitcoinProfits","BitcoinProg","Bitcoin_pro","BitcoinPunter","BitcoinRate","BitcoinRat","BitcoinReddit","Bitcoin_Report","bitcoinretweet","BitcoinRushes","Bitcoin_Rush","BitcoinRyan","BitcoinSachs","BitcoinSalad","BitCoinsandMore","bitcoinsberlin","BitcoinsChester","Bitcoinscom","BitcoinShaman","bitcoinshirt","BitcoinShopUS","BitcoinSignal","bitcoins","Bit_coins_","BitcoinSlovenia","bitcoinsouth","Bitcoin_Spain","BitcoinSPBowl","bitcoinspiros","BitcoinsSG","BitcoinStarter","BitcoinStatsApp","bitcoinstats","bitcoinstatus","Bitcoinstore","bitcoinstory","BitcoinSuisseAG","BitcoinTablet","bitcointalk","BitcoinTeam","BitCoin_Tech","bitcointegrate","BitcoinThai","bitcointipper","bitcointrader","BitcoinTrading1","Bitcoin_Trading","BitcoinTrezor","BitcoinTroy","BitcoinTrust","bitcoin_turkiye","bitcoin_tweet","bitcoin_txt","BitcoinUKmedia","bitcoin_updates","BitcoinVeneto","BitcoinViews","BitcoinVLC","BitcoinVOX_FR","Bitcoin_Walker","bitcoinwarlord","Bitcoin_Watcher","BitcoinWisdom","bitcoinwize","Bitcoinwoman","BitcoinXio","bitcoinxxbabe","BitcoinZAR","BitCongress","bitconomyca","BITcurrencies","BitDazzle","Bitdevu","Bitdominion","bitentrepreneur","bitexla","BitEXtra","Bitfash","BitFaucets","BitFinConf","bitfinex","BitFiServices","Bitfluence","BitGigs","BitGirlMiner","BitGiveOrg","BitGoInc","bithint","bithostio","BitInnovate","BitInstantNews","BitInvest","bitjson","bitkeebtc","bitkoins","BitKonan","bitkup","bitlegal_","BitLertLIVE","BitLicenseLLC","bitlitejp","bitlotto","BitMenta","BitMinter","BitMoCurrency","Bitnik_eu","Bitok_com","bitonbit","BitPagar","BitPagos","BitPay","BitPesa","BitPeter","bitpos","BitPowerCo","BitPremier","bitpump","bitreserveorg","bitriches","bitrific","BitRocket_ATM","BitSale","BitsBeTrippin","bitscanner","bitsellatm","_bitshares","BitShireHashAwy","bitsmash","BitsofProperty","BitspendDotNet","Bitstamp","Bitstar_coinz","bitstashCTO","bit_talk","Bittirahafi","bittunes","Bitty_Bot","Bittylicious_","bitundo","BitUpstart","BitVendo","BitVoucher","bitxbitxbitcoin","BlackCoin3d","Blackcoiner","BlackcoinGirl","BlackcoinGritt","BlackcoinMarket","BlackCoinMiner","BlackCoinPool","BlackCoinPromo","BlackFridayChad","BlackRisingX","BlackWaveLabs","BlakeCoin","blazecoin","Bleutrade","blitchiz","blkfoundation","blklottery","blkstkfestival","blockchainbro","blockchaingroup","Blockchain_IO","blockchain","BlockchainLab","BlockchainParty","BlockchainPhone","BlockchainSim","BlockCypher","blockio","Blockscan","blocksignit","Blockspin","BlocktechCEO","blocktrail","blogbitcoinfr","blondebitcoin","BLR13","BlueCoin_info","blumaberlin","BoardDavid","bobbyong","bodil","Bolsasymercados","Bonus_Coin","Boom_Coin","BoringBitcoin","borntobank","boshen1011","botdozeka","boxxa","BradE_CSM","bradmillscan","BrandonCasten","BrandonKBabcock","brandonkballard","brantonbits","bravenewcoin","brawker","BreakingBitcoin","breathingdog","brian_armstrong","briancartmell","brianchoffman","brianeha","brianeklein","BrianKellyBK","BristolPound","brixtonpound","brotter","brucebusiness","BrunoPro79","BryanMicon","BryanStarbuck","BsideBTC","Bspendcom","BTC2B","btc2ripple","btc38com","btc38Ehang","BTC38Exchange","BTC4BIZ","Btc4Euro","BTC4SmallBiz","BTCAcademy","BtcAllan","BTCAllianceInd","BTCarchitect","btcArtGallery","BTCAuthority","BTC_Bandwagon","BTCBazaar1","BTCBeauties","btcbite","BTCBoulevard","BTCBoulevardUS","BTCCanada","BTC_Casino","btcchina","BtcDanny","BTC_Direct","BTCDolphin","btcdotcom","btcecom","btcesp","BTCe_Trollbox","BTCExchange","BTCEXPOIRELAND","BTCFMexico","BTCforChildren","BTCFoundation","BtcFr","BTCGeek","BTC_Girl","BTCGlass","BTCGrace","btcgriffin","BTCHack94","btchokker","BTCinstant","btcintro","btcjam","BTC_kahir","btclondon","BTCLotteries","btcltcdigger","btcmind","BtcMINTer","BTCNetwork","BTCNews247","BTCPhiladelphia","btcplainenglish","btcpoint","BTC_Predictions","BtcRat","BTCreddit","btcReport","BTCrtg","btcsg","_BtcShutUp__","BTC_Society","btcsolutionsca","BTCsx","BTCTalks","BTCticker","btctip","BTC_Trader","BTC_Trader_Tom","BTCTradex","BTCtradingclub","BTCTradingRoom","btctxp","btcusa","btcusd","BTCWatch","BTCwolf","BTCworkshop","btcxindia","BTCYellowPages","btercom","Btplaza","BtradeAustralia","BTXTrader","bubblecoin","Buffs_Forever","Bunnycoin","burgerbeartom","BurnTurnPoker","bushstar","ButtCoin","Buttercoin","buttminer","BuyCrypto","BuyDoge","Buy_Proxies","BWLC2014","BWmagPL","Bytecoin_BCN","ByzantineGen","C2Ventures","caicaikiki"}; 
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
