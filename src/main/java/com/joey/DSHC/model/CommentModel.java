package com.joey.DSHC.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity(name = "comment_tb")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "company", nullable = false)
    private String company;

    @Column(name = "author_position", nullable = false)
    private String authorPosition;

    @Column(name = "comment_subject", nullable = false)
    private String commentSubject;

    @Column(name = "comment_text", nullable = false)
    private String commentText;

    @Column(name = "upvote", nullable = false)
    private Integer upVote;

    @Column(name = "downvote", nullable = false)
    private Integer downVote;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentModel that = (CommentModel) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "CommentModel{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", company='" + company + '\'' +
                ", authorPosition='" + authorPosition + '\'' +
                ", commentSubject='" + commentSubject + '\'' +
                ", commentText='" + commentText + '\'' +
                ", upvote=" + upVote +
                ", downvote=" + downVote +
                '}';
    }
}
