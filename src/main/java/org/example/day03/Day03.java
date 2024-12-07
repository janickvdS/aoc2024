package org.example.day03;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day03 {
  public int partOne(String input){
    String regex = "mul\\((-?\\d+),(-?\\d+)\\)";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(input);

    int sum = 0;
    while(matcher.find()){
      System.out.println(matcher.group(1) + "*" + matcher.group(2));
      int result = Integer.parseInt(matcher.group(1)) * Integer.parseInt(matcher.group(2));
      sum+=result;
    }
    return sum;
  }

  public int partTwo(String input){
    String regex = "do\\(\\)|don't\\(\\)|mul\\((-?\\d+),(-?\\d+)\\)";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(input);

    int sum = 0;
    boolean add = true;

    while(matcher.find()){
      if(matcher.group(0).equals("do()")){
        add = true;
      } else if(matcher.group(0).equals("don't()")){
        add = false;
      } else if(add) {
        int result = Integer.parseInt(matcher.group(1)) * Integer.parseInt(matcher.group(2));
        sum+=result;
      }
    }
    return sum;
  }


}
