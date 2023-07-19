import controller.PhotoAlbumController;

/**
 * PhotoAlbumMain class.
 */
public class PhotoAlbumMain {

  /**
   * Takes in args and starts the controller.
   * @param args given by user
   */
  public static void main(String[] args) {
    String inputFile = null;
    String view = null;
    String outFile = null;
    int maxX = 1000;
    int maxY = 1000;

    for (int i = 0; i < args.length; i++) {
      if (args[i].equals("-in")) {
        inputFile = args[++i];
      } else if (args[i].equals("-view") || args[i].equals("-v")) {
        view = args[++i];
      } else if (args[i].equals("-out")) {
        outFile = args[++i];
      } else if (i == args.length - 2) {
        maxX = Integer.parseInt(args[i]);
        maxY = Integer.parseInt(args[i + 1]);
        break;
      }
    }
    if (view != null) {
      new PhotoAlbumController(inputFile, outFile, maxX, maxY).executeCommands(view);
    }
  }
}