package org.example.day06;

import java.util.Arrays;

import org.example.Utils;
import org.example.day04.Koordinate;

public class Day06 {
  public int partOne(String input){
    char[][] map = refactorInput(input);
    Koordinate start = findStart(map);

    int x = start.getX();
    int y = start.getY();

    char cursor = '^';

    while(!outOfBound(map,x,y)){
      if(map[y][x] == '^' && !isZielfeldBlocked(map,x,y-1)){
        map[y][x] = 'X';
        y--;
        cursor = '^';
      } else if(map[y][x] == '^' && isZielfeldBlocked(map,x,y-1)){
        map[y][x] = 'X';
        x++;
        cursor = '>';
      } else if(map[y][x] == '>' && !isZielfeldBlocked(map,x +1,y)){
        map[y][x] = 'X';
        x++;
        cursor = '>';
      } else if(map[y][x] == '>' && isZielfeldBlocked(map,x +1,y)){
        map[y][x] = 'X';
        y++;
        cursor = 'v';
      } else if(map[y][x] == 'v' && !isZielfeldBlocked(map,x,y+1)){
        map[y][x] = 'X';
        y++;
        cursor = 'v';
      } else if(map[y][x] == 'v' && isZielfeldBlocked(map,x,y +1)){
        map[y][x] = 'X';
        x--;
        cursor = '<';
      }  else if(map[y][x] == '<' && !isZielfeldBlocked(map,x -1,y)){
        map[y][x] = 'X';
        x--;
        cursor = '<';
      } else if(map[y][x] == '<' && isZielfeldBlocked(map,x -1,y)){
        map[y][x] = 'X';
        y--;
        cursor = '^';
      }

      if(!outOfBound(map,x,y)){
        map[y][x] = cursor;
      }
    }

    return countX(map);
  }

  private boolean isZielfeldBlocked(char[][] map, int x, int y){
    if(!outOfBound(map,x,y)){
      return map[y][x] == '#';
    } else {
      return false;
    }
  }

  private boolean outOfBound(char[][] map, int x, int y){
    return y < 0 || x < 0 || y == map.length || x == map[y].length;
  }

  private int countX(char[][] map){
    int x = 0;
    for (char[] row : map) {
      for (char col : row) {
        if (col == 'X') {
          x++;
        }
      }
    }
    return x;
  }

  public int partTwo(String input){
    return 0;
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
