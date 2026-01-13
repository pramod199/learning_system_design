package machine_coding.inmemory_key_value_store;

class VersionedValue {
    String value;
    long version;

    VersionedValue(String value, long version) {
        this.value = value;
        this.version = version;
    }
}