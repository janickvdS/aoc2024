package org.example;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Utils {

  public static String[] splitByRow(String input){
    return input.split("\n");
  }

  public static String getInput(String packageName, InputType inputType) {
    String fileName = switch (inputType) {
      case EXAMPLE -> "example-input.txt";
      case REAL -> "input.txt";
    };

    String path = "/Users/janickvandersar/IntelliJIDEAProjects/adventOfCode2024/src/main/java/org" +
            "/example/"+ packageName +"/" + fileName;
    String data = "";

    try {
      data = Files.readString(Paths.get(path));
    } catch (Exception ignored) {
      System.out.println("File not found");
    }
    return data;
  }
}
