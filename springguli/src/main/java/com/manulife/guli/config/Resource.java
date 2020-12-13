package com.manulife.guli.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "resource")
public class Resource {

    //@Value("resource.imageServer")
    private String imageServer;
 //   @Value("resource.emailServer")
    private String emailServer;

    public String getImageServer() {
        return imageServer;
    }

    public void setImageServer(String imageServer) {
        this.imageServer = imageServer;
    }

    public String getEmailServer() {
        return emailServer;
    }

    public void setEmailServer(String emailServer) {
        this.emailServer = emailServer;
    }
}
