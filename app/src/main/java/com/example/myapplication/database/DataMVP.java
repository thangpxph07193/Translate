package com.example.myapplication.database;

import java.io.IOException;
import java.sql.SQLException;

public interface DataMVP {
    boolean checkDataBase();
    void createDataBase();
    void copyDataBase() throws IOException;
    boolean openDataBase() throws SQLException;
}
