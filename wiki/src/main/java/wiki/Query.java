package wiki;

import java.util.StringTokenizer;

public class Query {
	
	
	private String wikiSearchRelevance = "https://en.wikipedia.org/w/api.php?action=query&list=search&srlimit=20&srsearch=apple&srsort=relevance&utf8=&format=json";
	
	public String wikiSearchSrlimit = "https://en.wikipedia.org/w/api.php?action=query&list=search&srlimit=20&srsearch=apple&utf8=&format=json";
	
	private String wikiOpenSearch = "https://en.wikipedia.org/w/api.php?action=opensearch&search=apple&limit=80&namespace=0&format=json";
	
	private String searchQuery = "https://en.wikipedia.org/w/api.php?action=query&list=search&srlimit=100&srsearch=";
	private String searchFormat = "&utf8=&format=json";
	
	//https://en.wikipedia.org/w/api.php?action=query&list=search&srlimit=20&srsearch=apple&srinterwiki=true&srsort=just_match&utf8=&format=json
	
	public String createQuery(String inputSearch) {
		if (inputSearch.isEmpty() || inputSearch.isBlank()) {
			System.out.println( "empty string");
			return null;
		}
		else {
		StringBuffer stringBuffer = new StringBuffer(searchQuery);
		//System.out.println(stringBuffer.append(inputSearch).append(searchFormat).toString());
		return stringBuffer.append(inputSearch).append(searchFormat).toString();
		
		}		
	}
	

}
