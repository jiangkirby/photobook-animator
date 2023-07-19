package shapes;

/**
 * Checker helper class.
 */
public class Checker {
  /**
   * Checks for valid shape.
   * @param width shape width
   * @param height shape height
   * @param r RGB r value
   * @param g RGB g value
   * @param b RGE b value
   * @return true if valid shape
   */
  public static boolean isValidShape(double width, double height, double r, double g, double b) {
    if (width <= 0 || height <= 0) return false;
    if (r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255) return false;
    return true;
  }
}
