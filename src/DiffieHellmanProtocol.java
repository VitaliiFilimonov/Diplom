import java.math.*;

public class DiffieHellmanProtocol {
    public static BigInteger generatePartialKey(BigInteger k_public1, int k_private, BigInteger k_public2){ // генерация частичного ключа
        BigInteger partialKey = k_public1.pow(k_private);
        partialKey = partialKey.mod(k_public2);
        return partialKey;
    }

    public static BigInteger generateFullKey(BigInteger k_partial, int k_private, BigInteger k_public){
        BigInteger fullkey = k_partial.pow(k_private);
        fullkey = fullkey.mod(k_public);
        return fullkey;
    }

    public static StringBuilder encryptMessage(BigInteger fullKey, String message){
        int key = fullKey.intValue();
        StringBuilder encryptedMessage = new StringBuilder();
        int count = 0;
        for (char c: message.toCharArray()){
            encryptedMessage.append((char)(c + key));
            //System.out.println(encryptedMessage);
//            if (count != (message.toCharArray().length-1)){
//                encryptedMessage.append('-');
//            }
            count++;
        }
        return encryptedMessage;
    }

    public static StringBuilder decryptMessage(BigInteger fullKey, String encryptedMessage){
        int key = fullKey.intValue();
        StringBuilder decryptedMessage = new StringBuilder();
        for (char c: encryptedMessage.toCharArray()){
            decryptedMessage.append((char)(c - key));
        }
//        String[] str = encryptedMessage.split("-");
//        for (String s1: str){
//            System.out.print(s1 + ",");
//        }
//        for (String s: str){
//            decryptedMessage.append(Integer.parseInt(s) - key);
//        }
        return decryptedMessage;
    }
}
