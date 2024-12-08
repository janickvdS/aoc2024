package org.example.day06;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.example.Utils;
import org.example.day04.Koordinate;

public class Day06 {
  public int partOne(String input){
    char[][] map = refactorInput(input);
    Koordinate start = findStart(map);

    Map<Koordinate, Boolean> visited = new HashMap<>();

    Cursor cursor = new Cursor(start.getX(),start.getY());

    while(cursor.isInMap(map)){
      visited.put(new Koordinate(cursor.getX(),cursor.getY()),true);
      cursor.move(map);
    };

    return visited.size();
  }

  public int partTwo(String input){
    char[][] originalMap = refactorInput(input);
    Koordinate start = findStart(originalMap);


    int countOfLoops = 0;
    for(int yPosition = 0; yPosition < originalMap.length; yPosition++){
      for(int xPosition = 0; xPosition < originalMap[yPosition].length; xPosition++){

        if(originalMap[yPosition][xPosition] == '.' ){
          char[][] updatedMap = deepCopy(originalMap);
          Map<Koordinate,CursorSymbol> visited = new HashMap<>();
//          System.out.format("Blocker in x %s y %s \n", xPosition, yPosition);
          updatedMap[yPosition][xPosition] = '#';

          Cursor cursor = new Cursor(start.getX(),start.getY());

          while(cursor.isInMap(updatedMap)){
            visited.put(cursor.getKoordinate(),cursor.getSymbol());
            if(cursor.wasCursorInNextSpotAlready(updatedMap, visited)){
//              System.out.format("Loop wenn x %s y %s \n", xPosition, yPosition);
//              System.out.println(Arrays.deepToString(updatedMap));
              countOfLoops++;
              break;
            }
            cursor.move(updatedMap);
          };
        }


      }
    }

    return countOfLoops;
  }

  public static char[][] deepCopy(char[][] original) {
    if (original == null) {
      return null;
    }

    char[][] copy = new char[original.length][];

    for (int i = 0; i < original.length; i++) {
      // Kopiere jede Sub-Array für eine tiefe Kopie
      copy[i] = new char[original[i].length];
      System.arraycopy(original[i], 0, copy[i], 0, original[i].length);
    }

    return copy;
  }

  private boolean isPositionStart(Koordinate startPosition, int x, int y){
    return startPosition.getX() == x && startPosition.getY() == y;
  }

  Koordinate findStart(char[][] map){
    for(int y = 0; y < map.length; y++){
      for(int x = 0; x < map[y].length; x++){
        if(map[y][x] == '^'){
          return new Koordinate(x,y);
        }
      }
    }
    throw new Error("No start found");
  }

  char[][] refactorInput(String input){
    return Arrays.stream(Utils.splitByRow(input)).map(String::toCharArray).toArray(char[][]::new);
  }
}
