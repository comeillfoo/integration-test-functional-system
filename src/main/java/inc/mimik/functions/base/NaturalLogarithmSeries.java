package inc.mimik.functions.base;

public class NaturalLogarithmSeries extends TaylorSeriesFunction {
  public NaturalLogarithmSeries( long terms ) {
    super( terms );
  }

  @Override
  public Double apply( Double x ) {
    double result = 0;
    for ( long n = 1; n < TERMS; ++n )
      result += Math.pow( -1.0, n - 1 ) * Math.pow( x - 1, n ) / n;
    return result;
  }
}
