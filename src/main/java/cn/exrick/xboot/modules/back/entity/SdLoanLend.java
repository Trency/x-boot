package cn.exrick.xboot.modules.back.entity;

import cn.exrick.xboot.base.BaseEntity;
import cn.exrick.xboot.common.utils.SnowFlakeUtil;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

/**
 * @author
 */
@Data
@Entity
@Table(name = "sd_loan_lend")
@TableName("sd_loan_lend")
public class SdLoanLend extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @TableId
    @ApiModelProperty(value = "贷款表id，唯一标识")
    private String lendId = String.valueOf(SnowFlakeUtil.getFlowIdInstance().nextId());

    @ApiModelProperty(value = "贷款流水号")
    private String lendOrderNo;

    @ApiModelProperty(value = "利息金额")
    private Long interestAmout;

    @ApiModelProperty(value = "所属产品ID")
    private String productId;

    @ApiModelProperty(value = "产品名称")
    private String productName;

    @ApiModelProperty(value = "利率")
    private Double interestRate;

    @ApiModelProperty(value = "违约金利率")
    private Double violateRate;

    @ApiModelProperty(value = "违约金类型,COMPOUND ：复利,SIMPLE ：单利")
    private String violateType;

    @ApiModelProperty(value = "是否计算违约金,0:正常计入,1:不计入")
    private Integer isViolate;

    @ApiModelProperty(value = "所属用户ID")
    private String userId;

    @ApiModelProperty(value = "用户姓名")
    private String userName;

    @ApiModelProperty(value = "允许延长天数")
    private Long extend;

    @ApiModelProperty(value = "借款天数")
    private Long lendDays;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "收款账号")
    private String gatheringAccount;

    @ApiModelProperty(value = "收款账号类型：ALIPAY-支付宝, WECHAT-微信")
    private String gatheringAccountType;

    @ApiModelProperty(value = "申请贷款金额")
    private Long applyAmount;

    @ApiModelProperty(value = "实际贷款金额")
    private Long lendAmount;

    @ApiModelProperty(value = "联系电话")
    private String cellphone;

    @ApiModelProperty(value = "实际利息")
    private Long lendInterestAmount;

    @ApiModelProperty(value = "放款交易号")
    private String transactionId;

    @ApiModelProperty(value = "第三方支付平台类别 ALIPAY-支付宝, WECHAT-微信, WECHAT_SMALL-微信小程序")
    private String platformType;

    @ApiModelProperty(value = "贷款订单状态:1.已取消-BUYER_CANCEL (代表买家主动取消), 2.正常-NORMALL,")
    private String lendOrderStatus;

    @ApiModelProperty(value = "取消时间")
    private Date cancelTime;

    @ApiModelProperty(value = "错误信息")
    private String errMsg;

    @ApiModelProperty(value = "错误code")
    private String errCode;

    @ApiModelProperty(value = "签名")
    private String sign;

    @ApiModelProperty(value = "贷款申请时间")
    private Date applyTime;

    @ApiModelProperty(value = "审核时间，无论审核失败成功，都有此时间")
    private Date examineTime;

    @ApiModelProperty(value = "审核状态:审核中-EXAMINING, 审核通过-EXAMINE_SUCCESS,审核失败-EXAMINE_FAIL")
    private String examineStatus;

    @ApiModelProperty(value = "放款完成时间")
    private Date paymentTime;

    @ApiModelProperty(value = "还款完成时间")
    private Date repaymentTime;

    @ApiModelProperty(value = "审核备注")
    private String examineRemark;

    @ApiModelProperty(value = "审核人")
    private String examineUserId;

    @ApiModelProperty(value = "审核人姓名")
    private String examineUserName;

    @ApiModelProperty(value = "还款状态:待还款-PRE_REPAYMENT,已还款-REPAYMENTED")
    private String repaymentStatus;

    @ApiModelProperty(value = "放款IP")
    private String ip;

    @ApiModelProperty(value = "放款款状态:待还款-PRE_PAYMENT,已还款-REPAYMENTED")
    private String paymentStatus;

    @ApiModelProperty(value = "放款备注")
    private String paymentRemark;

    @ApiModelProperty(value = "放款人")
    private String paymentUserId;

    @ApiModelProperty(value = "放款人姓名")
    private String paymentUserName;

    @ApiModelProperty(value = "终端:PC-网页, APP-APP, WECHAT-微信")
    private String terminalType;

    @ApiModelProperty(value = "活动ID")
    private String activityId;

    @ApiModelProperty(value = "活动延长天数")
    private Long activityExtend;

    @ApiModelProperty(value = "违约金")
    private Long violateAmount;

    @ApiModelProperty(value = "违约状态:未违约-UN_VIOLAT’,已违约-VIOLATED")
    private String violateStatus;

    @ApiModelProperty(value = "逾期天数")
    private Integer violateDays;

    @ApiModelProperty(value = "催收次数 计算出的结果，非实际字段")
    private Integer dunningCount;

    @ApiModelProperty(value = "最后催收时间 非数据库字段")
    private Date lastDunningTime;

    @Transient
    @TableField(exist = false)
    private List<SdLoanUserRelationship> sdLoanUserRelationships;

    @Transient
    @TableField(exist = false)
    @ApiModelProperty(value = "还款信息")
    private List<SdLoanRepayment> repayments;

    /**
     * 展示的还款状态 待还款 PRE_REPAYMENT, 已还款 REPAYMENTED, 已违约 VIOLATED, 已挂起 HANGED
     * 待还款 不包含已挂起
     * 已还款
     * 已违约 不包含已挂起
     * 已挂起
     */
    @Transient
    @TableField(exist = false)
    private String repaymentShowStatus;
}