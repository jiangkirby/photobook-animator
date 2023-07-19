package shapes;

import java.text.DecimalFormat;

/**
 * AbstractRectangle abstract class.
 */
public abstract class AbstractRectangle implements IShape {
  protected double width;
  protected double height;
  protected Point point;
  protected Color color;
  private static final DecimalFormat df = new DecimalFormat("0.0");

  /**
   * AbstractRectangle constructor.
   * @param width width
   * @param height height
   * @param x x-coordinate for point
   * @param y y-coordinate for point
   * @param r red value
   * @param g green value
   * @param b blue value
   */
  public AbstractRectangle(double width, double height, int x, int y, double r, double g, double b)
          throws IllegalArgumentException {
    if (!Checker.isValidShape(width, height, r, g, b)) {
      throw new IllegalArgumentException("Not valid shape");
    }
    this.width = width;
    this.height = height;
    this.point = new Point(x, y);
    this.color = new Color(r, g, b);
  }

  /**
   * Changes width.
   * @param width new width
   */
  @Override
  public void changeWidth(double width) throws IllegalArgumentException {
    if (width <= 0) throw new IllegalArgumentException("Width can't be 0 or negative");
    this.width = width;
  }

  /**
   * Changes height.
   * @param height new height
   */
  @Override
  public void changeHeight(double height) throws IllegalArgumentException {
    if (height <= 0) throw new IllegalArgumentException("Height can't be 0 or negative");
    this.height = height;
  }

  /**
   * Changes point.
   * @param x new x-coordinate
   * @param y new y-coordinate
   */
  @Override
  public void changePoint(int x, int y) {
    this.point = new Point(x, y);
  }

  /**
   * Changes color.
   * @param r new red value
   * @param g new green value
   * @param b new blue value
   * @throws IllegalArgumentException if RGB values are invalid
   */
  @Override
  public void changeColor(double r, double g, double b) throws IllegalArgumentException {
    if (r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255) {
      throw new IllegalArgumentException("Invalid color");
    }
    this.color = new Color(r, g, b);
  }

  /**
   * Getter for width.
   * @return width
   */
  public double getWidth() {
    return this.width;
  }

  /**
   * Getter for height.
   * @return height
   */
  public double getHeight() {
    return this.height;
  }

  /**
   * Getter for point.
   * @return point
   */
  public Point getPoint() {
    return this.point;
  }

  /**
   * Getter for color.
   * @return color
   */
  public Color getColor() {
    return this.color;
  }

  /**
   * ToString method.
   * @return toString
   */
  @Override
  public String toString() {
    return "Type: " + this.getClass().getSimpleName()
            + "\nMin corner: " + this.point.toString()
            + ", Width: " + df.format(this.width)
            + ", Height: " + df.format(this.height)
            + ", Color: " + this.color.toString() + "\n";
  }
}
