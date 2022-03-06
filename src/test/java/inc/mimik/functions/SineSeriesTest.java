package inc.mimik.functions;

import inc.mimik.functions.base.CosineSeries;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public strictfp class SineSeriesTest {

  @ParameterizedTest
  @CsvFileSource( files = { "sin_actual_test.csv" } )
  public void testFromCSVFile( double x, double y ) {
    final double delta = 0.0099999566847;

    CosineSeries mock = Mockito.mock( CosineSeries.class );
    Mockito.when( mock.apply( x - Math.PI / 2 ) ).thenReturn( Math.cos( x - Math.PI / 2 ) );

    final SineSeries sin = new SineSeries( mock );
    assertEquals( y, sin.apply( x ), delta );
  }
}
