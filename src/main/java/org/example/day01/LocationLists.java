package org.example.day01;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Builder
@Value
public class LocationLists {
  List<Integer> left;
  List<Integer> right;
}
