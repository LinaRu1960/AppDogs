package cl.eme.appdogs.model;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

public class Breed {
    private Map<String, List<String>> message;
    private String status;

    public Breed(Map<String, List<String>> message, String status) {
        this.message = message;
        this.status = status;
    }

    public Map<String, List<String>> getMessage() {
        return message;
    }

    public void setMessage(Map<String, List<String>> message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @NotNull
    @Override
    public String toString() {
        return "Breed{" +
                "message=" + message +
                ", status='" + status + '\'' +
                '}';
    }
}

