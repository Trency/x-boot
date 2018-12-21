package cn.exrick.xboot.modules.back.entity;

import cn.exrick.xboot.base.BaseEntity;
import cn.exrick.xboot.common.utils.SnowFlakeUtil;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author
 */
@Data
@Entity
@Table(name = "sd_loan_activity")
@TableName("sd_loan_activity")
public class SdLoanActivity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @TableId
    @ApiModelProperty(value = "活动主键，唯一标识")
    private String activityId = String.valueOf(SnowFlakeUtil.getFlowIdInstance().nextId());

    private String partionId;        // 项目主键
    private Long activityExtend;        // 活动延长天数
    private String activityName;        // 活动名称
    private String activityImg;        // 活动图片
    private String activityStatus;        // 活动状态(待发布，已发布，终止)
    private Date activityStarttime;        // 活动开始时间
    private Date activityEndtime;        // 活动结束时间

}