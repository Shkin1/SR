package com.sr.demo.service;

import com.sr.demo.common.SrException;
import com.sr.demo.model.SellerModel;

import java.util.List;

/**
 * @author pushkin
 * @version v1.0.0
 * @date 2019/11/9 22:36
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 */

public interface SellerService {
    SellerModel create(SellerModel sellerModel);
    SellerModel get(Integer id);
    List<SellerModel> selectAll();
    SellerModel changeStatus(Integer id,Integer disabledFlag) throws SrException;

}
