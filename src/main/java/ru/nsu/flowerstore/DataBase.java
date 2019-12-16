package ru.nsu.flowerstore;

import java.sql.SQLException;

public interface DataBase {
    public Data getData() throws SQLException, ClassNotFoundException;
    public void changeData(Data date) throws SQLException, ClassNotFoundException;
}
