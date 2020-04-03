package filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StringFilter {
    private static final Logger logger = LogManager.getLogger(StringFilter.class);
    public static final String REGEX = "\\d+";
    public boolean filterInt(String str)  {
        String validStr = new String();
            if (str.matches("\\d+")) {
                return true;
            } else {
                logger.error("Input info isn't correct! Try again: ");
                return false;
        }
    }
}
