package org.zerock.b1.dreamtodo.common.dto;

import lombok.Data;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
public class PageResultDTO<T> {

    private List<T> dtoList;

    private int pageNum;

    private long totalPageNum, totalCount;

    private int pageSize;

    private int start, end;

    private List<Integer> pageNumList;

    public PageResultDTO(List<T> dtoList, Pageable pageable, long total, long totalPage ){

        this.dtoList = dtoList;
        this.pageNum = pageable.getPageNumber() +1;
        this.totalPageNum = totalPage;
        this.totalCount = total;
        this.pageSize = pageable.getPageSize();


        this.start = (int) ((Math.ceil(this.pageNum / 10.0)) * 10 ) - 9;

        int tempEnd = (int)(((Math.ceil(this.pageNum / 10.0)) * 10 ));

        this.end = tempEnd* pageSize > totalCount ?
                (int)(Math.ceil(totalCount/(double)pageSize)) : tempEnd;

        this.pageNumList = IntStream.rangeClosed(start,end).boxed().collect(Collectors.toList());

    }

}
