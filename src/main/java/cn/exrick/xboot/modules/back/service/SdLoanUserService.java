package cn.exrick.xboot.modules.back.service;

import cn.exrick.xboot.base.XbootBaseService;
import cn.exrick.xboot.modules.back.entity.SdLoanUser;

import java.util.List;

/**
 * 用户表接口
 *
 * @author
 */
public interface SdLoanUserService extends XbootBaseService<SdLoanUser, String> {

    List<SdLoanUser> findByMybatis();
}