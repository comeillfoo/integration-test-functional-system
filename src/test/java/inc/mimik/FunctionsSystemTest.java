package inc.mimik;

import inc.mimik.functions.CotangentSeries;
import inc.mimik.functions.RandomBaseLogarithmSeries;
import inc.mimik.functions.SecantSeries;
import inc.mimik.functions.SineSeries;
import inc.mimik.functions.base.CosineSeries;
import inc.mimik.functions.base.NaturalLogarithmSeries;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionsSystemTest {

  @ParameterizedTest
  @CsvFileSource( files = { "fs_negative_actual_test.csv" } )
  public void testFSNegativeFromCSVFile( double x, double y ) {
    final double delta = 0.0;

    CosineSeries cos = Mockito.mock( CosineSeries.class );
    Mockito.when( cos.apply( x ) ).thenReturn( Math.cos( x ) );

    SineSeries sin = Mockito.mock( SineSeries.class );
    Mockito.when( sin.apply( x ) ).thenReturn( Math.sin( x ) );

    SecantSeries sec = Mockito.mock( SecantSeries.class );
    Mockito.when( sec.apply( x ) ).thenReturn( 1 / Math.cos( x ) );

    CotangentSeries cot = Mockito.mock( CotangentSeries.class );
    Mockito.when( cot.apply( x ) ).thenReturn( Math.cos( x ) / Math.sin( x ) );


    NaturalLogarithmSeries ln = Mockito.mock( NaturalLogarithmSeries.class );
    Mockito.when( ln.apply( x ) ).thenReturn( Math.log( x ) );

    RandomBaseLogarithmSeries log2 = Mockito.mock( RandomBaseLogarithmSeries.class );
    Mockito.when( log2.apply( x ) ).thenReturn( Math.log( x ) / Math.log( 2.0 ) );

    RandomBaseLogarithmSeries log3 = Mockito.mock( RandomBaseLogarithmSeries.class );
    Mockito.when( log3.apply( x ) ).thenReturn( Math.log( x ) / Math.log( 3.0 ) );

    RandomBaseLogarithmSeries log5 = Mockito.mock( RandomBaseLogarithmSeries.class );
    Mockito.when( log5.apply( x ) ).thenReturn( Math.log( x ) / Math.log( 5.0 ) );

    RandomBaseLogarithmSeries log10 = Mockito.mock( RandomBaseLogarithmSeries.class );
    Mockito.when( log10.apply( x ) ).thenReturn( Math.log( x ) / Math.log( 10.0 ) );

    final FunctionsSystem fs = new FunctionsSystem( cos, sin, sec, cot, ln, log2, log3, log5, log10 );
    assertEquals( y, fs.apply( x ), delta );
  }

  @ParameterizedTest
  @CsvFileSource( files = { "fs_positive_actual_test.csv" } )
  public void testFSPositiveFromCSVFile( double x, double y ) {
    final double delta = 0;

    CosineSeries cos = Mockito.mock( CosineSeries.class );
    Mockito.when( cos.apply( x ) ).thenReturn( Math.cos( x ) );

    SineSeries sin = Mockito.mock( SineSeries.class );
    Mockito.when( sin.apply( x ) ).thenReturn( Math.sin( x ) );

    SecantSeries sec = Mockito.mock( SecantSeries.class );
    Mockito.when( sec.apply( x ) ).thenReturn( 1 / Math.cos( x ) );

    CotangentSeries cot = Mockito.mock( CotangentSeries.class );
    Mockito.when( cot.apply( x ) ).thenReturn( Math.cos( x ) / Math.sin( x ) );


    NaturalLogarithmSeries ln = Mockito.mock( NaturalLogarithmSeries.class );
    Mockito.when( ln.apply( x ) ).thenReturn( Math.log( x ) );

    RandomBaseLogarithmSeries log2 = Mockito.mock( RandomBaseLogarithmSeries.class );
    Mockito.when( log2.apply( x ) ).thenReturn( Math.log( x ) / Math.log( 2.0 ) );

    RandomBaseLogarithmSeries log3 = Mockito.mock( RandomBaseLogarithmSeries.class );
    Mockito.when( log3.apply( x ) ).thenReturn( Math.log( x ) / Math.log( 3.0 ) );

    RandomBaseLogarithmSeries log5 = Mockito.mock( RandomBaseLogarithmSeries.class );
    Mockito.when( log5.apply( x ) ).thenReturn( Math.log( x ) / Math.log( 5.0 ) );

    RandomBaseLogarithmSeries log10 = Mockito.mock( RandomBaseLogarithmSeries.class );
    Mockito.when( log10.apply( x ) ).thenReturn( Math.log( x ) / Math.log( 10.0 ) );

    final FunctionsSystem fs = new FunctionsSystem( cos, sin, sec, cot, ln, log2, log3, log5, log10 );
    assertEquals( y, fs.apply( x ), delta );
  }
}
