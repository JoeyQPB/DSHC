package com.joey.DSHC.factory;

import com.joey.DSHC.model.CommentModel;
import com.joey.DSHC.model.enums.SubjectEnum;
import org.springframework.stereotype.Component;

import javax.security.auth.Subject;

@Component
public class CommentModelFactory {

    public static CommentModel build (String author, String company, String authorPosition, Integer commentSubject,
                                      String commentText, Integer upVote, Integer downVote) {
        CommentModel comment = new CommentModel();
        comment.setAuthor(author);
        comment.setCompany(company);
        comment.setAuthorPosition(authorPosition);

        SubjectEnum subjectEnum = SubjectEnum.fromValue(commentSubject);
        String subject = subjectEnum.getName();
        comment.setCommentSubject(subject);

        comment.setCommentText(commentText);
        comment.setUpVote(upVote);
        comment.setDownVote(downVote);
        return comment;
    }

}
