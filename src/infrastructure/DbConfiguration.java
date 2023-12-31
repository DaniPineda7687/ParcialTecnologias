package infrastructure;

public class DbConfiguration {
    private String username;
    private String password;
    private int port;
    private String databaseName;
    private String host;

    public DbConfiguration(String username, String password, int port, String databaseName, String host) {
        this.username = username;
        this.password = password;
        this.port = port;
        this.databaseName = databaseName;
        this.host = host;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getPort() {
        return port;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
