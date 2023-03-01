public class ConfigurationException extends RuntimeException{
    String cause;
    public ConfigurationException(String cause){
        this.cause = cause;
    }
String exceptionMessage;
    public String toString() {
        exceptionMessage = "Error in configuration file. please check the file for any errors/invalid input.";
                exceptionMessage += "Error occured due to " + cause;
        return exceptionMessage;

    }
}
