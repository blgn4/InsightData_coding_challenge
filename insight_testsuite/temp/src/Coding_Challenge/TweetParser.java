package Coding_Challenge;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class TweetParser {

	private String create_time=null;
	private Date created_time=null;
	private ArrayList<String> hashtags=null;
	

	
	public TweetParser(String tweet)
	{
		try {
			JSONObject tweet_details = (JSONObject) new JSONParser().parse(tweet);
			if(tweet_details.containsKey("created_at")){
			create_time = tweet_details.get("created_at").toString();
			JSONObject entities = (JSONObject) tweet_details.get("entities");
			JSONArray hasht = (JSONArray)entities.get("hashtags");
			if(hasht!=null)
			{
				hashtags = new ArrayList<String>();	
				for(int i=0;i<hasht.size();i++)
				{
					JSONObject hash_item = (JSONObject)hasht.get(i);
					String hash_tag=hash_item.get("text").toString();
					hashtags.add(hash_tag);
				}
			}
		}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public Date getDate()
	{
		if(create_time!=null){
		try {
		DateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.ENGLISH);
		created_time = format.parse(create_time);
		} catch (java.text.ParseException e) {
			System.out.println(e);
		}// Fri Oct 30 15:29:45 +0000 2015
	}
		return created_time;
	}
	
	public ArrayList<String> getHashtags()
	{
		return hashtags;
	}
}
