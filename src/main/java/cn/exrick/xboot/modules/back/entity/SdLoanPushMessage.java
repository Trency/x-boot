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
@Table(name = "sd_loan_push_message")
@TableName("sd_loan_push_message")
public class SdLoanPushMessage extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @TableId
    @ApiModelProperty(value = "推送消息ID，唯一标识")
    private String pushMessageId = String.valueOf(SnowFlakeUtil.getFlowIdInstance().nextId());

    @ApiModelProperty(value = "推送类型, 应用程序自定义")
    private String pushMessageType;

    @ApiModelProperty(value = "标题, 对应属于 alert")
    private String title;

    @ApiModelProperty(value = "内容")
    private String message;

    @ApiModelProperty(value = "附加信息, 建议使用json 存储")
    private String extras;

    @ApiModelProperty(value = "第三方推送注册ID")
    private String registrationId;

    @ApiModelProperty(value = "推送平台, IOS-苹果 | ANDROID-安卓")
    private String platformType;

    @ApiModelProperty(value = "阅读状态, UN_READ-未读 | READ-已读")
    private String readStatus;

    @ApiModelProperty(value = "推送状态, UN_PUSH-未推送 | PUSHED-已推送")
    private String pushStatus;

    @ApiModelProperty(value = "错误信息")
    private String errorMsg;

    @ApiModelProperty(value = "异步ID, 可查推送状态")
    private String asyncId;

    @ApiModelProperty(value = "接收人Id")
    private String acceptUserId;

}