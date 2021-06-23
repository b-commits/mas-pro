package models.exceptions;

public class ExceptionMessageProvider {
    private ExceptionMessageProvider() {}
    public static final String TYPE_ERROR_MESSAGE = "It's not an event of type: %s";
    public static final String REGISTRATION_ERROR_MESSAGE = "Registration number has already been used";
    public static final String GROUP_ID_TAKEN_MESSAGE = "ID %s is taken.";
    public static final String FIREARM_NUM_REGISTRATION_ERROR_MESSAGE = "Registration number does not match the pattern.";
    public static final String OVER_LIMIT_ERROR_MESSAGE = "Over limit";
    public static final String IDENTIKIT_OVER_LIMIT_ERROR = "No more than %s characters allowed.";
    public static final String NO_CONTENT_ORG_MESSAGE = "Brak danych o organizacjach przestępczych.";
    public static final String NO_CONTENT_MEM_MESSAGE = "Brak danych o przestępcach.";
    public static final String ON_NO_ACTION_TOOLTIP = "Wciśnij grupę, aby wyswietlić jej członków";
    public static final String DESCRIPTION_TOO_LONG_MESSAGE = "Description must be shorter than 500 characters.";
    public static final String ALREADY_LOCKED_EXCEPTION_MESSAGE = "The area has already been locked down.";
    public static final String ILLEGAL_DANGER_LEVEL = "Danger level must be either 1, 2 or 3.";
    public static final String LICENSE_IN_USE_MESSAGE = "The license number is already in use";
    public static final String LICENSE_TOO_SHORT_MESSAGE = "The license number is too short.";


}
