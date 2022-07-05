import java.math.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Random;

public class ElectronicSignatureRSA {
    public static BigInteger multiplyBigInteger(int p, int q){ // произведение
        Integer pI = Integer.valueOf(p);
        Integer qI = Integer.valueOf(q);

        BigInteger bigP = BigInteger.valueOf(pI);
        BigInteger bigQ = BigInteger.valueOf(qI);

        return bigP.multiply(bigQ);
    }
    public static BigInteger eulerFunction(int p, int q){ // функция Эйлера
        Integer pI = Integer.valueOf(p);
        Integer qI = Integer.valueOf(q);

        BigInteger bigP = BigInteger.valueOf(pI);
        BigInteger bigQ = BigInteger.valueOf(qI);

        return bigP.add(new BigInteger("-1")).multiply(bigQ.add(new BigInteger("-1")));
    }

    public static BigInteger getRandomBigInteger(){ // рандомное число
        Random rand = new Random();
        BigInteger result = new BigInteger(20, rand);
        int check1, check2;
        check1 = result.compareTo(new BigInteger("0"));
        check2 = result.compareTo(new BigInteger("1"));

        while (check1 == 0 || check2 == 0){
            result = new BigInteger(20, rand);
            check1 = result.compareTo(new BigInteger("0"));
            check2 = result.compareTo(new BigInteger("1"));
        }
        return result;
    }

    public static BigInteger openExponent(int p, int q){ // открытая экспонента
        BigInteger bigPQ = eulerFunction(p, q);
        BigInteger exp;
        BigInteger check1;
        int check2;
        do {
            exp = getRandomBigInteger();
            check1 = bigPQ.gcd(exp);
            check2 = check1.intValue();
        }
        while (check2 != 1);
        return exp;
    }

    public static BigInteger secretExponent(BigInteger exp, BigInteger phi){ // секретная экспонента
        return exp.modInverse(phi);
    }

    public static BigInteger encodingRSA(String message, int p, int q){
        BigInteger n = multiplyBigInteger(p,q);
        BigInteger phi = eulerFunction(p,q);
        BigInteger exponent = openExponent(p, q);
        BigInteger secretExponent = secretExponent(exponent, phi);

        byte[] bytes = message.getBytes();
        System.out.println(bytesToString(bytes));

        byte[] encrypt = (new BigInteger(bytes)).modPow(exponent, n).toByteArray();
        System.out.println(bytesToString(encrypt));

        byte[] decrypt = (new BigInteger(encrypt)).modPow(secretExponent, n).toByteArray();
        System.out.println(bytesToString(encrypt));

        System.out.println("Текст сообщения: " + new String(decrypt));





//        BigInteger bytesBigInteger = new BigInteger(1, bytesUTF);
//        System.out.println(bytesBigInteger);
//
//        BigInteger b = bytesBigInteger.modPow(exponent, n);
//        System.out.println(b);
//        System.out.println("__________________________________");
//
//        BigInteger m = b.modPow(secretExponent, n);
//        System.out.println(m);
//
//        byte[] array = m.toByteArray();
//        String str = new String(array, StandardCharsets.US_ASCII);
//        System.out.println(str);
//
//
//        String s = new String(bytesUTF, StandardCharsets.US_ASCII);
//        System.out.println(s);

        return new BigInteger("0");
    }

    private static String bytesToString(byte[] array){
        String str = "";
        for (byte b: array){
            str += Byte.toString(b);
        }
        return str;
    }
}
