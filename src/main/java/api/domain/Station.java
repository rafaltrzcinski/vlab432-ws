package api.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Station {

    @Id
    private Long id;
    private String name;
    private String status;


    protected Station() {}

    public Station(Long id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
