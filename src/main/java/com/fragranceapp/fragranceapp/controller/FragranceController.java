package com.fragranceapp.fragranceapp.controller;

import com.fragranceapp.fragranceapp.dto.FragranceDTO;
import com.fragranceapp.fragranceapp.service.fragrance.FragranceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fragrances")
public class FragranceController {

    private FragranceServiceImpl fragranceService;

    @Autowired
    public FragranceController(FragranceServiceImpl fragranceService) {
        this.fragranceService = fragranceService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<FragranceDTO> getFragrance(@PathVariable long id) {
        FragranceDTO fragranceDTO = fragranceService.getFragranceById(id);

        return new ResponseEntity<>(fragranceDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<FragranceDTO>> getAllFragrances() {
        List<FragranceDTO> fragranceDTOS = fragranceService.getAllFragrances();

        return new ResponseEntity<>(fragranceDTOS, HttpStatus.OK);
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<List<FragranceDTO>> getAllFragrancesByCategory(@PathVariable(name = "id") long categoryId) {
        List<FragranceDTO> fragranceDTOS = fragranceService.getAllFragrancesByCategoryId(categoryId);

        return new ResponseEntity<>(fragranceDTOS, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FragranceDTO> createFragrance(@RequestBody FragranceDTO fragranceDTO) {
       FragranceDTO fragrance = fragranceService.createFragrance(fragranceDTO);

        return new ResponseEntity<>(fragrance, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FragranceDTO> updateFragrance(@PathVariable long id, @RequestBody FragranceDTO updateFragrance) {
        FragranceDTO fragranceDTO = fragranceService.updateFragrance(id, updateFragrance);

        return new ResponseEntity(fragranceDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteFragrance(@PathVariable long id) {
        fragranceService.deleteFragrance(id);

        return ResponseEntity.ok().build();
    }
}
