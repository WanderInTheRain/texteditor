# A Simple Text Editor based on Java

This is a simple text editor implemented in Java using Swing. It allows users to open and save text files.

## Usage

1. Navigate to the `bin` directory:

    ```bash
    cd bin
    ```

2. Run the text editor:

    ```bash
    java texteditor.Run
    ```

## Source Code Structure

The source code is organized into the following packages and classes:

### `texteditor.Run`

This class contains the `main` method and is the entry point for the text editor.

### `texteditor.Gui`

The `Gui` class sets up the graphical user interface (GUI) and handles user actions.

### `texteditor.Operation`

The `Operation` class contains action functions and uses the `Buffer` class for text manipulation.

## Folder Structure

- `src`: Contains the source code organized into packages.
  - `texteditor`: Package for text editor classes.
    - `Run.java`: Main class with the `main` method.
    - `Gui.java`: GUI setup and action handling.
    - `Operation.java`: Action functions using the `Buffer` class.

- `bin`: Contains compiled `.class` files.

Feel free to explore and enhance the text editor according to your needs.
