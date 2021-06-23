package models.exceptions;

public class DescriptionTooLongException extends Exception {
    public DescriptionTooLongException(String message) {
        super(message);
    }
}
