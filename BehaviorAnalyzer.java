public class BehaviorAnalyzer {
    public static void analyze(Response response) {
        // Implement behavior analysis logic here
        // For example, check for unexpected data or patterns in the response
        if (response.body() != null && response.body().string().contains("malicious_pattern")) {
            AlertManager.notify("Suspicious behavior detected: Malicious pattern found");
        }
    }
}
