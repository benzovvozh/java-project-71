package hexlet.code.utils;


import lombok.Setter;


@Setter
public class Data {
    private Object oldValue;
    private Object newValue;
    private String key;
    private Status status;

    public Object getOldValue() {
        return oldValue;
    }

    public Object getNewValue() {
        return newValue;
    }

    public String getKey() {
        return key;
    }

    public Status getStatus() {
        return status;
    }


    public Data(String key, Status status, Object oldValue, Object newValue) {
        this.key = key;
        this.status = status;
        this.newValue = newValue;
        this.oldValue = oldValue;
    }

    public Data(String key, Status status, Object oldValue) {
        this.key = key;
        this.status = status;
        this.oldValue = oldValue;
    }
}
