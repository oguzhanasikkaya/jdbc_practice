package jdbcTests;

import java.sql.*;

public class TestConnection {

    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@54.196.128.118:1521:XE";
        String username = "hr";
        String password = "hr";

        try {
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(("select * from employees"));
/*
            //next()--> move pointer to first row
            resultSet.next();

            //getting information with column name
            System.out.println(resultSet.getString("region_name"));
            System.out.println(resultSet.getString(2));

            //1- Europe
            //2- America

            System.out.println( resultSet.getInt(1)+" - "+ resultSet.getString(2)  );
            //move to second row
            resultSet.next();
            System.out.println( resultSet.getInt(1)+" - "+ resultSet.getString(2)  );
            //move to third row
            resultSet.next();
            System.out.println( resultSet.getInt(1)+" - "+ resultSet.getString(2)  );
            */
            while(resultSet.next()){
                System.out.println( resultSet.getInt(1)+" - "+ resultSet.getString(2)  );

            }


            //CLOSE CONNECTION
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
