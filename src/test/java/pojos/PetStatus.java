package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PetStatus {
    private String status;
    private double id;

    public PetStatus(String status, double id) {
        this.status = status;
        this.id = id;
    }

    public PetStatus() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PetStatus{" +
                "status='" + status + '\'' +
                ", id=" + id +
                '}';
    }
}
