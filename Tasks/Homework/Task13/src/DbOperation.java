import java.sql.*;

/**
 * Created by EVZabinskaya on 04.11.2017.
 */
public class DbOperation{

    static Connection connectSql()  throws SQLException, ClassNotFoundException {
       Class.forName("org.postgresql.Driver");
       String name = "postgres";
       String password = "280710";
       String url = "jdbc:postgresql://localhost:5432/Zabinskaya_db";
       Connection connection = DriverManager.getConnection(url, name, password);
       return connection;
   }

    public static void  addOwner(String ownerName,int height,int age) throws SQLException, ClassNotFoundException {
        Connection connection = connectSql();
        PreparedStatement preparedStatement = connection
                .prepareStatement("INSERT INTO owner(name,height,age) VALUES (?, ?, ?)");
        preparedStatement.setString(1, ownerName);
        preparedStatement.setInt(2, height);
        preparedStatement.setInt(3, age);
        preparedStatement.execute();
    }

    public static void  addCar(String number,String model,String color) throws SQLException, ClassNotFoundException {
        Connection connection = connectSql();
        PreparedStatement preparedStatement = connection
                .prepareStatement("INSERT INTO car(number,model,color) VALUES (?, ?, ?)");
        preparedStatement.setString(1, number);
        preparedStatement.setString(2, model);
        preparedStatement.setString(3, color);
        preparedStatement.execute();
    }

    public static void  showOwner() throws SQLException, ClassNotFoundException {
        Connection connection = connectSql();
        PreparedStatement preparedStatement = connection
                .prepareStatement("SELECT * FROM owner");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            System.out.print(rs.getInt("id"));
            System.out.println(" " + rs.getString("name") + " " + rs.getInt("height") + " " + rs.getInt("age"));
        }
    }

    public static void  showCar() throws SQLException, ClassNotFoundException {
        Connection connection = connectSql();
        PreparedStatement preparedStatement = connection
                .prepareStatement("SELECT * FROM car");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            System.out.print(rs.getInt("id"));
            System.out.println(" " + rs.getString("number") + " " + rs.getString("model") + " " + rs.getString("color"));
        }
    }

    public static void  showOwnerCar(String ownerName) throws SQLException, ClassNotFoundException {
        Connection connection = connectSql();
        PreparedStatement preparedStatement = connection
                .prepareStatement("SELECT car.* FROM car JOIN " +
                        "owner ON owner.id = car.owner_id " +
                        "WHERE owner.name = ?");
        preparedStatement.setString(1, ownerName);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            System.out.print(rs.getInt("id"));
            System.out.println(" " + rs.getString("number") + " " + rs.getString("model") + " " + rs.getString("color"));
        }
    }

    public static void  showColorCar(String color) throws SQLException, ClassNotFoundException {
        Connection connection = connectSql();
        PreparedStatement preparedStatement = connection
                .prepareStatement("SELECT * FROM car WHERE color = ?");
        preparedStatement.setString(1, color);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            System.out.print(rs.getInt("id"));
            System.out.println(" " + rs.getString("number") + " " + rs.getString("model") + " " + rs.getString("color"));
        }
    }
}
