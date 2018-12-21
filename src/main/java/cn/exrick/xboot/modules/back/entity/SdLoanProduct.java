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
@Table(name = "sd_loan_product")
@TableName("sd_loan_product")
public class SdLoanProduct extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @TableId
    @ApiModelProperty(value = "贷款产品主键，唯一标识")
    private String productId = String.valueOf(SnowFlakeUtil.getFlowIdInstance().nextId());

    private String title;        // 标题
    private String subTitle;        // 子标题
    private String coverImage;        // 封面图
    private Long productAmount;        // 贷款金额
    private Long interestAmount;        // 利息金额
    private Double interestRate;        // 利率
    private Double violateRate;        // 违约金利率
    private String violateType;        // 违约金类型,COMPOUND ：复利,SIMPLE ：单利
    private Long lendDays;        // 借款天数
    private Long stock;        // 库存
    private Long extend;        // 允许延长天数
    private String productName;        // 产品名称
    private String description;        // 产品描述
    private String simpleRemark;        // 简要介绍
    private String recommendDescription;        // 推荐描述
    private String productStatus;        // 产品状态 UN_SUBMIT-未提交,WAIT_UP-待上架,UP-已上架,DOWN-已下架

}