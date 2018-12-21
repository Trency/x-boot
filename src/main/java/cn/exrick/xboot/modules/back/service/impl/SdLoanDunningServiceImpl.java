package cn.exrick.xboot.modules.back.service.impl;

import cn.exrick.xboot.modules.back.dao.SdLoanDunningDao;
import cn.exrick.xboot.modules.back.service.SdLoanDunningService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 催收记录表接口实现
 *
 * @author
 */
@Slf4j
@Service
@Transactional
public class SdLoanDunningServiceImpl implements SdLoanDunningService {

    @Autowired
    private SdLoanDunningDao sdLoanDunningDao;

    @Override
    public SdLoanDunningDao getRepository() {
        return sdLoanDunningDao;
    }
}