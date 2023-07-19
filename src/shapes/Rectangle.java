package shapes;

import java.text.DecimalFormat;

/**
 * Rectangle class.
 */
public class Rectangle extends AbstractRectangle {
  /**
   * Rectangle constructor.
   * @param width width
   * @param height height
   * @param x x-coordinate for point
   * @param y y-coordinate for point
   * @param r red value
   * @param g green value
   * @param b blue value
   */
  public Rectangle(double width, double height, int x, int y, double r, double g, double b)
          throws IllegalArgumentException {
    super(width, height, x, y, r, g, b);
  }

  /**
   * Create copy of rectangle.
   * @return copy of rectangle
   */
  @Override
  public Rectangle copy() {
    return new Rectangle(this.width, this.height, this.point.getX(), this.point.getY(),
            this.color.getRed(), this.color.getGreen(), this.color.getBlue());
  }
}
