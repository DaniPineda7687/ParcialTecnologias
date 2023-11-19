package services;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import infrastructure.DbConfiguration;
import infrastructure.ReaderConfiguration;
import java.io.File;
import java.io.IOException;

public class JSONReader extends ReaderConfiguration {

    @Override
    public String getDbSelected() {
        String dbSelected = "";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(new File(configurationPath + "dbSelected.json"));
            if(jsonNode.get("postgres").asBoolean()){
                dbSelected = "postgres";
            }else if(jsonNode.get("mysql").asBoolean()){
                dbSelected = "mysql";
            }else{
                dbSelected = "";
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return  dbSelected;
    }

    @Override
    public DbConfiguration getDatabaseConfiguration(String databaseType) {
        DbConfiguration dbConfiguration = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(new File(configurationPath + "dbConfiguration.json"));
            JsonNode databaseProperty = jsonNode.get(databaseType);
            if (databaseProperty != null) {
                String user = databaseProperty.get("user").asText();
                String password = databaseProperty.get("password").asText();
                int port = databaseProperty.get("port").asInt();
                String bd = databaseProperty.get("bd").asText();
                String host = databaseProperty.get("host").asText();

                dbConfiguration = new DbConfiguration(user, password, port, bd, host);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return dbConfiguration;
    }
}
