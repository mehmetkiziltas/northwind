package kodlamaio.northwind.core.utilities.results;

public class Result {
    private boolean success;
    private String message;

    public Result(final boolean success) {
        this.success = success;
    }

    public Result(final boolean success,
                  final String message) {
        this(success);
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
