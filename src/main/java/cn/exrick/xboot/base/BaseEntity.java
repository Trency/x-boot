package cn.exrick.xboot.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Exrickx
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "fieldHandler"})
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "列表显示顺序")
    @Column(columnDefinition = "int(11) COMMENT '列表显示顺序'")
    private Long displayOrder;

    @ApiModelProperty(value = "备注")
    @Column(columnDefinition = "varchar(1000) COMMENT '备注'")
    private String remark;

    @ApiModelProperty(value = "版本")
    @Column(columnDefinition = "int(11) COMMENT '版本'")
    private Long version;

    @ApiModelProperty(value = "创建人Id")
    @Column(columnDefinition = "varchar(64) COMMENT '创建人Id'")
    private String createUserId;

    @ApiModelProperty(value = "创建人姓名")
    @Column(columnDefinition = "varchar(100) COMMENT '创建人姓名'")
    private String createUserName;

    @CreatedDate
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    @Column(columnDefinition = "datetime COMMENT '创建时间'")
    private Date createTime;

    @ApiModelProperty(value = "修改人")
    @Column(columnDefinition = "varchar(100) COMMENT '修改人'")
    private String updateUserId;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "修改时间")
    @Column(columnDefinition = "datetime COMMENT '修改时间'")
    private Date updateTime;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "最后修改时间")
    @Column(columnDefinition = "timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间'")
    private Date lastUpdate;

    @ApiModelProperty(value = "0:正常,1:删除(默认0)")
    @Column(columnDefinition = "int(1) DEFAULT '0' COMMENT '0:正常,1:删除(默认0)'")
    private Integer deleted;

}
