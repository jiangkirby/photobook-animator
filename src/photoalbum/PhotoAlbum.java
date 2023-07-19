package photoalbum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import shapes.IShape;
import shapes.Oval;
import shapes.Rectangle;

/**
 * PhotoAlbum class.
 */
public class PhotoAlbum {
  private Map<String, IShape> shapes;
  private List<Snapshot> snapshots;

  /**
   * PhotoAlbum constructor.
   */
  public PhotoAlbum() {
    shapes = new LinkedHashMap<>();
    snapshots = new ArrayList<>();
  }

  /**
   * Creates shape to add to canvas.
   * @param type shape type
   * @param name shape name
   * @param width shape width
   * @param height shape height
   * @param x x-coordinate for point
   * @param y y-coordinate for point
   * @param r RGB red value
   * @param g RGB green value
   * @param b RGB blue value
   * @throws IllegalArgumentException if shape type not valid
   */
  public void createShape(String type, String name, double width, double height, int x, int y,
                          double r, double g, double b) throws IllegalArgumentException {
    IShape shape;
    switch (type.toLowerCase()) {
      case "rectangle":
        shape = new Rectangle(width, height, x, y, r, g, b);
        break;
      case "oval":
        shape = new Oval(width, height, x, y, r, g, b);
        break;
      default:
        throw new IllegalArgumentException("Shape not valid");
    }
    this.shapes.put(name, shape);
  }

  /**
   * Moves a shape to different x and y coordinate.
   * @param name name of shape to move
   * @param x new x-coordinate
   * @param y new y-coordinate
   * @throws IllegalArgumentException if shape not found
   */
  public void moveShape(String name, int x, int y) throws IllegalArgumentException {
    IShape shape = shapes.get(name);
    if (shape == null) {
      throw new IllegalArgumentException("Shape not found");
    }
    shape.changePoint(x, y);
  }

  /**
   * Resizes a shape.
   * @param name name of shape to resize
   * @param width new width
   * @param height new height
   * @throws IllegalArgumentException if new width or height are 0 or negative
   */
  public void resizeShape(String name, double width, double height) throws IllegalArgumentException {
    IShape shape = shapes.get(name);
    if (shape == null || width <= 0 || height <= 0) {
      throw new IllegalArgumentException("Error resizing shape");
    }
    shape.changeWidth(width);
    shape.changeHeight(height);
  }

  /**
   * Recolor a shape.
   * @param name name of shape to recolor
   * @param r new RGB red value
   * @param g new RGB green value
   * @param b new RGB blue value
   * @throws IllegalArgumentException if RGB values are invalid
   */
  public void recolorShape(String name, double r, double g, double b) throws IllegalArgumentException {
    IShape shape = shapes.get(name);
    if (shape == null || r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255) {
      throw new IllegalArgumentException("Error changing shape color");
    }
    shape.changeColor(r, g, b);
  }

  /**
   * Removes a shape from the canvas.
   * @param name name of shape to remove
   * @throws IllegalArgumentException if shape not found
   */
  public void removeShape(String name) throws IllegalArgumentException {
    if (shapes.remove(name) == null) {
      throw new IllegalArgumentException("Shape not found");
    }
  }

  /**
   * Takes a snapshot and adds it to the history of snapshots taken.
   * @param description description to give to snapshot
   * @throws IllegalArgumentException if description is null or empty
   */
  public void takeSnapshot(String description) throws IllegalArgumentException {
    snapshots.add(new Snapshot(description, this.shapes));
  }

  /**
   * Returns a string of all snapshots.
   * @return string of all snapshots
   */
  public String getSnapshots() {
    String allSnapshots = "";
    for (Snapshot snapshot : snapshots) {
      allSnapshots += snapshot.toString() + "\n";
    }
    if (allSnapshots.isEmpty()) return null;
    return "Printing Snapshots\n" + allSnapshots;
  }

  /**
   * Getter for all snapshots.
   * @return all snapshots
   */
  public List<Snapshot> getAllSnapshots() {
    return this.snapshots;
  }

  /**
   * Clears all shapes currently on the canvas.
   */
  public void resetCanvas() {
    this.shapes = new HashMap<>();
  }

  /**
   * Clears history of snapshots.
   */
  public void resetSnapshots() {
    this.snapshots = new ArrayList<>();
  }

  /**
   * ToString method.
   * @return toString
   */
  public String toString() {
    String toString = "";
    for (Map.Entry<String, IShape> entry : this.shapes.entrySet()) {
      toString += "Name: " + entry.getKey() + "\n" + entry.getValue().toString() + "\n";
    }
    return toString;
  }
}
