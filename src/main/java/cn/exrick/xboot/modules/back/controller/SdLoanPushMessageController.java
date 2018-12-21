package cn.exrick.xboot.modules.back.controller;

import cn.exrick.xboot.base.XbootBaseController;
import cn.exrick.xboot.modules.back.entity.SdLoanPushMessage;
import cn.exrick.xboot.modules.back.service.SdLoanPushMessageService;
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
@Api(description = "消息推送管理接口")
@RequestMapping("/xboot/sdLoanPushMessage")
@Transactional
public class SdLoanPushMessageController extends XbootBaseController<SdLoanPushMessage, String> {

    @Autowired
    private SdLoanPushMessageService sdLoanPushMessageService;

    @Override
    public SdLoanPushMessageService getService() {
        return sdLoanPushMessageService;
    }

}
