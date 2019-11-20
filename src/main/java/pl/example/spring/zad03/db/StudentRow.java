package pl.example.spring.zad03.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity


public class StudentRow {

    protected StudentRow()
    {

    }
    public StudentRow(String name, String number, String group)
    { this.name = name;
        this.number = number;
        this.group = group;
    }


    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id private long id;
    private String name;
    private String number;
    private String group;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getgroup() {
        return group;
    }

    public void setgroup(String group) {
        this.group = group;
    }

}
