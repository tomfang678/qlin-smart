package com.qlin.smart.common.secret;

import java.io.IOException;
import java.security.MessageDigest;

public class MD5Encrypt {

  public MD5Encrypt() {

  }

  private final static String[] hexDigits = {
          "0", "1", "2", "3", "4", "5", "6", "7",
          "8", "9", "a", "b", "c", "d", "e", "f"};

  /**
   * 转换字节数组为16进制字串
   * @param b 字节数组
   * @return 16进制字串
   */
  public static String byteArrayToString(byte[] b) {
    StringBuffer resultSb = new StringBuffer();
    for (int i = 0; i < b.length; i++) {
      resultSb.append(byteToHexString(b[i]));//若使用本函数转换则可得到加密结果的16进制表示，即数字字母混合的形式
//      resultSb.append(byteToNumString(b[i]));//使用本函数则返回加密结果的10进制数字字串，即全数字形式
    }
    return resultSb.toString();
  }

  private static String byteToNumString(byte b) {

    int _b = b;
    if (_b < 0) {
      _b = 256 + _b;
    }

    return String.valueOf(_b);
  }

  private static String byteToHexString(byte b) {
    int n = b;
    if (n < 0) {
      n = 256 + n;
    }
    int d1 = n / 16;
    int d2 = n % 16;
    return hexDigits[d1] + hexDigits[d2];
  }

  public static String MD5Encode(String origin) {
    String resultString = null;

    try {
      resultString = new String(origin);
      MessageDigest md = MessageDigest.getInstance("MD5");
      resultString = byteArrayToString(md.digest(resultString.getBytes()));
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
    return resultString;
  }
  /**
   *
   * @param args
   */
  public static void main(String[] args) {
//    MD5Encrypt md5encrypt = new MD5Encrypt();
    System.out.println(MD5Encode("123456"));
  }

  /**
   * Exception that is thrown when an unexpected character is encountered
   * during Base64 decoding.  One could catch this exception and use
   * the unexpected character for some other purpose such as including it
   * with data that comes at the end of a Base64 encoded section of an email
   * message.
   *
   * @author Stephen Ostermiller http://ostermiller.org/contact.pl?regarding=Java+Utilities
   * @since ostermillerutils 1.00.00
   */
  public static class Base64DecodingException extends IOException {
      private char c;

      /**
       * Construct an new exception.
       *
       * @param message message later to be returned by a getMessage() call.
       * @param c character that caused this error.
       *
       * @since ostermillerutils 1.00.00
       */
      public Base64DecodingException(String message, char c){
          super(message);
          this.c = c;
      }

      /**
       * Get the character that caused this error.
       *
       * @return the character that caused this error.
       *
       * @since ostermillerutils 1.00.00
       */
      public char getChar(){
          return c;
      }
  }
}

