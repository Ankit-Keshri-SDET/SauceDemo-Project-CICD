package utils;

import constants.EnvType;
import java.util.Properties;

public class ConfigLoader {
    private final Properties properties;
    private static ConfigLoader configLoader;

    private ConfigLoader() {
        String env = System.getProperty("env", String.valueOf(EnvType.ROBINQA));
        switch (env) {
            case "DEVTEST1":
                properties = PropertyUtils.propertyLoader("src/test/resources/devtest1_config.properties");
                break;
            case "ALFRED":
                properties = PropertyUtils.propertyLoader("src/test/resources/alfred_config.properties");
                break;
            case "ROBINQA":
                properties = PropertyUtils.propertyLoader("src/test/resources/robinqa_config.properties");
                break;
            case "UAT":
                properties = PropertyUtils.propertyLoader("src/test/resources/uat_config.properties");
                break;
            case "PROD":
                properties = PropertyUtils.propertyLoader("src/test/resources/prod_config.properties");
                break;
            default:
                throw new IllegalArgumentException("INVALID ENVIRONMENT TYPE " + env);
        }
    }

    public static ConfigLoader getInstance() {
        if (configLoader == null) {
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public String getBaseUrl() {
        String prop = properties.getProperty("baseURL");
        if (prop != null)
            return prop;
        else throw new RuntimeException("property baseUrl is not specified in the file");
    }

    public String getUsername1() {
        String prop = properties.getProperty("userName1");
        if (prop != null)
            return prop;
        else throw new RuntimeException("property username1 is not specified in the file");
    }

    public String getUsername2() {
        String prop = properties.getProperty("userName2");
        if (prop != null)
            return prop;
        else throw new RuntimeException("property username2 is not specified in the file");
    }

    public String getUsername3() {
        String prop = properties.getProperty("userName3");
        if (prop != null)
            return prop;
        else throw new RuntimeException("property username3 is not specified in the file");
    }

    public String getUsername4() {
        String prop = properties.getProperty("userName4");
        if (prop != null)
            return prop;
        else throw new RuntimeException("property username4 is not specified in the file");
    }

    public String getPassword() {
        String prop = properties.getProperty("password");
        if (prop != null)
            return prop;
        else throw new RuntimeException("property password is not specified in the file");
    }

    public String getFirstName() {
        String prop = properties.getProperty("firstName");
        if (prop != null)
            return prop;
        else throw new RuntimeException("property firstName is not specified in the file");
    }

    public String getLastName() {
        String prop = properties.getProperty("lastName");
        if (prop != null)
            return prop;
        else throw new RuntimeException("property lastName is not specified in the file");
    }

    public String getZipCode() {
        String prop = properties.getProperty("zipCode");
        if (prop != null)
            return prop;
        else throw new RuntimeException("property zipCode is not specified in the file");
    }

    public String getProductName() {
        String prop = properties.getProperty("productName");
        if (prop != null)
            return prop;
        else throw new RuntimeException("property productName is not specified in the file");
    }
}
