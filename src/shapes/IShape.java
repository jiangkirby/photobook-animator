package shapes;

/**
 * IShape interface.
 */
public interface IShape {
  /**
   * Changes width.
   * @param width new width
   */
  void changeWidth(double width);

  /**
   * Changes height.
   * @param height new height
   */
  void changeHeight(double height);

  /**
   * Changes point.
   * @param x new x-coordinate
   * @param y new y-coordinate
   */
  void changePoint(int x, int y);

  /**
   * Changes color.
   * @param r new red value
   * @param g new green value
   * @param b new blue value
   */
  void changeColor(double r, double g, double b);

  /**
   * Create copy of shape.
   * @return copy of shape
   */
  IShape copy();

  /**
   * Getter for width.
   * @return width
   */
  double getWidth();

  /**
   * Getter for height.
   * @return height
   */
  double getHeight();

  /**
   * Getter for point.
   * @return point
   */
  Point getPoint();

  /**
   * Getter for color.
   * @return color
   */
  Color getColor();
}
