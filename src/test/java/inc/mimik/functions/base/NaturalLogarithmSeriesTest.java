package inc.mimik.functions.base;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NaturalLogarithmSeriesTest {
  private final NaturalLogarithmSeries ln = new NaturalLogarithmSeries( 32 );

  @ParameterizedTest
  @CsvFileSource( files = { "ln_actual_test.csv" } )
  public void testFromCSVFile( double x, double y ) {
    final double delta = 0.19;
    assertEquals( y, ln.apply( x ), delta );
  }
}
