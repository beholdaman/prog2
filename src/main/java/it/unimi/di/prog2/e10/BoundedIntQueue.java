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
 * A <em>queue</em> is a mutable data structure that provides access to its elements in
 * first-in/first-out order.
 *
 * <p>A <em>bounded</em> queue has an upper bound, established when a queue is created, on the
 * number of elements that can be stored in the queue.
 */
public class BoundedIntQueue {

  // EXERCISE: complete following the specification (with particular attention
  // to the eventual exceptions) and provide an implementation (including the
  // equals, hashCode, and toString methods); add methods that are adequate to
  // the specification.

  // Given the boundedness constraint, it is not allowed to use any Java
  // Collection Framework class. An array can be used to store the elements in a
  // circular buffer (see https://www.wikiwand.com/en/articles/Circular_buffer).
  
  int cap;
  int[] buffer;
  int i;  //first full spot
  int f; //first free spot
  int size; //number of elements

  //i=f means queue is empty
  //i=f-1 means queue is full

  /*-
  *
  * RI: i and f cannot be greater than cap-1
  *     cap must 1 or greater
  *     size must not be negative
  *     size must be lower than cap -1
  *    
  *
  * AF: the elements of the queue are the elements in the buffer
  *     the first element to be insereted is at i, the last is at f
  *
  *
  *
  */

  /**
   * Creates a new bounded queue with the given capacity.
   *
   * @param capacity the capacity of the queue.
   * @throws IllegalArgumentException if {@code capacity} is negative.
   */
  public BoundedIntQueue(int capacity) {
    if(capacity<1) throw new IllegalArgumentException("Queue capacity must be positive");
    cap = capacity;
    buffer = new int[cap];
    i = 0;
    f = 0;
    size = 0;
  }

  /**
  * Returns true if the queue is empty, false otherwise
  *
  * @return true if queue contains zero elements, false otherwise
  *
  */
  public boolean isEmpty() {
    return i==f;
  }

  /**
  * Returns number of elements on the queue
  *
  * @return the number of elements in the queue
  *
  */
  public int size() {
    return size;
  }

  /**
  * Returns the maximum capacity of the bounded queue
  *
  * @return the maximum number of elements the queue can contain
  *
  */
  public int capacity() {
    return cap;
  }

  /**
   * Adds an element to the queue.
   *
   * @param x the element to add.
   * @throws IllegalStateException if the queue is full.
   */
  public void enqueue(int x) {
    if(f==(i-1)) throw new IllegalStateException("Cannot insert in full queue");
    buffer[f] = x;
    f = (f+1)%cap;
    size++;
    return; 
  }

  /**
   * Removes the element at the head of the queue.
   *
   * @return the element at the head of the queue.
   * @throws IllegalStateException if the queue is empty.
   */
  public int dequeue() {
    if(i==f) throw new IllegalStateException("Cannot remove from empty queue");
    i=(i+1)%cap;
    size--;
    return buffer[i-1];
  }

  //@Override
  /*public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for(int s = i; ; s=(s+1)%cap) {
      sb.append(Integer.toString(buffer[s]));
      sb.append(" ");
    }
    sb.append("]");
    
    return sb.toString();
  }*/

  @Override 
  public boolean equals(Object obj) {
    return false;
  }

  @Override
  public int hashCode() {
    return 0;
  }
}
