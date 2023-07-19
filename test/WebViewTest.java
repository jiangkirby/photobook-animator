import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import view.WebView;

/**
 * WebViewTest class.
 */
public class WebViewTest {
  private WebView webView;

  /**
   * Setup.
   */
  @Before
  public void setUp() {
    webView = new WebView("output.txt");
  }

  /**
   * Tests beginHeader method.
   */
  @Test
  public void testFirst() {
    webView.beginHeader("Header");
    assertEquals("<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head>\n" +
            "\t<style>\n" +
            "\t.snapshot {\n" +
            "\t\tborder: 5px outset khaki;\n" +
            "\t\tbackground-color: gainsboro;\n" +
            "\t}\n" +
            "\t</style>\n" +
            "</head>\n" +
            "<body>\n" +
            "<h1>" + "Header" + "</h1>\n", webView.getHtmlOutput());
  }

  /**
   * Tests beginSnapshot method.
   */
  @Test
  public void testSecond() {
    webView.beginSnapshot("Snapshot");
    assertEquals("<div class=\"snapshot\">\n" +
            "\t<h2>" + "Snapshot" + "</h2>\n" +
            "\t<svg width=\"1000\" height=\"1000\">\n", webView.getHtmlOutput());
  }

  /**
   * Tests addRectangle method.
   */
  @Test
  public void testThird() {
    webView.addRectangle("Rect1", "100", "20", "40", "50", "255,0,0");
    assertEquals("\t\t<rect id=\"" + "Rect1" + "\" x=\"" + "40" + "\" y=\"" + "50" +
            "\" width=\"" + "100" + "\" height=\"" + "20" + "\" fill=\"rgb(" + "255,0,0" + ")\">\n" +
            "\t\t</rect>\n", webView.getHtmlOutput());
  }

  /**
   * Tests addOval method.
   */
  @Test
  public void testFourth() {
    webView.addOval("Oval2", "5", "5", "14", "16", "100,10,10");
    assertEquals("\t\t<ellipse id=\"" + "Oval2" + "\" cx=\"" + "14" + "\" cy=\"" + "16" +
            "\" rx=\"" + "5" + "\" ry=\"" + "5" + "\" fill=\"rgb(" + "100,10,10" + ")\">\n" +
            "\t\t</ellipse>\n", webView.getHtmlOutput());
  }

  /**
   * Tests closeSnapshot method.
   */
  @Test
  public void testFifth() {
    webView.closeSnapshot();
    assertEquals("\t</svg>\n" +
            "</div>\n", webView.getHtmlOutput());
  }

  /**
   * Tests closeHeader method.
   */
  @Test
  public void testSixth() {
    webView.closeHeader();
    assertEquals("</body>\n</html>", webView.getHtmlOutput());
  }
}
