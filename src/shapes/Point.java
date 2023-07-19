package shapes;

import java.text.DecimalFormat;

/**
 * Point class.
 */
public class Point {
  private int x;
  private int y;
  private static final DecimalFormat df = new DecimalFormat("0.0");

  /**
   * Point constructor.
   * @param x x-coordinate
   * @param y y-coordinate
   */
  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Getter for x-coordinate.
   * @return x-coordinate
   */
  public int getX() {
    return this.x;
  }

  /**
   * Getter for y-coordinate.
   * @return y-coordinate
   */
  public int getY() {
    return this.y;
  }

  /**
   * ToString method.
   * @return toString
   */
  public String toString() {
    return "(" + df.format(this.x) + "," + df.format(this.y) + ")";
  }
}
