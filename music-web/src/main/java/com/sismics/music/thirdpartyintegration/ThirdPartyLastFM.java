package com.sismics.music.thirdpartyintegration;

import java.io.IOException;
import java.net.URL;  
import java.io.InputStreamReader;  
import java.net.HttpURLConnection;  
import java.io.BufferedReader;


public class ThirdPartyLastFM implements ThirdPartyIntegrationStrategy {

	@Override
	public String search(String queryString,String queryType) throws IOException {
		//generate token		
		String API_KEY = "5a24f8cfea22982641452cf45409113a";
		String BASE_URI="http://ws.audioscrobbler.com/2.0/";
		
		String SEARCH_URL=BASE_URI+"?method="+queryType+".search&"+queryType+"="+queryString+"&api_key=+"+API_KEY+"&format=json";
		
		URL url = new URL(SEARCH_URL);
		
		//make a get request to search
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		conn.setRequestProperty("Content-Type","application/json");
		conn.setRequestMethod("GET");

		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String output;

		StringBuffer response = new StringBuffer();
		while ((output = in.readLine()) != null) {
			response.append(output);
		}

		in.close();
		// printing result from response
		System.out.println("Response:-" + response.toString());
		return response.toString();

	}

	@Override
	public String recommend(String queryString,String queryType)throws IOException {
		
		///2.0/?method=artist.getsimilar&artist=cher&api_key=YOUR_API_KEY&format=json
		
		String API_KEY = "5a24f8cfea22982641452cf45409113a";
		String BASE_URI="http://ws.audioscrobbler.com/2.0/";
		String RECOMMEND_URL=BASE_URI+"?method="+queryType+".getsimilar&"+queryType+"="+queryString+"&api_key=+"+API_KEY+"&format=json";
		
		URL url = new URL(RECOMMEND_URL);
		
		//make a get request to search
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		conn.setRequestProperty("Content-Type","application/json");
		conn.setRequestMethod("GET");

		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String output;

		StringBuffer response = new StringBuffer();
		while ((output = in.readLine()) != null) {
			response.append(output);
		}

		in.close();
		// printing result from response
		System.out.println("Response:-" + response.toString());
		return response.toString();
	}


}
