package inc.mimik;

import inc.mimik.functions.CotangentSeries;
import inc.mimik.functions.RandomBaseLogarithmSeries;
import inc.mimik.functions.SecantSeries;
import inc.mimik.functions.SineSeries;
import inc.mimik.functions.base.CosineSeries;
import inc.mimik.functions.base.NaturalLogarithmSeries;

import java.util.function.Function;

public class FunctionsSystem implements Function<Double, Double> {
  private final CosineSeries cos;
  private final SineSeries sin;
  private final SecantSeries sec;
  private final CotangentSeries cot;

  private final NaturalLogarithmSeries ln;
  private final RandomBaseLogarithmSeries log2;
  private final RandomBaseLogarithmSeries log3;
  private final RandomBaseLogarithmSeries log5;
  private final RandomBaseLogarithmSeries log10;

  public FunctionsSystem( CosineSeries cos, SineSeries sin, SecantSeries sec, CotangentSeries cot, NaturalLogarithmSeries ln, RandomBaseLogarithmSeries log2, RandomBaseLogarithmSeries log3, RandomBaseLogarithmSeries log5, RandomBaseLogarithmSeries log10 ) {

    this.cos = cos;
    this.sin = sin;
    this.sec = sec;
    this.cot = cot;

    this.ln = ln;
    this.log2 = log2;
    this.log3 = log3;
    this.log5 = log5;
    this.log10 = log10;
  }

  @Override
  public Double apply( Double x ) {
    double result = 0;
    if ( x <= Double.MIN_VALUE ) {
      final double sec_x = sec.apply( x );
      final double sec_x_3 = sec_x * sec_x * sec_x;
      final double sin_x = sin.apply( x );
      final double cot_x = cot.apply( x );
      result = ( ( ( cos.apply( x ) / cot_x ) * sin_x - cot_x ) / sec_x_3 ) * sin_x;
    } else {
      final double ln_x = ln.apply( x );
      final double log_2_x = log2.apply( x );
      final double log_3_x = log3.apply( x );
      final double log_5_x = log5.apply( x );
      final double log_10_x = log10.apply( x );
      result = ( ( ( log_2_x + log_3_x - log_10_x ) / ( log_10_x - ln_x ) ) - ( ln_x - log_5_x ) ) / ( ( ln_x + log_2_x ) * log_2_x * ( log_3_x + ( ln_x / log_2_x ) ) - log_3_x * log_3_x );
    }
    return result;
  }
}
