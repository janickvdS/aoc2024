package org.example.day05;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.example.InputType;
import org.example.Utils;
import org.example.day04.Day04;
import org.junit.jupiter.api.Test;

class Day05Test {
  Day05 day = new Day05();
  String packageName = "day05";

  @Test
  void examplePart1() {
    String input = Utils.getInput(packageName, InputType.EXAMPLE);

    assertThat(day.partOne(input)).isEqualTo(143);
  }

  @Test
  void realPart1() {
    String input = Utils.getInput(packageName, InputType.REAL);

    assertThat(day.partOne(input)).isEqualTo(4185);
  }

  @Test
  void examplePart2() {
    String input = Utils.getInput(packageName, InputType.EXAMPLE);

    assertThat(day.partTwo(input)).isEqualTo(123);
  }

  @Test
  void realPart2() {
    String input = Utils.getInput(packageName, InputType.REAL);

    assertThat(day.partTwo(input)).isEqualTo(4480);
  }
}