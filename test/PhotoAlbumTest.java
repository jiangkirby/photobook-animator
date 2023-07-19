import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import photoalbum.PhotoAlbum;

/**
 * PhotoAlbumTest class. Tests snapshots as well as all current shapes.
 */
public class PhotoAlbumTest {
  private PhotoAlbum myAlbum;

  @Before
  public void setUp() {
    myAlbum = new PhotoAlbum();
  }

  /**
   * Tests creating shapes and making sure the toString method gives correct canvas picture.
   */
  @Test
  public void testFirst() {
    myAlbum.createShape("Oval", "Oval1", 3.5, 7.1, 100, 150, 1.0, 0.0, 0.0);
    myAlbum.createShape("Rectangle", "Rectangle1", 2.9, 3.4, 0, 0, 0.0, 1.0, 0.0);
    assertEquals("Name: Rectangle1\n"
            + "Type: Rectangle\n"
            + "Min corner: (0.0,0.0), Width: 2.9, Height: 3.4, Color: (0.0,1.0,0.0)\n"
            + "\n" + "Name: Oval1\n"
            + "Type: Oval\n"
            + "Center: (100.0,150.0), X radius: 3.5, Y radius: 7.1, Color: (1.0,0.0,0.0)\n\n",
            myAlbum.toString());
  }

  /**
   * Tests creation of invalid shape.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testSecond() {
    myAlbum.createShape("Box", "Box1", 3.5, 7.1, 100, 150, 1.0, 0.0, 0.0);
  }

  /**
   * Tests moveShape method on both an oval and a rectangle.
   */
  @Test
  public void testThird() {
    myAlbum.createShape("Oval", "Oval1", 3.5, 7.1, 100, 150, 1.0, 0.0, 0.0);
    myAlbum.createShape("Rectangle", "Rectangle1", 2.9, 3.4, 0, 0, 0.0, 1.0, 0.0);
    myAlbum.moveShape("Oval1", 0, 0);
    myAlbum.moveShape("Rectangle1", 100, 150);
    assertEquals("Name: Rectangle1\n"
                    + "Type: Rectangle\n"
                    + "Min corner: (100.0,150.0), Width: 2.9, Height: 3.4, Color: (0.0,1.0,0.0)\n"
                    + "\n" + "Name: Oval1\n"
                    + "Type: Oval\n"
                    + "Center: (0.0,0.0), X radius: 3.5, Y radius: 7.1, Color: (1.0,0.0,0.0)\n\n",
            myAlbum.toString());
  }

  /**
   * Tests moving a shape not on the canvas.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testFourth() {
    myAlbum.createShape("Oval", "Oval1", 3.5, 7.1, 100, 150, 1.0, 0.0, 0.0);
    myAlbum.moveShape("Rectangle1", 200, 200);
  }

  /**
   * Tests resizeShape method.
   */
  @Test
  public void testFifth() {
    myAlbum.createShape("Oval", "Oval1", 3.5, 7.1, 100, 150, 1.0, 0.0, 0.0);
    myAlbum.createShape("Rectangle", "Rectangle1", 2.9, 3.4, 0, 0, 0.0, 1.0, 0.0);
    myAlbum.resizeShape("Oval1", 1.1, 2.2);
    myAlbum.resizeShape("Rectangle1", 3.1, 10.1);
    assertEquals("Name: Rectangle1\n"
                    + "Type: Rectangle\n"
                    + "Min corner: (0.0,0.0), Width: 3.1, Height: 10.1, Color: (0.0,1.0,0.0)\n"
                    + "\n" + "Name: Oval1\n"
                    + "Type: Oval\n"
                    + "Center: (100.0,150.0), X radius: 1.1, Y radius: 2.2, Color: (1.0,0.0,0.0)\n\n",
            myAlbum.toString());
  }

