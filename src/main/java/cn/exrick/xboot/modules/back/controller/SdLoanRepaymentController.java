package cn.exrick.xboot.modules.back.controller;

import cn.exrick.xboot.base.XbootBaseController;
import cn.exrick.xboot.modules.back.entity.SdLoanRepayment;
import cn.exrick.xboot.modules.back.service.SdLoanRepaymentService;
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
@Api(description = "还款表管理接口")
@RequestMapping("/xboot/sdLoanRepayment")
@Transactional
public class SdLoanRepaymentController extends XbootBaseController<SdLoanRepayment, String> {

    @Autowired
    private SdLoanRepaymentService sdLoanRepaymentService;

    @Override
    public SdLoanRepaymentService getService() {
        return sdLoanRepaymentService;
    }

}
