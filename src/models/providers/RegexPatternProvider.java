package models.providers;

import java.util.regex.Pattern;

public class RegexPatternProvider {
    private RegexPatternProvider() {}
    public static final Pattern NUM_REGISTRATION_PATTERN = Pattern.compile("([A-Z]){4}-\\d{3}-\\d{3}");
}
