package shapes;

/**
 * Oval class.
 */
public class Oval extends AbstractOval {
  /**
   * Oval constructor.
   * @param width width
   * @param height height
   * @param x x-coordinate for point
   * @param y y-coordinate for point
   * @param r red value
   * @param g green value
   * @param b blue value
   */
  public Oval(double width, double height, int x, int y, double r, double g, double b)
          throws IllegalArgumentException {
    super(width, height, x, y, r, g, b);
  }

  /**
   * Create copy of oval.
   * @return copy of oval
   */
  @Override
  public Oval copy() {
    return new Oval(this.width, this.height, this.point.getX(), this.point.getY(),
            this.color.getRed(), this.color.getGreen(), this.color.getBlue());
  }
}
