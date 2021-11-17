package tdd.tpp;

import io.vavr.Tuple2;
import java.util.LinkedHashMap;
import java.util.Map;

public class RomanConverter {

  private static final LinkedHashMap<Integer, String> arabicToRoman = new LinkedHashMap<>();

  static {
    arabicToRoman.put(1000, "M");
    arabicToRoman.put(900, "CM");
    arabicToRoman.put(500, "D");
    arabicToRoman.put(400, "CD");
    arabicToRoman.put(100, "C");
    arabicToRoman.put(90, "XC");
    arabicToRoman.put(50, "L");
    arabicToRoman.put(40, "XL");
    arabicToRoman.put(10, "X");
    arabicToRoman.put(9, "IX");
    arabicToRoman.put(5, "V");
    arabicToRoman.put(4, "IV");
    arabicToRoman.put(1, "I");
  }

  private Tuple2<Integer, String> combine(
    Tuple2<Integer, String> a,
    Tuple2<Integer, String> b
  ) {
    throw new UnsupportedOperationException("parallelStream is not supported");
  }

  private Tuple2<Integer, String> reduceArabic(
    Tuple2<Integer, String> acc,
    Map.Entry<Integer, String> entry
  ) {
    Integer times = acc._1 / entry.getKey();
    return new Tuple2<>(
      acc._1 - times * entry.getKey(),
      acc._2 + entry.getValue().repeat(times)
    );
  }

  public String convertToRoman(int arabic) {
    Tuple2<Integer, String> state = new Tuple2<>(arabic, "");

    return arabicToRoman
      .entrySet()
      .stream()
      .reduce(state, this::reduceArabic, this::combine)
      ._2();
  }
}
