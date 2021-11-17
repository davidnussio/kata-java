import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tdd.tpp.RomanConverter;

public class RomanConverterTest {

  @ParameterizedTest
  @CsvSource(
    {
      "1, 'I'",
      "2, 'II'",
      "3, 'III'",
      "4, 'IV'",
      "5, 'V'",
      "6, 'VI'",
      "9, 'IX'",
      "10, 'X'",
      "11, 'XI'",
      "14, 'XIV'",
      "15, 'XV'",
      "39, 'XXXIX'",
      "43, 'XLIII'",
      "73, 'LXXIII'",
      "89, 'LXXXIX'",
      "90, 'XC'",
      "91, 'XCI'",
      "99, 'XCIX'",
      "100, 'C'",
      "400, 'CD'",
      "500, 'D'",
      "900, 'CM'",
      "1000, 'M'",
      "1984, 'MCMLXXXIV'",
      "3999, 'MMMCMXCIX'",
      "3724, 'MMMDCCXXIV'",
      "4999, 'MMMMCMXCIX'",
    }
  )
  public void testConvertToRoman(int arabic, String roman) {
    RomanConverter converter = new RomanConverter();
    assertEquals(roman, converter.convertToRoman(arabic));
  }
}
