import java.math.BigInteger;
import java.sql.*;

public class SQL {
    public static final String url = "jdbc:postgresql://localhost:5432/postgres";
    public static final String username = "";
    public static final String password = "";


    public static void connectDB() throws SQLException, ClassNotFoundException{
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Соединение установлено!");
            Statement statement = null;
            statement = connection.createStatement();
            ResultSet result1 = statement.executeQuery(
                    "SELECT * FROM employee where id > 2 and id < 4");
            while (result1.next()) {
                System.out.println(result1.getInt("id")
                        + "\t" + result1.getString("first_name"));
            }
        } catch (Exception e) {
            System.out.println("Не подключено");
        }
    }

    public static void createTable() throws SQLException, ClassNotFoundException{
        try (Connection connection = DriverManager.getConnection(url, username, password)){
            Statement statement = null;
            statement = connection.createStatement();

            String sql = "CREATE TABLE test " +
                    "(id INTEGER NOT NULL , " +
                    " name_A VARCHAR(255), " +
                    " name_B VARCHAR(255), " +
                    " key_public_A VARCHAR(255), " +
                    " key_public_B VARCHAR(255), " +
                    " key_private_A VARCHAR(255), " +
                    " key_private_B VARCHAR(255), " +
                    " key_partial_A VARCHAR(255), " +
                    " key_partial_B VARCHAR(255), " +
                    " key_full VARCHAR(255), " +
                    " message VARCHAR(255), " +
                    " encoded_message VARCHAR(255), " +
                    " decoded_message VARCHAR(255), " +
                    " PRIMARY KEY(id))";

//            String sql = "CREATE TABLE test " +
//                    "(id INTEGER not NULL, " +
//                    " first VARCHAR(255), " +
//                    " last VARCHAR(255), " +
//                    " age INTEGER, " +
//                    " PRIMARY KEY ( id ))";

            statement.executeUpdate(sql);
            System.out.println("Таблица создана!");
        }catch(Exception e){
            System.out.println("Ошибка");
        }
    }

    public static void dropTable() throws SQLException, ClassNotFoundException{
        try (Connection connection = DriverManager.getConnection(url, username, password)){
            Statement statement = null;
            statement = connection.createStatement();

            String sql = "DROP TABLE test ";
            statement.executeUpdate(sql);
            System.out.println("Таблица удалена!");
        }catch(Exception e){
            System.out.println("Ошибка");
        }
    }

    public static void insertToTable() throws SQLException, ClassNotFoundException{
        try (Connection connection = DriverManager.getConnection(url, username, password)){
            Statement statement = null;
            statement = connection.createStatement();

            //String sql = "INSERT INTO test VALUES (1, 'Alice', 'Bob', '5', '23', '6', '15', '8', '19', '2', 'Hello', 'Jgnnq', 'Hello')";
            String sql = "INSERT INTO test VALUES (2, 'Alice', 'Bob', '5', '23', '6', '15'," + " '" +
                    DiffieHellmanProtocol.generatePartialKey(new BigInteger("5"), 6, new BigInteger("23")).toString() + "' " + ", '19', '2', 'Hello', 'Jgnnq', 'Hello')";
            statement.executeUpdate(sql);
            System.out.println("Данные добавлены!");
        }catch(Exception e){
            System.out.println("Ошибка");
        }
    }

    public static void deleteRows() throws SQLException, ClassNotFoundException{
        try (Connection connection = DriverManager.getConnection(url, username, password)){
            Statement statement = null;
            statement = connection.createStatement();

            String sql = "DELETE FROM  test ";
            statement.executeUpdate(sql);
            System.out.println("Данные удалены!");
        }catch(Exception e){
            System.out.println("Ошибка");
        }
    }
}


