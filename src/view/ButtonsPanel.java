package view;

import java.util.List;

import javax.swing.*;

import photoalbum.Snapshot;

/**
 * ButtonsPanel class.
 */
public class ButtonsPanel extends JPanel {
  private GraphicalView view;
  private List<Snapshot> snapshots;
  private JButton prev;
  private JComboBox<String> select;
  private JButton next;
  private JButton quit;

  /**
   * Constructor.
   * @param view view to communicate with
   * @param snapshots snapshots for setting up buttons
   */
  public ButtonsPanel(GraphicalView view, List<Snapshot> snapshots) {
    this.view = view;
    this.snapshots = snapshots;
    this.prev = new JButton("<< Prev <<");
    this.select = new JComboBox<String>();
    this.next = new JButton(">> Next >>");
    this.quit = new JButton("xx Quit xx");

    addSelections();

    add(this.prev);
    add(this.select);
    add(this.next);
    add(this.quit);
  }

  /**
   * Add snapshot IDs to selection button.
   */
  public void addSelections() {
    int i = 0;
    for (Snapshot snapshot : this.snapshots) {
      this.select.addItem(snapshot.getID());
      this.select.putClientProperty(snapshot.getID(), i++);
    }
  }

  /**
   * Getter for prev button.
   * @return prev button
   */
  public JButton getPrev() {
    return this.prev;
  }

  /**
   * Getter for select menu.
   * @return select menu
   */
  public JComboBox<String> getSelect() {
    return this.select;
  }

  /**
   * Getter for next button.
   * @return next button
   */
  public JButton getNext() {
    return this.next;
  }

  /**
   * Getter for quit button.
   * @return quit button
   */
  public JButton getQuit() {
    return this.quit;
  }
}
