/**
 * DesUtil.java com.ejie.nbrs.test
 * 
 * Function锛� TODO
 * 
 * ver date author 鈹�鈹�鈹�鈹�鈹�鈹�鈹�鈹�鈹�鈹�鈹�鈹�鈹�鈹�鈹�鈹�鈹�鈹�鈹�鈹�鈹�鈹�鈹�鈹�鈹�鈹�鈹�鈹�鈹�鈹�鈹�鈹�鈹�鈹� ver1.1 2017骞�7鏈�17鏃� torreswang
 * 
 * Copyright (c) 2017, EJie All Rights Reserved.
 */

package com.ejie.nbrs.util;

/**
 * ClassName:des 鍔犺В瀵嗗伐鍏风被
 * 
 * @author torreswang
 * @version
 * @since Ver 1.1
 * @Date 2017骞�7鏈�17鏃� 涓嬪崍2:13:50
 * @see
 */
import java.io.IOException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class TdesUtil {

  private final static String DES = "DES";
  private final static String TKEY = "!Q@W3e4rqwe321";

  public static void main(String[] args) throws Exception {
    String data = "98EMHytNpbc=";
    String key = "!Q@W3e4rqwe321";
    System.err.println(encrypt(data, key));
    System.err.println(decrypt(data, key));
    // System.err.println(encrypt("1234"));
  }

  /**
   * Description 鏍规嵁閿�艰繘琛屽姞瀵�
   * 
   * @param data
   * @param key 鍔犲瘑閿産yte鏁扮粍
   * @return
   * @throws Exception
   */
  public static String encrypt(String data, String key) throws Exception {
    byte[] bt = encrypt(data.getBytes(), key.getBytes());
    String strs = new BASE64Encoder().encode(bt);
    return strs;
  }

  /**
   * Description 鏍规嵁閿�艰繘琛屽姞瀵�
   * 
   * @param data
   * @return
   * @throws Exception
   */
  public static String encrypt(String data) throws Exception {
    byte[] bt = encrypt(data.getBytes(), TKEY.getBytes());
    String strs = new BASE64Encoder().encode(bt);
    return strs;
  }

  /**
   * Description 鏍规嵁閿�艰繘琛岃В瀵�
   * 
   * @param data
   * @param key 鍔犲瘑閿産yte鏁扮粍
   * @return
   * @throws IOException
   * @throws Exception
   */
  public static String decrypt(String data) throws IOException, Exception {
    if (data == null) {
      return null;
    }
    BASE64Decoder decoder = new BASE64Decoder();
    byte[] buf = decoder.decodeBuffer(data);
    byte[] bt = decrypt(buf, TKEY.getBytes());
    return new String(bt);
  }-

  /**
   * Description 鏍规嵁閿�艰繘琛岃В瀵�
   * 
   * @param data
   * @param key 鍔犲瘑閿産yte鏁扮粍
   * @return
   * @throws IOException
   * @throws Exception
   */
  public static String decrypt(String data, String key) throws IOException, Exception {
    if (data == null) {
      return null;
    }
    BASE64Decoder decoder = new BASE64Decoder();
    byte[] buf = decoder.decodeBuffer(data);
    byte[] bt = decrypt(buf, key.getBytes());
    return new String(bt);
  }

  /**
   * Description 鏍规嵁閿�艰繘琛屽姞瀵�
   * 
   * @param data
   * @param key 鍔犲瘑閿産yte鏁扮粍
   * @return
   * @throws Exception
   */
  private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
    // 鐢熸垚涓�涓彲淇′换鐨勯殢鏈烘暟婧�
    SecureRandom sr = new SecureRandom();

    // 浠庡師濮嬪瘑閽ユ暟鎹垱寤篋ESKeySpec瀵硅薄
    DESKeySpec dks = new DESKeySpec(key);

    // 鍒涘缓涓�涓瘑閽ュ伐鍘傦紝鐒跺悗鐢ㄥ畠鎶奃ESKeySpec杞崲鎴怱ecretKey瀵硅薄
    SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
    SecretKey securekey = keyFactory.generateSecret(dks);

    // Cipher瀵硅薄瀹為檯瀹屾垚鍔犲瘑鎿嶄綔
    Cipher cipher = Cipher.getInstance(DES);

    // 鐢ㄥ瘑閽ュ垵濮嬪寲Cipher瀵硅薄
    cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);

    return cipher.doFinal(data);
  }


  /**
   * Description 鏍规嵁閿�艰繘琛岃В瀵�
   * 
   * @param data
   * @param key 鍔犲瘑閿産yte鏁扮粍
   * @return
   * @throws Exception
   */
  private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
    // 鐢熸垚涓�涓彲淇′换鐨勯殢鏈烘暟婧�
    SecureRandom sr = new SecureRandom();

    // 浠庡師濮嬪瘑閽ユ暟鎹垱寤篋ESKeySpec瀵硅薄
    DESKeySpec dks = new DESKeySpec(key);

    // 鍒涘缓涓�涓瘑閽ュ伐鍘傦紝鐒跺悗鐢ㄥ畠鎶奃ESKeySpec杞崲鎴怱ecretKey瀵硅薄
    SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
    SecretKey securekey = keyFactory.generateSecret(dks);

    // Cipher瀵硅薄瀹為檯瀹屾垚瑙ｅ瘑鎿嶄綔
    Cipher cipher = Cipher.getInstance(DES);

    // 鐢ㄥ瘑閽ュ垵濮嬪寲Cipher瀵硅薄
    cipher.init(Cipher.DECRYPT_MODE, securekey, sr);

    return cipher.doFinal(data);
  }
}
