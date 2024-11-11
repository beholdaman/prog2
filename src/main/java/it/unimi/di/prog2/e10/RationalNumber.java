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
  public RationalNumber(int numerator, int denominator) {}

  /**
   * Returns the sum of this rational number and another one.
   *
   * @param other the other rational number.
   * @return the sum of this rational number and {@code other}.
   */
  public RationalNumber add(RationalNumber other) {
    return null;
  }

  /**
  * Returns int representation of the denominator of {@code this}
  *
  * @return int value of the denominator of {@code this}
  *
  * */
  private int den() {
    return 0;
  }

  /**
  * Returns int representation of the numerator of {@code this}
  *
  * @return int value of the numerator of {@code this}
  *
  * */
  private int num() {
    return 0;
  }

  /**
   * Returns the product of this rational number and another one.
   *
   * @param other the other rational number.
   * @return the product of this rational number and {@code other}.
   */
  public RationalNumber mul(RationalNumber other) {
    return null;
  }

  /**
  * Returns the inverse of this rational number, that is {@code this} elevated to -1
  *
  * @return the inverse of {@code this}
  *
   */
  public RationalNumber inv() {
    return null;
  }

  /**
  * Returns the opposite if this rational number, that is {@code this} multiplied by -1
  *
  * @return the opposite of {@code this}
  *
  * */
  public RationalNumber opp() {
    return null;
  }

  /**
  * Returns the rational number resulting from the subtraction of {@code other} from {@code this}
  *
  * @param other rational number
  * @return a new rational number that is the result of the subtraction of {@code other} from {@code this}
  *
  * */
  public RationalNUmber suv(RationalNumber other) {
    return null;
  }

  /**
  * Returns the rational number resulting from the division of {@code this} by {@code other}
  *
  * @param other rational number
  * @return a new rational that is the result of dividing {@code this} by {@code other}
  *
   */
  public RationalNumber div(RationalNumber other) {
    return null;
  }

  @Override
  public String toString() {
    return null;
  }

  @Override
  public boolean equals(RationalNumber other) {
    return false;
  }

  @Override 
  public int hashCode() {
    return 0;
  }
}