package cn.exrick.xboot.modules.back.service.impl;

import cn.exrick.xboot.modules.back.dao.SdLoanRepaymentDao;
import cn.exrick.xboot.modules.back.service.SdLoanRepaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 还款表接口实现
 *
 * @author
 */
@Slf4j
@Service
@Transactional
public class SdLoanRepaymentServiceImpl implements SdLoanRepaymentService {

    @Autowired
    private SdLoanRepaymentDao sdLoanRepaymentDao;

    @Override
    public SdLoanRepaymentDao getRepository() {
        return sdLoanRepaymentDao;
    }
}