package inc.mimik;

import inc.mimik.utils.ModuleCSVWriter;

import java.util.function.Function;

public strictfp class Main {

  public static void main( String[] args ) {

    ModuleCSVWriter mw = new ModuleCSVWriter( "fs_positive_actual_test.csv", ( x ) -> {
      if ( x <= Double.MIN_VALUE ) {
        Function<Double, Double> sec = ( a ) -> ( 1 / Math.cos( a ) );
        return ( ( ( Math.sin( x ) ) - Math.cos( x ) / Math.sin( x ) ) / ( sec.apply( x ) * sec.apply( x ) * sec.apply( x ) ) ) * Math.sin( x );
      } else {
        Function<Double, Double> log2 = ( a ) -> ( Math.log( a ) / Math.log( 2.0 ) );
        Function<Double, Double> log3 = ( a ) -> ( Math.log( a ) / Math.log( 3.0 ) );
        Function<Double, Double> log5 = ( a ) -> ( Math.log( a ) / Math.log( 5.0 ) );
        Function<Double, Double> log10 = ( a ) -> ( Math.log( a ) / Math.log( 10.0 ) );

        return ( ( ( ( log2.apply( x ) + log3.apply( x ) ) - log10.apply( x ) ) / ( log10.apply( x ) - Math.log( x ) ) ) - ( Math.log( x ) - log5.apply( x ) ) ) /
            ( ( ( Math.log( x ) + log2.apply( x ) ) * log2.apply( x ) * ( log3.apply( x ) + ( Math.log( x ) / log2.apply( x ) ) ) ) - log3.apply( x ) * log3.apply( x ) );
      }
    } );
    mw.write( 0.02, 1.99, 0.01 );
  }
}
