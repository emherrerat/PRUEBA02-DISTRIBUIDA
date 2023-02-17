package com.distribuida.db;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import javax.persistence.*;

@Access(AccessType.FIELD)
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @Getter
    @Setter
    private Integer id;
    @NotBlank
    @Column(name = "isbn")
    @Getter @Setter private String isbn;
    @NotBlank
    @Column(name = "title")
    @Getter @Setter private String title;
    @NotBlank
    @Column(name = "author")
    @Getter @Setter private String author;
    @NotBlank
    @Getter @Setter @Column(name = "price")
    private Double price;
}
