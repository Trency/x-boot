package cn.exrick.xboot.modules.back.controller;

import cn.exrick.xboot.base.BaseController;
import cn.exrick.xboot.modules.back.entity.SdLoanUserRelationship;
import cn.exrick.xboot.modules.back.service.SdLoanUserRelationshipService;
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
@Api(description = "联系人表管理接口")
@RequestMapping("/xboot/sdLoanUserRelationship")
@Transactional
public class SdLoanUserRelationshipController extends BaseController<SdLoanUserRelationship, String> {

    @Autowired
    private SdLoanUserRelationshipService sdLoanUserRelationshipService;

    @Override
    public SdLoanUserRelationshipService getService() {
        return sdLoanUserRelationshipService;
    }

}
