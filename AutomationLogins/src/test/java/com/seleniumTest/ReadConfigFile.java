package com.seleniumTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigFile {

    Properties properties;
    String path = "C:\\Users\\Asus\\AutomationLogins\\src\\test\\java\\com\\seleniumTest\\ConfigText.txt";

    public ReadConfigFile() throws IOException {
        properties = new Properties();
        FileInputStream file = new FileInputStream(path);
        properties.load(file);

    }

    public String getURL(){
        String url = properties.getProperty("url");
        if (url != null)
            return url;
        else
            throw new RuntimeException("url not specified in config file.");
    }
    public String getUsername(){
        String username = properties.getProperty("username");
        if (username != null)
            return username;
        else
            throw new RuntimeException("username not specified in config file.");
    }
    public String getPassword(){
        String password = properties.getProperty("password");
        if (password != null)
            return password;
        else
            throw new RuntimeException("password not specified in config file.");
    }
}
