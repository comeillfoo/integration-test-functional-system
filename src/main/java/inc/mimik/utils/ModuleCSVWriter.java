package inc.mimik.utils;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.function.Function;

public class ModuleCSVWriter {
  private final Function<Double, Double> F;
  private final String FILE_PATH;

  public ModuleCSVWriter( String filePath, Function<Double, Double> f ) {
    FILE_PATH = filePath;
    F = f;
  }

  public double append( double x ) {
    double result = F.apply( x );
    try ( CSVWriter csvWriter = new CSVWriter( new FileWriter( FILE_PATH, true ), ',', '\0', '\\', "\n" ) ) {
      String[] record = { Double.toString( x ), Double.toString( result ) };
      csvWriter.writeNext( record );
    } catch ( IOException io ) {
      return Double.NaN;
    }
    return result;
  }

  public boolean write( double a, double b, double step ) {
    try ( CSVWriter csvWriter = new CSVWriter( new FileWriter( FILE_PATH, false ), ',', '\0', '\\', "\n" ) ) {
      double x = a;
      while ( x < b + step ) {
        final double fx = F.apply( x );
        x += step;
        String[] record = { Double.toString( x ), Double.toString( fx ) };
        csvWriter.writeNext( record );
      }
    } catch ( IOException io ) {
      return false;
    }
    return true;
  }
}
