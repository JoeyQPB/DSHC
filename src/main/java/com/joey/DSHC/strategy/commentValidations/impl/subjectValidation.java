package com.joey.DSHC.strategy.commentValidations.impl;

import com.joey.DSHC.DTOs.CommentDTO;
import com.joey.DSHC.exceptions.InvalidArgumentException;
import com.joey.DSHC.strategy.commentValidations.ICommentValidations;

public class subjectValidation  implements ICommentValidations {

    @Override
    public void execute(CommentDTO data) {

        if (data.getCommentSubject() != null &&
                ((data.getCommentSubject() == 0) || (data.getCommentSubject() == 1))
        ) {
            return;
        }
        throw new InvalidArgumentException("The subject must be 0 to E-Book or 1 to Relato");
    }
}
