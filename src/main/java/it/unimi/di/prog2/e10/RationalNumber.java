/*

Copyright 2024 Massimo Santini

This file is part of "Programmazione 2 @ UniMI" teaching material.

This is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This material is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this file.  If not, see <https://www.gnu.org/licenses/>.

*/

package it.unimi.di.prog2.e10;

/**
 * A rational number is an immutable number that can be expressed as the quotient or fraction \( p/q
 * \) of two {@code int}s, a numerator \( p \) and a non-zero denominator \( q \).
 */
public class RationalNumber {

  // EXERCISE: complete following the specification (with particular attention
  // to the eventual exceptions) and provide an implementation (including the
  // equals, hashCode, and toString methods); add methods that are adequate to
  // the specification.

  /**
   * Creates a new rational number.
   *
   * @param numerator the numerator.
   * @param denominator the denominator.
   */

   int numerator;
   int denominator;

   //How to represent 0?
   //Allow fractions like 0/n
   //How to deal with non positive denominator?
  public RationalNumber(int numerator, int denominator) {
    if(denominator<1) throw new IllegalArgumentException("Denominator must be strictly positive");
    this.denominator = denominator;
    this.numerator = numerator;
  }

  /**
  * Returns int representation of the denominator of {@code this}
  *
  * @return int value of the denominator of {@code this}
  * */
  public int den() {
    return denominator;
  }

  /**
  * Returns int representation of the numerator of {@code this}
  *
  * @return int value of the numerator of {@code this}
  * */
  public int num() {
    return numerator;
  }

 /**
  * Given two positive intergers returns its maximum common divisor
  * that is the greatest number that divides both numbers exactly
  * @param a positive integer
  * @param b positive integer
  * @return maximum common divisor of {@code a} and {@code b}
  * */
  private static int mcd(int a, int b) {
    while(b!=0) {
      int x = b;
      b = a%b;
      a = x;
    }
    return a;
  }

  /**
  * Given two positive intergers returns its lowest common multiplier
  * that is the smallest number that is divided by both numbers exactly
  * @param a positive integer
  * @param b positive integer
  * @return lowest common multiplier of {@code a} and {@code b}
  * */
  private static int mcm(int a, int b) {
     return (a*b)/mcd(a,b);
  }

  /**
  * reduces {@code this} fraction
  * 
  *<p> this method modifies {@code this} object
  *
  * */
  private void simplify() {
    int d = mcd(numerator,denominator);
    numerator = numerator/d;
    denominator = denominator/d;
  }

  /**
  * returns a new rational number that is {@code this} reduced
  *
  * @return a new rational number that is {@code this} reduced
  * */
  public RationalNumber simplified() {
    int d = mcd(numerator,denominator);
    return new RationalNumber(numerator/d, denominator/d);
  }

  /**
   * Returns the sum of this rational number and another one.
   *
   * @param other the other rational number.
   * @return the sum of this rational number and {@code other}.
   */
  public RationalNumber add(RationalNumber other) {
      int den = mcm(denominator, other.denominator);
      return new RationalNumber( 
        (den/this.denominator)*this.numerator + (den/other.denominator)*other.denominator, den).simplify();
  }

 
  /**
   * Returns the product of this rational number and another one.
   *
   * @param other the other rational number.
   * @return the product of this rational number and {@code other}.
   */
  public RationalNumber mul(RationalNumber other) {
    return new RationalNumber(
      this.numerator*other.numerator, this.denominator*other.denominator).simplify();
  }

  /**
  * Returns the inverse of this rational number, that is {@code this} elevated to -1
  *
  * @return the inverse of {@code this}
  *
   */
  public RationalNumber inv() {
    return new RationalNumber(denominator,numerator);
  }

  /**
  * Returns the opposite if this rational number, that is {@code this} multiplied by -1
  *
  * @return the opposite of {@code this}
  * */
  public RationalNumber opp() {
    return new RationalNumber(-numerator, denominator);
  }

  /**
  * Returns the rational number resulting from the subtraction of {@code other} from {@code this}
  *
  * @param other rational number
  * @return a new rational number that is the result of the subtraction of {@code other} from {@code this}
  *
  * */
  public RationalNumber sub(RationalNumber other) {
    return this.add(other.opp()).simplify();
  }

  /**
  * Returns the rational number resulting from the division of {@code this} by {@code other}
  *
  * @param other rational number
  * @return a new rational that is the result of dividing {@code this} by {@code other}
  *
   */
  public RationalNumber div(RationalNumber other) {
    return this.mul(other.inv()).simplify();
  }

  @Override
  public String toString() {
    String s = Integer.toString(numerator) +"/"+ Integer.toString(denominator);
    return s;
  }

  @Override
  public boolean equals(Object obj) {
    if( !(obj instanceof RationalNumber other)) return false;
    this.simplify(); other.simplify();
    return this.numerator == other.numerator && this.denominator == other.denominator;
      
  }
 
  @Override 
  public int hashCode() {
    return 0;
  }
}
