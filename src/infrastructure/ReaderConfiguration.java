package infrastructure;

import javax.swing.filechooser.FileSystemView;

public abstract class ReaderConfiguration {

    protected String configurationPath = FileSystemView.getFileSystemView().getHomeDirectory().getPath() +  "/ConfigurationTA/";

    public abstract String getDbSelected();
    public abstract DbConfiguration getDatabaseConfiguration(String databaseType);
}
