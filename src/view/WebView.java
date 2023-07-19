package view;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * WebView class.
 */
public class WebView implements IView {
  private String html_output;
  private String output;

  /**
   * Constructor.
   * @param output file to output to
   */
  public WebView(String output) {
    this.html_output = "";
    this.output = output;
  }

  /**
   * Begins and ends a header element, sets the style, and begins the body element.
   * @param header header title
   */
  public void beginHeader(String header) {
    this.html_output += "<!DOCTYPE html>\n" +
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
            "<h1>" + header + "</h1>\n";
  }

  /**
   * Begins a snapshot division.
   * @param title ID of snapshot
   */
  public void beginSnapshot(String title) {
    this.html_output += "<div class=\"snapshot\">\n" +
            "\t<h2>" + title + "</h2>\n" +
            "\t<svg width=\"1000\" height=\"1000\">\n";
  }

  /**
   * Adds a rectangle.
   * @param name rectangle name
   * @param width rectangle width
   * @param height rectangle height
   * @param x rectangle x-coordinate
   * @param y rectangle y-coordinate
   * @param rgb rectangle RGB value
   */
  public void addRectangle(String name, String width, String height,
                           String x, String y, String rgb) {
    this.html_output += "\t\t<rect id=\"" + name + "\" x=\"" + x + "\" y=\"" + y +
            "\" width=\"" + width + "\" height=\"" + height + "\" fill=\"rgb(" + rgb + ")\">\n" +
            "\t\t</rect>\n";
  }

  /**
   * Adds an oval.
   * @param name oval name
   * @param width oval width
   * @param height oval height
   * @param x oval x-coordinate
   * @param y oval y-corrdinate
   * @param rgb oval RGB value
   */
  public void addOval(String name, String width, String height,
                      String x, String y, String rgb) {
    this.html_output += "\t\t<ellipse id=\"" + name + "\" cx=\"" + x + "\" cy=\"" + y +
            "\" rx=\"" + width + "\" ry=\"" + height + "\" fill=\"rgb(" + rgb + ")\">\n" +
            "\t\t</ellipse>\n";
  }

  /**
   * Closes the snapshot division.
   */
  public void closeSnapshot() {
    this.html_output += "\t</svg>\n" +
            "</div>\n";
  }

  /**
   * Closes the body element and file.
   */
  public void closeHeader() {
    this.html_output += "</body>\n</html>";
  }

  /**
   * Creates and writes the file.
   */
  public void display() {
    try {
      File outFile = new File(this.output);
      FileWriter writer = new FileWriter(outFile);
      writer.write(this.html_output);
      writer.close();
    } catch (IOException e) {
      System.out.println("Could not create HTML file.");
    }
  }

  /**
   * Getter for html_output.
   * @return html_output
   */
  public String getHtmlOutput() {
    return this.html_output;
  }
}
