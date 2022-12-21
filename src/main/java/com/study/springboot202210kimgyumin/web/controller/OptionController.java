package com.study.springboot202210kimgyumin.web.controller;

import com.study.springboot202210kimgyumin.service.OptionService;
import com.study.springboot202210kimgyumin.service.UserService;
import com.study.springboot202210kimgyumin.web.dto.CategoryDto;
import com.study.springboot202210kimgyumin.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

    @RestController
    @RequestMapping("/api/option")

public class OptionController {

        @Autowired
        private OptionService optionService;

        @PostMapping("/category")
        public ResponseEntity<?> addCategory(@RequestBody CategoryDto categoryDto) {
            return ResponseEntity
                    .created(URI.create("/api/option/category"+optionService.addCategory(categoryDto)))
                    .body(categoryDto);
        }

        @GetMapping("/categories")
        public ResponseEntity<?> getCategories() {
            return ResponseEntity.ok(optionService.categories());
        }

        @PutMapping("/category/{objId}")
        public ResponseEntity<?> modifyCategory(@PathVariable int objId, @RequestBody CategoryDto categoryDto){
            optionService.modifyCategory(objId,categoryDto);
            return ResponseEntity.ok(true);
        }
    }

