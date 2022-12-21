package com.study.springboot202210kimgyumin.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoryDto {
    private int objId;
    private String categoryName;
    private String categoryOpt1;
    private String categoryOpt2;

}
