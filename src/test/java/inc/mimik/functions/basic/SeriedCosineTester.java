package inc.mimik.functions.basic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.*;

public strictfp class SeriedCosineTester {
  private final SeriedCosine cos20 = new SeriedCosine( 20 );
  private final double cos20delta = 0.0047706623103982;

  @ParameterizedTest
  @CsvFileSource( files={ "cosine_table.csv" } )
  public void testOnMinimalRequiredSegmentUsingCSVFile( double x, double expectedY ) {
    assertEquals( expectedY, cos20.apply( x ), cos20delta );
  }
}

