
import java.sql.SQLException;


/**
 * @author Admin
 *
 */
public class Main {

	public static void main(String args[]) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{

		/*TRUMP*/
		Candidate trump = new Candidate("trump");
		trump.loadTweetDB();
		double totalTweetsTrump = trump.getNumTweets();
		System.out.println("Trump Total Tweets	: "+totalTweetsTrump);
		
		System.out.println("Keywords: "+ trump.getKeyWords());
		System.out.println("Hashtags: "+ trump.getHashTags());
		System.out.println("Languages: "+trump.getNumLang());
		
		System.out.println("Total Favorites: "+trump.totalFav());
		System.out.println("Total Retweets: "+trump.totalRetweet());
		
		double trumpTW = trump.totalWords();
		System.out.println("Total Words: "+trumpTW);
		System.out.println("Avg. Words Per Tweet: "+trumpTW/totalTweetsTrump);
		System.out.println("Avg. Length of Word: "+trump.totalChars()/trumpTW);

		
		System.out.println();
		/*Hillary*/
		Candidate hillary = new Candidate("hillary");
		hillary.loadTweetDB();
		double totalTweetsHillary = hillary.getNumTweets();
		System.out.println("Hillary Total Tweets: "+totalTweetsHillary);

		System.out.println("Keywords: "+ hillary.getKeyWords());
		System.out.println("Hashtags: "+ hillary.getHashTags());
		System.out.println("Languages: "+hillary.getNumLang());
		System.out.println("Total Favorites: "+hillary.totalFav());
		System.out.println("Total Retweets: "+hillary.totalRetweet());
		
		double hillaryTW = hillary.totalWords();
		System.out.println("Total Words: "+hillaryTW);
		System.out.println("Avg. Words Per Tweet: "+hillaryTW/totalTweetsHillary);
		System.out.println("Avg. Length of Word: "+hillary.totalChars()/hillaryTW);

		
		
		System.out.println();
		/*Berine*/
		Candidate berine = new Candidate("berine");
		berine.loadTweetDB();
		double totalTweetsBerine = berine.getNumTweets();
		System.out.println("Berine Total Tweets: "+totalTweetsBerine);
		
		System.out.println("Keywords: "+ berine.getKeyWords());
		System.out.println("Hashtags: "+ berine.getHashTags());
		System.out.println("Languages: "+berine.getNumLang());
		System.out.println("Total Favorites: "+berine.totalFav());
		System.out.println("Total Retweets: "+berine.totalRetweet());
		
		double berineTW = berine.totalWords();
		System.out.println("Total Words: "+berineTW);
		System.out.println("Avg. Words Per Tweet: "+berineTW/totalTweetsBerine);
		System.out.println("Avg. Length of Word: "+berine.totalChars()/berineTW);

		
		
		System.out.println();
		/*Cruz*/
		Candidate cruz = new Candidate("cruz");
		cruz.loadTweetDB();
		double totalTweetsCruz = cruz.getNumTweets();
		System.out.println("Cruz Total Tweets: "+totalTweetsCruz);
		
		System.out.println("Keywords: "+ cruz.getKeyWords());
		System.out.println("Hashtags: "+ cruz.getHashTags());
		System.out.println("Languages: "+cruz.getNumLang());
		
		System.out.println("Total Favorites: "+cruz.totalFav());
		System.out.println("Total Retweets: "+cruz.totalRetweet());
		
		double cruzTW = cruz.totalWords();
		System.out.println("Total Words: "+cruz.totalWords());
		System.out.println("Avg. Words Per Tweet: "+cruzTW/totalTweetsCruz);
		System.out.println("Avg. Length of Word: "+cruz.totalChars()/cruzTW);

		System.out.println("Loaded :)");

	}

}
