package com.sismics.music.thirdpartyintegration;

import java.net.URL;  
import java.io.InputStreamReader;  
import java.net.HttpURLConnection;  
import java.io.BufferedReader;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;


public class ThirdPartySpotify implements ThirdPartyIntegrationStrategy {

	@Override
	public String search(String queryString,String queryType) throws IOException {
		//generate token		
		String accessToken = getAccessToken();
		System.out.println("TOKEN "+accessToken);
		String BASE_URI="https://api.spotify.com/v1/search";
		//String SEARCH_URL="https://api.spotify.com/v1/search?type=track&q=indian";
		
		String SEARCH_URL=BASE_URI+"?type="+queryType+"&q="+queryString+"";
		//add query params		
		URL url = new URL(SEARCH_URL);
		System.out.println("33");
		//make a get request to search
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		conn.setRequestProperty("Authorization","Bearer "+accessToken);
		System.out.println("38");
		conn.setRequestProperty("Content-Type","application/json");
		conn.setRequestMethod("GET");
		System.out.println("41");
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String output;
		System.out.println("44");
		StringBuffer response = new StringBuffer();
		while ((output = in.readLine()) != null) {
			response.append(output);
		}
		System.out.println("49");
		in.close();
		// printing result from response
		System.out.println("Response:-" + response.toString());
		return response.toString();

	}

	@Override
	public String recommend(String queryString,String queryType) {
		// TODO Auto-generated method stub
		return "";

	}

	private static String getAccessToken() throws IOException {
		String CLIENT_ID="f897b413968b46288d95dbb1e543541d";
		String CLIENT_SECRET="b4c7897711df415d92b9651f8f827882";
		String AUTH_URL = "https://accounts.spotify.com/api/token";

		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(AUTH_URL);
		httpPost.setHeader("Authorization", "Basic " + Base64.getEncoder().encodeToString((CLIENT_ID + ":" + CLIENT_SECRET).getBytes(StandardCharsets.UTF_8)));
		httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
		httpPost.setEntity(new StringEntity("grant_type=client_credentials"));

		try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				String result = EntityUtils.toString(entity);
				JsonObject jsonObject = JsonParser.parseString(result).getAsJsonObject();
				String accessToken = jsonObject.get("access_token").getAsString();
				return accessToken;
			}
		}
		return null;
	}

}
