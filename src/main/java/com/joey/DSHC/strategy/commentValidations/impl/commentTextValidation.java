package com.joey.DSHC.strategy.commentValidations.impl;

import com.joey.DSHC.DTOs.CommentDTO;
import com.joey.DSHC.exceptions.InvalidArgumentException;
import com.joey.DSHC.strategy.commentValidations.ICommentValidations;
import jakarta.persistence.Column;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class commentTextValidation implements ICommentValidations {

    @Override
    public void execute(CommentDTO data) {

        List<String> badWordsList = new ArrayList<>(List.of(
                "Puta que pariu", "PQP", "Merda", "Caralho", "Porra", "Filho da puta",
                "FDP", "Cacete", "Desgraça", "Vai se foder", "VSF", "Bosta", "Vai tomar no cu",
                "VTNC", "imbecil", "Idiota", "Otário", "Otária", "Babaca"
        ));

        if (data.getCommentText() == null || data.getCommentText().isEmpty()) {
            throw new InvalidArgumentException("The comment cannot be null!");
        }

        badWordsList.forEach(badWord -> {
            if (data.getCommentText().contains(badWord)) {
                throw new InvalidArgumentException("The comment cannot contain the word: " + badWord);
            }
        });
    }
}
