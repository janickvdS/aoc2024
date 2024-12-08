package org.example.day06;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CursorSymbol {
  UP('^', '|',0, -1),
  DOWN('v', '|',0, 1),
  LEFT('<', '-',-1, 0),
  RIGHT('>', '-',1, 0);

  private final char symbol;
  private final char movementSymbol;
  private final int xOffset;
  private final int yOffset;
  public static char getTurnSymbol(){
    return '+';
  }
}
