package cn.exrick.xboot.modules.back.service.impl;

import cn.exrick.xboot.modules.back.dao.SdLoanViolateDao;
import cn.exrick.xboot.modules.back.service.SdLoanViolateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 违约金接口实现
 *
 * @author
 */
@Slf4j
@Service
@Transactional
public class SdLoanViolateServiceImpl implements SdLoanViolateService {

    @Autowired
    private SdLoanViolateDao sdLoanViolateDao;

    @Override
    public SdLoanViolateDao getRepository() {
        return sdLoanViolateDao;
    }
}