package com.ecommerce.utils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    Properties prop;
    public ConfigReader() throws IOException {
        FileInputStream fis=new FileInputStream("C:\\Users\\santhosh.krishnan\\Downloads\\Capstone_Project_Hp\\src\\test\\resources\\config.properties");
        prop=new Properties();
        prop.load(fis);
    }

    public String getAppUrl()
    {
        return prop.getProperty("url");
    }

    public String getUserName(){
        return prop.getProperty("username");
    }

    public String getUserPassword(){
        return prop.getProperty("password");
    }

    public String getFirstName()
    {
        return prop.getProperty("firstname");
    }

    public String getTelephone(){
        return prop.getProperty("telephone");
    }

    public String getLastName()
    {
        return prop.getProperty("lastname");
    }

    public String getEmail()
    {
        return prop.getProperty("email");
    }

    public boolean isHeadless() {
        return Boolean.parseBoolean(prop.getProperty("headless"));
    }






}
