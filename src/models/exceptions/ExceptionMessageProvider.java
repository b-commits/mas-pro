package models.exceptions;

public class ExceptionMessageProvider {
    private ExceptionMessageProvider() {}
    public static final String TYPE_ERROR_MESSAGE = "It's not an event of type: %s";
    public static final String REGISTRATION_ERROR_MESSAGE = "Registration number has already been used";
    public static final String GROUP_ID_TAKEN_MESSAGE = "ID %s is taken.";
    public static final String FIREARM_NUM_REGISTRATION_ERROR_MESSAGE = "Registration number does not match the pattern.";
    public static final String OVER_LIMIT_ERROR_MESSAGE = "Over limit";
    public static final String IDENTIKIT_OVER_LIMIT_ERROR = "No more than %s characters allowed.";
}
