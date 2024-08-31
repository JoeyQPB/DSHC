package com.joey.DSHC.strategy.commentValidations.impl;

import com.joey.DSHC.DTOs.CommentDTO;
import com.joey.DSHC.strategy.commentValidations.ICommentValidations;
import org.springframework.stereotype.Component;

@Component
public class companyValidation  implements ICommentValidations {

    @Override
    public void execute(CommentDTO data) {
        if (data.getCompany() == null ||
                data.getCompany().isEmpty() ||
                data.getCompany().trim().equalsIgnoreCase("Não Informada") ||
                data.getCompany().trim().equalsIgnoreCase("anônima")) {
            data.setCompany("Não Informada");
        }
    }
}
