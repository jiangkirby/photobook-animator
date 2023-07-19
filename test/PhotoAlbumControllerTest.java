import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import controller.PhotoAlbumController;
import photoalbum.PhotoAlbum;

/**
 * PhotoAlbumControllerTest class.
 */
public class PhotoAlbumControllerTest {
  private PhotoAlbumController controller;

  /**
   * Gives a test file with all commands to test controller's shape methods.
   */
  @Before
  public void setUp() {
    controller = new PhotoAlbumController("testing.txt", null, 1000, 800);
    controller.executeCommands("graphical");
  }

  /**
   * Tests getSnapshots method.
   */
  @Test
  public void testFirst() {
    assertEquals(4, controller.getSnapshots().size());
  }

  /**
   * Tests creating a separate PhotoAlbum object and giving it the same commands as the controller.
   * Then compares the snapshots that the new PhotoAlbum object has to the ones the controller has.
   * Data should be the same (except for snapshot times that may vary by milliseconds).
   */
  @Test
  public void testSecond() {
    PhotoAlbum myAlbum = new PhotoAlbum();
    myAlbum.createShape("rectangle", "rect1",
            100, 200, 0, 0, 0, 255, 0);
    myAlbum.takeSnapshot("First rectangle");
    myAlbum.moveShape("rect1", 200, 100);
    myAlbum.recolorShape("rect1", 255, 0, 0);
    myAlbum.takeSnapshot("Moved and recolored");
    myAlbum.resizeShape("rect1", 200, 400);
    myAlbum.takeSnapshot("Resized");
    myAlbum.removeShape("rect1");
    myAlbum.takeSnapshot("Blank");
    assertEquals(myAlbum.getAllSnapshots().size(), controller.getSnapshots().size());
  }
}
