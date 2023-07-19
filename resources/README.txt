One of the model changes I had to make was changing the valid RGB values my shapes would accept
from 0-1 to 0-255, because at first I thought the 0.0 to 1.0 would represent the percentages for
the colors. Another model change I made was adding many new getters for my classes. Obviously I
wanted to keep the attributes for my shapes and snapshots private, but I still needed to know their
values, and that's why I used getters.

My Design
- PhotoAlbumMain: Main that takes in arguments from the user and starts the controller.

- PhotoAlbumController: The controller that interacts with the model (PhotoAlbumModel) and the
views (GraphicalView and WebView).

- FileController: File reader reads a file of commands so the controller (PhotoAlbumController)
can take and then start executing them.

-GraphicalView: A JFrame that is made up of two JPanels (SnapshotPanel and ButtonsPanel). Can
communicate directly with the controller, and is the only object (from the graphical view side)
that communicates with the controller. Paints the snapshots and listens for button clicks.

-SnapshotPanel: Takes the shapes from a snapshot and paints them. This panel gets added to
GraphicalView. It can repaint itself every time a new snapshot is given to it.

-ButtonsPanel: The buttons for GraphicalView. Includes "prev", "select", "next", and "quit"

-WebView: The html + svg view. Communicates with GraphicalView.