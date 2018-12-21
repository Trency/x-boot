package cn.exrick.xboot.modules.back.controller;

import cn.exrick.xboot.base.XbootBaseController;
import cn.exrick.xboot.modules.back.entity.SdLoanActivity;
import cn.exrick.xboot.modules.back.service.SdLoanActivityService;
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
@Api(description = "活动表管理接口")
@RequestMapping("/xboot/sdLoanActivity")
@Transactional
public class SdLoanActivityController extends XbootBaseController<SdLoanActivity, String> {

    @Autowired
    private SdLoanActivityService sdLoanActivityService;

    @Override
    public SdLoanActivityService getService() {
        return sdLoanActivityService;
    }

}
