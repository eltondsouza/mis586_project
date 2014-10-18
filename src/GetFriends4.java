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

public class GetFriends4 {

	public static void main(String a[]) throws UnknownHostException, NumberFormatException
	{
		MongoClient mongoClient = new MongoClient( "localhost" );
		DB db = mongoClient.getDB( "bigdata" );
		DBCollection coll = db.getCollection("pr2_coreusers");
		DBCollection friendsList = db.getCollection("friendsList");
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
    	cb.setDebugEnabled(true)
    	  .setOAuthConsumerKey("OYeNYvnFToMjtV0XwVgGcm1Zw")
    	  .setOAuthConsumerSecret("Od2iGwFvxnDj0M9CW2olJQUKbzi8IthGE8PpzbV8D1TRBs5Xlu")
    	  .setOAuthAccessToken("2319838854-wzymzSoeDst85eVZAqGBwmthSZizWjXbFzTOhoW")
    	  .setOAuthAccessTokenSecret("1SGRk1KAioGsoveRZbpAarEGRH10hm89s6y9IqlFGswLT")
    	  .setJSONStoreEnabled(true);
    	TwitterFactory tf = new TwitterFactory(cb.build());
    	Twitter twitter = tf.getInstance();
		String[] ids = {"322547469","145947376","2325706010","2350794840","2578447430","2587938332","2153282234","2705309263","14434688","2779711375","2516688952","2310777235","2460051793","1086950162","1608400430","20521873","2351872981","272871165","2326168699","45261625","335877098","61017258","2230299369","129194365","2569417056","151012533","1604647603","1852375970","459146464","1383135702","2460445424","2287471915","19312115","62281954","517813520","2306763157","2457409999","2492264401","16493930","79983286","2218489248","98872165","373410923","221338206","39207995","22680719","572106531","201875169","338207111","2485860480","28919797","36117172","2646774571","17392240","33856538","140808864","2167563187","44174493","390656761","2220837499","342768965","312789382","2387789618","70607600","2594856620","172289207","341746855","1471313300","217590569","308265684","611780076","19069440","7643372","700195467","1937793373","16105237","2397706092","885174530","2353870874","566899596","319900653","429490578","2557453404","1407628819","2810056274","304006109","41193","47273529","15905103","2605061959","14371655","64642607","2537375857","2450494832","2317217822","2307218970","2356574996","2639468239","7347012","2288889440","2208101450","2740171926","2194899020","2661528013","2664792266","2413976168","2324587142","85567835","2731803404","2266309700","2314000705","2344808299","1853339276","1435461608","1289426263","2584214035","1882168650","1167764648","2336078372","1583507190","1608967069","2797437470","2303605586","553807422","1373395154","1621024344","383156291","547679335","2258082151","18297543","2727626096","2283506731","51406900","31395520","381218136","2398235546","2765226284","2280782923","2452269168","63159399","212587812","2446042801","2255724792","135977208","129532508","1332082406","2222816113","2591939491","2496266659","2392005812","22093237","1347812419","2335911301","2684054892","2696197700","351228844","334079148","43116045","1075901425","2571752209","88936049","39033726","1243896186","3107271","266036162","46498861","2675098898","2730064296","18358836","921400778","2314562610","234912898","50264379","2360219959","2333652252","1614345643","2163909828","1081699639","268205675","169276166","2149236450","2690472098","2279318342","951006367","1317390270","2406122988","17047434","2373803311","18888820","529771597","290977100","527932109","15034917","2283745740","339441441","282478907","603094930","200169107","2586042583","2398629950","472325542","14285961","14629462","21307888","2525543532","81456235","1222472503","2703837784","1426844426","1739367744","1051053836","1905095641","2178721315","2226064693","1953108752","1515392432","1857544458","2178163129","2605697964","19459100","15746242","6095822","1668554546","1586601326","14144398","20887841","176758255","6750752","45774330","2497324873","1455084547","17206070","2515887780","60176671","2694402566","16334783","2791497348","2523078991","25034284","2573154480","361423475","2948211","1346817354","198690162","12061032","179085895","2437048214","16866170","413180125","26239076","2403469828","272052019","2616345878","18201699","17678085","14721332","19688667","269271423","330466825","1617392467","18469669","2397607368","2345414360","145811411","419649237","251176049","17868705","384032274","431317100","861075427","507204573","509797544","2419805060","1337991073","2291673639","2518609100","2728762555","562316907","1142333346","2266707271","125196986","243840904","2262119468","131192688","53315871","2218695248","42383421","355918876","2697847370","2377831164","418789376","34392584","2324184558","2476339638","279833293","11162592","2680295102","48813277","182006140","1436771642","1403949241","40933104","15306082","327205199","607498773","2385750270","545715221","224453100","1614494702","543743228","2579243714","115489942","1611865789","1587172549","2772244069","2777844974","17977475","2561715571","2436895231","2459215261","2180169519","18012384","2336334722","381212752","2326120100","2483410794","1323039649","2249796589","390667542","1638270607","2553526670","2305628744","2383515716","110922116","2480336251","48798180","108925379","95449346","2369135388","1246251662","2727488095","2373111157","250560251","13531682","467793677","381198038","243580662","1699413122","2160055980","954720871","18248948","5870242","1064741256","57708109","597721437","15731156","2347592509","2227310618","608252528","239433097","55671407","216655995","2593604311","22847791","2400802573","2758948260","2244295159","48064561","1656679982","423847817","19773268","16883838","43027023","2329376978","459779185","249134535","2283779256","257636955","2582626465","1486489878","2407344331","2273985072","14802014","1527806202","2385732037","310399830","306545682","2186091102","366104267","332375984","2257160995","2280862698","2345648568","2370239502","1951038848","1095596473","2273187548","836675654","2584994952","2460502890","2698307036","230517800","18802551","15682552","292176600","91951829","1566259446","290183114","27709461","20956923","2724681785","2347583498","79761601","281502332","345738416","2200176114","2215626528","2714920710","1937087244","1690347601","1672255892","42386348","2272292319","387976826","2431785793","77807166","1643739668","78697700","119060937","19651231","54866589","61628815","16443393","2327954702","2630377824","2228932730","2244022064","17234234","2400670752","2379836341","34231071","17898357","2759513277","33704279","2424230918","205761169","6857232","14295211","2346209293","2254417807","2375967853","2472254341","153823771","319371528","2601400633","392858225","2367307028","73713248","2594553979","2372712211","150002397","2372197513","2225895566","148356704","45077567","1426074565","2372555492","1463450342","2218413296","2291938488","1970272057","2273572556","1332262141","1398412014","2240169361","2696209237","22840842","2254118922","2790458455","2432690425","2337009366","2317455648","2273356700","2229103004","2246827121","2414718752","492059269","2327888161","2288573108","1561107559","2409428359","2358022490","2312420372","2233352208","342862480","30579101","2369627384","2652920774","2380465687","2332710751","2213287195","2174858379","2321378298","540876800","455868132","46688460","27264042","1669448522","2424275857","2420467715","2402406811","2322888908","1639237562","77630385","1950996829","569207907","2222061030","2313992502","485147004","2533378032","21295652","2374069022","51260502","83864968","56400087","1385821218","64529052","235314284","107075639","610700309","2696454104","2463285680","2649102596","2463529423","2784532830","269721555","2357688096","2421189014","2475860526","2667208280","2593709460","2492507066","129279182","226549651","2265324883","14206068","2565409752","284178022","845754786","25307983","17213382","57475289","45596333","820582093","65417407","57689645","152482212","1330477226","2487792392","301723305","2313884124","2440897582","79060391","228380252","51194306","30044262","46770271","2348537208","295500287","1580054484","268532619","2806310688","2338193426","730337431","40742821","15145762","2193616844","2458611126","2399089015","46049980","24222556","917614586","2569890612","1542271266","2376965870","2434036304","23423359","404207758","2459319727","305034111","2410909952","41118486","2616586700","2457683928","2325992934","379305414","771655646","2727884968","15764136","2321557470","1332042942","18307362","54622027","155762930","2149856370","2366962609","399822089","25288785","2312776951","2318701463","2557641355","2571313752","2499168360","2436257148","2511178802","2559499986","2275810436","2595164142","14336151","49573449","2252300041","2432540773","2157362647","2446274048","2309346044","1854401","72049603","2561607684","22484810","2218058070","2254068349","203109320","2535613592","2471721170","2727015983","17348043","2756274607","180212381","14423379","2382609071","41584238","20833","2568399732","1649055714","21901064","2410047721","2313769146","15443845","2447209717","462746400","2782924616","225254547","15519304","18804654","692023","176068393","1436700416","2362909520","2444478354","2571618025","2202922362","2801534743","39997988","309202372","2443058040","997600459","45262242","600524171","422640612","6853442","69748042","26866426","2507133859","250980843","2730082602","1580114557","2557807074","1894221596","56000672","2354063868","2290025954","2291053022","2305059338","1391809814","2474577541","108856742","1694861228","1466601224","2450180160","1651775515","142634586","2329526714","2296575456","2503750676","2408038603","2321928620","139722074","2250858594","18416400","2202464676","61409691","2511383156","2647037660","2450273904","2407088308","2290674582","2409735355","2310942446","24500377","2561239784","2275188243","2239417057","2218812745","1410710136","12864452","2346120139","21051918","78048656","2211823729","2620121233","200771926","346479186","2450991854","14651754","544329984"};
		String[] screen_names = {"OnBitcoin","onemanatatime","OneMorePeter","onenameio","OneRandMan","Oni_no_Hanzo","OnlyFreeBitcoin","OnyxCoinV2","ooyala","OpalCoinTeam","openbazaar","OptimizeAltCoin","Orangecoins","orbicos","Orbitcoin","orblivion","Orcacoin","orionwl","orobit2014","orobitaff","oscarbennasar","OscopeLabs","outragedhuman","Ozzie_Litecoin","PabloCryptobar","_pablog","pagabitcoin","Pagobit_es","pagobit","PanamaBitcoins","PandacoinPND","PanteraCapital","panzer","Parabear","paradimeshift","ParticleCoin","ParticlePRT","PassportsforBTC","Pat_Jack","patrickkivits","PatronaPartners","paulbuitink","PaulCryptopus","paullewismoney","paullinator","paulvigna","paxsevenfour","paxuminc","paymium","paypebble","paywise_org","Payzaofficial","PayzorCoin","pbaril","pcollinson","PeacheyK","PeercoinPPC","pennyw1se","Peoplearebusy","peoplepumps","perelmanor","PerianneDC","Permacredits","PerthMint","PesamobCom","pete_earle","pete_rizzo_","petertoddbtc","pheevaWallet","philfrancis77","philipvdlinde","PhillipaLJ","philrod","Phneep","Phoenixcoin","pierrebourque","PierreNoizat","Pierre_Rochard","piggycoin","PikaPayBot","PikaPay","Pinkcoin_","Pinkcoinlottery","PiperWallet","PitCoin","Pixelperfecti0n","PJWilkinson","plaintech","planetmoney","PlanktonFOOD","plasticlobster","PLEComputers","pndtip","pnpbitcoin","pockiouk","Poetry4Bitcoin","PokerShibes","pokerwithcrypto","polemitis","Poloniex","PolyCoins","Polycrypto","PolyParadyme","poornatabcu1977","PopsAndFlops","Populacecoin","PopularCoinPOP","PorcTherapy","posthoc_","PotCoin","POTCOIN_KING","PotCoinMe","PowerBunnycom","Predictious","prefiguractivo","PremiumBitcoins","PRHacks","primaindustria","PrimalDomains","Primecoin","Primecoins","PrimeCX","Prismicide","PrivacyMaverick","Privisi_","ProjectCoin","ProjectPika","ProPlayVideos","ProTraderTips","proussakis","ProzCoin","Prypto","psionides","pterion2910","PummpAndDummp","PumpsValue","PurifyCrypto","PurseIO","pyc_inc","pyramuscrypto","qoin","QTMHoldings","QuadrigaCoinEx","Quake_Bake","quantabytes","Quantmn_org","Quark_QRK","quatloocoin","QuazarCoin","QueenOfShibe","queentatiana","quickbitcoin","QuickCoinCo","QUIDCoin","Quietcoin","R3LB0RG","RachelEnsignWSJ","RachelWait","RadkoAlbrecht","RagnarDelTorres","rakkhis","ralphtheninja","randalb3","randybias","raphymcduck","raulnogales","RawCoind","RawCoins","rayhigdon","RayIstre","RazorCoin","razormind","rbtcollins","rdekley","Real_Coinsert","RealComicGirl","RealityKeys","Reality_Pill","REALsocialnet","rebexahn","recursosbitcoin","ReddCoinForums","reddcoin","RedditBTC","redditBTCUK","RedOakCoin","reedjholmes","ReggieSells","reiddraper","remitly","RemitONE","rendygo90","renfrowk","Resilient_21","RestaurntCoupon","RetweetNLD","reypoullard","rgondie","RhinoCoinXRC","RibbitRewards","Ricaspone","ricburton","richardboase","Rich_Browning","Richcoin46","RichDevX","_RichFinch","ridior76","rippleCN","RippleGiveaway","Ripple","RippleLabs","RippleLounge","Ripplelution","RippleSingapore","RippleStream","Ripplesync","RippleWise","RisenBirds","rmhrisk","robamichael","robertobrien","robin_f_hill","robocoin","robustus","RockyCozzo","rogerkver","RogerSchultz","Roman_Skaskiw","romansnitko","Ronang_","roncarmel","RonGlantz","roopgill","Root_Coin","Roryfelton","roscoin","RouletteRun","roxoxo","RoyalMiners","RR_Deol","rsg","RTMoney_","RubberMonkey1","ruima","RuiSousaSantos","Rustcity_DMT","rutgervz","Ruth_Emery","RuthLythe","RXcrypto","ryancharleston","RyanPeterson41","RyanTheTerrible","rzanolli","sachutney","sackdaddy","sacrelege","SaeedGatson","SafelloAB","saifedean","saintcrypto","saitoshee","Salwilliam","samdunn1972","Samertje2","sammantic","SamSwisher","SamuelPatt","Samueltates","SandrineAy","sarahjaneperry4","sasankansony","SATOSHI00000001","SATOSHI00000003","SatoshiATX","Satoshi_Citadel","SatoshiDICE","satoshiPL","satoshipoint","Satoshisongbird","SatoshiStyleTO","SatoshiTango","Savingssully","Savvy_Woman","sayo_btc","Sazeeb","SBartender","scambust","scarrbondale","scharmbeck","schwentker","SciFiCryptoCoin","ScottBitcoin","scottsteuber","scotty321","SDCoin","sDefrees","SDLerner","SeansOutpost","sean_spoonts","Seanzscreams","seb2point0","Sebuh_com","Seccour_FR","SecondHandTiger","secparam","sEczema","SeedcoinHK","SexyBitcoinAds","sfhiddenbitcoin","sfrcoin","SFUBitcoin","SGBitcoin","shacoin2","ShadeCoin","shak","ShapeShift_io","ShareMint","SharkCoins","sharkybit","sheilakraics","SherlockCoin","Shibeliciousxo","ShibeMint","SHIBEXF","Shirtoshi","shit_rbtc_says","shivaculture","SHodyEsq","shovel_boss","Sicarious_","SiliconVaCoin","SilIyPenguin","Silk_coin","Silkyshadow","_simonlambert","Simonlovesmoney","SimplyCrypto","SirBitsALot","sirConga","SiriusCrypto","sixthformpoet","sketchy1poker","Skippy_Brussels","Skjoldung","Skoylesy","SkyeElijah","SkyhookBTC","SkyzaLimitPro","SlateMoneybox","sleepylemur","sleevi_","SlimRevolution","S_Lolley","Slosh","smokemon514","S_Murphy_PhD","SnapSwap","snavarromedina","Snowripper1106","soboku_Normcore","Socal_crypto","socrates1024","SoepkipCrypto","SolarBTC","SolarCoin_SLR","soltantgris","SomozaAndrew","SonarBitcoin","Sonnenshein","_sortega","sostickie","Soul_Eater_43","SouthernBTC","southtopia","sovbtc","sovereignmonkey","SoWhatsBitcoin","sp495","spacebull4000","SpaceCashApp","spair","spencernoon","spendabit","Spendbitcoins","spinlister","ss3katen","StackBitcoin","StackCrypto","StackinBTC","StalwartBX","startbitcoin","start_coin","StartJOIN","StartUsingDoge","Starzenn","StatelessSweets","StealthCoin","StellarOrg","stellarvalue","stephanlivera","stephantual","StephenHui","stephenrowlison","stevenzeiler","steveomarburg","stewartie4","StewQ","stimuluswatch","stkliment","STLcoin","stmic","ST_Money","storjproject","streamuse1","Strozland","STRPiePal","strprice","sub25boston","sub25net","suehaywardmedia","sumobitcoin","SunnyStartups","SwapHole","SwartJS","swissicevault","SyncGirls","syscoin","sytaylor","T3naciousC","taariqlewis","tadfriend","TakeMyBitcoins","talibq86","talkchainapp","talkee_bitcoin","Tall_Geek","TampaBayBitcoin","TamRob92","TanayaMacheel","taraevans","tarentrout56","tarmedia","tatianacoin","taxdood","tayloramiles","TaylorGerring","tbbo_twits","TeamDoge","TeamProCoin","techneave","Technom4ge","TECHNSAVE","teddycointeam","teempai","Tembusuterminal","temite","temptation313","TenaciousCrypto","TeringNering","Tetcoin","TexasBitcoin","TheAdamGarrity","TheAlexGalaxy","TheBitcoinArmy","thebitcoinbyte","TheBitcoinCoop","The_BitCoiner","TheBitcoinGirl","thebitcoingroup","TheBitcoinimist","TheBitcoinMan","TheBitcoinWife","TheBitconnect","TheBitDrop","theblueandred","TheCashBusiness","TheChainLinks","TheCheersApp","TheCoinBeast","TheCoinFront","thecoinspondent","TheCryptoAddict","TheCryptoEdge","TheCryptoKelly","TheCryptonomist","thecryptopope","TheCryptoRush","thecryptostore","TheCryptoWars","TheCryptoWoman","thecypherfunks","TheDarkwallet","TheDCGirl","TheDerek2009","TheDogeOfWallSt","theDogeparty","TheEndOfMoney","TheFateofBTC","theFITJAR","TheGenscher","TheHempCoin","TheIndyMoney","The_K_meister","Theo_Sauls","theoscarvs","ThePriceOfBTC","TheProtocolTV","ThePumpFactor","TheRazorCoin","TheRealAltcoin","TheRealDement","TheRealJFOD","TheRichDouche","TheRockTrading","The_Schmo","The____Shadow","TheShinyCrobat","ThinkingInBTC","thisismoney","ThisIsOurCoin","ThisWeeksCoin","thomasselby","tiffany_wan","Tigerwood0432","tiiid","tilt","TiM_news","timoncc","tipbitcoins","tipblk","TipDogecoin","tipflutter","tipioc","tippercoin","tipreddcoin","TiPS_FedoraCoin","tipstl","tipvia","tipvrc","tipxlb","TitaniumPlays","TKGibbonsCPA","TLeonardBC","tlrobinson","TodaysCoin","TomGullen","TomHashemi","tomlebree","TomRittervg","tom_sharkey","tonilanec","torrent_invites","totofrance","tracemayer","tracphil","TradeBlock","TradeCrypto","TradeHill","TradeMyBit","TrainCash","trakout","TransferWise","travelwithdayo","Trekgirl7of9","TreyStewart14","TriangleBitcoin","trillclintonn","tristan_winters","Trucoin","TRUTHforCRYPTO","TryHoneybadgr","TuCk3R0","TuurDemeester","Tuxavant","twobitidiot","TxBTCEmbassy","TXCoinitiative","tylermevans","tylerwinklevoss","UEGinc","Ugeo211","UkAlpha","UKBuyBitcoins","UKCryptoTrader","ukmoneyguru","UltimaFund","UmbrellaCryptos","UMoMobileMoney","Unbreakablcoin","unchaz","universalmol","_UniversityCoin","unobtanium_uno","unocoin","unSYSTEM2013","urisebG","USATODAYmoney","useCryptos","UseLitecoin","v8rx7","valkenburgh","VaughnBlake","vaultofsatoshi","Vaultoro","Vaurum","VBischoff","VeBitcoin","Venebitcoin","VericoinDev3","VeriCoinDice","vericoinews","VeriCoin","VeriCoinPool","VeriLadies","Vertcoin","VeryVeriViral","vessenes","vhpoet","viabitcoin","viacoin","victoriavaneyk","VikMaKD","Vindyne8","VinnyLingham","VioletTullip","vir6_crypto","VirginMoney","VirtuallyBroke","visionman_btc","Vlad_Roberto","vootcoin","vr2co","vujybenS","Vyker","Vzlabitcoin","WahWhoWah","walne","WarriorRanch","WarwickChing","waterhousephd","Wcoincn","wdcalliance","WDCSpender","weacceptcoin","wealthico","webbson_","WebCoinsCo","WeBeDigi","WebMasteR_007","webswonder","wefivekings","wellerco","westcoastbill","Wewedslim","WhatIsBitcoin","whatmine_com","WhatToMine","WheelofDoge","wheretospendbtc","whichcrypto","WhichMoney","WhiteAdamL","WhiteCoiner","WhyWeTrance","widget4bc","WildPaola","William_Rushlow","willobrien","Willwaukee","willzminame","win88casino","winklevoss","WinOneBitcoin","Witalijusss","withAltcoin","WizeBit","wiz","wizrig","Wolf_Of_Alts","WolfofCrypto","Wolf_Of_Crypto","wollit","WolongPumps","Wolverineks","WomenInBitcoin","woods_nh","woodwallets","WorkForCrypto","worksonmypc","WorldBitcoinNet","WorldBTCForum","worldcoin777","WorldCoin_News","WorldCryptoNet","WorldRemit","WowSuchDogecoin","wsculley","WWitthauer","xBByAM0R","XBTeller","xcloudcoin","XCurrencyRob","XGcurrency","XNFCEO","XNFTrading","XnigmaExchange","xor","_xpool_","XRPFuture","xrpio","XRPRipple","XRPtalk","xyrth","YAAMP1","yablochko","Yakpimp","yBitcoin","Ycun1985","yerofeyev","yeswepump","yirbu","Yodlee","YohanKristanto"}; 
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
