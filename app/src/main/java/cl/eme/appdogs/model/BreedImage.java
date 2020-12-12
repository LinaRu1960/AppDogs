package cl.eme.appdogs.model;

import java.util.List;

public class BreedImage {

    private List<String> message;
    private String status;

    public BreedImage(List<String> message, String status) {
        this.message = message;
        this.status = status;
    }


    public List<String> getMessage() {
        return message;
    }
}
