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
		String[] ids = {"2445129295","2664589436","1221931562","2695164606","2386331916","2465210088","2336915726","279697896","2248455812","2294321154","198328580","2321935855","2779933484","50421523","2569350374","2759537759","1421188585","371017223","9717812","1364761980","18018877","28063981","35008698","106147007","2296288333","5484502","2237114579","2161821500","281816135","2384550564","762218449","51088856","2265995556","2734939570","2547284799","299481102","2330213353","2530959439","442158567","524569537","2796235358","2530285952","2467956192","3241231","1897582214","1391664912","29175949","23452820","44986650","1512098635","143053926","2420616888","569178408","2578973684","2428792844","763798","577553459","223487393","2365985360","2268656437","53307005","6793252","2203102299","2726288998","2620427880","1463788003","40451792","2583077821","2374567051","2244320174","2430552198","802941816","37346709","227637029","2272600994","13493592","2221859437","396038597","870835010","54244012","785778427","12212","210881916","2221741436","371447953","2393655090","381174944","2334070482","22977825","22384268","121208633","19924691","2815065470","210617781","2463832009","15836377","2281415593","1873573621","2548654315","2602862346","2553785804","2783793384","39613642","18983132","2700809730","12137672","2193930343","2362341804","54847350","383053632","216368649","265559976","2412982777","1580847698","2654370114","560040021","257085972","28010941","105912547","2425322684","156995497","2589840943","2208328500","20235950","2588067271","288582120","492064542","196419329","2571258674","137989479","67452097","2696955264","227470090","52739234","2291979780","2383411874","2206552629","2435195054","1567256983","2350119740","2218542704","2287648848","875988247","1586736096","2381316481","2230607126","329062007","819814","2351113374","2476424478","32840777","2511349693","2310129848","5482372","2258179363","2795748140","270723897","2787844987","2215498945","15672869","2380596110","2390647591","2379976232","1364642054","1595615893","22349125","11322372","1158273668","2501762808","2652032094","2312965772","1141179834","2386122979","2400075631","2421429734","2394835411","2399791014","2275802862","2489990580","417100889","14601336","2527223036","2701153873","1960403330","44869950","1258113061","92498320","24808228","328601406","1697580223","1673570310","1696874269","25234157","485835818","2561808524","2156463577","421878407","2535840451","42889738","776654600","2677557343","2368596187","2448531482","247176773","1650866053","2323068068","2400204420","1413332510","2337491262","92411036","1685411","2487257818","337239968","2584400712","1471719000","2761895491","2648931079","2611639314","301010289","459936166","322368179","2572108555","2404208676","712580966","37707331","14408185","2610349321","828777793","94004726","480070160","1876837532","247187808","19976748","317025554","150125493","21520419","2214839078","93295809","198504873","508953605","798726734","646153","76143","2240466703","14846194","143931236","1392723769","250221450","278154986","122092489","17396038","222367117","28093733","1339267513","37676307","291511317","14963214","2215214240","36347192","333817958","243621425","379400685","66950686","2677825302","56999514","154209001","94274445","2269203073","38579685","135229601","15369123","2232218690","12498082","1133351336","2245636670","25992562","1219516518","169676997","15969848","224955613","2308429837","816838","35749949","1098681096","29960671","14714979","2733621400","344925704","26532789","38949370","2416890145","18137981","2564185735","84049101","10358052","15106933","85203198","276656109","4828981","14672392","25605494","34612564","221618035","46038999","14116342","921839401","164916886","1452180834","2607752989","1404650310","2295386088","297065591","17636509","2664467498","2490459582","92529382","14598134","21925490","14444941","737946372","5624402","232991743","284737750","39222068","22031726","11728992","1260765168","20842848","305643230","14166026","14196511","2448059157","20803620","19302427","62886110","27805380","1419412153","2276379296","40148301","42992649","14907468","57320859","23978388","1449178470","36393115","15524228","2233245703","347730881","2521020643","2209519381","2384463408","2294715644","2262061560","784519","2287698954","23871988","547007288","150799800","755419507","861304268","1329894067","2377654520","13965492","2166708276","1872028693","15794404","2763932078","2431580779","2242726506","2221602384","398585833","1562588947","2801110812","1399148563","2468282359","118699429","392927357","2810452478","272578582","2722551020","2329356506","2230675752","2521075591","2530506919","2268165020","590525923","2546700895","24357549","921359120","712881733","27023307","19724036","2299554823","1190256253","7396822","2343836600","287769673","289564880","2435694072","2742020989","2200708910","96396125","201387364","2342402455","2309818874","2518784544","39066951","1647081858","163051182","2485427205","2721621668","1379130169","963241754","2338907259","1380695610","367743069","469330646","2235136754","2616318362","134411372","21558596","1384955754","1210952893","1325629370","2623464418","2423211476","14928942","15119529","385562752","1268291780","1327769568","1393174363","1379072365","2226830395","475106078","2759564242","106124522","609091503","2200360908","1523185238","54598980","143977123","1223385103","227418944","17588600","2366303126","1338191270","813883412","2608353780","8432752","95994080","2384363672","2216237670","29762963","353813389","2455300670","14763764","455699696","13244152","16451932","2409710738","103019186","2437368144","25127035","18160134","2604429991","2334920414","871107427","14279462","2611725756","9863612","488536612","15320102","14427338","2352743983","1402032307","222531597","549304757","33149849","35865236","17591742","196044151","1628642976","2382833052","2455746828","8289702","252569527","2228144390","1478663665","824060377","14638841","217503506","106234268","433518591","10739992","52340418","619303","9103922","21122421","386588359","295862357","2295803233","2320443654","2312008597","2363896933","301731542","2482090896","2575007138","2220287622","2402032692","1466189700","2314227612","2320404222","1129116216","2180526523","2214916674","1979449668","2667670064","1567096106","46869914","36033287","730086612","1870417183","16179805","15364687","2482963466","22162666","2715312378","1045007220","71787994","282552417","165190014","1893890754","2645327969","2224075856","2319494958","27422071","102784774","92281665","40586273","20929072","1325282202","2363586666","2343566634","2400183606","2653394250","2248110146","2228862812","2322494803","2320806962","2396894258","2417542227","2387827116","14418873","802702237","2328351174","2328807065","2154512879","52335744","2218547448","13325762","376172658","179461935","37417270","1878595094","361666014","1585932799","25052903","2426280816","1354739114","2478439963","2532954854","460584564","113061083","130471189","24723897","559797807","92279996","18634281","2492130176","119365950","1704878910","40182630","15174692","15232850","71291767","1020203322","14326675","15855616","941182304","152460986","2272208143","1370444665","418803165","709294406","2292281622","6015932","1733867336","4034031","1591747004","2455304028","2178858974","24546521","2420979416","1729661822","85868590","14684626","1960439930","36477638","343902575","260146304","2313072698","777220598","2280289681","2430969794","15134307","2676288085","537570342","18185614","164628863","2584595419","1274469684","2161995060","2241456800","388579395","2433648590","2365613563","86508614","85726089","43514030","2161496719","381185553","606286599","286728598","335311525","239871798","1527962941","52160722","612458670","2465184583","2532881881","16670774","110075039","2279681898","2480548052","2313671966","2320852861","2723492052","2585736660","1492819644","2743312900","213829067","2323493340","2600194316","2603955661","59307142","1344389899","2150123534","2340647486","14199521","14763980","1223938794","1315790306","20588098","2303650739","872738546","1901611970","89429647","17811957","38270714","2674226202","2419465506","765007633","2211174856","183816474","2260789034","1293548664","2276194537","917655432","19240388","2278542824","2244257760","316809023","2801347050","2355533382","1736280751","36081258","1077965228","27557141","2576848693","2585829824","2574819667","2574828552","2574721470","2576846984","2575007623","2573084024","2574845166","2574957176","2576864514","2576965832","2574985188","1975454844","1920655710","27583645","10446482","2239885255","2243862290","2360654905","2328704769","2502162932","2302018777","13697","859226797","487696298","814667","264828029","2314224984","2288771270","15885871","519800095","38392573","2445396642","16912671","32356246"};
		String[] screen_names = {"flanders7229","flashv1rus1","flibbr","FlowLikeEvian","fluttercoin","fluttercoinpool","flyingheadofbtc","fnxTX","FollowTheCoin","fonebtc","Fontase","FontasPumps","FosfeneCrypto","fractastical","Francecrypto","FranceMarcum","FrankoCurrency","FrankPasquale","FrankSchuil","franksil88","FredericJacobs","frederikro","Fred_Mazo","freebtcdaily","FreeDogeCoinGuy","FreedomFeens","Freedomglass","Free_Ross","FreshMarketism","FrozenBitIO","Frygizzle","ftmoney","FUDCOIN","FudZero","fuelcoinNEWS","FunViewx2","futurecoins","futuretraderx","fxinter_net","GabeCoin","GaiaPlatform","galaxyatx","GameLeaguecoin","GamerAndy","Gamingbitcoin","GanaBitcoins","garethjenkins","GarethRShaw","Gary_Ashby","Gatecoin","gavinandresen","GAWMiners","GCaffyn","GCRcoin","GDenomination","gelenbe","General_Crypto","GeneralSeven","GeneralWarbucks","genesiscoin","geoburke","georgedonnelly","GeorgiBitcoing","gepozRut","GestokyGospodin","GetCoinJar","getearthcoin","getfortuneapp","getintocoin","GETMONEYWEBSITE","GetPimp","G_Finan","ggeorgiev","ggomezrojo","ghash_io","GianniDalerta","giannitsatown","Gian_TCatt","gillianim","gilluria","giveemdaD","giyom","gjericu","glcbitcoin","gli_ph","global_btc","GLOBALlnvesting","GlobeCurrency","gmelika","gmendiratta","GMolenkamp","gmoney75","GnosisCrypto","GNULinuxGuy","GoCoinCEO","GoCoin","GodofCoins","GogoCoin","GoGreenCoin","goldeng00se","GoldenGatewayUS","Goldmin_es","GoldMoneyNews","gompertz","GordansKids","gorillamania","goswitchless","gotgoxed","gotoalberto","GoWestBTC","GrabDatCash","GraehamF","Gravacoin","GreenAddress","GreenBacksDev","GreenBTC","gregdsouza","Griffcub","Grimeandreason","GroestlcoinTeam","GrumpyOldTone","GryfenCoin","GryfenCrypto","guardianmoney","gustavowiz","gwb03","gyft","H4CKN3T","Hackadoge","hafnero","haiyanksa","HalofireBTC","hannahevetillso","Hannet00","Harborly","HashCASHblog","HashCashWolf","HashcoinHASH","HashFast","HashingNow","HashPlex","HashraTech","hassanresad","Havelock_Inv","Hawaiicoin","HeadChikun","Headlinemoney_","heathervescent","HeavycoinNews","Heisenshibe","hektikest","HelgaDanova","HelloCrypto","helloluis","helpuswithBTC","Hempcoins4you","hermanjunge","Hibryda","HighBitCoin","hilaryosborne","HipBitcoiner","HiroCryptoSatou","HiroNaomoto","hitbtc","hivewallet","hmichellerose","holman","holytransaction","HongKetoCoin","HOPEGoldCoin","Horusisthesun","hsinjuchuang","HTMLCOIN","htxbtcmeetup","Hugh_Starr","HullCoin","HumbleDoge","Humint_is","huobicom","hybridsole","HyperBTC","HyperCrypto","HyprKey","_Hypron","iamGodgifted","Iam_Satoshi","iamsonge","iamsuz85","ianatmars","IBWTofficial","IcarusGlider","ICE3X","ICee712","IdentityMind","idigbitcoin","IHaveBitcoins","ilovebitcoins","imbecileee","Imcloud9","InBitBox","Incognitocoin","India_Bitcoin","InfluxStrategy","infocannabis","InPayTo","InsaneDumps","InsideBitcoins1","InsideBitcoins","instabt","instalox","intelliot","InternetofValue","inthepixels","INTLlottery","IntoBitCoin","InvestinginBTC","IO_Coin","IOMCryptoValley","ionayoungmoney","ioptio","irinacioaca","IronBankCoin","Isracoin","itBit","itisCaLvin","Itnom","itsvericoin","itvMLshow","ja1meluna","JabulonCryptoBC","jacobsfarber","JacquesTheRippr","jaimenm","jakedienelt","jakimanboy","jamesbarcia","james_dal_","JamesGRickards","jamienelson1","JamilBerglund","janeescobal","japes","Jasmine","JasonCatalyst","jasondole","JayEfEm","JCarrillo_BTC","JCristales","jdebunt","JDRoa92","jedisct1","jeffakaslinger","jeff_smith01","JeffWalker82","jemkob","jemredin","jen_h","JennaBitcoin","jennicrypto","JeredKenna","jeremybonney","JeremyRubin","jespow","Jessabel1335","jessevanek","Jesus_Cryptos","jgarzik","jiapetz","jillfriedman","jimconey","Jim_Harper","jim_lowry","jimmyhomma","jinyoungenglund","JJaPhillips","jjasonchow","jjehrlich18","jmgranola","jmiehau","Jobs_4_Bitcoins","Jobs4Bitcoins","JoeCascio","JoelKatz","joeykrug447","jofaithy","johnefrancis","JOHNNYB_CASH","JohnRMeese","JohnTheJourno","johnvillarz","JoinTapeke","JonathanMohan","jonhy_peter_","JonnyBitcoin","jonone100","jonwaller","jony_levin","joobid","joonian","josecelano","Jose_Pagliery","josephbonneau","josephjpeters","josephzhou","JoshMPlant","jp_koning","jpmorgan_alts","JPSchaumleffel","jshplhm","jstcoin","JStuhlman","JtotheOE","JuanLlanos","JudgecoinPrice","judgecrypto","juny21c","jurbed","justinsimon","justmoon","JustWillFocus","jyap","kaarmann","kabloemski","kachayev","kadhimshubber","kaepora","KamilBrejcha","kangasbros","kaputski91","karengifford","karrisaarinen","KashmirCoin","katherineryan","kayden1989","kazonomics","KculShare","KDioby","KeiserCoin","kendo451","kennwhite","kennyog","kenshishido","kentindell","kettelseven","kevinmclendon","killhamster","Kilocoin1","Kim_Jong_Skill","kinetiktrader","_KingBreaJhaun","kingbtc","Kingcoiny","kingscrownBTC","KirinDave","KittehCoin","KittMcCurdy","kittybitcoin","kiwicerisemiaw","klinthoufy","KlooklReview","kncminer","KnightsSatoshi","knilsen_","knowbitcoin","KnowYourBitcoin","kobi514","kochmoney","Koin_Pool","koinsmart","Kolin_Quark","KonradSGraf","KorbitBTC","KoreCoinBR","krakenfx","KrakenTicker","kravchenkopo","kresssK","kriptoman1","KristenTaylorS","KrypTip","KryptoFX","KryptoKit","KryptoniteCoin","KryptoStorm","KryptozCom","kunachii","KurtAndTheMoon","kw0ng","kwamgee","kymmer7691","LADLynn","lafetaylor","LaMaisonDuBTC","LamassuBTC","langer_hans","la_porca","Larry_OBrien1","LasVegasBitcoin","LatiumCoin","LatiumFan","LaunchCoin","lauragales","Laurie_Rice_","LazyCoins","leafcoin","LeagueCoin","leahmilner","learnbitcoinUK","lee_boyce","lekingdlabeach","lemurcoin","LenklaHudakova","LeoFromH3ll","letsgetbitcoin","LetsTalkBitcoin","Liam_Duff1","libcoin","libertyteller","LibrexCoin","licuende","lifeboathq","lifeonbitcoin","lightcoin","lilbitcoin","LillyBitcoinSol","linhlan966","lisacheng","lisafleisher","litecoin","LitecoinMining","LiteCoinNews","LitecoinProject","LitecoinRates","Lite_Coins","LitecoinWatch","lloyd_felisa","loboscoinsure","LocalBitcoins","LogoDesign4BTC","LondonBTCMeetUp","LondonMarathon","Lord_Ashdrake","Lorenzo_Money","LorenzTrader","lovemoney_com","LoveseatBlog","LTCBTC","LTCWatch","luckysatoshi","lukestokes","Lukewearechange","lurkerAKAJesse","M4niAK_","maartented","MaBetschart","machinist_gitju","maciejolpinski","mad_etf","MadMoneyMachine","MadMoneyOnCNBC","MadPotCoins","magaFirst","_Magicaltux","Magoo","mahingupta","MajningMaster","MajorMiners","MakeNDAAfamous","makevoid","MalibuBitcoin","mandiees","mannypr1m3","maranh","maraoz","marcoaaronk","marcoporretto","MarkAthertonTim","markdavidlamb","markhamthomson","markkevtaylor","MarkLyford","markwoodsaz","MarquisDonatien","MarshallHayner","MarteXcoin","martindale","MartinSLewis","MastermindBTC","masterofmyself2","MasterZeus2012","matshenricson","MattdeCourcelle","matthew_d_green","Matthewkenahan","MatthewRoszak","matt_innes","mattmatt","MattPRD","matt_tuzzolo","Mauri_Wowie","mawueli","MaxCoinDice","MaxCoin_nl","maxcoinproject","MaxcoinWorld","MaxMoyle","MaxPromote","mayorofshytcoin","MazaCoin","mazatalk","MBitcoin","mBTCPizpie","McCluskyJoe","meetpays","mega_coin","MegaCoinTrader","MentasoBitcoin","MerchantCoin","Metaballo","metacurrency","metaquestions","MetaTrades","Mexbt","mhluongo","miaoux","microdesic","MidasMarni","MidasPay","MidgeGaunt","mids106","MiguelCuneta","miguelproulx","mihcomih","mikecrypto","Mike_Crypto","mikegeister","mikegogulski","mikehogan_","mikejcasey","mike_maloney","mikerotman","MikeSweeneyBit","MileCoins","mimcoin","MineCryptoCoins","MineFilecoin","MinerDealer","MintBTC","MintcoinTeam","MintPalExchange","mintpal_pumper","MintPumps","MintTip","MironLulic","MissDanielleToU","MissSatochi","MisterCrypto","MITBitcoinClub","mittsdaki","MJKCurrency","mlrichard","mmeijeri","m_murfy","mobilemoneyafr","MobileMoneyZA","MobilesWanted","mochi_wsj","MoiraONeill","_monayen_","moneeroHQ","monerocurrency","MonetaVerde","money2020","money2themasses","Money_Advice","moneyandmedia","Moneyandtech","MoneyfactsNews","Moneymagpie","MoneyMikeOnline","MoneyObserver","MoneyPennySF","MoneySavingExp","moneyStrands","MoneySupermkt","moneysuperPR","MoneyTelegraph","moneywatch","MonicaLongSF","monimobile","MonoMesa","moolah_io","MostlyBitcoin","mperklin","Mr_anonymousJR","MrCrypto_owlman","mrebola","MrKryptoKnight","mrmx","Mr_PlNK","mrsbitcoin","msantoriESQ","MSBCompliance","MScDigital","MSCProtocol","MSE_GuyAnker","msnmoney","msteph_matthew","Mtal","mtgoxalerts","MtGox","MuchCryptoKing","munoz233","Murraycoin","MurrayOverboard","musha68k","musicformoon","Mut_Coin","muxiaoliang","mvidallopez","MWL4Money","MyBitX","MyBTCNinja","mydogecoin","MyMoneyPlatform","MyPumpAcc","myriadcoin","n00shinm","nachoorozcog","nadam9","NakamotoInst","NamecoinCable","NamecoinDotInfo","Namecoin","NatarrshaRSmith","natdebtline","NateTripleB","nathanielpopper","nathanwosnack","Nautiluscoin","NavajoCoin","nbougalis","nealstephenson","needacoin","NeedForBitcoin","nemcoin","NeoandBee","NeosCoin","nestcoin","netagio","Netcurrency","Neurotraveller1","NewBitcoinToday","NewKoreCoin","NewsAltcoin","NewsAndChat","News_Bitcoin","newsbtc","NewtOnCrypto","NEXUSBITCOIN","niccary","nicegfc","nicekidd0","nicholaslovell","nickjachelson","nicoamorescom","nielsnnn","nigelverdon","Nightwolf42","nil8tor","NimbusCoin","Nixecom","nkwsy","nlbosna","nmachijidenma","nnbitmob","NobelCode","NobleCoin","NoCashFee2Trade","noel_llopis","NoFiatCoin","NoirbitsCoin","nomaxpi","Noobgettinrich","NotoriousBTC","NowellAssociate","nozomimagine","nsch0481BITCOIN","NTmoney","NuBills_ar","NuBills_at","NuBills_ch","NuBills_es","NuBills_fr","NuBills_hk","NuBills_my","NuBillsNews","NuBills_nl","NuBills_nz","NuBills_se","NuBills_ua","NuBills_za","NukMark","numistat","Nuseii","nvk","NXTCoin","NxtCommunity","Nxt_e","Nxter_org","nycbtcpros","nzcrypto","obeattie","ObscureJelly","OccupyTeaTent","octal","odoudin","Official_Florin","official_utc","ofirbeigel","ofnumbers","oib9","OKCoinBTC","oleganza","omnik"}; 
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
