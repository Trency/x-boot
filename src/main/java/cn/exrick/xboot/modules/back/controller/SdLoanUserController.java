package cn.exrick.xboot.modules.back.controller;

import cn.exrick.xboot.base.XbootBaseController;
import cn.exrick.xboot.modules.back.entity.SdLoanUser;
import cn.exrick.xboot.modules.back.service.SdLoanUserService;
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
@Api(description = "用户表管理接口")
@RequestMapping("/xboot/sdLoanUser")
@Transactional
public class SdLoanUserController extends XbootBaseController<SdLoanUser, String> {

    @Autowired
    private SdLoanUserService sdLoanUserService;

    @Override
    public SdLoanUserService getService() {
        return sdLoanUserService;
    }


}
