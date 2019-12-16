package ru.nsu.flowerstore;

import java.sql.*;

public class DataBaseImpl implements DataBase {

    public Data getData() throws SQLException, ClassNotFoundException {
        Data data = null;
        try{
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://remotemysql.com:3306/nbd7TAXbxf";
        String user = "nbd7TAXbxf";
        String password = "9SSWe2taFx";
        Connection con = DriverManager.getConnection(url,user,password);
        try {
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM `Admin` WHERE id=(SELECT MAX(id) FROM `Admin`)";
            ResultSet resultSet = stmt.executeQuery(query);
            resultSet.next();
            String minSum = String.valueOf(resultSet.getInt(2));
            String maxSum = String.valueOf(resultSet.getInt(3));
            String minTime = String.valueOf(resultSet.getInt(4));
            String maxTime = String.valueOf(resultSet.getInt(5));
            String rate = String.valueOf(resultSet.getDouble(6));
            data = new Data(minSum, maxSum, minTime, maxTime, rate);
            stmt.close();
        }finally {
            con.close();
        }
        }catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }


    public void changeData(Data data) throws SQLException, ClassNotFoundException {

        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://remotemysql.com:3306/nbd7TAXbxf";
            String user = "nbd7TAXbxf";
            String password = "9SSWe2taFx";
            Connection con = DriverManager.getConnection(url,user,password);
            try {
                Statement stmt = con.createStatement();
                String update = "INSERT INTO `Admin` (`minSum`, `maxSum`, `minTime`, `maxTime`, `rate`) VALUES " + data.toSql();
                stmt.execute(update);
                stmt.close();
            } finally {
                con.close();
            }
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }

    }


}