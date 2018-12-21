package cn.exrick.xboot.modules.back.controller;

import cn.exrick.xboot.base.BaseController;
import cn.exrick.xboot.modules.back.entity.SdUserLoanLimitLog;
import cn.exrick.xboot.modules.back.service.SdUserLoanLimitLogService;
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
@Api(description = "贷款额度变动记录管理接口")
@RequestMapping("/xboot/sdUserLoanLimitLog")
@Transactional
public class SdUserLoanLimitLogController extends BaseController<SdUserLoanLimitLog, String> {

    @Autowired
    private SdUserLoanLimitLogService sdUserLoanLimitLogService;

    @Override
    public SdUserLoanLimitLogService getService() {
        return sdUserLoanLimitLogService;
    }

}
