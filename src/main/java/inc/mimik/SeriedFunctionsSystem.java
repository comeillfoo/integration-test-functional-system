package inc.mimik;

import inc.mimik.functions.SeriedCotangent;
import inc.mimik.functions.SeriedRandomBaseLogarithm;
import inc.mimik.functions.SeriedSecant;
import inc.mimik.functions.SeriedSine;
import inc.mimik.functions.basic.SeriedCosine;
import inc.mimik.functions.basic.SeriedNaturalLogarithm;

import java.util.function.Function;

public strictfp class SeriedFunctionsSystem implements Function<Double, Double> {
  private final SeriedCosine cos;
  private final SeriedSine sin;
  private final SeriedSecant sec;
  private final SeriedCotangent cot;

  private final SeriedNaturalLogarithm ln;
  private final SeriedRandomBaseLogarithm log2;
  private final SeriedRandomBaseLogarithm log3;
  private final SeriedRandomBaseLogarithm log5;
  private final SeriedRandomBaseLogarithm log10;

  public SeriedFunctionsSystem( SeriedCosine cos, SeriedSine sin, SeriedSecant sec, SeriedCotangent cot, SeriedNaturalLogarithm ln, SeriedRandomBaseLogarithm log2, SeriedRandomBaseLogarithm log3, SeriedRandomBaseLogarithm log5, SeriedRandomBaseLogarithm log10 ) {

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
    double result;
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
