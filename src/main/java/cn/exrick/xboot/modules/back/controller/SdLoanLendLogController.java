package cn.exrick.xboot.modules.back.controller;

import cn.exrick.xboot.base.BaseController;
import cn.exrick.xboot.modules.back.entity.SdLoanLendLog;
import cn.exrick.xboot.modules.back.service.SdLoanLendLogService;
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
@Api(description = "贷款记录表管理接口")
@RequestMapping("/xboot/sdLoanLendLog")
@Transactional
public class SdLoanLendLogController extends BaseController<SdLoanLendLog, String> {

    @Autowired
    private SdLoanLendLogService sdLoanLendLogService;

    @Override
    public SdLoanLendLogService getService() {
        return sdLoanLendLogService;
    }

}
