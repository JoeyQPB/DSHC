package com.joey.DSHC.strategy.commentValidations.impl;

import com.joey.DSHC.DTOs.CommentDTO;
import com.joey.DSHC.strategy.commentValidations.ICommentValidations;
import org.springframework.stereotype.Component;

@Component
public class authorValidation  implements ICommentValidations {

    @Override
    public void execute(CommentDTO data) {

        if (data.getAuthor() == null ||
                data.getAuthor().isEmpty() ||
                data.getAuthor().trim().equals("Não Informado") ||
                data.getAuthor().trim().equalsIgnoreCase("anonimo") ||
                data.getAuthor().trim().equalsIgnoreCase("anônimo")) {
            data.setAuthor("Anônimo");
        }
    }
}
