package cn.exrick.xboot.modules.back.service.impl;

import cn.exrick.xboot.modules.back.dao.SdLoanPushMessageDao;
import cn.exrick.xboot.modules.back.service.SdLoanPushMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 消息推送接口实现
 *
 * @author
 */
@Slf4j
@Service
@Transactional
public class SdLoanPushMessageServiceImpl implements SdLoanPushMessageService {

    @Autowired
    private SdLoanPushMessageDao sdLoanPushMessageDao;

    @Override
    public SdLoanPushMessageDao getRepository() {
        return sdLoanPushMessageDao;
    }
}