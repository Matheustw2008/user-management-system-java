package util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public final class HashUtil {

    private HashUtil() {}

    public static String gerarHash(String valor) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(valor.getBytes(StandardCharsets.UTF_8));

            StringBuilder hex = new StringBuilder();
            for (byte b : hash) {
                hex.append(String.format("%02x", b));
            }
            return hex.toString();

        } catch (Exception e) {
            throw new IllegalStateException("Erro ao gerar hash");
        }
    }
}
