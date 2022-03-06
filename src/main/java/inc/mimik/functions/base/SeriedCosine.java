package inc.mimik.functions.base;

import inc.mimik.utils.AdditionalMathUtils;

public strictfp class SeriedCosine extends SeriedTaylorFunction {
  public SeriedCosine( long terms ) {
    super( terms );
  }

  @Override
  public Double apply( Double x ) {
    double result = 0;
    for ( long n = 0; n < TERMS / 2; ++n )
      result += Math.pow( -1, n ) * Math.pow( x, 2 * n ) / AdditionalMathUtils.fact( 2 * n );
    return result;
  }
}
