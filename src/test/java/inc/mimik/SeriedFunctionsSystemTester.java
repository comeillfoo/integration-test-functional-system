package inc.mimik;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import inc.mimik.functions.SeriedCotangent;
import inc.mimik.functions.SeriedRandomBaseLogarithm;
import inc.mimik.functions.SeriedSecant;
import inc.mimik.functions.SeriedSine;
import inc.mimik.functions.basic.SeriedCosine;
import inc.mimik.functions.basic.SeriedNaturalLogarithm;
import inc.mimik.functions.basic.SeriedTaylorFunction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public strictfp class SeriedFunctionsSystemTester {

  private static SeriedCosine cos = mock( SeriedCosine.class );
  private static SeriedSine sin = mock( SeriedSine.class );
  private static SeriedSecant sec = mock( SeriedSecant.class );
  private static SeriedCotangent cot = mock( SeriedCotangent.class );
  private static SeriedNaturalLogarithm ln = mock( SeriedNaturalLogarithm.class );
  private static SeriedRandomBaseLogarithm log2 = mock( SeriedRandomBaseLogarithm.class );
  private static SeriedRandomBaseLogarithm log3 = mock( SeriedRandomBaseLogarithm.class );
  private static SeriedRandomBaseLogarithm log5 = mock( SeriedRandomBaseLogarithm.class );
  private static SeriedRandomBaseLogarithm log10 = mock( SeriedRandomBaseLogarithm.class );
  private static SeriedFunctionsSystem fs = null;

  private static void fillMock( SeriedTaylorFunction fn, String tableName ) throws IOException, CsvException {
    try ( CSVReader csvReader = new CSVReader( new FileReader( tableName ) ) ) {
      List<String[]> records = csvReader.readAll();
      for ( String[] record : records ) {
        final double x = Double.parseDouble( record[ 0 ] );
        final double y = Double.parseDouble( record[ 1 ] );
        when( fn.apply( x ) ).thenReturn( y );
      }
    } catch ( IOException | CsvException exp ) {
      throw exp;
    }
  }

  @BeforeAll
  public static void setup() throws IOException, CsvException {
    fillMock( cos, "cosine_inttable.csv" );
    fillMock( sin, "sine_inttable.csv" );
    fillMock( sec, "secant_inttable.csv" );
    fillMock( cot, "cotangent_inttable.csv" );
    fillMock( ln, "natural_logarithm_inttable.csv" );
    fillMock( log2, "log2_inttable.csv" );
    fillMock( log3, "log3_inttable.csv" );
    fillMock( log5, "log5_inttable.csv" );
    fillMock( log10, "log10_inttable.csv" );
    fs = new SeriedFunctionsSystem( cos, sin, sec, cot, ln, log2, log3, log5, log10 );
  }

  @ParameterizedTest
  @CsvFileSource( files={ "fs_non_positive_table.csv" } )
  public void testFunctionsSystemOnNonPositiveUsingCSVFile( double x, double expectedY ) {
    final double delta = 0.0;
    assertEquals( expectedY, fs.apply( x ), delta );
  }

  @ParameterizedTest
  @CsvFileSource( files={ "fs_positive_table.csv" } )
  public void testFunctionsSystemOnPositiveUsingCSVFile( double x, double expectedY ) {
    final double delta = 0.0;
    assertEquals( expectedY, fs.apply( x ), delta );
  }
}
