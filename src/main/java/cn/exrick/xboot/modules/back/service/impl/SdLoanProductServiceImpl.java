package cn.exrick.xboot.modules.back.service.impl;

import cn.exrick.xboot.modules.back.dao.SdLoanProductDao;
import cn.exrick.xboot.modules.back.service.SdLoanProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 产品表接口实现
 *
 * @author
 */
@Slf4j
@Service
@Transactional
public class SdLoanProductServiceImpl implements SdLoanProductService {

    @Autowired
    private SdLoanProductDao sdLoanProductDao;

    @Override
    public SdLoanProductDao getRepository() {
        return sdLoanProductDao;
    }
}