package inc.mimik.functions;

import inc.mimik.functions.base.CosineSeries;
import inc.mimik.functions.base.TaylorSeriesFunction;

public class CotangentSeries extends TaylorSeriesFunction {
  private final CosineSeries COS;
  private final SineSeries SIN;

  public CotangentSeries( CosineSeries cos, SineSeries sin ) {
    super( Math.min( cos.TERMS, sin.TERMS ) );
    COS = cos;
    SIN = sin;
  }

  @Override
  public Double apply( Double x ) {
    return COS.apply( x ) / SIN.apply( x );
  }
}
