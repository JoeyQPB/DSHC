package com.joey.DSHC.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommentDTO {
    private String author;
    private String company;
    private String authorPosition;
    private Integer commentSubject;
    private String commentText;
}
