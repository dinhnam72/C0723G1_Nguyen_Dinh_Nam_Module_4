package com.example.bt.dto;

import com.example.bt.model.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlogDto {
    private int id;
    private String title;
    private String content;
    private Date dateOfWriting;
    private String pathImg;
    private Category category;
}
