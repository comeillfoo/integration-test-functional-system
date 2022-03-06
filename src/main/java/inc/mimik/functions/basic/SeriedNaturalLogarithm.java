package inc.mimik.functions.basic;

public strictfp class SeriedNaturalLogarithm extends SeriedTaylorFunction {
  public SeriedNaturalLogarithm( long terms, double a ) {
    super( terms );
    this.a = a;
  }

  private final double a;

  @Override
  public Double apply( Double x ) {
    double fx = Math.log( a );
    for ( long n = 1; n < TERMS + 1; ++n ) {
      fx += Math.pow( -1, n - 1 ) * Math.pow( x - a, n ) / ( n * Math.pow( a, n ) );
    }
    return fx;
  }
}
