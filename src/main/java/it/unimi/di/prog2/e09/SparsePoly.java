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

package it.unimi.di.prog2.e09;

import it.unimi.di.prog2.h08.impl.NegativeExponentException;
import java.util.List;
import java.util.LinkedList;

/**
 * {@code SparsePoly}s are immutable polynomials with integer coefficients such that the number of
 * nonzero coefficient is small with respect to the degree.
 *
 * <p>A typical {@code Poly} is \( p = c_0 + c_1 x + c_2 x^2 + \cdots + c_n x^n \).
 */
public class SparsePoly {

  /**
   * A record holding a term of the polynomial.
   *
   * @param coeff the coefficient.
   * @param degree the degree.
   */
  public record Term(int coeff, int degree) {
    /**
     * Builds a term.
     *
     * @throws NegativeExponentException if if {@code degree} &lt; 0.
     */
    public Term { // using the compact constructor
      if (degree < 0)
        throw new NegativeExponentException("A term cannot have a negative exponent.");
    }
  }

  /** The array of terms (in increasing non-zero degree). */
  private final List<Term> terms;
  private int degree;

  /** Initializes this to be the zero polynomial, that is \( p = 0 \). */
  //utile che sia popolata per il toString.
  //l'addizione puo' gestirlo nei termini noti
  public SparsePoly() {
    Term t = new Term(0,0);
    terms = new LinkedList<Term>(); terms.add(t);
    degree = 0;
  }

  /**
   * Initializes this to be the polynomial \(p = cx^n\).
   *
   * @param c the coefficient.
   * @param n the degree.
   * @throws NegativeExponentException if {@code n} &lt; 0.
   */
  public SparsePoly(int c, int n) throws NegativeExponentException {
    Term t = new Term(c,n);
    terms = new LinkedList<Term>(); terms.add(t);
    degree = n;
    
  }

  /**
   * Returns the coefficient of the term of given exponent.
   *
   * @param d the exponent of the term to consider.
   * @return the coefficient of the considered term.
   */
   //se il grado d non esiste nel polinomio significa che il suo coefficiente e' 0
  public int coeff(int d) {
    for(Term t: terms) {
      if(t.degree==d) return t.coeff;
    }
    return 0;
  }

  /**
   * Returns the degree of this polynomial.
   *
   * @return the largest exponent with a non-zero coefficient; returns 0 if this is the zero {@code
   *     Poly}.
   */
  public int degree() {
    return degree;
  }

  /**
   * Performs polynomial addition.
   *
   * <p>If \( p \) is this polynomial, returns \( p + q \).
   *
   * @param q the polynomial to add to this one.
   * @return the sum among this and the given polynomial.
   * @throws NullPointerException if {@code q} is {@code null}.
   */
  public SparsePoly add(SparsePoly q) throws NullPointerException {

    if(q==null) throw new NullPointerException();

    SparsePoly res = new SparsePoly();
    if(q.degree>this.degree) res.degree = q.degree;
    else res.degree = this.degree;

    for(Term t1: q.terms) {
      for(Term t2: this.terms) {
        if(t2.degree==t1.degree) {
          res.terms.add(new Term(t1.degree, t1.coeff+t2.coeff));
        }
      }
    }

    return res;

    
  }

  /**
   * Performs polynomial multiplication.
   *
   * <p>If \( p \) is this polynomial, returns \( p q \).
   *
   * @param q the polynomial to multiply by this one.
   * @return the product among this and the given polynomial.
   * @throws NullPointerException if {@code q} is {@code null}.
   */
  public SparsePoly mul(SparsePoly q) throws NullPointerException {

    if(q==null) throw new NullPointerException();

    SparsePoly res = new SparsePoly();
    res.degree = this.degree * q.degree;

    for(Term t1: this.terms) {
      for(Term t2: q.terms) {
        res.terms.add(new Term(t1.degree+t2.degree, t1.coeff*t2.coeff));
      }
    }

    return res.sumSameCoeff();


  }

  /**
   * Performs polynomial subtraction.
   *
   * <p>If \( p \) is this polynomial, returns \( p - q \).
   *
   * @param q the polynomial to subtract from this one.
   * @return the subtraction among this and the given polynomial.
   * @throws NullPointerException if {@code q} is {@code null}.
   */
  public SparsePoly sub(SparsePoly q) throws NullPointerException {
    return this.add(q.minus());
  }

  /**
   * Returns the negate polynomial.
   *
   * <p>If \( p \) is this polynomial, returns \( -p \).
   *
   * @return this polynomial multiplied by \( -1 \).
   */
   //metodo modificatore?
  public SparsePoly minus() {
    for(Term t: terms) {
      t.coeff = - t.coeff;
    }
  }

  /**
  * Sums the terms of the polynomial which have the same coefficient 
  *
  * @return this polynomial with all coefficient by the same degree summed up
  *
  *
   */
  private sumSameCoeff() {
    for(Term t1: coeff) {
      for(Term t2: coeff) {
        if(t1.degree==t2.degree && t1!=t2)  t1.coeff += t2.coeff;
      }
    }
  }
}
