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

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "子标题")
    private String subTitle;

    @ApiModelProperty(value = "封面图")
    private String coverImage;

    @ApiModelProperty(value = "贷款金额")
    private Long productAmount;

    @ApiModelProperty(value = "利息金额")
    private Long interestAmount;

    @ApiModelProperty(value = "利率")
    private Double interestRate;

    @ApiModelProperty(value = "违约金利率")
    private Double violateRate;

    @ApiModelProperty(value = "违约金类型,COMPOUND ：复利,SIMPLE ：单利")
    private String violateType;

    @ApiModelProperty(value = "借款天数")
    private Long lendDays;

    @ApiModelProperty(value = "库存")
    private Long stock;

    @ApiModelProperty(value = "允许延长天数")
    private Long extend;

    @ApiModelProperty(value = "产品名称")
    private String productName;

    @ApiModelProperty(value = "产品描述")
    private String description;

    @ApiModelProperty(value = "简要介绍")
    private String simpleRemark;

    @ApiModelProperty(value = "推荐描述")
    private String recommendDescription;

    @ApiModelProperty(value = "产品状态 UN_SUBMIT-未提交,WAIT_UP-待上架,UP-已上架,DOWN-已下架")
    private String productStatus;

}