package com.bezkoder.springbootjpah2.ServicesImpl;

import com.bezkoder.springbootjpah2.Dto.TutorialDTO;
import com.bezkoder.springbootjpah2.Models.Tutorial;
import com.bezkoder.springbootjpah2.Repositories.ITutorialRepository;
import com.bezkoder.springbootjpah2.Services.ITutorialService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.dozer.Mapper;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
@AllArgsConstructor
public class TutorialServiceImp implements ITutorialService {

    ITutorialRepository tutorialRepository;

    private Mapper mapper;


    @Override
    public Page<TutorialDTO> getAllTutorials(String title, Integer page, Integer size) throws Exception{

        Pageable paging = PageRequest.of(page, size);
            if (title == null)
                return tutorialRepository.findAll(paging).
                        map(tutorial -> mapper.map(tutorial,TutorialDTO.class));
            else
                return tutorialRepository.findByTitleContaining(title, paging)
                        .map(tutorial -> mapper.map(tutorial,TutorialDTO.class));


    }

    @Override
    public TutorialDTO getTutorialById(Long id) {

        return tutorialRepository.findById(id)
                .map(tutorial -> mapper.map(tutorial,TutorialDTO.class))
                .orElse(null);


    }

    @Override
    public TutorialDTO createTutorial(TutorialDTO tutorialDTO) throws Exception{



        return mapper.map(
                tutorialRepository
                    .save(new Tutorial(tutorialDTO.getTitle(), tutorialDTO.getDescription(), false))
                    ,TutorialDTO.class
        );

    }

    @Override
    public TutorialDTO updateTutorial(TutorialDTO tutorialDTO) {
        Optional<Tutorial> tutorialData = tutorialRepository.findById(tutorialDTO.getId());

        return tutorialRepository.findById(tutorialDTO.getId())
                .map(tutorial -> {
            tutorial.setTitle(tutorialDTO.getTitle());
            tutorial.setDescription(tutorialDTO.getDescription());
            tutorial.setPublished(tutorialDTO.isPublished());
            return mapper.map(tutorialRepository.save(tutorial),TutorialDTO.class);
        }).orElse(null);



    }

    @Override
    public void deleteTutorialById(Long id)  throws Exception{
        tutorialRepository.deleteById(id);

    }

    @Override
    public void deleteAllTutorials()  throws Exception{
        tutorialRepository.deleteAll();


    }

    @Override
    public Page<TutorialDTO> findPublishedByPage(Integer page , Integer size) throws  Exception {

        Pageable paging = PageRequest.of(page, size);
        return tutorialRepository.findByPublished(true, paging)
                .map(tutorial -> mapper.map(tutorial,TutorialDTO.class));

    }
}
