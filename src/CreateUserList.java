import java.net.UnknownHostException;

import com.mongodb.BasicDBList;
//Mongo imports
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

public class CreateUserList {
	public static void main(String[] args) throws UnknownHostException {
	
		MongoClient mongoClient = new MongoClient( "localhost" );
		DB db = mongoClient.getDB( "bigdata" );
		DBCollection userList = db.getCollection("userList2");
		DBCollection friendsListColl = db.getCollection("newFriendsList");
		DBCursor friendsCursor = friendsListColl.find();
		
		while(friendsCursor.hasNext())
		{
			
			
			BasicDBList friendsList =(BasicDBList) ((DBObject)(friendsCursor.next().get("friendsString")));
			//System.out.println(friendsList);
			
			
			for (Object friendID : friendsList) {
				
				System.out.println(friendID);
				BasicDBObject doc = new BasicDBObject("id_str",Long.valueOf((String)friendID)).append("isCore", false); 
				DBObject friendInColl = userList.findOne(new BasicDBObject("id_str",(String)friendID));
				
				if(friendInColl==null)
				{
					try
					{
						//System.out.println((String)friendID);
						userList.insert(doc);
					}
					
					catch(MongoException e)
					{
						e.printStackTrace();
					}
				}
			}
	}
}
}