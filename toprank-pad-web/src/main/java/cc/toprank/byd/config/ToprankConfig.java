package cc.toprank.byd.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ToprankConfig {

	private String httpServer;

	public String getHttpServer() {
		return httpServer;
	}

	public void setHttpServer(String httpServer) {
		this.httpServer = httpServer;
	}

}
