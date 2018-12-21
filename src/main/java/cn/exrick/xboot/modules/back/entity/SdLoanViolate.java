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
@Table(name = "sd_loan_violate")
@TableName("sd_loan_violate")
public class SdLoanViolate extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @TableId
    @ApiModelProperty(value = "违约金表id，唯一标识")
    private String violateId = String.valueOf(SnowFlakeUtil.getFlowIdInstance().nextId());

    @ApiModelProperty(value = "所属用户ID")
    private String userId;

    @ApiModelProperty(value = "贷款ID")
    private String lendId;

    @ApiModelProperty(value = "贷款流水号")
    private String lendOrderNo;

    @ApiModelProperty(value = "违约金金额")
    private Long reviolateAmount;

    @ApiModelProperty(value = "变动前总违约金金额")
    private Long beforeReviolateAmount;

    @ApiModelProperty(value = "变动后总违约金金额")
    private Long afterReviolateAmount;

    @ApiModelProperty(value = "实际贷款金额")
    private Long lendAmount;

}