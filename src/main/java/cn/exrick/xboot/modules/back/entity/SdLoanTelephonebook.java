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
@Table(name = "sd_loan_telephonebook")
@TableName("sd_loan_telephonebook")
public class SdLoanTelephonebook extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @TableId
    @ApiModelProperty(value = "电话本表id，唯一标识")
    private String telephonebookId = String.valueOf(SnowFlakeUtil.getFlowIdInstance().nextId());

    @ApiModelProperty(value = "电话")
    private String cellphone;

    @ApiModelProperty(value = "所属用户ID")
    private String userId;

    @ApiModelProperty(value = "联系人电话")
    private String contactTelephone;

    @ApiModelProperty(value = "标题")
    private String contactName;

    @ApiModelProperty(value = "业务Id")
    private String bizId;

    @ApiModelProperty(value = "业务类型:注册-REGIST,申请借款-LEND")
    private String bizType;

}