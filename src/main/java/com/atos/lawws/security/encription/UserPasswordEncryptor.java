/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atos.lawws.security.encription;

import javax.annotation.PostConstruct;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;

/**
 *
 * @author a637201
 */
@Component
public class UserPasswordEncryptor implements AttributeConverter<String, String> {

    protected static final String SECRET_KEY_1 = "ssdkF$HUy2A#D%kd";
    protected static final String SECRET_KEY_2 = "weJiSEvR5yAC5ftB";
 
    protected IvParameterSpec ivParameterSpec;
    protected SecretKeySpec secretKeySpec;
    protected Cipher cipher;
    
    @PostConstruct
    public void init() {
        try {
            ivParameterSpec = new IvParameterSpec(SECRET_KEY_1.getBytes("UTF-8"));
            secretKeySpec = new SecretKeySpec(SECRET_KEY_2.getBytes("UTF-8"), "AES");
            cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        } catch (Exception e) {            
        }
    }    
    
    @Override
    public String convertToDatabaseColumn(String attribute) {
        try {
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
            byte[] encrypted = cipher.doFinal(attribute.getBytes());
            return Base64.encodeBase64String(encrypted);
        } catch (Exception e) {
        }
        return attribute;
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        try {
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
            byte[] decryptedBytes = cipher.doFinal(Base64.decodeBase64(dbData));
            return new String(decryptedBytes);
        } catch (Exception e) {
        }
        return dbData;
    }
    
}
