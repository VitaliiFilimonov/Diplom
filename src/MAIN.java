import java.util.*;
import java.math.*;
import java.sql.*;

public class MAIN {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");

        /**  _____________________________________________DifH test **/

//        BigInteger a_public = new BigInteger("197"); // g
//        int a_private = 199; // a
//        BigInteger b_public = new BigInteger("151"); // p
//        int b_private = 157; // b
//
//        System.out.println("a_public = " + a_public + ", b_public = " + b_public);
//        System.out.println("a_private = " + a_private + ", b_private = " + b_private);
//
//        BigInteger a_partial, b_partial;
//
//        {
//            a_partial = DiffieHellmanProtocol.generatePartialKey(a_public, a_private, b_public); // A
//            b_partial = DiffieHellmanProtocol.generatePartialKey(a_public, b_private, b_public); // B
//        }
//        System.out.println("a_partial = " + a_partial + ", b_partial =  " + b_partial);
//
//        BigInteger a_fullkey, b_fullkey;
//        {
//            a_fullkey = DiffieHellmanProtocol.generateFullKey(b_partial, a_private, b_public); // s
//            b_fullkey = DiffieHellmanProtocol.generateFullKey(a_partial, b_private, b_public); // s
//        }
//        if (a_fullkey.equals(b_fullkey)){
//            System.out.println("Ключ вычислен и равен = " + a_fullkey);
//        }else {
//            System.out.println("Ключи не сошлись, сообщение не дешифровать!");
//        }
//        System.out.println(a_fullkey + " " + b_fullkey);
//
//        String message = "Hello world!";
//        String encodedMessage = DiffieHellmanProtocol.encryptMessage(a_fullkey, message).toString();
//        System.out.println("Сообщение до шифровки: " + message);
//        System.out.println(DiffieHellmanProtocol.encryptMessage(a_fullkey, message));
//        System.out.println(DiffieHellmanProtocol.decryptMessage(a_fullkey, encodedMessage));

        //SQL.connectDB(); // проверка подключения
        //SQL.createTable(); // создание таблицы
        //SQL.dropTable(); // удаление таблицы
        //SQL.insertToTable(); // добавление записи
        //SQL.deleteRows();


        /**  _____________________________________________RSA test **/

        //System.out.println(ElectronicSignatureRSA.eulerFunction(3557, 2579));
        //System.out.println(ElectronicSignatureRSA.getRandomBigInteger());
        //System.out.println(ElectronicSignatureRSA.openExponent(3557, 2579));

        //System.out.println(ElectronicSignatureRSA.secretExponent(new BigInteger("3"), new BigInteger("9167368")));
        //System.out.println(ElectronicSignatureRSA.encodingRSA("hello world", 3557, 2579));
    }
}
