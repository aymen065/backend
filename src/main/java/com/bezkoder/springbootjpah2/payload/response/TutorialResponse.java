package com.bezkoder.springbootjpah2.payload.response;

import com.bezkoder.springbootjpah2.Dto.TutorialDTO;
import com.bezkoder.springbootjpah2.Models.Tutorial;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TutorialResponse {
    private TutorialDTO tutorial;
    private Integer currentPage;
    private Long totalItems;
    private Integer totalPages;
}
