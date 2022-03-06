package inc.mimik.functions;

import inc.mimik.functions.base.NaturalLogarithmSeries;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomBaseLogarithmSeriesTest {

  @ParameterizedTest
  @CsvFileSource( files = { "log2_actual_test.csv" } )
  public void testLog2FromCSVFile( double x, double y ) {
    final double delta = 0.2224;
    NaturalLogarithmSeries ln = Mockito.mock( NaturalLogarithmSeries.class );
    Mockito.when( ln.apply( x ) ).thenReturn( Math.log( x ) );
    Mockito.when( ln.apply( 2.0 ) ).thenReturn( Math.log( 2.0 ) );

    final RandomBaseLogarithmSeries log = new RandomBaseLogarithmSeries( ln, 2.0 );
    assertEquals( y, log.apply( x ), delta );
  }

  @ParameterizedTest
  @CsvFileSource( files = { "log3_actual_test.csv" } )
  public void testLog3FromCSVFile( double x, double y ) {
    final double delta = 0.140314;
    NaturalLogarithmSeries ln = Mockito.mock( NaturalLogarithmSeries.class );
    Mockito.when( ln.apply( x ) ).thenReturn( Math.log( x ) );
    Mockito.when( ln.apply( 3.0 ) ).thenReturn( Math.log( 3.0 ) );

    final RandomBaseLogarithmSeries log = new RandomBaseLogarithmSeries( ln, 3.0 );
    assertEquals( y, log.apply( x ), delta );
  }

  @ParameterizedTest
  @CsvFileSource( files = { "log5_actual_test.csv" } )
  public void testLog5FromCSVFile( double x, double y ) {
    final double delta = 0.0959;
    NaturalLogarithmSeries ln = Mockito.mock( NaturalLogarithmSeries.class );
    Mockito.when( ln.apply( x ) ).thenReturn( Math.log( x ) );
    Mockito.when( ln.apply( 5.0 ) ).thenReturn( Math.log( 5.0 ) );

    final RandomBaseLogarithmSeries log = new RandomBaseLogarithmSeries( ln, 5.0 );
    assertEquals( y, log.apply( x ), delta );
  }

  @ParameterizedTest
  @CsvFileSource( files = { "log10_actual_test.csv" } )
  public void testLog10FromCSVFile( double x, double y ) {
    final double delta = 0.067;
    NaturalLogarithmSeries ln = Mockito.mock( NaturalLogarithmSeries.class );
    Mockito.when( ln.apply( x ) ).thenReturn( Math.log( x ) );
    Mockito.when( ln.apply( 10.0 ) ).thenReturn( Math.log( 10.0 ) );

    final RandomBaseLogarithmSeries log = new RandomBaseLogarithmSeries( ln, 10.0 );
    assertEquals( y, log.apply( x ), delta );
  }
}