  /**
   * Tests resizing a shape not on the canvas.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testSixth1() {
    myAlbum.createShape("Oval", "Oval1", 3.5, 7.1, 100, 150, 1.0, 0.0, 0.0);
    myAlbum.resizeShape("Rectangle1", 10.1, 10.2);
  }

  /**
   * Tests resizing a shape to an invalid width.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testSixth2() {
    myAlbum.createShape("Oval", "Oval1", 3.5, 7.1, 100, 150, 1.0, 0.0, 0.0);
    myAlbum.resizeShape("Oval1", -1, 3.4);
  }

  /**
   * Tests resizing a shape to an invalid height.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testSixth3() {
    myAlbum.createShape("Oval", "Oval1", 3.5, 7.1, 100, 150, 1.0, 0.0, 0.0);
    myAlbum.resizeShape("Oval1", 4.5, 0);
  }

  /**
   * Tests recolorShape method.
   */
  @Test
  public void testSeventh() {
    myAlbum.createShape("Oval", "Oval1", 3.5, 7.1, 100, 150, 1.0, 0.0, 0.0);
    myAlbum.createShape("Rectangle", "Rectangle1", 2.9, 3.4, 0, 0, 0.0, 1.0, 0.0);
    myAlbum.recolorShape("Oval1", 0.5, 0.5, 0.0);
    myAlbum.recolorShape("Rectangle1", 0.0, 0.5, 0.5);
    assertEquals("Name: Rectangle1\n"
                    + "Type: Rectangle\n"
                    + "Min corner: (0.0,0.0), Width: 2.9, Height: 3.4, Color: (0.0,0.5,0.5)\n"
                    + "\n" + "Name: Oval1\n"
                    + "Type: Oval\n"
                    + "Center: (100.0,150.0), X radius: 3.5, Y radius: 7.1, Color: (0.5,0.5,0.0)\n\n",
            myAlbum.toString());
  }

  /**
   * Tests recoloring a shape not on the canvas.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testEighth1() {
    myAlbum.createShape("Oval", "Oval1", 3.5, 7.1, 100, 150, 1.0, 0.0, 0.0);
    myAlbum.recolorShape("Rectangle1", 0.3, 0.3, 0.4);
  }

  /**
   * Tests recoloring a shape with invalid red RGB value.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testEighth2() {
    myAlbum.createShape("Oval", "Oval1", 3.5, 7.1, 100, 150, 1.0, 0.0, 0.0);
    myAlbum.recolorShape("Oval1", 2.0, 0.3, 0.4);
  }

  /**
   * Tests recoloring a shape with invalid green RGB value.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testEighth3() {
    myAlbum.createShape("Oval", "Oval1", 3.5, 7.1, 100, 150, 1.0, 0.0, 0.0);
    myAlbum.recolorShape("Oval1", 0.3, -0.5, 0.4);
  }

  /**
   * Tests recoloring a shape with invalid blue RGB value.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testEighth4() {
    myAlbum.createShape("Oval", "Oval1", 3.5, 7.1, 100, 150, 1.0, 0.0, 0.0);
    myAlbum.recolorShape("Oval1", 0.3, 0.3, 10.2);
  }

  /**
   * Tests removeShape method.
   */
  @Test
  public void testNinth() {
    myAlbum.createShape("Oval", "Oval1", 3.5, 7.1, 100, 150, 1.0, 0.0, 0.0);
    myAlbum.removeShape("Oval1");
    assertEquals("", myAlbum.toString());
  }

  /**
   * Tests removing a shape not on the canvas.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testTenth() {
    myAlbum.createShape("Oval", "Oval1", 3.5, 7.1, 100, 150, 1.0, 0.0, 0.0);
    myAlbum.removeShape("Rectangle1");
  }

  /**
   * Tests takeSnapshot method and getSnapshots method.
   */
  @Test
  public void testEleventh() {
    myAlbum.createShape("Oval", "Oval1", 3.5, 7.1, 100, 150, 1.0, 0.0, 0.0);
    myAlbum.takeSnapshot("Added oval shape");
    myAlbum.createShape("Rectangle", "Rectangle1", 2.9, 3.4, 0, 0, 0.0, 1.0, 0.0);
    myAlbum.takeSnapshot("Added rectangle shape");
    myAlbum.removeShape("Oval1");
    myAlbum.takeSnapshot("Removed oval shape");
    assertNotNull(myAlbum.getSnapshots());
  }

  /**
   * Tests resetSnapshots method.
   */
  @Test
  public void testTwelfth() {
    myAlbum.createShape("Oval", "Oval1", 3.5, 7.1, 100, 150, 1.0, 0.0, 0.0);
    myAlbum.takeSnapshot("Added oval shape");
    myAlbum.createShape("Rectangle", "Rectangle1", 2.9, 3.4, 0, 0, 0.0, 1.0, 0.0);
    myAlbum.takeSnapshot("Added rectangle shape");
    myAlbum.removeShape("Oval1");
    myAlbum.takeSnapshot("Removed oval shape");
    myAlbum.resetSnapshots();
    assertNull(myAlbum.getSnapshots());
  }

  /**
   * Tests resetCanvas method.
   */
  @Test
  public void testThirteenth() {
    myAlbum.createShape("Oval", "Oval1", 3.5, 7.1, 100, 150, 1.0, 0.0, 0.0);
    myAlbum.createShape("Rectangle", "Rectangle1", 2.9, 3.4, 0, 0, 0.0, 1.0, 0.0);
    myAlbum.resetCanvas();
    assertEquals("", myAlbum.toString());
  }
}
