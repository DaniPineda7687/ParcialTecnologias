package infrastructure;

public class DbFactory {

    private static DbFactory db;
    private final ReaderConfiguration readerConfiguration;
    private DbFactory(ReaderConfiguration readerConfiguration){
        this.readerConfiguration = readerConfiguration;
    }

    public static DbFactory getDbInstance(ReaderConfiguration readerConfiguration){
        if(db == null){
            db = new DbFactory(readerConfiguration);
        }
        return db;
    }

    public DbConnection createDbConnection() throws Exception {
        
        String dbSelected = readerConfiguration.getDbSelected();
        DbConfiguration dbConfiguration = readerConfiguration.getDatabaseConfiguration(dbSelected);
        if(dbSelected.equals("postgres")){
            return DbPostgreSQL.getDbPostgreSQL(dbConfiguration);
        }else if(dbSelected.equals("mysql")){
            return DbMySQL.getDbMySQL(dbConfiguration);
        }else{
            throw new Exception("Base de datos no reconocida");
        }
    }



}
