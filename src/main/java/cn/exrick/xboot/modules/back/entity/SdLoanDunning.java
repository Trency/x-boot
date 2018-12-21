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

/**
 * @author
 */
@Data
@Entity
@Table(name = "sd_loan_dunning")
@TableName("sd_loan_dunning")
public class SdLoanDunning extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @TableId
    @ApiModelProperty(value = "电话本表id，唯一标识")
    private String dunningId = String.valueOf(SnowFlakeUtil.getFlowIdInstance().nextId());
    private String userId;//用户ID
    private String userName;//用户姓名
    private String dunningCellphone;        // 被催收人电话
    private String lendId;        // 所属订单ID
    private String lendOrderNo;        // 贷款流水号
    private String dunningRemark;        // 催收备注
    private Long dunningNum;        // 催收次数
    private String dunningName;        // 催收人
}