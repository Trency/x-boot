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
import java.util.Date;

/**
 * @author
 */
@Data
@Entity
@Table(name = "sd_loan_repayment")
@TableName("sd_loan_repayment")
public class SdLoanRepayment extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @TableId
    @ApiModelProperty(value = "还款表id，唯一标识")
    private String repaymentId = String.valueOf(SnowFlakeUtil.getFlowIdInstance().nextId());

    @ApiModelProperty(value = "还款流水号")
    private String repaymentOrderNo;

    @ApiModelProperty(value = "所属用户ID")
    private String userId;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "手机号")
    private String cellphone;

    @ApiModelProperty(value = "贷款ID")
    private String lendId;

    @ApiModelProperty(value = "贷款流水号")
    private String lendOrderNo;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "产品ID")
    private String productId;

    @ApiModelProperty(value = "产品名称")
    private String productName;

    @ApiModelProperty(value = "还款金额")
    private Long repaymentAmount;

    @ApiModelProperty(value = "利息金额")
    private Long interestAmout;

    @ApiModelProperty(value = "实际贷款金额")
    private Long lendAmount;

    @ApiModelProperty(value = "违约金额")
    private Long violateAmount;

    @ApiModelProperty(value = "还款交易号")
    private String transactionId;

    @ApiModelProperty(value = "还款交易平台： ALIPAY-支付宝, WECHAT-微信, WECHAT_SMALL-微信小程序")
    private String platformType;

    @ApiModelProperty(value = "错误信息")
    private String errMsg;

    @ApiModelProperty(value = "错误code")
    private String errCode;

    @ApiModelProperty(value = "签名")
    private String sign;

    @ApiModelProperty(value = "还款时间")
    private Date repaymentTime;

    @ApiModelProperty(value = "终端:PC-网页, APP-APP, WECHAT-微信")
    private String terminalType;

}