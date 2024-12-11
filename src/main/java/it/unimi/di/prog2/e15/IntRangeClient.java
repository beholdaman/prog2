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

package it.unimi.di.prog2.e15;

import java.util.Scanner;
import java.util.Iterator;

/** A class to test int ranges. */
public class IntRangeClient {

    public static class IntRange implements Iterable<Integer> {

    /*
    * AF: dato un {@code inizio}, una {@code fine} e un {@code passo} interi, 
    *     la serie e' costituita da ogni {@code passo} interi da {@code inizio} a {@code fine}
    * 
    * 
    *
    *
    */

    private int inizio;
    private int fine;
    private int passo;
    private int prossimo;

    /** 
    *  Costruisce una serie che va da {@code inizio} a {@code fine} con passo {@passo}
    * 
    */
    public IntRange(int inizio, int fine, int passo) {
        this.inizio = inizio;
        this.fine = fine;
        this.passo = passo;
        prossimo = inizio;
    }

    
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            @Override
            public boolean hasNext() {
              if(passo>0) return prossimo < fine;
              if(passo<0) return prossimo > fine;
              return false;
            }

            @Override
            public Integer next() {
              int to_return = prossimo;
              prossimo = prossimo + passo;
              return to_return;
            }
        };
    }
   
}

  /** . */
  private IntRangeClient() {}

  /**
   * A method to test the {@link IntRange} class.
   *
   * <p>This methods reads the parameters of an {@link IntRange} from the lines in the standard
   * input in the form {@code command value}, where the command is:
   *
   * <ul>
   *   <li>{@code F} to set the from value of the range.
   *   <li>{@code T} to set the to value of the range.
   *   <li>{@code S} to set the step of the range.
   * </ul>
   *
   * commands can be repeated, the last value is the one that is considered; the default values for
   * from, to and step are respectively {@link Integer#MIN_VALUE}, {@link Integer#MAX_VALUE}, and 1.
   * Once the input is exhausted, the method emits in a single line of the standard output:
   *
   * <ul>
   *   <li>the number of integers in the range,
   *   <li>the first integer in the range (if any),
   *   <li>the last integer in the range (if different from the first).
   * </ul>
   *
   * @param args not used.
   */



  // Uncomment and complete once you have implemented the range class

    public static void main(String[] args) {

      IntRange range;

      //valori di default
      int from = Integer.MIN_VALUE;
      int to = Integer.MAX_VALUE;
      int step = 1;

      try (Scanner sc = new Scanner(System.in)) {
        while (sc.hasNext()) {
          char command = sc.next().charAt(0);
          int value = sc.nextInt();
          switch (command) {
            case 'F':
              from = value;
              break;
            case 'T':
              to = value;
              break;
            case 'S':
              step = value;
              break;
            default:
              throw new IllegalArgumentException("Unknown command: " + command);
          }
        }
      }
      int iterations = 0, first = 0, last = 0;

      range = new IntRange(from,to,step);
      Iterator<Integer> it = range.iterator();

      while(it.hasNext()) {
        last = it.next();
        iterations++;
      }

      first = from;

      System.out.println(
          iterations + (iterations > 0 ? " " + first : "") + (iterations > 1 ? " " + last : ""));
    }
}
