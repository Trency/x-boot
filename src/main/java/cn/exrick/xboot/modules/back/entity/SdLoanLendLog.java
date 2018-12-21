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
@Table(name = "sd_loan_lend_log")
@TableName("sd_loan_lend_log")
public class SdLoanLendLog extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @TableId
    @ApiModelProperty(value = "贷款操作表id，唯一标识")
    private String lendLogId = String.valueOf(SnowFlakeUtil.getFlowIdInstance().nextId());
    private String lendOrderNo;        // 贷款流水号
    private String lendId;        // 贷款ID
    private String beforeJson;        // 操作前json
    private String afterJson;        // 操作后json
    private String operateUserId;        // 操作人Id
    private String operateUserType;        // 操作人类型
    private String operateType;        // 操作类型

}