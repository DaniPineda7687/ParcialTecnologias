package services;

import java.util.List;

public interface TableOperations <T>{
    public List<T> getUnion(String firstTable,String SecondTable);
    public List<T> getDifference(String firstTable,String SecondTable);
}
