package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileController {
  private final String fileName;
  private List<List<String>> commands;

  public FileController(String fileName) {
    this.fileName = fileName;
    this.commands = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
      String line;
      while ((line = br.readLine()) != null) {
        if (line.startsWith("#")) {
          continue;
        }
        String[] tokens = line.split("\\s+");
        this.commands.add(List.of(tokens));
      }
    } catch (IOException e) {
      System.err.println("Error reading file: " + e.getMessage());
    }
  }

  public List<List<String>> getCommands() {
    return this.commands;
  }
}
