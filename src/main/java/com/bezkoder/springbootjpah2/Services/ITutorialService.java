package com.bezkoder.springbootjpah2.Services;

import com.bezkoder.springbootjpah2.Dto.TutorialDTO;
import com.bezkoder.springbootjpah2.Models.Tutorial;
import com.bezkoder.springbootjpah2.payload.response.TutorialsResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ITutorialService {

    public Page<TutorialDTO> getAllTutorials(String title, Integer page, Integer size)throws Exception;


    public TutorialDTO getTutorialById(Long id);

    public TutorialDTO createTutorial(TutorialDTO tutorial) throws Exception;


    public TutorialDTO updateTutorial(TutorialDTO tutorialDTO);

    public void deleteTutorialById(Long id) throws Exception;


    public void deleteAllTutorials() throws Exception;

    public Page<TutorialDTO> findPublishedByPage(Integer page , Integer size) throws  Exception;
}
