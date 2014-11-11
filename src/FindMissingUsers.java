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
import com.mongodb.MongoException;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static java.util.concurrent.TimeUnit.SECONDS;

public class FindMissingUsers {

	public static void main(String[] args) throws UnknownHostException {
		MongoClient mongoClient = new MongoClient( "localhost" );
		DB db = mongoClient.getDB( "bigdata" );
		DBCollection userColl = db.getCollection("pr2_coreusers");
		DBCollection friendsList = db.getCollection("newFriendsList");
		DBCollection missingIDsColl = db.getCollection("missingIDs");
		
		DBCursor userCursor = userColl.find();
		
		ArrayList<String> coreIDs = new ArrayList<String>();
		
		while(userCursor.hasNext())
		{
			coreIDs.add((String) userCursor.next().get("id_str"));
		}

		ArrayList<String> foundIDs = new ArrayList<String>();
		
		DBCursor friendsCursor = friendsList.find();
		
		while(friendsCursor.hasNext())
		{
			foundIDs.add((String) friendsCursor.next().get("id_str"));
		}
		
		ArrayList<String> missingIDs = new ArrayList<String>();
		
		for (String id : coreIDs) {
			if(!foundIDs.contains(id))
			{
				missingIDs.add(id);
				DBObject doc = new BasicDBObject("id",id);
				missingIDsColl.insert(doc);
			}
		}
		
		for(String id:missingIDs)
		{
			System.out.println(id);
		}
	}

}
