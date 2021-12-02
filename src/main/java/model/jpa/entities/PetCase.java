package model.jpa.entities;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PetCase") // Optional
@NamedQueries({
        @NamedQuery(name = "petcase.findAll",
                query = "SELECT b FROM PetCase b")
})

public class PetCase {


    @Id
    @GeneratedValue
    @Column(name = "case_id")
    private Integer case_id;

    @Column(name = "created_at", nullable = false)
    private Date created_at;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "pet_id")
    private Pet pet;

    public PetCase() {
    }

    public PetCase(Date created_at, String type, String description) {
        this.created_at = created_at;
        this.type = type;
        this.description = description;
    }

    public PetCase(Integer case_id, Date created_at, String type, String description, Pet pet) {
        this.case_id = case_id;
        this.created_at = created_at;
        this.type = type;
        this.description = description;
        this.pet = pet;
    }

    public Integer getCase_id() {
        return case_id;
    }

    public void setCase_id(Integer case_id) {
        this.case_id = case_id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
