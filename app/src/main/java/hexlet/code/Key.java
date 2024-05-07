package hexlet.code;

public final class Key {
    private final String diff;
    private final String key;

    public Key(String diff, String key) {
        this.diff = diff;
        this.key = key;
    }

    public String getDiff() {
        return diff;
    }

    public String getKey() {
        return key;
    }
}
