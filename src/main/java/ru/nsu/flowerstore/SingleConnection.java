//package ru.nsu.flowerstore;
//
//import com.mysql.jdbc.ConnectionImpl;
//import java.sql.*;
//
//public  class SingleConnection extends ConnectionImpl {
//
//    private static Connection instance;
//
//    public static synchronized Connection getInstance() throws ClassNotFoundException, SQLException {
//
//        Connection con = null;
//        try {
//            if (instance == null || instance.isClosed()) {
//                Class.forName("com.mysql.jdbc.Driver");
//                String url = "jdbc:mysql://remotemysql.com:3306/nbd7TAXbxf?useSSL=false";
//                String user = "nbd7TAXbxf";
//                String password = "9SSWe2taFx";
//                instance = DriverManager.getConnection(url,user,password);
//            }
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//        return instance;
//    }
//
//    public void close() throws SQLException {
//        instance.close();
//    }
//
//}

