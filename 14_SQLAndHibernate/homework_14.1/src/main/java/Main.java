import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "секретная информация:)";
        try {
            Connection connection = DriverManager.getConnection(url,user,pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet= statement.executeQuery("SELECT course_name AS name, " +
                    "COUNT(*)/MAX(MONTH(subscription_date)) AS average_count_subscriptions" +
                    " FROM PurchaseList WHERE YEAR(subscription_date)=2018 GROUP BY course_name");

//            statement.execute("SELECT p1.course_name AS name, " +
//                    "p1.COUNT(*)/MAX(MONTH(subscription_date)) AS average_count_subscriptions" +
//                    " FROM PurchaseList p1 GROUP BY p1.course_name");

           while (resultSet.next())
            {
                String courseName = resultSet.getString("name" );
                String courseAverageCount = resultSet.getString("average_count_subscriptions" );

                System.out.println(courseName +" - "+ courseAverageCount);
           }
           resultSet.close();
           statement.close();
           connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
