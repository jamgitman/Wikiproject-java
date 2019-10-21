package wiki;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import javafx.concurrent.Task;
import wiki.AlertBox.AlertApp;

public class SearchQuery {
	
	Query query = new Query();
	
	ObjectMapper mapper = new ObjectMapper();
	
    List<String> queryResponseList = new ArrayList<String>();
	
	private String queryString;
	
	boolean checkconn;
	
	public SearchQuery(String qString) {
		
		this.queryString = query.createQuery(qString);
		System.out.println(this.queryString);
		 check_connection(this.queryString);
	}
	
	public List<String> getSearchedResponseList() {
		return queryResponseList;
	}

	public void loadqueryResponse() {
	
		if (checkconn) {
			JsonNode jsonNode;
			try {
				
				jsonNode = mapper.readValue(new URL(queryString), JsonNode.class);
				JsonNode queryNode = jsonNode.get("query");
	            JsonNode searchNode = queryNode.get("search");
	            
				for (int i = 0; i < searchNode.size(); i++) {
					
					String NodeString =	searchNode.get(i).get("title").asText();
				//	System.out.println(NodeString);
					queryResponseList.add(NodeString);
				
					}
				
				
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
			

		}
		
	}

	Task<Void> task = new Task<Void>() {

		@Override
		protected Void call() throws Exception {
			
			loadqueryResponse();
			
			return null;
		}
	};
	
	public void check_connection(String urlString) {
		
		try {
			URL url = new URL(urlString);
			URLConnection connection = url.openConnection();
			connection.connect();
			checkconn = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			checkconn = false;
			AlertBox.MessageDisplay("No internet connection", AlertApp.NOINTERNETCONN);
		}
	}

}
