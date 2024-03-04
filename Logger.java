public class Logger {
    public static void error(String message, Exception e) {
        // Implement logging mechanism for errors
        Log.e("Error", message, e);
    }

    public static void debug(String message) {
        // Implement logging mechanism for debug messages
        Log.d("Debug", message);
    }
}
