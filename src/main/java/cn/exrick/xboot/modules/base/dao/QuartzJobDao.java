package cn.exrick.xboot.modules.base.dao;

import cn.exrick.xboot.base.BaseDao;
import cn.exrick.xboot.modules.base.entity.QuartzJob;

import java.util.List;

/**
 * 定时任务数据处理层
 *
 * @author Exrick
 */
public interface QuartzJobDao extends BaseDao<QuartzJob, String> {

    /**
     * 通过类名获取
     *
     * @param jobClassName
     * @return
     */
    List<QuartzJob> findByJobClassName(String jobClassName);
}