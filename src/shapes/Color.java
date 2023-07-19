package shapes;

import java.text.DecimalFormat;

/**
 * Color class.
 */
public class Color {
  private double red;
  private double green;
  private double blue;
  private static final DecimalFormat df = new DecimalFormat("0.0");

  /**
   * Color constructor.
   * @param red red value
   * @param green green value
   * @param blue blue value
   */
  public Color(double red, double green, double blue) {
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  /**
   * Getter for red value.
   * @return red value
   */
  public double getRed() {
    return this.red;
  }

  /**
   * Getter for green value.
   * @return green value
   */
  public double getGreen() {
    return this.green;
  }

  /**
   * Getter for blue value.
   * @return blue value
   */
  public double getBlue() {
    return this.blue;
  }

  /**
   * ToString method.
   * @return toString
   */
  public String toString() {
    return "(" + df.format(this.red) + "," + df.format(this.green) + "," + df.format(this.blue) + ")";
  }
}
