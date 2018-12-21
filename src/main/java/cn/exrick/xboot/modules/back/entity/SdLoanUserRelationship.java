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
@Table(name = "sd_loan_user_relationship")
@TableName("sd_loan_user_relationship")
public class SdLoanUserRelationship extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @TableId
    @ApiModelProperty(value = "用户亲戚主键，唯一标识")
    private String relationshipId = String.valueOf(SnowFlakeUtil.getFlowIdInstance().nextId());

    private String userId;        // 用户主键
    private String contactRelationship;        // 联系人关系
    private String contactName;        // 联系人姓名
    private String contactTel;        // 联系人电话

}