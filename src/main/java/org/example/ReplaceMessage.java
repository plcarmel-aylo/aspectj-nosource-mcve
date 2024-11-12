package org.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReplaceMessage {

  public static void main(String[] args) throws IOException {
    byte[] bytes;
    try (var fis = new FileInputStream(args[0])) {
      bytes = fis.readAllBytes();
    }
    for (var i = 0; i < bytes.length-5; i++) {
      if (bytes[i] == 'H' && bytes[i+1] == 'e' && bytes[i+2] == 'l' && bytes[i+3] == 'l' && bytes[i+4] == 'o') {
        bytes[i] = 'F';
        bytes[i+1] = 'u';
        bytes[i+2] = 'b';
        bytes[i+3] = 'a';
        bytes[i+4] = 'r';
      }
    }
    try (var fos = new FileOutputStream(args[0])) {
      fos.write(bytes);
    }
  }

}
