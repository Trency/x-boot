package cn.exrick.xboot.modules.base.dao;

import cn.exrick.xboot.base.BaseDao;
import cn.exrick.xboot.modules.base.entity.Dict;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 字典数据处理层
 *
 * @author Exrick
 */
public interface DictDao extends BaseDao<Dict, String> {

    /**
     * 通过type获取
     *
     * @param type
     * @return
     */
    List<Dict> findByType(String type);

    /**
     * 模糊搜索
     *
     * @param key
     * @return
     */
    @Query(value = "select * from t_dict d where d.title like %:key% or d.type like %:key%", nativeQuery = true)
    List<Dict> findByTitleOrTypeLike(@Param("key") String key);
}