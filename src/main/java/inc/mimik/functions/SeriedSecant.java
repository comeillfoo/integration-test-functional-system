package inc.mimik.functions;

import inc.mimik.functions.basic.SeriedCosine;
import inc.mimik.functions.basic.SeriedTaylorFunction;

public strictfp class SeriedSecant extends SeriedTaylorFunction {
  private final SeriedCosine COS;

  public SeriedSecant( SeriedCosine cos ) {
    super( cos.TERMS );
    COS = cos;
  }

  @Override
  public Double apply( Double x ) {
    return 1 / COS.apply( x );
  }
}
