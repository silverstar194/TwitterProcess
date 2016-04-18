import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


import database.DataBase;

/**
 * @author Admin
 *
 */
public class Candidate {

	/**Holds all Tweets for canidate*/
	private ArrayList<Tweet> tweets;

	/**Candidate's name*/
	private String name;

	public Candidate(String name){
		this.tweets = new ArrayList<Tweet>();
		this.name = name;

	}

	
	public void addTweet(Tweet e){
		tweets.add(e);
	}

	public ArrayList<Tweet> getTweets(){
		return tweets;
	}

	public String getName(){
		return name;
	}

	public void loadTweetDB() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		DataBase dataBase = new DataBase();

		Connection dataBaseConn = dataBase.getConnection();

		String command = "SELECT * FROM `twitterDB`.`Tweet` WHERE `search`='"+name+"'";
		System.out.println(command);


		ResultSet rs = dataBase.getDataBaseInfo(dataBaseConn, command);


		while(rs.next()){
			String strip = rs.getString("content").toLowerCase().replace(".", "").replace(",", "").replace("\"", "").replace("?", "");

			if(strip.contains("http")){;
			strip = "http";
			}
			tweets.add(new Tweet(rs.getString("search"), rs.getString("content"),strip, Boolean.parseBoolean(rs.getString("isTruc")), rs.getInt("retweetCount"),rs.getInt("favoriteCount"), rs.getString("lang"), rs.getString("createdAt")));
		}
	}

	public int getNumTweets(){
		return tweets.size();
	}

	public Map<String, Double> getKeyWords(){
		HashMap<String, Double> map = new HashMap<String, Double>();

		for(Tweet e : tweets){
			String content = e.getContentStrip();
			String[] tokens = content.trim().split(" ");
			for(String s : tokens){
				if(!s.contains("#")){
					if(map.containsKey(s)){
						map.put(s, map.get(s)+1);
					}else{
						map.put(s, 0.0);
					}
				}
			}
		}

		map.remove("");
		map.remove(" ");


		Iterator<Map.Entry<String,Double>> iter = map.entrySet().iterator();

		while (iter.hasNext()) {
			Map.Entry<String,Double> entry = iter.next();

			//removes words with low value of occurrences
			if(Config.minOccurencesKey >= entry.getValue() || Helper.isStopWord(entry.getKey())){
				iter.remove();
			}

		}
		return sortByComparator(map);
	}

	public Map<String, Double> getHashTags(){
		HashMap<String, Double> map = new HashMap<String, Double>();

		for(Tweet e : tweets){
			String content = e.getContentStrip();
			String[] tokens = content.trim().split(" ");
			for(String s : tokens){
				if(s.contains("#")){
					if(map.containsKey(s)){
						map.put(s, map.get(s)+1);
					}else{
						map.put(s, 0.0);
					}
				}
			}
		}

		map.remove("");
		map.remove(" ");


		Iterator<Map.Entry<String,Double>> iter = map.entrySet().iterator();

		while (iter.hasNext()) {
			Map.Entry<String,Double> entry = iter.next();

			//removes words with low value of occurrences
			if(Config.minOccurencesHash >= entry.getValue() || Helper.isStopWord(entry.getKey())){
				iter.remove();
			}

		}
		return sortByComparator(map);
	}

	public int totalWords(){

		int numWords = 0;
		for(Tweet e : tweets){
			String lang = e.getContent();
			String[] tokens = lang.split(" ");

			for(String s : tokens){
				numWords += 1;
			}
		}

		return numWords;
	}

	public int totalChars(){

		int numWords = 0;
		for(Tweet e : tweets){
			String lang = e.getContent();
			String[] tokens = lang.split(" ");

			for(String s : tokens){
				numWords += s.length();
			}
		}

		return numWords;
	}


	public Map<String, Double> getNumLang(){
		HashMap<String, Double> map = new HashMap<String, Double>();

		for(Tweet e : tweets){
			String lang = e.getLang();
			if(map.containsKey(lang)){
				map.put(lang, map.get(lang)+1);
			}else{
				map.put(lang, 1.0);
			}
		}


		map.remove("");
		map.remove(" ");


		return sortByComparator(map);
	}

	public int totalFav(){
		int fav = 0;
		for(Tweet e : tweets){
			fav += e.getfavoriteCount();
		}

		return fav;
	}

	public int totalRetweet(){
		int RT = 0;
		for(Tweet e : tweets){
			RT += e.getRetweetCount();
		}

		return RT;
	}

	private static Map<String, Double> sortByComparator(HashMap<String, Double> unsortMap) {

		// Convert Map to List
		List<Map.Entry<String, Double>> list = 
				new LinkedList<Map.Entry<String, Double>>(unsortMap.entrySet());

		// Sort list with comparator, to compare the Map values
		Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
			public int compare(Map.Entry<String, Double> o1,
					Map.Entry<String, Double> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});

		// Convert sorted map back to a Map
		Map<String, Double> sortedMap = new LinkedHashMap<String, Double>();
		for (Iterator<Map.Entry<String, Double>> it = list.iterator(); it.hasNext();) {
			Map.Entry<String, Double> entry = it.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}


}
