package cn.exrick.xboot.modules.back.service.impl;

import cn.exrick.xboot.modules.back.dao.SdLoanLendDao;
import cn.exrick.xboot.modules.back.service.SdLoanLendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 贷款表接口实现
 *
 * @author
 */
@Slf4j
@Service
@Transactional
public class SdLoanLendServiceImpl implements SdLoanLendService {

    @Autowired
    private SdLoanLendDao sdLoanLendDao;

    @Override
    public SdLoanLendDao getRepository() {
        return sdLoanLendDao;
    }
}