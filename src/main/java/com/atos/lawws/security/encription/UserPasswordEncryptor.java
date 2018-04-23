/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.security.encription;

import java.nio.charset.StandardCharsets;
import javax.annotation.PostConstruct;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.AttributeConverter;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;

/**
 *
 * @author a637201
 */
@Component
public class UserPasswordEncryptor implements AttributeConverter<String, String> {

    protected static SecretKeySpec secretKey;
    protected static Cipher cipher;
    protected static final String SECRET = "ADBSJHJS12547896";
    protected static final String ALGORITHM = "AES";
    
    public UserPasswordEncryptor() {
    }
    
    @PostConstruct
    public void init() {
        try {
            secretKey = new SecretKeySpec(SECRET.getBytes(), ALGORITHM);
            cipher = Cipher.getInstance(ALGORITHM);
        } catch (Exception e) {            
        }
    }    
    
    @Override
    public String convertToDatabaseColumn(String attribute) {
        try {            
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedVal = cipher.doFinal(attribute.getBytes());
            byte[] encodedValue = new Base64().encode(encryptedVal);
            return new String(encodedValue, "UTF-8");  
        } catch (Exception e) {
        }
        return attribute;
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        try {          
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decodedValue = new Base64().decode(dbData.getBytes("UTF-8"));
            byte[] decryptedVal = cipher.doFinal(decodedValue);
            return new String(decryptedVal);
        } catch (Exception e) {
        }
        return dbData;
    }

    public SecretKeySpec getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(SecretKeySpec secretKey) {
        secretKey = secretKey;
    }

    public Cipher getCipher() {
        return cipher;
    }

    public void setCipher(Cipher cipher) {
        cipher = cipher;
    }
    
}
