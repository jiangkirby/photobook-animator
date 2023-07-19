package view;

import java.awt.*;
import java.util.LinkedHashMap;

import javax.swing.*;

import photoalbum.Snapshot;
import shapes.IShape;

/**
 * SnapshotPanel class.
 */
public class SnapshotPanel extends JPanel {
  private LinkedHashMap<String, IShape> shapeMap;

  /**
   * Constructor.
   */
  public SnapshotPanel() {}

  /**
   * Paints the snapshot.
   * @param g the <code>Graphics</code> object to protect
   */
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    for (IShape shape : this.shapeMap.values()) {
      g.setColor(new Color((int) shape.getColor().getRed(),
              (int) shape.getColor().getGreen(), (int) shape.getColor().getBlue()));
      String type = shape.getClass().getSimpleName().toLowerCase();
      switch (type) {
        case "oval":
          g.fillOval(shape.getPoint().getX(), shape.getPoint().getY(),
                  (int) shape.getWidth(), (int) shape.getHeight());
          break;
        case "rectangle":
          g.fillRect(shape.getPoint().getX(), shape.getPoint().getY(),
                  (int) shape.getWidth(), (int) shape.getHeight());
          break;
        default:
          break;
      }
    }
  }

  /**
   * Changes the snapshot to paint and repaints it.
   * @param snapshot
   */
  public void addSnapshot(Snapshot snapshot) {
    removeAll();
    this.shapeMap = snapshot.getShapes();
    JLabel description;
    String snapshotDescription = snapshot.getDescription();
    if (!snapshotDescription.isBlank()) {
      description = new JLabel(snapshot.getID() + "     Description: " + snapshotDescription);
    } else {
      description = new JLabel(snapshot.getID());
    }
    add(description, BorderLayout.NORTH);
    repaint();
  }
}
