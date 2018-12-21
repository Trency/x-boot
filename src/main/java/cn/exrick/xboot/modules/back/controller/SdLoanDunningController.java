package cn.exrick.xboot.modules.back.controller;

import cn.exrick.xboot.base.XbootBaseController;
import cn.exrick.xboot.modules.back.entity.SdLoanDunning;
import cn.exrick.xboot.modules.back.service.SdLoanDunningService;
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
@Api(description = "催收记录表管理接口")
@RequestMapping("/xboot/sdLoanDunning")
@Transactional
public class SdLoanDunningController extends XbootBaseController<SdLoanDunning, String> {

    @Autowired
    private SdLoanDunningService sdLoanDunningService;

    @Override
    public SdLoanDunningService getService() {
        return sdLoanDunningService;
    }

}
