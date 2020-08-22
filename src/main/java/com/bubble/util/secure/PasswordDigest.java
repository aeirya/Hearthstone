package com.bubble.util.secure;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class PasswordDigest {

    private MessageDigest sha;

    public void reset() {
        sha = sha();
    }

    public String generatePassword(String username, String password) {
        reset();
        updateSha(password);
        updateSha(username);
        return base64Encode(sha.digest());
    }

    private String base64Encode(byte[] hash) {
        return new String(Base64.getEncoder().encode(hash));
    }
    
    private void updateSha(String string) {
        sha.update(getUTFByte(string));
    }

    private byte[] getUTFByte(String string) {
        return string.getBytes(StandardCharsets.UTF_8);
    }

    private MessageDigest sha() {
        try {
            return MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            //
        }
        return null;
    }
}