package com.joey.DSHC.controller;

import com.joey.DSHC.DTOs.CommentDTO;
import com.joey.DSHC.DTOs.ServiceResponse;
import com.joey.DSHC.model.CommentModel;
import com.joey.DSHC.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public ResponseEntity<CommentModel> createComment (@RequestBody CommentDTO dto) {
        ServiceResponse<CommentModel> serviceResponse = this.commentService.create(dto);
        return ResponseEntity.status(serviceResponse.httpStatus()).body(serviceResponse.body());
    }

    @GetMapping
    public ResponseEntity<Iterable<CommentModel>> getAll () {
        ServiceResponse<Iterable<CommentModel>> serviceResponse = this.commentService.findAll();
        return ResponseEntity.status(serviceResponse.httpStatus()).body(serviceResponse.body());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentModel> getById (@PathVariable Long id) {
        ServiceResponse<CommentModel> serviceResponse = this.commentService.findById(id);
        return ResponseEntity.status(serviceResponse.httpStatus()).body(serviceResponse.body());
    }

    @GetMapping("?page={page}&size={size}")
    public ResponseEntity<Page<CommentModel>> getAllPagination (@PathVariable int page,
                                                                @PathVariable int size) {
        ServiceResponse<Page<CommentModel>> serviceResponse = this.commentService.getAllPagination(page, size);
        return ResponseEntity.status(serviceResponse.httpStatus()).body(serviceResponse.body());
    }

    @PostMapping("/add-upVote/{id}")
    public ResponseEntity<CommentModel> addUpVote (@PathVariable Long id) {
        ServiceResponse<CommentModel> serviceResponse = this.commentService.addUpVote(id);
        return ResponseEntity.status(serviceResponse.httpStatus()).body(serviceResponse.body());
    }

    @PostMapping("/remove-upVote/{id}")
    public ResponseEntity<CommentModel> removeUpVote (@PathVariable Long id) {
        ServiceResponse<CommentModel> serviceResponse = this.commentService.removeUpVote(id);
        return ResponseEntity.status(serviceResponse.httpStatus()).body(serviceResponse.body());
    }

    @PostMapping("/add-downVote/{id}")
    public ResponseEntity<CommentModel> addDownVote (@PathVariable Long id) {
        ServiceResponse<CommentModel> serviceResponse = this.commentService.addDownVote(id);
        return ResponseEntity.status(serviceResponse.httpStatus()).body(serviceResponse.body());
    }

    @PostMapping("/remove-downVote/{id}")
    public ResponseEntity<CommentModel> removeDownVote (@PathVariable Long id) {
        ServiceResponse<CommentModel> serviceResponse = this.commentService.removeDownVote(id);
        return ResponseEntity.status(serviceResponse.httpStatus()).body(serviceResponse.body());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete (@PathVariable Long id) {
        ServiceResponse<String> serviceResponse = this.commentService.delete(id);
        return ResponseEntity.status(serviceResponse.httpStatus()).body(serviceResponse.body());
    }

}
