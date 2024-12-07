package org.example.day04;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.example.InputType;
import org.example.Utils;
import org.example.day03.Day03;
import org.junit.jupiter.api.Test;

class Day04Test {
  Day04 day = new Day04();
  String packageName = "day04";

  @Test
  void examplePart1() {
    String input = Utils.getInput(packageName, InputType.EXAMPLE);

    assertThat(day.partOne(input)).isEqualTo(18);
  }

  @Test
  void realPart1() {
    String input = Utils.getInput(packageName, InputType.REAL);

    assertThat(day.partOne(input)).isEqualTo(2514);
  }

  @Test
  void examplePart2() {
    String input = Utils.getInput(packageName, InputType.EXAMPLE);

    assertThat(day.partTwo(input)).isEqualTo(9);
  }

  @Test
  void realPart2() {
    String input = Utils.getInput(packageName, InputType.REAL);

    assertThat(day.partTwo(input)).isEqualTo(1888);
  }
}