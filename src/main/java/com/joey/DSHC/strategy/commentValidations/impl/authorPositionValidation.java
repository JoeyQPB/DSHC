package com.joey.DSHC.strategy.commentValidations.impl;

import com.joey.DSHC.DTOs.CommentDTO;
import com.joey.DSHC.strategy.commentValidations.ICommentValidations;
import org.springframework.stereotype.Component;

@Component
public class authorPositionValidation implements ICommentValidations {

    @Override
    public void execute(CommentDTO data) {

        if (data.getAuthorPosition() == null ||
                data.getAuthorPosition().isEmpty() ||
                data.getAuthorPosition().trim().equals("Não Informada")) {
            data.setAuthorPosition("Não Informada");
        }
    }
}
