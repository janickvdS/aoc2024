package org.example.day02;

import static org.assertj.core.api.Assertions.assertThat;

import org.example.InputType;
import org.example.Utils;
import org.example.day01.Day01;
import org.junit.jupiter.api.Test;

class Day02Test {

  Day02 day = new Day02();
  String packageName = "day02";

  @Test
  void examplePart1() {
    String input = Utils.getInput(packageName, InputType.EXAMPLE);

    assertThat(day.partOne(input)).isEqualTo(2);
  }

  @Test
  void realPart1() {
    String input = Utils.getInput(packageName, InputType.REAL);

    assertThat(day.partOne(input)).isEqualTo(282);
  }

  @Test
  void examplePart2() {
    String input = Utils.getInput(packageName, InputType.EXAMPLE);

    assertThat(day.partTwo(input)).isEqualTo(4);
  }

  @Test
  void realPart2() {
    String input = Utils.getInput(packageName, InputType.REAL);

    assertThat(day.partTwo(input)).isEqualTo(349);
  }
}