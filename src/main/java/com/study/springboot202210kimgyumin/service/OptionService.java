package com.study.springboot202210kimgyumin.service;
import com.study.springboot202210kimgyumin.repository.OptionRepository;
import com.study.springboot202210kimgyumin.web.dto.CategoryDto;
import com.study.springboot202210kimgyumin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionService {
    @Autowired
    private OptionRepository optionRepository;

    public int addCategory(CategoryDto categoryDto) {

        System.out.println("데이터베이스에 insert전: " + categoryDto);
        optionRepository.saveCategory(categoryDto);
        System.out.println("데이터베이스에 insert후: " + categoryDto);
        return optionRepository.saveCategory(categoryDto) > 0 ? categoryDto.getObjId() : 0;
    }

    public List<CategoryDto> categories() {
        return optionRepository.getCategories();

    }

    public void modifyCategory(int objId, CategoryDto categoryDto) {
        categoryDto.setObjId(objId);
        optionRepository.modifyCategory(categoryDto);
    }

}
