package cn.exrick.xboot.modules.back.service.impl;

import cn.exrick.xboot.modules.back.dao.SdLoanActivityDao;
import cn.exrick.xboot.modules.back.service.SdLoanActivityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 活动表接口实现
 *
 * @author
 */
@Slf4j
@Service
@Transactional
public class SdLoanActivityServiceImpl implements SdLoanActivityService {

    @Autowired
    private SdLoanActivityDao sdLoanActivityDao;

    @Override
    public SdLoanActivityDao getRepository() {
        return sdLoanActivityDao;
    }
}