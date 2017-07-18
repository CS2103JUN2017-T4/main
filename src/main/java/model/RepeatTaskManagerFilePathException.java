package model;

public class RepeatTaskManagerFilePathException extends Exception {
    public RepeatTaskManagerFilePathException() {
        super("Function will result in duplicate tasks");
    }
}
