package inc.mimik.utils;

import java.util.stream.LongStream;

public class AdditionalMathUtils {
  public static double fact( long n ) {
    return ( double ) LongStream.rangeClosed( 1, n )
        .reduce(1, ( long x, long y ) -> x * y );
  }
}
