package org.example.day02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.example.Utils;

public class Day02 {

  public int partOne(String input){
    List<List<Integer>> rows = refactorInput(input);
    int safeCount = 0;

    for (List<Integer> row : rows) {
      if(this.isRowSafe(row)){
        safeCount++;
      }
    }

    return safeCount;
  }

  public int partTwo(String input){
    List<List<Integer>> rows = refactorInput(input);
    int safeCount = 0;

    for (List<Integer> row : rows) {
      if(isRowSafe(row)){
        safeCount++;
      } else {
        for(int i = 0; i< row.size();i++){
          if(isRowSafe(deleteIndexOfList(row,i))){
            safeCount++;
            break;
          }
        }
      }
    }

    return safeCount;
  }

  List<Integer> deleteIndexOfList(List<Integer> row, int index){
    List<Integer> result = new ArrayList<>(row);
    result.remove(index);
    return result;
  }

  boolean isRowSafe(List<Integer> row){
    Order order = row.get(1) > row.get(0) ? Order.ASC : Order.DESC;
    for (int i = 1; i < row.size(); i++) {
      int firstNum = row.get(i - 1);
      int secondNum = row.get(i);

      int diff = secondNum - firstNum;
      if (!this.isDiffValid(diff) || !this.orderValid(order, diff)) {
        return false;
      }
    }
    return true;
  }

  private boolean orderValid(Order order, int diff) {
    return order == Order.ASC && diff > 0  || order == Order.DESC && diff < 0;
  }

  private boolean isDiffValid(int diff){
    return Math.abs(diff) >= 1 && Math.abs(diff) <= 3;
  }

  private List<List<Integer>> refactorInput(String input){
    String[] splitByRow = Utils.splitByRow(input);
    return Arrays.stream(splitByRow)
            .map(row -> Arrays.stream(row.split(" ")).map(Integer::valueOf).toList())
            .toList();
  };
}
