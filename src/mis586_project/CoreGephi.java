package mis586_project;
import java.net.UnknownHostException;
import java.util.ArrayList;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class CoreGephi {
	public static void main(String[] args) throws UnknownHostException {
		MongoClient mongoClient = new MongoClient( "localhost" );
		DB db = mongoClient.getDB( "bigdata");
		//DBCollection coll = db.getCollection("pr2_coreusers");
		DBCollection coreUsers = db.getCollection("coreusers");
		DBCollection friendsList = db.getCollection("friendsList");
		DBCollection coreFriends = db.getCollection("coreFriends");
		
		//get ids of core users into a list
		DBCursor coreUsersCursor = coreUsers.find();
		ArrayList<Long> coreUserIDs = new ArrayList<Long>(); 
		long[] coreUserIDPrim = {1868074730L,140892663L,29468585L,61417559L,101580574L,1469101279L,62805324L,1435626302L,2201220235L,14698049L,34056134L,32841620L,2441910085L,2505478057L,2335741172L,2768000832L,572478728L,65923928L,1632855667L,443484148L,901796180L,2337886340L,1619086339L,527119125L,3496041L,473617692L,223315248L,14445920L,191932849L,97994396L,15387117L,10448732L,794532L,295049967L,782632L,11244372L,121486117L,17881672L,7032912L,15254730L,567059880L,9732512L,7718322L,2770511L,2278064736L,30744136L,18073651L,14200949L,267344900L,815803254L,334090417L,2421317989L,31208923L,15711635L,14910027L,804633782L,45184849L,8731752L,816509173L,14639500L,142515652L,2778320166L,2257350176L,14948062L,2321735011L,1390540460L,123428539L,351306056L,126916586L,2680350607L,2736952543L,1952836374L,2478756618L,217081909L,324539863L,233318165L,1562625614L,2392531752L,2406505603L,2381420407L,2315539361L,2257104332L,2287145203L,2286545720L,50609160L,2567934373L,2502466327L,2322651270L,2309637680L,1728667957L,916257050L,157759025L,41140413L,2326927580L,603147106L,490808869L,155440944L,167434488L,40217798L,2584810652L,20737357L,2259434528L,2379768630L,16489197L,162573283L,2309081983L,1387081490L,299952246L,1420795609L,307699453L,357312062L,1687931155L,1328406894L,1113937704L,1260416562L,2230083151L,1390214179L,458769926L,9337702L,15173724L,14338147L,2313732494L,576018898L,28477224L,14110443L,334161392L,735523747L,118917461L,19132398L,2366348178L,1004978042L,2616036566L,553389027L,2682395184L};
		for(int i=0;i<coreUserIDPrim.length;i++)
		{
			coreUserIDs.add(new Long(coreUserIDPrim[i]));
		}
		
		/*while(coreUsersCursor.hasNext())
		{
			try{
				Double x = (Double)coreUsersCursor.next().get("id");
				long y = x.longValue();
				coreUserIDs.add(new Long(y));
			}
			catch(ClassCastException e)
			{
				Integer a = (Integer)coreUsersCursor.next().get("id");
				long b = a.longValue();
				coreUserIDs.add(new Long(b));
			}
			try{
				coreUserIDs.add((Long)coreUsersCursor.next().get("id"));
			}
			catch(ClassCastException e){
				try{
				Double x = (Double)coreUsersCursor.next().get("id");
				long y = x.longValue();
				coreUserIDs.add(new Long(y));}
				catch(ClassCastException q)
				{
					Integer a = (Integer)coreUsersCursor.next().get("id");
					long b = a.longValue();
					coreUserIDs.add(new Long(b));
				}
			}
		}*/
		//foreach core user id, check if present in the friends list collection
		
		DBCursor friendCursor = friendsList.find();
		
		while(friendCursor.hasNext())
		{
			Long ID = (Long) friendCursor.next().get("id");
			if(coreUserIDs.contains(ID))
			{
				//if present, add to coreFriends collection
				BasicDBObject doc = new BasicDBObject("id",friendCursor.curr().get("id")).append("screen_name",friendCursor.curr().get("screen_name")).append("friends", friendCursor.curr().get("friends"));
				coreFriends.insert(doc);
			}
		}
	
		
		
	}
}
