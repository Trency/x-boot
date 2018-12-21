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
@Table(name = "sd_loan_feedback")
@TableName("sd_loan_feedback")
public class SdLoanFeedback extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @TableId
    @ApiModelProperty(value = "反馈主键，唯一标识")
    private String feedbackId = String.valueOf(SnowFlakeUtil.getFlowIdInstance().nextId());

    @ApiModelProperty(value = "所属用户ID")
    private String userId;

    @ApiModelProperty(value = "反馈联系手机号")
    private String userTelephone;

    @ApiModelProperty(value = "反馈联系人姓名")
    private String userName;

    @ApiModelProperty(value = "反馈标题")
    private String title;

    @ApiModelProperty(value = "反馈内容")
    private String content;

    @ApiModelProperty(value = "分类")
    private String classification;

    @ApiModelProperty(value = "贷款流水号")
    private String orderNo;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "图片地址")
    private String imgLists;

    @ApiModelProperty(value = "问题类型")
    private String problemType;

    @ApiModelProperty(value = "处理状态，0:正常,1:删除(默认0)")
    private Integer isFix;
}