package net.codejava.hibernate.model;

import javax.persistence.*;

@Entity
@Table(name = "Record")
public class URL {

    @Id
    @Column(name = "RecordID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "URL")
    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}