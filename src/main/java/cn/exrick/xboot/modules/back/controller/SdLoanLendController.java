package cn.exrick.xboot.modules.back.controller;

import cn.exrick.xboot.base.BaseController;
import cn.exrick.xboot.modules.back.entity.SdLoanLend;
import cn.exrick.xboot.modules.back.service.SdLoanLendService;
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
@Api(description = "贷款表管理接口")
@RequestMapping("/xboot/sdLoanLend")
@Transactional
public class SdLoanLendController extends BaseController<SdLoanLend, String> {

    @Autowired
    private SdLoanLendService sdLoanLendService;

    @Override
    public SdLoanLendService getService() {
        return sdLoanLendService;
    }

}
