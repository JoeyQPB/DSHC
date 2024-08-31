package com.joey.DSHC.service;

import com.joey.DSHC.DTOs.ServiceResponse;
import com.joey.DSHC.DTOs.CommentDTO;
import com.joey.DSHC.exceptions.CommentNotFoundException;
import com.joey.DSHC.factory.CommentModelFactory;
import com.joey.DSHC.model.CommentModel;
import com.joey.DSHC.repository.CommentRepository;
import com.joey.DSHC.strategy.commentValidations.ICommentValidations;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final List<ICommentValidations> commentValidations;
    private final CommentRepository repository;

    public CommentService(List<ICommentValidations> commentValidations,
                          CommentRepository repository) {
        this.commentValidations = commentValidations;
        this.repository = repository;
    }

    @Transactional
    public ServiceResponse<CommentModel> create (CommentDTO comment) {

        commentValidations.forEach(validation -> validation.execute(comment));

        CommentModel commentModel = CommentModelFactory.build(
                comment.getAuthor(),
                comment.getCompany(),
                comment.getAuthorPosition(),
                comment.getCommentSubject(),
                comment.getCommentText(),
                0, 0
        );
        commentModel = this.repository.save(commentModel);

        return new ServiceResponse<>(HttpStatus.CREATED, commentModel);
    }

    // get by subject 7 - 7

    public ServiceResponse<Iterable<CommentModel>> finAll () {
        return new ServiceResponse<>(HttpStatus.FOUND, this.repository.findAll());
    }

    public ServiceResponse<CommentModel> finById (Long id) {
        CommentModel commentModel = this.UtilFindById(id);
        return new ServiceResponse<>(HttpStatus.FOUND, commentModel);
    }

    public ServiceResponse<CommentModel> addUpVote (Long id) {
        CommentModel commentModel = this.UtilFindById(id);
        commentModel.setUpVote(commentModel.getUpVote() + 1);
        commentModel = this.repository.save(commentModel);
        return new ServiceResponse<>(HttpStatus.OK, commentModel);
    }

    public ServiceResponse<CommentModel> removeUpVote (Long id) {
        CommentModel commentModel = this.UtilFindById(id);
        commentModel.setUpVote(commentModel.getUpVote() - 1);
        commentModel = this.repository.save(commentModel);
        return new ServiceResponse<>(HttpStatus.OK, commentModel);
    }

    public ServiceResponse<CommentModel> addDownVote (Long id) {
        CommentModel commentModel = this.UtilFindById(id);
        commentModel.setDownVote(commentModel.getDownVote() + 1);
        commentModel = this.repository.save(commentModel);
        return new ServiceResponse<>(HttpStatus.OK, commentModel);
    }

    public ServiceResponse<CommentModel> removeDownVote (Long id) {
        CommentModel commentModel = this.UtilFindById(id);
        commentModel.setDownVote(commentModel.getDownVote() - 1);
        commentModel = this.repository.save(commentModel);
        return new ServiceResponse<>(HttpStatus.OK, commentModel);
    }

    public ServiceResponse<String> delete (Long id) {
        this.repository.deleteById(id);
        return new ServiceResponse<>(HttpStatus.OK, "Deleted comment with id: " + id);
    }

    public CommentModel UtilFindById (Long id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new CommentNotFoundException("Comment not found for id: " + id));
    }
}
