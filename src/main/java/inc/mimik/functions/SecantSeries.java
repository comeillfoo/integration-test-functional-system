package inc.mimik.functions;

import inc.mimik.functions.base.CosineSeries;
import inc.mimik.functions.base.TaylorSeriesFunction;

public class SecantSeries extends TaylorSeriesFunction {
  private final CosineSeries COS;

  public SecantSeries( CosineSeries cos ) {
    super( cos.TERMS );
    COS = cos;
  }

  @Override
  public Double apply( Double x ) {
    return 1 / COS.apply( x );
  }
}
