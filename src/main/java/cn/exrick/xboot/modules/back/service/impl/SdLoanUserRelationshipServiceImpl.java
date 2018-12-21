package cn.exrick.xboot.modules.back.service.impl;

import cn.exrick.xboot.modules.back.dao.SdLoanUserRelationshipDao;
import cn.exrick.xboot.modules.back.service.SdLoanUserRelationshipService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 联系人表接口实现
 *
 * @author
 */
@Slf4j
@Service
@Transactional
public class SdLoanUserRelationshipServiceImpl implements SdLoanUserRelationshipService {

    @Autowired
    private SdLoanUserRelationshipDao sdLoanUserRelationshipDao;

    @Override
    public SdLoanUserRelationshipDao getRepository() {
        return sdLoanUserRelationshipDao;
    }
}