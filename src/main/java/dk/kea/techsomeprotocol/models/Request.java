package dk.kea.techsomeprotocol.models;

public class Request {

    public String method;
    public String srcEmail;
    public String srcHost;
    public String desEmail;
    public String desHost;
    public Double version;

    @Override
    public String toString() {
        return "Request{" +
                "method='" + method + '\'' +
                ", srcEmail='" + srcEmail + '\'' +
                ", srcHost='" + srcHost + '\'' +
                ", desEmail='" + desEmail + '\'' +
                ", desHost='" + desHost + '\'' +
                ", version=" + version +
                '}';
    }
}

