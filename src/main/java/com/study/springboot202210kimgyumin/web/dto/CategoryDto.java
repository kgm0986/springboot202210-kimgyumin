package com.study.springboot202210kimgyumin.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoryDto {
    private int objId;
    @NotBlank
    private String categoryName;
    private String categoryOpt1;
    private String categoryOpt2;

}
