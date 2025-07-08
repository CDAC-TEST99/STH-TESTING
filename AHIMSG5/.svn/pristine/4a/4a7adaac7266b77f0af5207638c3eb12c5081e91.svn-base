package hislogin.transactions.utl;

public class XORUtil {

    private static final char SECRET_KEY = 'K'; // Simple XOR key

    public static String xorEncrypt(String data) {
        char[] chars = data.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] ^= SECRET_KEY;
        }
        return new String(chars);
    }

    public static String xorDecrypt(String encryptedData) {
        return xorEncrypt(encryptedData); // XOR operation is symmetric
    }

    public static void main(String[] args) {
        String original = "valid";
        String encrypted = xorEncrypt(original);
        System.out.println("Encrypted: " + encrypted);
        String decrypted = xorDecrypt(encrypted);
        System.out.println("Decrypted: " + decrypted);
    }
}
