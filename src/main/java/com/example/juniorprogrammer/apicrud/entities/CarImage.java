package com.example.juniorprogrammer.apicrud.entities;

import com.example.juniorprogrammer.apicrud.audit.AuditableBase;
import jakarta.persistence.*;

import java.sql.Blob;

@Entity
public class CarImage extends AuditableBase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private CarEntity car;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String base64;

    private String contentType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CarEntity getCar() {
        return car;
    }

    public void setCar(CarEntity car) {
        this.car = car;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
