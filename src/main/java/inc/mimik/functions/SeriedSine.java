package inc.mimik.functions;

import inc.mimik.functions.basic.SeriedCosine;
import inc.mimik.functions.basic.SeriedTaylorFunction;

public strictfp class SeriedSine extends SeriedTaylorFunction {
  private final SeriedCosine COS;

  public SeriedSine( SeriedCosine cos ) {
    super( cos.TERMS );
    COS = cos;
  }

  public Double normalize( Double x ) {
    x = x % ( -2 * Math.PI );
    if ( x > 0 ) x -= 2 * Math.PI;
    return x;
  }

  @Override
  public Double apply( Double x ) {
    x = normalize( x );
    double one = 1;
    if ( x < 0 && x > -Math.PI ) one = -1;
    return one * Math.sqrt( 1 - COS.apply( x ) * COS.apply( x ) );
  }
}
