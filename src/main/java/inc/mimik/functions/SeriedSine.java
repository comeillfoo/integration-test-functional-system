package inc.mimik.functions;

import inc.mimik.functions.base.SeriedCosine;
import inc.mimik.functions.base.SeriedTaylorFunction;

public strictfp class SeriedSine extends SeriedTaylorFunction {
  private final SeriedCosine COS;

  public SeriedSine( SeriedCosine cos ) {
    super( cos.TERMS );
    COS = cos;
  }

  @Override
  public Double apply( Double x ) {
    return COS.apply( x - ( Math.PI / 2 ) );
  }
}
