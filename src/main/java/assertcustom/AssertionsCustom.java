package assertcustom;

public class AssertionsCustom {

    public static void myAssertTrue(String message, boolean b) {
        if (!b) {
            fail(message);
        }
    }
    
    public static void myAssertTrue(boolean b) {
    	myAssertTrue(null, b);
    }
    
    static public void fail(String message) {
        if (message == null) {
            throw new AssertionErrorCustom(message);
        }
        throw new AssertionErrorCustom(message);
    }
    
    static public void myAssertEquals(String message, Object expected,
            Object actual) {
        if (myEqualsRegardingNull(expected, actual)) {
            return;
        } else if (expected instanceof String && actual instanceof String) {
            failNotEquals(message, expected, actual);
        } else {
            failNotEquals(message, expected, actual);
        }
    }
    
    static public void myAssertEquals(Object expected,
            Object actual) {
    	myAssertEquals("",expected, actual);
    }
    
    static public void assertNotEquals(String message, long unexpected, long actual) {
        if (unexpected == actual) {
            failEquals(message, Long.valueOf(actual));
        }
    }
    
    static public void assertNotEquals(long unexpected, long actual) {
        assertNotEquals(null, unexpected, actual);
    }
    
    private static void failEquals(String message, Object actual) {
        String formatted = "Os valores deveriam ser diferentes. ";
        if (message != null) {
            formatted = message + ". ";
        }

        formatted += "Atual: " + actual;
        fail(formatted);
    }
    
    private static boolean myEqualsRegardingNull(Object expected, Object actual) {
        if (expected == null) {
            return actual == null;
        }

        return isEquals(expected, actual);
    }
    
    static private void failNotEquals(String message, Object expected,
            Object actual) {
    	message = "Comparacao: "+message;
        fail(format(message, expected, actual));
    }
    
    static String format(String message, Object expected, Object actual) {
        String formatted = "";
        if (message != null && !message.equals("")) {
            formatted = message + " ";
        }
        String expectedString = String.valueOf(expected);
        String actualString = String.valueOf(actual);
        if (expectedString.equals(actualString)) {
            return formatted + " - o esperado: "
                    + formatClassAndValue(expected, expectedString)
                    + " porem retornou " + formatClassAndValue(actual, actualString);
        } else {
            return formatted + " - o esperado: <" + expectedString + "> porem retornou <"
                    + actualString + ">";
        }
    }
    
    private static String formatClassAndValue(Object value, String valueString) {
        String className = value == null ? "null" : value.getClass().getName();
        return className + "<" + valueString + ">";
    }
    
    private static boolean isEquals(Object expected, Object actual) {
        return expected.equals(actual);
    }

}