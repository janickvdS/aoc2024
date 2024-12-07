package org.example.day04;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class Koordinate {
  int x;
  int y;
}
