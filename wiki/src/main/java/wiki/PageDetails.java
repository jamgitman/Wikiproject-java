package wiki;

import java.io.IOException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import javafx.concurrent.Task;

public class PageDetails {
	
	ObjectMapper mapper = new ObjectMapper();
	
	StringBuffer buffer = new StringBuffer();
	
	//String pageSection = "https://en.wikipedia.org/w/api.php?action=parse&page=Pet_door&prop=wikitext&section=3&format=json";
	//String pageSections = "https://en.wikipedia.org/w/api.php?action=parse&page=Pet_door&prop=sections&format=json";
	String pageDetails = "https://en.wikipedia.org/w/api.php?action=parse&page=Pet_door&format=json";
	
	public String getPageDetails() {
		return buffer.toString();
	}
	
	public void loadPageDetails() {
		JsonNode jsonNode;
		
		try {
			jsonNode = mapper.readValue(new URL("https://en.wikipedia.org/w/api.php?action=parse&page=Pet_door&prop=wikitext&section=2&format=json"), JsonNode.class);
			JsonNode parsewiki = jsonNode.get("parse");
			JsonNode textwiki = parsewiki.get("wikitext");
			JsonNode selectAll = textwiki.get("*");
			System.out.println(selectAll.textValue());
		//	buffer.append(selectAll.textValue());
			Document document = Jsoup.parse(selectAll.asText());
		//	buffer.append(document.text());
			System.out.println(document.text());
			//buffer.append(document.text());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void parseText() {
		Document document = Jsoup.parse(getPageDetails());
		System.out.println(document.text());
	}
	
	Task<Void> pageParsetask = new Task<Void>() {

		@Override
		protected Void call() throws Exception {
			
			loadPageDetails();
			return null;
		}
		
		
		
	};
	
}
