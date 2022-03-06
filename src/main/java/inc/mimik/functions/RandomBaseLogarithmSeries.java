package inc.mimik.functions;

import inc.mimik.functions.base.NaturalLogarithmSeries;
import inc.mimik.functions.base.TaylorSeriesFunction;

public class RandomBaseLogarithmSeries extends TaylorSeriesFunction {
  private final NaturalLogarithmSeries LN;
  private final double BASE;

  public RandomBaseLogarithmSeries( NaturalLogarithmSeries ln, double base ) {
    super( ln.TERMS );
    LN = ln;
    BASE = base;
  }

  @Override
  public Double apply( Double x ) {
    return LN.apply( x ) / LN.apply( BASE );
  }
}
