package inc.mimik.functions;

import inc.mimik.functions.base.CosineSeries;
import inc.mimik.functions.base.TaylorSeriesFunction;

public class SineSeries extends TaylorSeriesFunction {
  private final CosineSeries COS;

  public SineSeries( CosineSeries cos ) {
    super( cos.TERMS );
    COS = cos;
  }

  @Override
  public Double apply( Double x ) {
    return COS.apply( x - ( Math.PI / 2 ) );
  }
}
