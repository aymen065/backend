package com.bezkoder.springbootjpah2.Services;

import com.bezkoder.springbootjpah2.Dto.TutorialDTO;

import org.springframework.data.domain.Page;


public interface ITutorialService {

     Page<TutorialDTO> getAllTutorials(String title, Integer page, Integer size)throws Exception;


     TutorialDTO getTutorialById(Long id);

     TutorialDTO createTutorial(TutorialDTO tutorial) throws Exception;


     TutorialDTO updateTutorial(TutorialDTO tutorialDTO);

     void deleteTutorialById(Long id) throws Exception;


     void deleteAllTutorials() throws Exception;

     Page<TutorialDTO> findPublishedByPage(Integer page , Integer size) throws  Exception;
}
