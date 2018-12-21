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

    @ApiModelProperty(value = "用户ID")
    private String userId;

    @ApiModelProperty(value = "用户姓名")
    private String userName;

    @ApiModelProperty(value = "被催收人电话")
    private String dunningCellphone;

    @ApiModelProperty(value = "所属订单ID")
    private String lendId;

    @ApiModelProperty(value = "贷款流水号")
    private String lendOrderNo;

    @ApiModelProperty(value = "催收备注")
    private String dunningRemark;

    @ApiModelProperty(value = "催收次数")
    private Long dunningNum;

    @ApiModelProperty(value = "催收人")
    private String dunningName;

}