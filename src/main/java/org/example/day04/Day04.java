package org.example.day04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.example.Utils;

public class Day04 {
  public int partOne(String input){
    Map<Koordinate, Character> charMap = refactorInput(input);
    List<Koordinate> allX = findAllX(input);
    int xmasCount = 0;

    for(Koordinate koordinateX : allX){
      List<Koordinate> possibleMs = lookForM(charMap,koordinateX);
      for(Koordinate koordinateM : possibleMs){
        int diffX = koordinateM.getX() - koordinateX.getX();
        int diffY = koordinateM.getY() - koordinateX.getY();
        int xA = koordinateM.getX()+diffX;
        int yA = koordinateM.getY()+diffY;
        Koordinate koordinateA = new Koordinate(xA,yA);
        if(charMap.containsKey(koordinateA) && charMap.get(koordinateA) == 'A'){
          int xS = xA + diffX;
          int yS = yA + diffY;
          Koordinate koordinateS = new Koordinate(xS,yS);
          if(charMap.containsKey(koordinateS) && charMap.get(koordinateS) == 'S'){
            xmasCount++;
          }
        }
      }
    }

    return xmasCount;

  }

  public int partTwo(String input){
    return 0;
  }

  List<Koordinate> lookForM(Map<Koordinate,Character> input, Koordinate koordinateX) {
    int x = koordinateX.getX();
    int y = koordinateX.getY();

    List<Koordinate> foundMs = new ArrayList<>();
    List<Koordinate> possibilities = List.of(
            new Koordinate(x - 1, y - 1),new Koordinate(x, y - 1),
            new Koordinate(x +1, y - 1),new Koordinate(x - 1, y),new Koordinate(x +1, y),
            new Koordinate(x - 1, y + 1),new Koordinate(x, y + 1),new Koordinate(x +1, y + 1));

    for(Koordinate koordinate : possibilities){
      if(input.containsKey(koordinate) && input.get(koordinate) == 'M'){
        foundMs.add(koordinate);
      }
    }
    return foundMs;
}

  List<Koordinate> findAllX(String input){
    List<Koordinate> result = new ArrayList<>();
    String[] splitByRow = Utils.splitByRow(input);
    for (int y = 0; y < splitByRow.length; y++) {
      for(int x = 0; x < splitByRow[y].length(); x++){
        if(splitByRow[y].charAt(x) == 'X'){
          result.add(new Koordinate(x,y));
        }
      }
    }
    return result;
  }


  Map<Koordinate, Character> refactorInput(String input){
    String[] splitByRow = Utils.splitByRow(input);

    Map<Koordinate,Character> result = new HashMap<>();


    for (int y = 0; y < splitByRow.length; y++) {
      for(int x = 0; x < splitByRow[y].length(); x++){
        result.put(new Koordinate(x,y),splitByRow[y].charAt(x));
      }
    }
    return result;
  }


}
