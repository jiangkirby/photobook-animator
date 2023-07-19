package photoalbum;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import shapes.IShape;

/**
 * Snapshot class.
 */
public class Snapshot {
  private LocalDateTime id;
  private String description;
  private LinkedHashMap<String, IShape> shapes;

  /**
   * Snapshot constructor.
   * @param description description to give snapshot
   * @param shapes all shapes and their names on the current canvas
   */
  public Snapshot(String description, Map<String, IShape> shapes) {
    this.id = java.time.LocalDateTime.now();
    this.description = description;
    this.shapes = shapes.entrySet().stream()
            .collect(Collectors.toMap(a -> a.getKey(), a -> a.getValue().copy(), (a, b) -> a, LinkedHashMap::new));
  }

  /**
   * Getter for ID.
   * @return ID
   */
  public String getID() {
    return this.id.format(java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss.SSS"));
  }

  /**
   * Getter for description.
   * @return description
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * Getter for all shapes in snapshot.
   * @return all shapes
   */
  public LinkedHashMap<String, IShape> getShapes() {
    return this.shapes;
  }

  /**
   * ToString method.
   * @return toString
   */
  public String toString() {
    String toString = "Snapshot ID: " + this.id
            + "\nTimestamp: " + this.id.format(java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"))
            + "\nDescription: " + this.description
            + "\nShape Information:";
    for (Map.Entry<String, IShape> entry : this.shapes.entrySet()) {
      toString += "\nName: " + entry.getKey() + "\n" + entry.getValue().toString();
    }
    return toString;
  }
}
