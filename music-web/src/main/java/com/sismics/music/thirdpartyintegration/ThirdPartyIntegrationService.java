package com.sismics.music.thirdpartyintegration;

import java.io.IOException;

public class ThirdPartyIntegrationService 
{
	private ThirdPartyIntegrationStrategy thirdPartyIntegrationStrategy;
	
	public void setStrategy(ThirdPartyIntegrationStrategy thirdPartyIntegrationStrategy) {
		this.thirdPartyIntegrationStrategy = thirdPartyIntegrationStrategy;
	}
	
	public String searchSongs(String queryString,String queryType) throws IOException {
		return thirdPartyIntegrationStrategy.search(queryString,queryType);
	}
	
	public String recommendSongs(String queryString,String queryType) throws IOException {
		return thirdPartyIntegrationStrategy.recommend(queryString,queryType);
	}
}
