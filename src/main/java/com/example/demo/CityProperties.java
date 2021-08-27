package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "file")
public class CityProperties {
    public String getUploadDir() {
        return uploadDir;
    }

    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }

    private  String uploadDir;

}
