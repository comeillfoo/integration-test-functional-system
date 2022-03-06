package inc.mimik.functions;

import inc.mimik.functions.basic.SeriedNaturalLogarithm;
import inc.mimik.functions.basic.SeriedTaylorFunction;

public strictfp class SeriedRandomBaseLogarithm extends SeriedTaylorFunction {
  private final SeriedNaturalLogarithm LN;
  private final double BASE;

  public SeriedRandomBaseLogarithm( SeriedNaturalLogarithm ln, double base ) {
    super( ln.TERMS );
    LN = ln;
    BASE = base;
  }

  @Override
  public Double apply( Double x ) {
    return LN.apply( x ) / LN.apply( BASE );
  }
}
