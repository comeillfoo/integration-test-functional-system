package inc.mimik.functions.base;

import java.util.function.Function;

public strictfp abstract class TaylorSeriesFunction implements Function<Double, Double> {
  public final long TERMS;

  public TaylorSeriesFunction( long terms ) {
    if ( terms <= 0 )
      TERMS = 1;
    else TERMS = terms;
  }
}
