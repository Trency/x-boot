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
    private String userId;        // 所属用户ID
    private String userTelephone;        // 反馈联系手机号
    private String userName;        // 反馈联系人姓名
    private String title;        // 反馈标题
    private String content;        // 反馈内容
    private String classification;        // 分类
    private String orderNo;        // 贷款流水号
    private String email;        // 邮箱
    private String imgLists;        // 图片地址
    private String problemType;        // 问题类型
    private Integer isFix;        // 处理状态，0:正常,1:删除(默认0)
}