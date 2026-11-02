package com.company;

import java.io.File;
import java.util.Scanner;

public class Application {

    // Състояние на програмата в паметта
    private static boolean isFileOpened = false;
    private static String currentFilePath = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        // Главен терминален цикъл
        while (isRunning) {
            System.out.print("> ");
            String inputLine = scanner.nextLine().trim();

            if (inputLine.isEmpty()) {
                continue;
            }

            // Разделяне на команда и аргументи
            String[] tokens = inputLine.split("\\s+");
            String command = tokens[0].toLowerCase();

            switch (command) {
                case "open":
                    handleOpen(tokens);
                    break;

                case "close":
                    handleClose();
                    break;

                case "save":
                    handleSave();
                    break;

                case "saveas":
                    handleSaveAs(tokens);
                    break;

                case "help":
                    handleHelp();
                    break;

                case "exit":
                    System.out.println("Exit");
                    isRunning = false;
                    break;

                // SVG специфични команди (за следващите стъпки)
                case "print":
                case "create":
                case "erase":
                case "translate":
                case "within":
                    if (!isFileOpened) {
                        System.out.println("Please open a file first!");
                    } else {
                        System.out.println("Command '" + command + "' will be implemented in Step 2!");
                    }
                    break;

                default:
                    System.out.println("Unknown command!Type 'help' for available commands.");
                    break;
            }
        }
        scanner.close();
    }

    private static void
handleOpen(String[]tokens){
        if(tokens.length<2){

            System.out.println("Usage:open<filepath>");
            return;
        }

        String filePath = tokens[1];
        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("File does not exist. Creating a new empty file in memory: " + file.getName());
        } else {
            System.out.println("Successfully opened " + file.getName());
        }

        currentFilePath = filePath;
        isFileOpened = true;
    }

    private static void handleClose() {
        if (!isFileOpened) {
            System.out.println("No file is currently open.");
            return;
        }

        File file = new File(currentFilePath);
        System.out.println("Successfully closed " + file.getName());

        currentFilePath = null;
        isFileOpened = false;
    }

    private static void handleSave() {
        if (!isFileOpened) {
            System.out.println("No file is currently open to save!");
            return;
        }

        File file = new File(currentFilePath);
        System.out.println("Successfully saved the changes to " + file.getName());
    }

    private static void handleSaveAs(String[] tokens) {
        if (!isFileOpened) {
            System.out.println("No file is currently open to save!");
            return;
        }
        if (tokens.length < 2) {
            System.out.println("Usage: saveas <filepath>");
            return;
        }

        String newPath = tokens[1];
        File file = new File(newPath);
        System.out.println("Successfully saved " + file.getName());
    }

    private static void handleHelp() {
        System.out.println("The following commands are supported:");
        System.out.println("open <file>    opens <file>");
        System.out.println("close          closes currently opened file");
        System.out.println("save           saves the currently open file");
        System.out.println("saveas <file>  saves the currently open file in <file>");
        System.out.println("help           prints this information");
        System.out.println("exit           exists the program");
    }
}