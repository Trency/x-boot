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
    private String lendOrderNo;        // 贷款流水号
    private Long interestAmout;        // 利息金额
    private String productId;        // 所属产品ID
    private String productName;        // 产品名称
    private Double interestRate;        // 利率
    private Double violateRate;        // 违约金利率
    private String violateType;        // 违约金类型,COMPOUND ：复利,SIMPLE ：单利
    private Integer isViolate;        // 是否计算违约金,0:正常计入,1:不计入
    private String userId;        // 所属用户ID
    private String userName;        // 用户姓名
    private Long extend;        // 允许延长天数
    private Long lendDays;        // 借款天数
    private String title;        // 标题
    private String gatheringAccount;        // 收款账号
    private String gatheringAccountType;        // 收款账号类型：ALIPAY-支付宝, WECHAT-微信
    private Long applyAmount;        // 申请贷款金额
    private Long lendAmount;        // 实际贷款金额
    private String cellphone;        // 联系电话
    private Long lendInterestAmount;        // 实际利息
    private String transactionId;        // 放款交易号
    private String platformType;        // 第三方支付平台类别 ALIPAY-支付宝, WECHAT-微信, WECHAT_SMALL-微信小程序
    private String lendOrderStatus;        // 贷款订单状态:1.已取消-BUYER_CANCEL (代表买家主动取消), 2.正常-NORMALL,
    private Date cancelTime;        // 取消时间
    private String errMsg;        // 错误信息
    private String errCode;        // 错误code
    private String sign;        // 签名
    private Date applyTime;        // 贷款申请时间
    private Date examineTime;        // 审核时间，无论审核失败成功，都有此时间
    private String examineStatus;        // 审核状态:审核中-EXAMINING, 审核通过-EXAMINE_SUCCESS,审核失败-EXAMINE_FAIL
    private Date paymentTime;        // 放款完成时间
    private Date repaymentTime;        // 还款完成时间
    private String examineRemark;        // 审核备注
    private String examineUserId;        // 审核人
    private String examineUserName;        // 审核人姓名
    private String repaymentStatus;        // 还款状态:待还款-PRE_REPAYMENT,已还款-REPAYMENTED
    private String ip;        // 放款IP
    private String paymentStatus;        // 放款款状态:待还款-PRE_PAYMENT,已还款-REPAYMENTED
    private String paymentRemark;        // 放款备注
    private String paymentUserId;        // 放款人
    private String paymentUserName;        // 放款人姓名
    private String terminalType;        // 终端:PC-网页, APP-APP, WECHAT-微信
    private String activityId;        // 活动ID
    private Long activityExtend;        // 活动延长天数

    private Long violateAmount;//违约金

    private String violateStatus;//违约状态:未违约-UN_VIOLAT’,已违约-VIOLATED
    private Integer violateDays;        // 逾期天数

    private Integer dunningCount;        // 催收次数 计算出的结果，非实际字段
    private Date lastDunningTime;        // 最后催收时间 非数据库字段

    @Transient
    @TableField(exist = false)
    private List<SdLoanUserRelationship> sdLoanUserRelationships;

    @Transient
    @TableField(exist = false)
    private List<SdLoanRepayment> repayments;    // 还款信息

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