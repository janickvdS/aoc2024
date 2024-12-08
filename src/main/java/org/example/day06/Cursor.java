package org.example.day06;

import java.util.Map;

import org.example.day04.Koordinate;

import lombok.Getter;

@Getter
public class Cursor {

  private int x;
  private int y;
  private CursorSymbol symbol = CursorSymbol.UP;

  Cursor(int x, int y){
    this.x = x;
    this.y = y;
  }

  public void move(char[][] map){
    if(isNextMoveBlocked(map)){
      this.symbol = this.turnRight();
      map[y][x]=CursorSymbol.getTurnSymbol();
    } else {
      map[y][x]=this.symbol.getMovementSymbol();
    }

    this.x+=this.symbol.getXOffset();
    this.y+=this.symbol.getYOffset();
    if(this.isInMap(map)){
      map[y][x]=this.symbol.getSymbol();
    }

  }

  public Koordinate getKoordinate(){
    return new Koordinate(this.x,this.y);
  }

  public boolean isNextMoveBlocked(char[][] map){
    int newX = this.x + this.symbol.getXOffset();
    int newY = this.y + this.symbol.getYOffset();

    return isPositionInMap(map, newX, newY) && map[newY][newX] == '#';
  }

  public boolean wasCursorInNextSpotAlready(char[][] map, Map<Koordinate,CursorSymbol> visited){
    CursorSymbol symbol = this.symbol;

    if (isNextMoveBlocked(map)) {
      symbol  = this.turnRight();
    }

      int newX = this.x + symbol .getXOffset();
      int newY = this.y + symbol .getYOffset();
      Koordinate koordinate = new Koordinate(newX,newY);
      return isPositionInMap(map, newX, newY) && visited.containsKey(koordinate) && visited.get(koordinate) == symbol ;

  }

  private boolean isPositionInMap(char[][] map, int x, int y){
    return y >= 0 && x >= 0 && y != map.length && x != map[y].length;
  }

  public boolean isInMap (char[][] map){
    return isPositionInMap(map, this.x, this.y);
  }

  protected CursorSymbol turnRight(){
    return switch (this.symbol){
      case UP -> CursorSymbol.RIGHT;
      case RIGHT -> CursorSymbol.DOWN;
      case DOWN -> CursorSymbol.LEFT;
      case LEFT -> CursorSymbol.UP;
    };
  }

}
