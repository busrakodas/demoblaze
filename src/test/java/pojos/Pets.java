package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//{
//        "id": 0,
//        "category": {
//        "id": 0,
//        "name": "string"
//        },
//        "name": "doggie",
//        "photoUrls": [
//        "string"
//        ],
//        "tags": [
//        {
//        "id": 0,
//        "name": "string"
//        }
//        ],
//        "status": "available"
//        }

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pets {
    private int id;
    private String name;
    private String status;
    private Category category;


    public Pets(int id, String name, String status, Category category) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.category = category;
    }

    public Pets() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Pets{" +
                "id=" + id +
                ", category=" + category +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
