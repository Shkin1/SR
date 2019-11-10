package com.sr.demo.service.impl;

import com.sr.demo.common.SrErrorEnum;
import com.sr.demo.common.SrException;
import com.sr.demo.mapper.CategoryModelMapper;
import com.sr.demo.model.CategoryModel;
import com.sr.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author pushkin
 * @version v1.0.0
 * @date 2019/11/10 22:15
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */

public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryModelMapper categoryModelMapper;

    @Override
    @Transactional
    public CategoryModel create(CategoryModel categoryModel) throws SrException {
        categoryModel.setCreatedAt(new Date());
        categoryModel.setUpdatedAt(new Date());

        try{
            categoryModelMapper.insertSelective(categoryModel);
        }catch(DuplicateKeyException ex){
            throw new SrException(SrErrorEnum.CATEGORY_NAME_DUPLICATED);
        }


        return get(categoryModel.getId());
    }

    @Override
    public CategoryModel get(Integer id) {
        return categoryModelMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<CategoryModel> selectAll() {
        return categoryModelMapper.selectAll();
    }

    @Override
    public Integer countAllCategory() {
        return categoryModelMapper.countAllCategory();
    }
}
