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

  private static SeriedSine stubSin = null;
  private static SeriedSecant stubSec = null;
  private static SeriedCotangent stubCot = null;

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
    stubSin = new SeriedSine( cos );
    stubSec = new SeriedSecant( cos );
    stubCot = new SeriedCotangent( cos, stubSin );
  }

  @ParameterizedTest
  @CsvFileSource( files={ "sine_table.csv" } )
  public void testSineOnCosineStubUsingCSVFile( double x, double expectedY ) {
    final double sinDelta = 0.002;
    assertEquals( expectedY, stubSin.apply( x ), sinDelta );
  }

  @ParameterizedTest
  @CsvFileSource( files={ "sine_table.csv" } )
  public void testSineOnRealCosineModuleUsingCSVFile( double x, double expectedY ) {
    final double sinDelta = 0.08200494902353769;
    final SeriedCosine realCos = new SeriedCosine( 20 );
    final SeriedSine realSin = new SeriedSine( realCos );
    assertEquals( expectedY, realSin.apply( x ), sinDelta );
  }

  @ParameterizedTest
  @CsvFileSource( files={ "secant_table.csv" } )
  public void testSecantOnCosineStubUsingCSVFile( double x, double expectedY ) {
    final double secDelta = 0.0049103606726;
    assertEquals( expectedY, stubSec.apply( x ), secDelta );
  }

  @ParameterizedTest
  @CsvFileSource( files={ "secant_table.csv" } )
  public void testSecantOnRealCosineModuleUsingCSVFile( double x, double expectedY ) {
    final double secDelta = 0.0049104448045;
    final SeriedCosine realCos = new SeriedCosine( 20 );
    final SeriedSecant realSec = new SeriedSecant( realCos );
    assertEquals( expectedY, realSec.apply( x ), secDelta );
  }

  @ParameterizedTest
  @CsvFileSource( files={ "cotangent_table.csv" } )
  public void testCotangentOnSineAndCosineStubsUsingCSVFile( double x, double expectedY ) {
    final double cotDelta = 0.4;
    assertEquals( expectedY, stubCot.apply( x ), cotDelta );
  }

  @ParameterizedTest
  @CsvFileSource( files={ "cotangent_table.csv" } )
  public void testCotangentOnSineStubAndRealCosineUsingCSVFile( double x, double expectedY ) {
    final double cotDelta = 0.4;
    final SeriedCosine realCos = new SeriedCosine( 20 );
    final SeriedCotangent almostRealCot = new SeriedCotangent( realCos, stubSin );
    assertEquals( expectedY, almostRealCot.apply( x ), cotDelta );
  }

  @ParameterizedTest
  @CsvFileSource( files={ "cotangent_table.csv" } )
  public void testCotangentOnRealSineAndCosineStubUsingCSVFile( double x, double expectedY ) {
    final double cotDelta = 0.4;
    final SeriedSine realSin = new SeriedSine( new SeriedCosine( 20 ) );
    final SeriedCotangent almostRealCot = new SeriedCotangent( cos, realSin );
    assertEquals( expectedY, almostRealCot.apply( x ), cotDelta );
  }

  @ParameterizedTest
  @CsvFileSource( files={ "cotangent_table.csv" } )
  public void testCotangentOnRealCosineAndRealSineUsingCSVFile( double x, double expectedY ) {
    final double cotDelta = 0.4;
    final SeriedCosine realCos = new SeriedCosine( 20 );
    final SeriedSine realSin = new SeriedSine( realCos );
    final SeriedCotangent realCot = new SeriedCotangent( realCos, realSin );
    assertEquals( expectedY, realCot.apply( x ), cotDelta );
  }

  @ParameterizedTest
  @CsvSource( value={
      "9.425,-3.142",
      "-9.425,-3.142"
  } )
  public void testAngleNormalization( double x, double expectedX ) {
    final double delta = 0.001;
    assertEquals( expectedX, stubSin.normalize( x ), delta );
  }
}
