package cn.exrick.xboot.modules.back.controller;

import cn.exrick.xboot.base.XbootBaseController;
import cn.exrick.xboot.modules.back.entity.SdLoanProduct;
import cn.exrick.xboot.modules.back.service.SdLoanProductService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author
 */
@Slf4j
@RestController
@Api(description = "产品表管理接口")
@RequestMapping("/xboot/sdLoanProduct")
@Transactional
public class SdLoanProductController extends XbootBaseController<SdLoanProduct, String> {

    @Autowired
    private SdLoanProductService sdLoanProductService;

    @Override
    public SdLoanProductService getService() {
        return sdLoanProductService;
    }

}
