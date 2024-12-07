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
    Map<Koordinate, Character> charMap = refactorInput(input);
    List<Koordinate> startKoordinaten = findAllDoubleM(input);
    int xmasCount = 0;
    for(Koordinate koordinateM : startKoordinaten){
      Koordinate horizontalM = new Koordinate(koordinateM.getX() +2,koordinateM.getY());
      Koordinate verticalM = new Koordinate(koordinateM.getX(),koordinateM.getY() +2);
      if(charMap.containsKey(horizontalM) && charMap.get(horizontalM) == 'M'){
        Koordinate downA = new Koordinate(koordinateM.getX() +1,koordinateM.getY() +1);
        Koordinate upA = new Koordinate(koordinateM.getX() +1,koordinateM.getY() -1);
        Koordinate leftS;
        Koordinate rightS;
        if(charMap.containsKey(downA) && charMap.get(downA) == 'A') {
          leftS = new Koordinate(downA.getX() - 1, downA.getY() + 1);
          rightS = new Koordinate(downA.getX() + 1, downA.getY() + 1);
          if (charMap.containsKey(leftS) && charMap.get(leftS) == 'S' &&
                  charMap.containsKey(rightS) && charMap.get(rightS) == 'S'
          ) {
            xmasCount++;
          }
        }

        if(charMap.containsKey(upA) && charMap.get(upA) == 'A') {
          leftS = new Koordinate(upA.getX() - 1, upA.getY() - 1);
          rightS = new Koordinate(upA.getX() + 1, upA.getY() - 1);
          if (charMap.containsKey(leftS) && charMap.get(leftS) == 'S' &&
                  charMap.containsKey(rightS) && charMap.get(rightS) == 'S'
          ) {
            xmasCount++;
          }
        }
      }
      if(charMap.containsKey(verticalM) && charMap.get(verticalM) == 'M'){
        Koordinate leftA = new Koordinate(koordinateM.getX() - 1,koordinateM.getY() +1);
        Koordinate rightA = new Koordinate(koordinateM.getX() +1,koordinateM.getY() +1);
        Koordinate upS;
        Koordinate downS;
        if(charMap.containsKey(leftA) && charMap.get(leftA) == 'A') {
          upS = new Koordinate(leftA.getX() - 1, leftA.getY() - 1);
          downS = new Koordinate(leftA.getX() - 1, leftA.getY() + 1);
          if (charMap.containsKey(upS) && charMap.get(upS) == 'S' &&
                  charMap.containsKey(downS) && charMap.get(downS) == 'S'
          ) {
            xmasCount++;
          }
        }

        if(charMap.containsKey(rightA) && charMap.get(rightA) == 'A') {
          upS = new Koordinate(rightA.getX() + 1, rightA.getY() - 1);
          downS = new Koordinate(rightA.getX() + 1, rightA.getY() + 1);
          if (charMap.containsKey(upS) && charMap.get(upS) == 'S' &&
                  charMap.containsKey(downS) && charMap.get(downS) == 'S'
          ) {
            xmasCount++;
          }
        }
      }
    }
    return xmasCount;
  }

  List<Koordinate> findAllDoubleM(String input){
    List<Koordinate> result = new ArrayList<>();
    String[] splitByRow = Utils.splitByRow(input);
    for (int y = 0; y < splitByRow.length; y++) {
      for(int x = 0; x < splitByRow[y].length(); x++){
        try {
          if (splitByRow[y].charAt(x) == 'M' && x+2 < splitByRow[y].length() && splitByRow[y].charAt(x + 2) == 'M') {
            result.add(new Koordinate(x, y));
          } else if (splitByRow[y].charAt(x) == 'M' && y+ 2 < splitByRow.length && splitByRow[y + 2].charAt(x) == 'M') {
            result.add(new Koordinate(x, y));
          }
        } catch (Exception ignored){}
      }
    }
    return result;
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
