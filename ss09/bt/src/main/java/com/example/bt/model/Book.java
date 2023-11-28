package com.example.bt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", columnDefinition = "varchar(100) not null")
    private String name;
    @Column(name = "amount", columnDefinition = "int default 0")
    private int amount;
    @Column(name = "path")
    private String path;

    @OneToMany(mappedBy = "book")
    private Set<BookCode> bookCodeSet;



}
