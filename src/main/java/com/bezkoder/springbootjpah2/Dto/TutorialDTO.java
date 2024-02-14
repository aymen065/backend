package com.bezkoder.springbootjpah2.Dto;

import com.bezkoder.springbootjpah2.Models.Tutorial;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter


public class TutorialDTO {

    private Long id;

    private String title;

    private String description;

    private boolean published;


}
