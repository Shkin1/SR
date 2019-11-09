package com.sr.demo.service.impl;

import com.sr.demo.common.SrErrorEnum;
import com.sr.demo.common.SrException;
import com.sr.demo.mapper.SellerModelMapper;
import com.sr.demo.model.SellerModel;
import com.sr.demo.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author pushkin
 * @version v1.0.0
 * @date 2019/11/9 22:37
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerModelMapper sellerModelMapper;


    @Override
    @Transactional
    public SellerModel create(SellerModel sellerModel) {
        sellerModel.setCreatedAt(new Date());
        sellerModel.setUpdatedAt(new Date());
        sellerModel.setRemarkScore(new BigDecimal(0));
        sellerModel.setDisabledFlag(0);
        sellerModelMapper.insertSelective(sellerModel);
        return get(sellerModel.getId());
    }

    @Override
    public SellerModel get(Integer id) {
        return sellerModelMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SellerModel> selectAll() {
        return sellerModelMapper.selectAll();
    }

    @Override
    public SellerModel changeStatus(Integer id, Integer disabledFlag) throws SrException {
        SellerModel sellerModel = get(id);
        if(sellerModel == null){
            throw new SrException(SrErrorEnum.PARAMETER_VALIDATION_ERROR);
        }
        sellerModel.setDisabledFlag(disabledFlag);
        sellerModelMapper.updateByPrimaryKeySelective(sellerModel);
        return sellerModel;
    }
}
