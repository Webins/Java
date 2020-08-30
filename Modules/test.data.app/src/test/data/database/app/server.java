package test.data.database.app;

public class server {
    private String serverName;
    private String serverIp;

    public String getServerIp() {
        return serverIp;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }
};