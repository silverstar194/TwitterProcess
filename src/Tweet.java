/**
 * @author Admin
 *
 */
public class Tweet {

	private String search;

	private String content;
	
	private String contentStrip;

	private boolean isTruc;

	private int retweetCount;

	private int favoriteCount;

	private String lang;

	private String createdAt;



	public Tweet(String search, String content, String contentStrip, boolean isTruc, int retweetCount,int favoriteCount, String lang, String createdAt){
		this.search = search;
		this.content = content;
		this.isTruc = isTruc;
		this.retweetCount = retweetCount;
		this.lang = lang;
		this.createdAt = createdAt;
		this.favoriteCount = favoriteCount;
		this.contentStrip = contentStrip;

	}

	/*setters*/
	public void setSearch(String search){
		this.search = search;
	}

	public void setContent(String content){
		this.content = content;
	}
	
	public void setContentStrip(String content){
		this.content = content;
	}
	
	public void setisTruc(boolean isTruc){
		this.isTruc = isTruc;
	}

	public void setRetweetCount(int retweetCount){
		this.retweetCount = retweetCount;
	}
	
	public void setfavoriteCount(int favoriteCount){
		this.favoriteCount = favoriteCount;
	}
	
	public void setLang(String lang){
		this.lang = lang;
	}
	
	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}
	
	
	/*getters*/
	public String getSearch(){
		return search;
	}

	public String getContent(){
		return content;
	}
	
	public String getContentStrip(){
		return contentStrip;
	}
	
	public boolean getisTruc(){
		return isTruc;
	}

	public int getRetweetCount(){
		return retweetCount;
	}
	
	public int getfavoriteCount(){
		return favoriteCount;
	}
	
	public String getLang(){
		return lang;
	}
	
	public String getCreatedAt(){
		return createdAt;
	}




}
