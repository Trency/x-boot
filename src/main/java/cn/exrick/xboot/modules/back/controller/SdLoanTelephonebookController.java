package cn.exrick.xboot.modules.back.controller;

import cn.exrick.xboot.base.BaseController;
import cn.exrick.xboot.modules.back.entity.SdLoanTelephonebook;
import cn.exrick.xboot.modules.back.service.SdLoanTelephonebookService;
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
@Api(description = "电话本管理接口")
@RequestMapping("/xboot/sdLoanTelephonebook")
@Transactional
public class SdLoanTelephonebookController extends BaseController<SdLoanTelephonebook, String> {

    @Autowired
    private SdLoanTelephonebookService sdLoanTelephonebookService;

    @Override
    public SdLoanTelephonebookService getService() {
        return sdLoanTelephonebookService;
    }

}
