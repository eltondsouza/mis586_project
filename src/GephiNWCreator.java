import java.net.UnknownHostException;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;


public class GephiNWCreator {
	
		public static void main(String[] args) throws UnknownHostException {
		
			
				MongoClient mongoClient = new MongoClient( "localhost" );
				DB db = mongoClient.getDB( "bigdata" );
				DBCollection friendsColl = db.getCollection("newFriendsList");
				DBCollection gephi = db.getCollection("gephi");
				DBCollection userColl = db.getCollection("pr2_coreusers");
				
				DBCursor friendsCursor = friendsColl.find();
				
				while(friendsCursor.hasNext())
				{
					
					
					BasicDBList friendsList =(BasicDBList) ((DBObject)(friendsCursor.next().get("friendsString")));
					System.out.println(friendsList);
					
					
					for (Object friendID : friendsList) {
						String source = (String)friendsCursor.curr().get("id_str");
						String target = (String)friendID; 
								
						
						//System.out.println(source+" to "+target);
						
						DBObject doc = new BasicDBObject("source",source).append("target",target);
						
						//DBObject src = userColl.findOne(new BasicDBObject("id",(String)likesCursor.curr().get("id")));
						DBObject dest = userColl.findOne(new BasicDBObject("id_str",target));
						//System.out.println(object);
						
						if(dest!=null)
						{
							//System.out.println(source+" to "+target);
							gephi.insert(doc);
						}
					}
					
					
					/*System.out.println(foo.size());
					System.out.println(foo);*/
				}
		}
	}

