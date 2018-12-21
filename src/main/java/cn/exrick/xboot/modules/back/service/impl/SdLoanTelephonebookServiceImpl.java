package cn.exrick.xboot.modules.back.service.impl;

import cn.exrick.xboot.modules.back.dao.SdLoanTelephonebookDao;
import cn.exrick.xboot.modules.back.service.SdLoanTelephonebookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 电话本接口实现
 *
 * @author
 */
@Slf4j
@Service
@Transactional
public class SdLoanTelephonebookServiceImpl implements SdLoanTelephonebookService {

    @Autowired
    private SdLoanTelephonebookDao sdLoanTelephonebookDao;

    @Override
    public SdLoanTelephonebookDao getRepository() {
        return sdLoanTelephonebookDao;
    }
}