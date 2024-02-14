package com.bezkoder.springbootjpah2.payload.response;

import com.bezkoder.springbootjpah2.Dto.TutorialDTO;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TutorialsResponse {
    private List<TutorialDTO> tutorials;
    private Integer currentPage;
    private Long totalItems;
    private Integer totalPages;

}
