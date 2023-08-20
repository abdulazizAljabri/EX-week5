package com.example.week5day1.Controoler;

import com.example.week5day1.Api.ApiResponse;
import com.example.week5day1.DTO.DetailsDTO;
import com.example.week5day1.Service.CustomerDetialsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/details")
@RequiredArgsConstructor
public class DetailsController {
    private final CustomerDetialsService customerdetialsservice;
    @GetMapping("/")
    public ResponseEntity getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(customerdetialsservice.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity addDetails(@RequestBody @Valid DetailsDTO detailsDTO) {
        customerdetialsservice.addDetails(detailsDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Details  Added"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity removeDetails(@PathVariable Integer id) {
        customerdetialsservice.removeDetails(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Details deleted"));
    }
    @PutMapping("/update")
    public ResponseEntity updateDetails(@RequestBody @Valid DetailsDTO detailsDTO) {
        customerdetialsservice.updateDetails(detailsDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Details updated"));

    }

}
