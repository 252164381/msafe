import java.util.Base64;
public class XORBase64 {
    // 定义 XOR 加密函数
    public static String xorEncrypt(String input, String key) {
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            encrypted.append((char) (input.charAt(i) ^ key.charAt(i % key.length())));
        }
        return encrypted.toString();
    }
    public static void main(String[] args) {
        // 要加密的原始字符串
        String originalString = "Hello, world!";
        // 密钥
        String key = "<私钥>";
        // 对原始字符串进行 XOR 加密
        String encryptedString = xorEncrypt(originalString, key);
        System.out.println("Encrypted: " + encryptedString);
        // 将加密后的字符串进行 Base64 编码
        String base64EncodedString = Base64.getEncoder().encodeToString(encryptedString.getBytes());
        System.out.println("Base64 Encoded: " + base64EncodedString);
    }
}
