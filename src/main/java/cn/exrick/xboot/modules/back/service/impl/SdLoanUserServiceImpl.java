package cn.exrick.xboot.modules.back.service.impl;

import cn.exrick.xboot.modules.back.dao.SdLoanUserDao;
import cn.exrick.xboot.modules.back.entity.SdLoanUser;
import cn.exrick.xboot.modules.back.service.SdLoanUserService;
import cn.exrick.xboot.modules.base.dao.mapper.SdLoanUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户表接口实现
 *
 * @author
 */
@Slf4j
@Service
@Transactional
public class SdLoanUserServiceImpl implements SdLoanUserService {

    @Autowired
    private SdLoanUserDao sdLoanUserDao;

    @Autowired
    private SdLoanUserMapper sdLoanUserMapper;

    @Override
    public SdLoanUserDao getRepository() {
        return sdLoanUserDao;
    }

    @Override
    public List<SdLoanUser> findByMybatis() {
        return sdLoanUserMapper.findAll();
    }
}