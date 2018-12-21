package cn.exrick.xboot.modules.back.service.impl;

import cn.exrick.xboot.modules.back.dao.SdLoanFeaturedDao;
import cn.exrick.xboot.modules.back.service.SdLoanFeaturedService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 推荐位接口实现
 *
 * @author
 */
@Slf4j
@Service
@Transactional
public class SdLoanFeaturedServiceImpl implements SdLoanFeaturedService {

    @Autowired
    private SdLoanFeaturedDao sdLoanFeaturedDao;

    @Override
    public SdLoanFeaturedDao getRepository() {
        return sdLoanFeaturedDao;
    }
}