package inc.mimik.functions;

import inc.mimik.functions.basic.SeriedCosine;
import inc.mimik.functions.basic.SeriedTaylorFunction;

public strictfp class SeriedCotangent extends SeriedTaylorFunction {
  private final SeriedCosine COS;
  private final SeriedSine SIN;

  public SeriedCotangent( SeriedCosine cos, SeriedSine sin ) {
    super( Math.min( cos.TERMS, sin.TERMS ) );
    COS = cos;
    SIN = sin;
  }

  @Override
  public Double apply( Double x ) {
    return COS.apply( x ) / SIN.apply( x );
  }
}
