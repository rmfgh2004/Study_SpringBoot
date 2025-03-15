package com.example.simple_board.board.db;

import java.util.List;

import org.hibernate.annotations.OrderBy;
import org.hibernate.annotations.Where;
import org.hibernate.annotations.DialectOverride.Wheres;

import com.example.simple_board.post.db.PostEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity(name = "board")
public class BoardEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String boardName;
    
    private String status;
    
    @OneToMany(
        mappedBy = "board"
    )
    @Builder.Default
    @Where(clause = "status = 'REGISTERED'")
    @OrderBy(clause = "id desc")
    private List<PostEntity> postList = List.of();
}
