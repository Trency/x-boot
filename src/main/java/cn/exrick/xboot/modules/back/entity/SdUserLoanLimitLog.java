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
@Table(name = "sd_user_loan_limit_log")
@TableName("sd_user_loan_limit_log")
public class SdUserLoanLimitLog extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @TableId
    @ApiModelProperty(value = "用户贷款额度变动主键，唯一标识")
    private String userLoanLimitLog = String.valueOf(SnowFlakeUtil.getFlowIdInstance().nextId());

    @ApiModelProperty(value = "用户主键")
    private String userId;

    @ApiModelProperty(value = "调整类型:EnumAdjustType 增加-ADD, 减少-REDUCE")
    private String adjustType;

    @ApiModelProperty(value = "调整数量")
    private Long amount;

    @ApiModelProperty(value = "调整前额度")
    private Long beforeLimit;

    @ApiModelProperty(value = "调整后额度")
    private Long afterLimit;

    @ApiModelProperty(value = "来源")
    private String source;

    @ApiModelProperty(value = "业务Id")
    private String bizId;

    @ApiModelProperty(value = "业务类型:贷款-LEND,还款-REPAYMENT,未知:UNKNOWN")
    private String bizType;

}