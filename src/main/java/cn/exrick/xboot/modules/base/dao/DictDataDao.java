package cn.exrick.xboot.modules.base.dao;

import cn.exrick.xboot.base.BaseDao;
import cn.exrick.xboot.modules.base.entity.DictData;

import java.util.List;

/**
 * 字典数据数据处理层
 *
 * @author Exrick
 */
public interface DictDataDao extends BaseDao<DictData, String> {


    /**
     * 通过dictId和状态获取
     *
     * @param dictId
     * @param status
     * @return
     */
    List<DictData> findByDictIdAndStatusOrderBySortOrder(String dictId, Integer status);

    /**
     * 通过dictId删除
     *
     * @param dictId
     */
    void deleteByDictId(String dictId);
}