package com.shk.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

    @Entity(name="Image")
    @Table(name="image")
    public class Image {
        @Id
        @GeneratedValue(strategy= GenerationType.AUTO, generator = "native")
        @GenericGenerator(name="native",strategy="native")
        private int id;
        private String url;

        @OneToOne
        @JsonIgnore
        private Artist artist;

    }
