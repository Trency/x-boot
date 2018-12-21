package cn.exrick.xboot.modules.back.controller;

import cn.exrick.xboot.base.XbootBaseController;
import cn.exrick.xboot.modules.back.entity.SdLoanViolate;
import cn.exrick.xboot.modules.back.service.SdLoanViolateService;
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
@Api(description = "违约金管理接口")
@RequestMapping("/xboot/sdLoanViolate")
@Transactional
public class SdLoanViolateController extends XbootBaseController<SdLoanViolate, String> {

    @Autowired
    private SdLoanViolateService sdLoanViolateService;

    @Override
    public SdLoanViolateService getService() {
        return sdLoanViolateService;
    }

}
