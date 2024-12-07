package org.example.day01;

import static org.assertj.core.api.Assertions.assertThat;

import org.example.InputType;
import org.example.Utils;
import org.junit.jupiter.api.Test;

class Day01Test {

  Day01 day = new Day01();
  String packageName = "day01";

  @Test
  void examplePart1() {
    String input = Utils.getInput(packageName, InputType.EXAMPLE);

    assertThat(day.partOne(input)).isEqualTo(11);
  }

  @Test
  void realPart1() {
    String input = Utils.getInput(packageName, InputType.REAL);

    assertThat(day.partOne(input)).isEqualTo(1651298);
  }

  @Test
  void examplePart2() {
    String input = Utils.getInput(packageName, InputType.EXAMPLE);

    assertThat(day.partTwo(input)).isEqualTo(21306195L);
  }

  @Test
  void realPart2() {
    String input = Utils.getInput(packageName, InputType.REAL);

    assertThat(day.partTwo(input)).isEqualTo(1651298);
  }
}