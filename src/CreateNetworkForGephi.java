import java.net.UnknownHostException;
import java.util.ArrayList;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class CreateNetworkForGephi {
	public static void main(String a[]) throws UnknownHostException
	{
		MongoClient mongoClient = new MongoClient( "localhost" );
		DB db = mongoClient.getDB( "bigdata");
		//DBCollection coll = db.getCollection("pr2_coreusers");
		DBCollection source = db.getCollection("newfriendsList");
		DBCollection dest = db.getCollection("newfriendsList");
		DBCollection gephiCollection = db.getCollection("newgephi_nw");
		
		DBCursor destCursor = dest.find();
		int counter = 0;
		
		destCursor.addOption(com.mongodb.Bytes.QUERYOPTION_NOTIMEOUT);
		
		while(destCursor.hasNext())
		{
			
			Long destID = (Long)destCursor.next().get("id");
			String destIDStr = (String)destCursor.curr().get("id_str"); 
			System.out.println("User No: "+counter++);
			DBCursor sourceCursor = source.find();
			
			while(sourceCursor.hasNext())
			{

				ArrayList<Long> friendsIDs = (ArrayList <Long>) sourceCursor.next().get("friendsString");
				//System.out.println(destID);
				//System.out.println(friendsIDs);
				//System.out.println("Checking if "+sourceCursor.curr().get("screen_name")+" is following "+destCursor.curr().get("screen_name"));
				if(friendsIDs.contains(destIDStr))
				{
					BasicDBObject doc = new BasicDBObject("source",sourceCursor.curr().get("screen_name")).append("dest",destCursor.curr().get("screen_name"));
					gephiCollection.insert(doc);
				}
				
			}
		}
		
	}
}
