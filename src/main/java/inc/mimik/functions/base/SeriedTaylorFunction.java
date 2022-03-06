package inc.mimik.functions.base;

import java.util.function.Function;

public abstract class SeriedTaylorFunction implements Function<Double, Double> {
  public final long TERMS;

  public SeriedTaylorFunction( long terms ) {
    if ( terms <= 0 )
      TERMS = 1;
    else TERMS = terms;
  }
}
