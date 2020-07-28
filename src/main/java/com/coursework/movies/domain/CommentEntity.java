package com.coursework.movies.domain;


import com.coursework.movies.domain.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Clob;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentEntity {


    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "post_id")
    private PostEntity post;

    @ManyToOne(optional = false)
    @JoinColumn(name = "author_id")
    private UserEntity author;

    @ManyToOne(optional = false)
    @JoinColumn(name = "movie_id")
    private MovieEntity movie;

    @Column(name = "content")
    private Clob content;


}
