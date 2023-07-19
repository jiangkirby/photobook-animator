package controller;

import java.util.List;
import java.util.Map;

import photoalbum.PhotoAlbum;
import photoalbum.Snapshot;
import shapes.IShape;
import view.GraphicalView;
import view.WebView;

/**
 * PhotoAlbumController class.
 */
public class PhotoAlbumController {
  private List<List<String>> commands;
  private String outFile;
  private int maxX;
  private int maxY;
  private PhotoAlbum album;
  private List<Snapshot> snapshots;
  private GraphicalView view;
  private int page;

  /**
   * Constructor that creates a new FileController to read and store commands.
   * @param inputFile file with commands
   */
  public PhotoAlbumController(String inputFile, String outFile, int maxX, int maxY) {
    this.commands = new FileController(inputFile).getCommands();
    this.outFile = outFile;
    this.maxX = maxX;
    this.maxY = maxY;
    this.album = new PhotoAlbum();
    this.page = 0;
  }

  /**
   * Starts the whole view.
   */
  public void executeCommands(String view) {
    for (List<String> command : this.commands) {
      String action = command.get(0);
      if (!action.isBlank()) {
        switch (action) {
          case "shape":
            createShape(command);
            break;
          case "move":
            moveShape(command);
            break;
          case "color":
            recolorShape(command);
            break;
          case "resize":
            resizeShape(command);
            break;
          case "remove":
            removeShape(command);
            break;
          case "snapshot":
            takeSnapshot(command);
            break;
          default:
            System.err.println("Unrecognized command: " + command);
            break;
        }
      }
    }
    this.snapshots = this.album.getAllSnapshots();
    if (view.equalsIgnoreCase("graphical")) {
      this.view = new GraphicalView(this, this.maxX, this.maxY);
      this.view.paintSnapshot(this.snapshots.get(this.page));
    } else if (view.equalsIgnoreCase("web")) {
      displayWebView();
    }
  }

  /**
   * Displays the web html view.
   */
  public void displayWebView() {
    WebView webView = new WebView(this.outFile);
    webView.beginHeader("Photo Album");
    for (Snapshot snapshot : this.snapshots) {
      webView.beginSnapshot(snapshot.getID());
      for (Map.Entry<String, IShape> entry : snapshot.getShapes().entrySet()) {
        IShape shape = entry.getValue();
        String type = shape.getClass().getSimpleName().toLowerCase();
        String rgb = String.valueOf(shape.getColor().getRed()) + "," +
                String.valueOf(shape.getColor().getGreen()) + "," +
                String.valueOf(shape.getColor().getBlue());
        switch (type) {
          case "oval":
            webView.addOval(entry.getKey(), String.valueOf(shape.getWidth()), String.valueOf(shape.getHeight()),
                    String.valueOf(shape.getPoint().getX()), String.valueOf(shape.getPoint().getY()),
                    rgb);
            break;
          case "rectangle":
            webView.addRectangle(entry.getKey(), String.valueOf(shape.getWidth()), String.valueOf(shape.getHeight()),
                    String.valueOf(shape.getPoint().getX()), String.valueOf(shape.getPoint().getY()),
                    rgb);
            break;
          default:
            break;
        }
      }
      webView.closeSnapshot();
    }
    webView.closeHeader();
    webView.display();
  }

  /**
   * Goes to the next page for the graphical view.
   * @return true if current page isn't last page
   */
  public boolean nextPage() {
    if (this.page < this.snapshots.size() - 1) {
      this.page++;
      this.view.paintSnapshot(this.snapshots.get(this.page));
      return true;
    }
    return false;
  }

  /**
   * Goes to the previous page for the graphical view.
   * @return true if current page isn't first page
   */
  public boolean prevPage() {
    if (this.page > 0) {
      this.page--;
      this.view.paintSnapshot(this.snapshots.get(this.page));
      return true;
    }
    return false;
  }

  /**
   * Getter for all snapshots in photo album.
   * @return all snapshots
   */
  public List<Snapshot> getSnapshots() {
    return this.snapshots;
  }

  /**
   * Displays snapshot by index for the graphical view.
   * @param i index of snapshot to show
   */
  public void viewSnapshot(int i) {
    this.page = i;
    this.view.paintSnapshot(this.snapshots.get(this.page));
  }

  /**
   * Creates shape in photo album.
   * @param command command with parameters
   */
  private void createShape(List<String> command) {
    String name = command.get(1);
    String type = command.get(2);
    int x = Integer.parseInt(command.get(3));
    int y = Integer.parseInt(command.get(4));
    int width = Integer.parseInt(command.get(5));
    int height = Integer.parseInt(command.get(6));
    int red = Integer.parseInt(command.get(7));
    int green = Integer.parseInt(command.get(8));
    int blue = Integer.parseInt(command.get(9));
    this.album.createShape(type, name, width, height, x, y, red, green, blue);
  }

  /**
   * Mvoes shape in photo album.
   * @param command command with parameters
   */
  private void moveShape(List<String> command) {
    String name = command.get(1);
    int x = Integer.parseInt(command.get(2));
    int y = Integer.parseInt(command.get(3));
    this.album.moveShape(name, x, y);
  }

  /**
   * Recolors shape in photo album
   * @param command command with parameters
   */
  private void recolorShape(List<String> command) {
    String name = command.get(1);
    int red = Integer.parseInt(command.get(2));
    int green = Integer.parseInt(command.get(3));
    int blue = Integer.parseInt(command.get(4));
    this.album.recolorShape(name, red, green, blue);
  }

  /**
   * Resizes shape in photo album.
   * @param command command with parameters
   */
  private void resizeShape(List<String> command) {
    String name = command.get(1);
    int width = Integer.parseInt(command.get(2));
    int height = Integer.parseInt(command.get(3));
    this.album.resizeShape(name, width, height);
  }

  /**
   * Removes shape in photo album.
   * @param command command with parameter
   */
  private void removeShape(List<String> command) {
    String name = command.get(1);
    this.album.removeShape(name);
  }

  /**
   * Takes snapshot of current album shapes.
   * @param command command with description
   */
  private void takeSnapshot(List<String> command) {
    String description = "";
    if (command.size() > 1) {
      for (int i = 1; i < command.size(); i++) {
        description += command.get(i);
        if (i != command.size() - 1) description += " ";
      }
    }
    this.album.takeSnapshot(description);
  }
}
