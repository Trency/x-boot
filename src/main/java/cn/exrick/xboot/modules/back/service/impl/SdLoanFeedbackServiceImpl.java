package cn.exrick.xboot.modules.back.service.impl;

import cn.exrick.xboot.modules.back.dao.SdLoanFeedbackDao;
import cn.exrick.xboot.modules.back.service.SdLoanFeedbackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户反馈接口实现
 *
 * @author
 */
@Slf4j
@Service
@Transactional
public class SdLoanFeedbackServiceImpl implements SdLoanFeedbackService {

    @Autowired
    private SdLoanFeedbackDao sdLoanFeedbackDao;

    @Override
    public SdLoanFeedbackDao getRepository() {
        return sdLoanFeedbackDao;
    }
}