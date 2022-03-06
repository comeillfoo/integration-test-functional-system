package inc.mimik.functions.basic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.*;

public strictfp class SeriedNaturalLogarithmTester {

  private final SeriedNaturalLogarithm ln256At6 = new SeriedNaturalLogarithm( 256, 6.0 );
  private final double ln256At6Delta = 0.3846704739794538;

  @ParameterizedTest
  @CsvFileSource( files={ "natural_logarithm_table.csv" } )
  public void testOnMinimalRequiredSegmentUsingCSVFile( double x, double expectedY ) {
    assertEquals( expectedY, ln256At6.apply( x ), ln256At6Delta );
  }
}
