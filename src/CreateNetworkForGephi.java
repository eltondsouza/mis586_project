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
		DBCollection source = db.getCollection("friendsList");
		DBCollection dest = db.getCollection("friendsList");
		DBCollection gephiCollection = db.getCollection("gephi_nw");
		
		DBCursor destCursor = dest.find();
		int counter = 0;
		
		while(destCursor.hasNext())
		{
			
			Long destID = (Long)destCursor.next().get("id");
			System.out.println("The destination node's ID is "+destID);
			DBCursor sourceCursor = source.find();
			
			while(sourceCursor.hasNext())
			{

				ArrayList<Long> friendsIDs = (ArrayList <Long>) sourceCursor.next().get("friends");
				//System.out.println(destID);
				//System.out.println(friendsIDs);
				//System.out.println("Checking if "+sourceCursor.curr().get("screen_name")+" is following "+destCursor.curr().get("screen_name"));
				if(friendsIDs.contains(destID))
				{
					BasicDBObject doc = new BasicDBObject("source",sourceCursor.curr().get("screen_name")).append("dest",destCursor.curr().get("screen_name"));
					gephiCollection.insert(doc);
				}
				
			}
		}
		
	}
}
