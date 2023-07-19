# Shapes Photo Album

## Table of Contents

- [Description](#description)
- [File Structure](#file-structure)
- [Setup](#setup)
- [Usage](#usage)
- [Additional Notes](#additional-notes)
- [Testing](#testing)
- [Contributing](#contributing)

## Description

This project is an interactive application that allows users to create, manage, and view snapshots of various shapes on a canvas. The application offers two different views: the "Graphical View" using Java Swing and the "Web View" using HTML with embedded SVG.

## File Structure

```
/ resources
  |-- buildingsOut.html
  |-- design.txt
  |-- shape_draw.jar
/ src
  |-- controller
  |-- META-INF
  |-- photoalbum
  |-- shapes
  |-- view
/ README.md
```

## Setup

1. Clone the repository to your local machine.
2. Make sure you have Java JDK installed for running the graphical view.
3. Ensure you have a web browser that supports SVG rendering for the web view.

## Usage

### Input File Format
The input file should contain a list of sequential commands that the application's model should execute. Each command corresponds to actions such as creating a new shape, moving a shape, changing its color, resizing, removing a shape, and taking snapshots.

The command set includes:
- `shape`: Creates a new shape with attributes like ID, type, position, dimensions, and color.
- `move`: Moves a shape to a new position.
- `color`: Changes the color of a shape.
- `resize`: Resizes a shape.
- `remove`: Removes a shape.
- `snapshot`: Takes a snapshot of the current state of the album with an optional description.

### Running the Graphical View
To run the graphical view, use the following command from the terminal:
```
java -jar ShapesPhotoAlbum.jar -in input_file.txt -v graphical [width] [height]
```
- `input_file.txt`: The name of the text file containing the commands to be executed.
- `width` and `height` (optional): The dimensions of the graphical view window.

### Running the Web View
To generate the web view output, use the following command from the terminal:
```
java -jar ShapesPhotoAlbum.jar -in input_file.txt -v web [-out output_file.html]
```
- `input_file.txt`: The name of the text file containing the commands to be executed.
- `output_file.html` (optional): The name of the HTML file where the web view output will be saved.

## Additional Notes

- The application is organized using the Model-View-Controller (MVC) architecture to keep a clear separation of concerns.
- Each view adheres to a common interface, ensuring consistent behavior and easy extensibility to other views in the future.
- The graphical view uses Java Swing for drawing the snapshots on the canvas, while the web view generates static HTML with embedded SVG for graphics.
- The PhotoAlbum class is responsible for managing snapshots and providing methods to change the canvas.
- The Snapshot class contains copies of each shape object and an optional description assigned by the user.

## Testing

Tests are found in the 'test' folder.

## Contributing

If you find any issues with the project or have suggestions for improvements, please feel free to contribute or open an issue.