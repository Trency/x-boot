package cn.exrick.xboot.modules.back.entity;

import cn.exrick.xboot.base.BaseEntity;
import cn.exrick.xboot.common.utils.SnowFlakeUtil;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * @author
 */
@Data
@Entity
@Table(name = "sd_loan_user")
@TableName("sd_loan_user")
public class SdLoanUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @TableId
    @ApiModelProperty(value = "用户主键，唯一标识")
    private String userId = String.valueOf(SnowFlakeUtil.getFlowIdInstance().nextId());

    @ApiModelProperty(value = "真实姓名")
    private String fullName;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "所在地省份")
    private String locationProvince;

    @ApiModelProperty(value = "所在地城市")
    private String locationCity;

    @ApiModelProperty(value = "注册来源")
    private String registSource;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "密码salt")
    private String passwordSalt;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "头像 URL")
    @Column(length = 500)
    private String photo;

    @ApiModelProperty(value = "性别 EnumUserGender：UNKNOWN，MALE，FEMALE，CONFIDENTIALITY")
    private String gender;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "出生日期")
    private Date birthday;

    @ApiModelProperty(value = "注册手机号")
    @Column(length = 20)
    private String cellphone;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "最后登录时间")
    private Date lastLoginTime;

    @ApiModelProperty(value = "最后登录IP")
    private String lastLoginIp;

    @ApiModelProperty(value = "联系电话")
    @Column(length = 20)
    private String tel;

    @ApiModelProperty(value = "邮件")
    private String email;

    @ApiModelProperty(value = "用户状态：UserStatus:正常 -NORMAL，禁用-CLOSED")
    private String userStatus;

    @ApiModelProperty(value = "贷款额度")
    private Long loanLimit;

    @ApiModelProperty(value = "支付宝账号")
    private String alipayAccount;

    @ApiModelProperty(value = "学号")
    private String studentNumber;

    @ApiModelProperty(value = "学校")
    private String school;

    @ApiModelProperty(value = "公司")
    private String company;

    @ApiModelProperty(value = "身份证正面照片")
    @Column(length = 500)
    private String idCardNoFrontPhoto;

    @ApiModelProperty(value = "身份证背面照片")
    @Column(length = 500)
    private String idCardNoBackPhoto;

    @ApiModelProperty(value = "扫脸照片")
    @Column(length = 500)
    private String userPhoto;

    @ApiModelProperty(value = "身份证号码")
    private String idCardNo;

    @ApiModelProperty(value = "信息状态,UN_SUBMIT-未提交,审核中-EXAMINING, 审核通过-EXAMINE_SUCCESS,审核失败-EXAMINE_FAIL")
    private String informationStatus;

    @ApiModelProperty(value = "个人身份证状态,UN_SUBMIT-未提交,审核中-EXAMINING, 审核通过-EXAMINE_SUCCESS,审核失败-EXAMINE_FAIL")
    private String idCardStatus;

    @ApiModelProperty(value = "个人扫脸状态状态,UN_SUBMIT-未提交,审核中-EXAMINING, 审核通过-EXAMINE_SUCCESS,审核失败-EXAMINE_FAIL")
    private String userPhotoStatus;

    @ApiModelProperty(value = "联系人状态,UN_SUBMIT-未提交,审核中-EXAMINING, 审核通过-EXAMINE_SUCCESS,审核失败-EXAMINE_FAIL")
    private String relationshipStatus;

    @ApiModelProperty(value = "支付宝状态,UN_SUBMIT-未提交,审核中-EXAMINING, 审核通过-EXAMINE_SUCCESS,审核失败-EXAMINE_FAIL")
    private String alipayAccountStatus;

    @ApiModelProperty(value = "短信验证码")
    private String verification;

    @ApiModelProperty(value = "token")
    private String token;

    @ApiModelProperty(value = "是否允许贷款")
    private Boolean isCanLend;

    @ApiModelProperty(value = "详细地址")
    private String address;

    @Transient
    @TableField(exist = false)
    private List<SdLoanTelephonebook> telephonebookList;

}