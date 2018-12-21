package cn.exrick.xboot.modules.back.controller;

import cn.exrick.xboot.base.BaseController;
import cn.exrick.xboot.modules.back.entity.SdLoanFeedback;
import cn.exrick.xboot.modules.back.service.SdLoanFeedbackService;
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
@Api(description = "用户反馈管理接口")
@RequestMapping("/xboot/sdLoanFeedback")
@Transactional
public class BaseController extends BaseController<SdLoanFeedback, String> {

    @Autowired
    private SdLoanFeedbackService sdLoanFeedbackService;

    @Override
    public SdLoanFeedbackService getService() {
        return sdLoanFeedbackService;
    }

}
