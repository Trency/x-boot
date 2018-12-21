package cn.exrick.xboot.modules.back.service.impl;

import cn.exrick.xboot.modules.back.dao.SdLoanLendLogDao;
import cn.exrick.xboot.modules.back.service.SdLoanLendLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 贷款记录表接口实现
 *
 * @author
 */
@Slf4j
@Service
@Transactional
public class SdLoanLendLogServiceImpl implements SdLoanLendLogService {

    @Autowired
    private SdLoanLendLogDao sdLoanLendLogDao;

    @Override
    public SdLoanLendLogDao getRepository() {
        return sdLoanLendLogDao;
    }
}