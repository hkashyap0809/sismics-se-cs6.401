package com.sismics.music.thirdpartyintegration;

import java.io.IOException;

public interface ThirdPartyIntegrationStrategy {
	public String search(String queryString,String queryType) throws IOException;
	public String recommend(String queryString,String queryType)throws IOException;
}
