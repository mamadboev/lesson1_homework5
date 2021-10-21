package config;

import models.List;

import java.sql.*;

public class DbConfig {
   private String url = "jdbc:postgresql://localhost:5432/computer_db";
   private String db_user = "root";
   private String db_password = "s@rdor1997";


   public void getList(String TableName, Double quyi, Double yuqori){
      try {
         Class.forName( "org.postgresql.Driver" );
         Connection connection = DriverManager.getConnection(url,db_user,db_password);
         Statement statement = connection.createStatement();

         String sql = "select product.maker, "+TableName+".model, "+TableName+".price from "+TableName+
                 " join product on product.model="+TableName+".model "+
                 " where "+TableName+".price between "+quyi+" and "+yuqori+
                 "order by "+TableName+".price";

         ResultSet resultSet = statement.executeQuery(sql);
         if(resultSet.next()){
         while(resultSet.next()){
            String maker = resultSet.getString(1);
            String model = resultSet.getString(2);
            String price = resultSet.getString(3);
            List list = new List(maker, model, price);
            System.out.println(list);
         }
         }else{
            System.out.println("Ma'lumot topilmadi");
         }
      } catch (SQLException | ClassNotFoundException throwables) {
         throwables.printStackTrace();
      }

   }



}
