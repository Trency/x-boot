package cn.exrick.xboot.modules.back.service;

import cn.exrick.xboot.base.BaseService;
import cn.exrick.xboot.modules.back.entity.SdLoanUser;

import java.util.List;

/**
 * 用户表接口
 *
 * @author
 */
public interface SdLoanUserService extends BaseService<SdLoanUser, String> {

    List<SdLoanUser> findByMybatis();
}