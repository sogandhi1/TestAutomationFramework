package com.automationS;

public class ConfigurationException extends RuntimeException {

    String exceptionMessage;
    String cause;

    public ConfigurationException(String Message) {
        this.cause = Message;
    }

    public String toString() {
        exceptionMessage = "Error in configuration file. Pls check the file for any errors/invalid Input";
        exceptionMessage += "Exception occured due to: " + this.cause;
        return exceptionMessage;
    }
}
