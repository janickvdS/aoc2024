package org.example.day03;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.example.InputType;
import org.example.Utils;
import org.junit.jupiter.api.Test;

class Day03Test {
  Day03 day = new Day03();
  String packageName = "day03";

  @Test
  void examplePart1() {
    String input = Utils.getInput(packageName, InputType.EXAMPLE);

    assertThat(day.partOne(input)).isEqualTo(161);
  }

  @Test
  void realPart1() {
    String input = Utils.getInput(packageName, InputType.REAL);

    assertThat(day.partOne(input)).isEqualTo(166905464);
  }

  @Test
  void examplePart2() {
    String input = Utils.getInput(packageName, InputType.EXAMPLE);

    assertThat(day.partTwo(input)).isEqualTo(48);
  }

  @Test
  void realPart2() {
    String input = Utils.getInput(packageName, InputType.REAL);

    assertThat(day.partTwo(input)).isEqualTo(72948684);
  }

}