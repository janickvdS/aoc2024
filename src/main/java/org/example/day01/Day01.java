package org.example.day01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.example.Utils;

public class Day01 {

  public int partOne(String input){
    LocationLists locationLists = refactorInput(input);

    int distance = 0;
    for(int i= 0; i <locationLists.getLeft().size(); i++){
      int left = locationLists.getLeft().get(i);
      int right = locationLists.getRight().get(i);

      distance+=Math.abs(right - left);
    }
    return distance;
  }

  public long partTwo(String input){
    LocationLists locationLists = refactorInput(input);
    long count = 0;

    for(int i = 0; i < locationLists.getLeft().size(); i++){
      int left = locationLists.getLeft().get(i);
      long countInRightList = locationLists.getRight().stream().filter(right -> left == right).count();
      count +=(countInRightList * left);
    }

    return count;
  }

  private LocationLists refactorInput(String input){
    String[] splitByRow = Utils.splitByRow(input);
    List<Integer> firstTeam = new ArrayList<>();
    List<Integer> secondTeam = new ArrayList<>();

    Arrays.stream(splitByRow).forEach(row -> {
      String[] nums = row.split(" {3}");
      firstTeam.add(Integer.valueOf(nums[0]));
      secondTeam.add(Integer.valueOf(nums[1]));
    });

    firstTeam.sort(Integer::compareTo);
    secondTeam.sort(Integer::compareTo);
    return LocationLists.builder().left(firstTeam).right(secondTeam).build();
  };
}
