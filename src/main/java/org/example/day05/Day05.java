package org.example.day05;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.example.Utils;

public class Day05 {
  public int partOne(String input){
    Map<Integer,List<Integer>> rules = getAllRules(input);
    List<List<Integer>> updates = getAllUpdates(input);

    int correctMiddles = 0;

    for(List<Integer> update : updates){
      boolean valid = true;
      for(int i = 0; i < update.size(); i++){
        List<Integer> rule = rules.containsKey(update.get(i)) ? rules.get(update.get(i)): List.of();
        List<Integer> previousNums = update.subList(0, i);
        if(rule.stream().anyMatch(previousNums::contains)){
          valid = false;
          break;
        }
      }
      if(valid){
      correctMiddles+=update.get((update.size() - 1) / 2);
      }
    }

    return correctMiddles;

  }

  public int partTwo(String input){
    Map<Integer,List<Integer>> rules = getAllRules(input);
    Map<Integer,List<Integer>> invertedRules = invertRules(rules);

    List<List<Integer>> updates = getAllUpdates(input);

    List<List<Integer>> incorectUpdates = new ArrayList<>();
    for(List<Integer> update : updates) {
      for (int i = 0; i < update.size(); i++) {
        List<Integer> rule = rules.containsKey(update.get(i)) ? rules.get(update.get(i)) : List.of();
        List<Integer> previousNums = update.subList(0, i);
        if (rule.stream().anyMatch(previousNums::contains)) {
          incorectUpdates.add(update);
          break;
        }
      }
    }

    int correctMiddles = 0;
    for(List<Integer> incorrectUpdate : incorectUpdates){
      List<Integer> correctedUpdate = new ArrayList<>();
      for(int num : incorrectUpdate){
        if(correctedUpdate.isEmpty()){
        correctedUpdate.add(num);
        continue;
        }
        List<Integer> invertedRule = invertedRules.containsKey(num) ?
                invertedRules.get(num) :
                List.of();


        for(int index = 0; index <= correctedUpdate.size(); index++){
          List<Integer> followingNums = correctedUpdate.subList(index, correctedUpdate.size());

          if (invertedRule.stream().noneMatch(followingNums::contains)) {
            correctedUpdate.add(index,num);
            break;
          }
        }
      }
      correctMiddles+=correctedUpdate.get((correctedUpdate.size() - 1) / 2);
    }

    return correctMiddles;
  }
  Map<Integer,List<Integer>> invertRules(Map<Integer,List<Integer>> rules){
    Map<Integer,List<Integer>> invertedRules = new HashMap<>();
    for(int key : rules.keySet()){
      for(int value : rules.get(key)){
        if(invertedRules.containsKey(value)){
          invertedRules.get(value).add(key);
        } else {
          invertedRules.put(value,new ArrayList<>(List.of(key)));
        }
      }
    }
    return invertedRules;
  }


  Map<Integer,List<Integer>> getAllRules(String input){
    Map<Integer,List<Integer>> rules = new HashMap<>();

    String regex = "(\\d+)\\|(\\d+)";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(input);

    while(matcher.find()){
      int left = Integer.parseInt(matcher.group(1));
      int right = Integer.parseInt(matcher.group(2));

      if(rules.containsKey(left)){
        rules.get(left).add(right);
      } else {
        rules.put(left,new ArrayList<>(List.of(right)));
      }

    }
    return rules;
  }

  List<List<Integer>> getAllUpdates(String input){
    List<List<Integer>> rules = new ArrayList<>();

    for(String row: Utils.splitByRow(input)){
      if(row.contains(",")){
        rules.add(Arrays.stream(row.split(",")).map(Integer::parseInt).toList());
      }
    }
    return rules;
  }


}
