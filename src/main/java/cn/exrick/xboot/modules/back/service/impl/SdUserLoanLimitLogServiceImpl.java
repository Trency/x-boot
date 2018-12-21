package cn.exrick.xboot.modules.back.service.impl;

import cn.exrick.xboot.modules.back.dao.SdUserLoanLimitLogDao;
import cn.exrick.xboot.modules.back.service.SdUserLoanLimitLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 贷款额度变动记录接口实现
 *
 * @author
 */
@Slf4j
@Service
@Transactional
public class SdUserLoanLimitLogServiceImpl implements SdUserLoanLimitLogService {

    @Autowired
    private SdUserLoanLimitLogDao sdUserLoanLimitLogDao;

    @Override
    public SdUserLoanLimitLogDao getRepository() {
        return sdUserLoanLimitLogDao;
    }
}