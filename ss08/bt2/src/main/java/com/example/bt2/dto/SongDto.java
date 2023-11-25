package com.example.bt2.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Validator;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SongDto {
    private int id;
    @NotBlank(message = "Bạn chưa nhập tên bài hát")
    @Pattern(regexp = "^[A-Za-z0-9\\s]{1,800}$", message = "Tên bài hát không chứa ký tự đặc biệt và có ít hơn 800 ký tự!")
    private String nameSong;
    @NotBlank(message = "Bạn chưa nhập tên ca sĩ")
    @Pattern(regexp = "^[A-Za-z0-9\\s]{1,300}$", message = "Tên người thể hiện không chưa ký tự đặc biệt và có ít hơn 300 ký tự!")
    private String singer;
    @NotBlank(message = "Bạn chưa nhập thể loại bài hát")
    @Pattern(regexp = "[A-Za-z]+(,?\\s?[A-Za-z]+)*", message = "Tên thể loại bài hát chưa hợp lệ!")
    private String type;
}
