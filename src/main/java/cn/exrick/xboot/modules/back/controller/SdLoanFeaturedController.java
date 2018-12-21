package cn.exrick.xboot.modules.back.controller;

import cn.exrick.xboot.base.BaseController;
import cn.exrick.xboot.modules.back.entity.SdLoanFeatured;
import cn.exrick.xboot.modules.back.service.SdLoanFeaturedService;
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
@Api(description = "推荐位管理接口")
@RequestMapping("/xboot/sdLoanFeatured")
@Transactional
public class SdLoanFeaturedController extends BaseController<SdLoanFeatured, String> {

    @Autowired
    private SdLoanFeaturedService sdLoanFeaturedService;

    @Override
    public SdLoanFeaturedService getService() {
        return sdLoanFeaturedService;
    }

}
