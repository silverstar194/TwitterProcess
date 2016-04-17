import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author Admin
 *
 */
public class Helper {

	/**Holds Stopwords*/
	private static TreeSet<String> stopWords;

	/**
	 * Check if is stop word
	 */
	public static boolean isStopWord(String e){

		loadStopWords();
		e = e.toLowerCase();
		if(stopWords.contains(e)){
			return true;
		}
		else{
			return false;
		}
	}
	
	
	/**
	 * Load stop words from text file
	 */
	public static void loadStopWords(){
		Scanner in = null;
		stopWords = new TreeSet<String>();

		try {
			in = new Scanner(new File("stopwordsNoDup.txt"));

			while(in.hasNextLine()){
				String e = in.nextLine();
				stopWords.add(e);
			}

		} catch (FileNotFoundException e1) {
			System.out.println("CANNOT LOAD STOPWORDS");
			e1.printStackTrace();
		}finally{
			in.close();
		}

	}

}
