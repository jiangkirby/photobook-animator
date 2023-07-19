package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.PhotoAlbumController;
import photoalbum.Snapshot;

/**
 * GraphicalView class.
 */
public class GraphicalView extends JFrame implements ActionListener {
  private PhotoAlbumController controller;
  private ButtonsPanel buttons;
  private SnapshotPanel snapshotPanel;

  /**
   * Constructor where everything is set up.
   * @param controller controller to communicate with
   * @param maxX size of x value for frame
   * @param maxY size of y value for frame
   */
  public GraphicalView(PhotoAlbumController controller, int maxX, int maxY) {
    super("Photo Album");
    this.controller = controller;
    setSize(maxX, maxY);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.buttons = new ButtonsPanel(this, this.controller.getSnapshots());
    this.buttons.getPrev().addActionListener(this);
    this.buttons.getSelect().addActionListener(this);
    this.buttons.getNext().addActionListener(this);
    this.buttons.getQuit().addActionListener(this);
    getContentPane().add(this.buttons, BorderLayout.SOUTH);

    this.snapshotPanel = new SnapshotPanel();
    getContentPane().add(this.snapshotPanel, BorderLayout.CENTER);
  }

  /**
   * Paints new snapshot.
   * @param snapshot snapshot to paint
   */
  public void paintSnapshot(Snapshot snapshot) {
    this.snapshotPanel.addSnapshot(snapshot);
    setVisible(true);
  }

  /**
   * Invoked when an action occurs.
   * @param e the event to be processed
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == this.buttons.getPrev()) {
      if (!this.controller.prevPage()) {
        JOptionPane.showMessageDialog(null, "No snapshots before this.");
      }
    } else if (e.getSource() == this.buttons.getSelect()) {
      JComboBox<String> combo = (JComboBox<String>) e.getSource();
      this.controller.viewSnapshot(combo.getSelectedIndex());
    } else if (e.getSource() == this.buttons.getNext()) {
      if (!this.controller.nextPage()) {
        JOptionPane.showMessageDialog(null, "No snapshots after this.");
      }
    } else if (e.getSource() == this.buttons.getQuit()) {
      System.exit(0);
    }
  }
}

