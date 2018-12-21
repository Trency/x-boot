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

    private String repaymentOrderNo;        // 还款流水号
    private String userId;        // 所属用户ID
    private String userName;        // 用户名
    private String cellphone;        // 手机号
    private String lendId;        // 贷款ID
    private String lendOrderNo;        // 贷款流水号
    private String title;        // 标题
    private String productId;        // 产品ID
    private String productName;        // 产品名称
    private Long repaymentAmount;        // 还款金额
    private Long interestAmout;        // 利息金额
    private Long lendAmount;        // 实际贷款金额
    private Long violateAmount;        // 违约金额
    private String transactionId;        // 还款交易号
    private String platformType;        // 还款交易平台： ALIPAY-支付宝, WECHAT-微信, WECHAT_SMALL-微信小程序
    private String errMsg;        // 错误信息
    private String errCode;        // 错误code
    private String sign;        // 签名
    private Date repaymentTime;        // 还款时间
    private String terminalType;        // 终端:PC-网页, APP-APP, WECHAT-微信

}