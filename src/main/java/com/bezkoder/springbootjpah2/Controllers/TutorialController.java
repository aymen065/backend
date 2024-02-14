package com.bezkoder.springbootjpah2.Controllers;

import com.bezkoder.springbootjpah2.Dto.TutorialDTO;
import com.bezkoder.springbootjpah2.Models.Tutorial;
import com.bezkoder.springbootjpah2.Services.ITutorialService;
import com.bezkoder.springbootjpah2.payload.response.TutorialsResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/api/tutorials")
@AllArgsConstructor
public class TutorialController {

    private ITutorialService tutorialService;

    @GetMapping()
    public ResponseEntity<TutorialsResponse> getAllTutorials(@RequestParam(required = false) String title,
                                                            @RequestParam(defaultValue = "0") int page,
                                                            @RequestParam(defaultValue = "3") int size) {

                try {

                    Page<TutorialDTO> tutorialsPage = tutorialService.getAllTutorials(title,page,size);
            return new ResponseEntity<>(new TutorialsResponse(tutorialsPage.getContent(),tutorialsPage.getNumber(),tutorialsPage.getTotalElements(),tutorialsPage.getTotalPages()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<TutorialDTO> getTutorialById(@PathVariable("id") long id) {
        TutorialDTO tutorialDTO = tutorialService.getTutorialById(id);

                if (tutorialDTO != null) {
            return new ResponseEntity<>(tutorialDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }

    @PostMapping()
    public ResponseEntity<TutorialDTO> createTutorial(@RequestBody TutorialDTO tutorial) {

                try {

            return new ResponseEntity<>(tutorialService.createTutorial(tutorial), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("")
    public ResponseEntity<TutorialDTO> updateTutorial(@RequestBody TutorialDTO tutorialDTO) {

        TutorialDTO tutorial = tutorialService.updateTutorial(tutorialDTO);
                if (tutorial != null) {

            return new ResponseEntity<>(tutorial, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTutorialById(@PathVariable("id") long id) {

        try {
            tutorialService.deleteTutorialById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping()
    public ResponseEntity<HttpStatus> deleteAllTutorials() {
        try {
            tutorialService.deleteAllTutorials();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/published")
    public ResponseEntity<TutorialsResponse> findPublishedByPage( @RequestParam(defaultValue = "0") int page,
                                                           @RequestParam(defaultValue = "3") int size) {

        try {

            Page<TutorialDTO> tutorialsPage = tutorialService.findPublishedByPage(page,size);
            return new ResponseEntity<>(new TutorialsResponse(tutorialsPage.getContent(),tutorialsPage.getNumber(),tutorialsPage.getTotalElements(),tutorialsPage.getTotalPages()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }


}
