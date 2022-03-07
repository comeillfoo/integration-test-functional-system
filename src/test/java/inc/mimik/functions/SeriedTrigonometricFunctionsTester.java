package inc.mimik.functions;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import inc.mimik.functions.basic.SeriedCosine;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public strictfp class SeriedTrigonometricFunctionsTester {

  private static SeriedCosine cos = mock( SeriedCosine.class );

  private static SeriedSine sin = null;
  private static SeriedSecant sec = null;
  private static SeriedCotangent cot = null;

  @BeforeAll
  public static void setup( ) throws IOException, CsvException {
    try ( CSVReader csvReader = new CSVReader( new FileReader( "cosine_table.csv" ) ) ) {
      List<String[]> records = csvReader.readAll();
      for ( String[] record : records ) {
        final double x = Double.parseDouble( record[ 0 ] );
        final double y = Double.parseDouble( record[ 1 ] );
        when( cos.apply( x ) ).thenReturn( y );
      }
    } catch ( IOException | CsvException exp ) {
      throw exp;
    }
    sin = new SeriedSine( cos );
    sec = new SeriedSecant( cos );
    cot = new SeriedCotangent( cos, sin );
  }

  @ParameterizedTest
  @CsvFileSource( files={ "sine_table.csv" } )
  public void testSineUsingCSVFile( double x, double expectedY ) {
    final double sinDelta = 0.002;
    assertEquals( expectedY, sin.apply( x ), sinDelta );
  }

  @ParameterizedTest
  @CsvFileSource( files={ "secant_table.csv" } )
  public void testSecantUsingCSVFile( double x, double expectedY ) {
    final double secDelta = 0.0049103606726;
    assertEquals( expectedY, sec.apply( x ), secDelta );
  }

  @ParameterizedTest
  @CsvFileSource( files={ "cotangent_table.csv" } )
  public void testCotangentUsingCSVFile( double x, double expectedY ) {
    final double cotDelta = 0.4;
    assertEquals( expectedY, cot.apply( x ), cotDelta );
  }

  @ParameterizedTest
  @CsvSource( value={
      "9.425,-3.142",
      "-9.425,-3.142"
  } )
  public void testAngleNormalization( double x, double expectedX ) {
    final double delta = 0.001;
    assertEquals( expectedX, sin.normalize( x ), delta );
  }
}
