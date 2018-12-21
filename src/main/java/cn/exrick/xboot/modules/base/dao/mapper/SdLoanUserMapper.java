package cn.exrick.xboot.modules.base.dao.mapper;

import cn.exrick.xboot.modules.back.entity.SdLoanUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Exrickx
 */
@Component
public interface SdLoanUserMapper extends BaseMapper<SdLoanUser> {

    /**
     * 通过用户id获取
     *
     * @param userId
     * @return
     */
    List<SdLoanUser> findAll();


}
