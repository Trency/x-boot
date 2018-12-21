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
@Table(name = "sd_loan_featured")
@TableName("sd_loan_featured")
public class SdLoanFeatured extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @TableId
    @ApiModelProperty(value = "推荐位主键，唯一标识")
    private String featuredId = String.valueOf(SnowFlakeUtil.getFlowIdInstance().nextId());

    @ApiModelProperty(value = "推荐位code,前端页面按照code字段获取推荐位的信息")
    private String featuredCode;

    @ApiModelProperty(value = "推荐位类型")
    private String featuredType;

    @ApiModelProperty(value = "推荐位名称")
    private String featuredName;

    @ApiModelProperty(value = "推荐位图")
    private String featuredImage;

    @ApiModelProperty(value = "跳转链接")
    private String urlHref;

    @ApiModelProperty(value = "是否启用:ENABLE-正常| DISABLE-禁用")
    private String featuredStatus;
}