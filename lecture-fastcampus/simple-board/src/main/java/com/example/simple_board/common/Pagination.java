package com.example.simple_board.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pagination {

    private Integer page;
    
    private Integer size;

    private Integer currentElements;

    private Integer totalPage;

    private Long totalElements;
    
}
