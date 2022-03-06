package inc.mimik.functions.base;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.*;

public strictfp class CosineSeriesTest {

  private final CosineSeries cos = new CosineSeries( 22 );

  @ParameterizedTest
  @CsvFileSource( files = { "cos_actual_test.csv" } )
  public void testFromCSVFile( double x, double y ) {
    final double delta = 0.0482340630861513288383002131617;
    assertEquals( y, cos.apply( x ), delta );
  }
}
