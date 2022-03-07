package inc.mimik.functions;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import inc.mimik.functions.basic.SeriedNaturalLogarithm;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public strictfp class SeriedRandomBaseLogarithmTester {

  private final static SeriedNaturalLogarithm ln = mock( SeriedNaturalLogarithm.class );
  private static SeriedRandomBaseLogarithm log2 = null;
  private static SeriedRandomBaseLogarithm log3 = null;
  private static SeriedRandomBaseLogarithm log5 = null;
  private static SeriedRandomBaseLogarithm log10 = null;

  @BeforeAll
  public static void setup( ) throws IOException, CsvException {
    try ( CSVReader csvReader = new CSVReader( new FileReader( "natural_logarithm_table.csv" ) ) ) {
      List<String[]> records = csvReader.readAll();
      for ( String[] record : records ) {
        final double x = Double.parseDouble( record[ 0 ] );
        final double y = Double.parseDouble( record[ 1 ] );
        when( ln.apply( x ) ).thenReturn( y );
      }
    } catch ( IOException | CsvException exp ) {
      throw exp;
    }
    log2 = new SeriedRandomBaseLogarithm( ln, 2.000 );
    log3 = new SeriedRandomBaseLogarithm( ln, 3.000 );
    log5 = new SeriedRandomBaseLogarithm( ln, 5.000 );
    log10 = new SeriedRandomBaseLogarithm( ln, 10.000 );
  }

  @ParameterizedTest
  @CsvFileSource( files={ "log2_table.csv" } )
  public void testLog2OnLnStubUsingCSVFile( double x, double expectedY ) {
    final double log2Delta = 0.0;
    assertEquals( expectedY, log2.apply( x ), log2Delta );
  }

  @ParameterizedTest
  @CsvFileSource( files={ "log3_table.csv" } )
  public void testLog3OnLnStubUsingCSVFile( double x, double expectedY ) {
    final double log3Delta = 0.0;
    assertEquals( expectedY, log3.apply( x ), log3Delta );
  }

  @ParameterizedTest
  @CsvFileSource( files={ "log5_table.csv" } )
  public void testLog5OnLnStubUsingCSVFile( double x, double expectedY ) {
    final double log5Delta = 0.0;
    assertEquals( expectedY, log5.apply( x ), log5Delta );
  }

  @ParameterizedTest
  @CsvFileSource( files={ "log10_table.csv" } )
  public void testLog10OnLnStubUsingCSVFile( double x, double expectedY ) {
    final double log10Delta = 0.0;
    assertEquals( expectedY, log10.apply( x ), log10Delta );
  }

  @ParameterizedTest
  @CsvFileSource( files={ "log2_table.csv" } )
  public void testLog2OnRealLnUsingCSVFile( double x, double expectedY ) {
    final double log2Delta = 0.554963739231812;
    final SeriedNaturalLogarithm realLn = new SeriedNaturalLogarithm( 256, 6.0 );
    assertEquals( expectedY, new SeriedRandomBaseLogarithm( realLn, 2.0 ).apply( x ), log2Delta );
  }

  @ParameterizedTest
  @CsvFileSource( files={ "log3_table.csv" } )
  public void testLog3OnRealLnUsingCSVFile( double x, double expectedY ) {
    final double log3Delta = 0.35014999603766;
    final SeriedNaturalLogarithm realLn = new SeriedNaturalLogarithm( 256, 6.0 );
    assertEquals( expectedY, new SeriedRandomBaseLogarithm( realLn, 3.0 ).apply( x ), log3Delta );
  }

  @ParameterizedTest
  @CsvFileSource( files={ "log5_table.csv" } )
  public void testLog5OnRealLnUsingCSVFile( double x, double expectedY ) {
    final double log5Delta = 0.239005871169066;
    final SeriedNaturalLogarithm realLn = new SeriedNaturalLogarithm( 256, 6.0 );
    assertEquals( expectedY, new SeriedRandomBaseLogarithm( realLn, 5.0 ).apply( x ), log5Delta );
  }

  @ParameterizedTest
  @CsvFileSource( files={ "log10_table.csv" } )
  public void testLog10OnRealLnUsingCSVFile( double x, double expectedY ) {
    final double log10Delta = 0.1670564370340710;
    final SeriedNaturalLogarithm realLn = new SeriedNaturalLogarithm( 256, 6.0 );
    assertEquals( expectedY, new SeriedRandomBaseLogarithm( realLn, 10.0 ).apply( x ), log10Delta );
  }
}
