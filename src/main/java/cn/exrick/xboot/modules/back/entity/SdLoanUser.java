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
@Table(name = "sd_loan_user")
@TableName("sd_loan_user")
public class SdLoanUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @TableId
    @ApiModelProperty(value = "用户主键，唯一标识")
    private String userId = String.valueOf(SnowFlakeUtil.getFlowIdInstance().nextId());

    private String fullName;        // 真实姓名
    private String userName;        // 用户名
    private String locationProvince;        // 所在地省份
    private String locationCity;        // 所在地城市
    private String registSource;        // 注册来源
    private String password;        // 密码
    private String passwordSalt;        // 密码salt
    private String nickname;        // 昵称
    private String photo;        // 头像 URL
    private String gender;        // 性别 EnumUserGender：UNKNOWN，MALE，FEMALE，CONFIDENTIALITY
    private Date birthday;        // 出生日期
    private String cellphone;        // 注册手机号
    private Date lastLoginTime;        // 最后登录时间
    private String lastLoginIp;        // 最后登录IP
    private String tel;        // 联系电话
    private String email;        // 邮件
    private String userStatus;        // 用户状态：UserStatus:正常 -NORMAL，禁用-CLOSED
    private Long loanLimit;        // 贷款额度
    private String alipayAccount;        // 支付宝账号
    private String studentNumber;        // 学号
    private String school;        // 学校
    private String company;        // 公司
    private String idCardNoFrontPhoto;        // 身份证正面照片
    private String idCardNoBackPhoto;        // 身份证背面照片
    private String userPhoto;        // 扫脸照片
    private String idCardNo;        // 身份证号码
    private String informationStatus;        // 信息状态,UN_SUBMIT-未提交,审核中-EXAMINING, 审核通过-EXAMINE_SUCCESS,审核失败-EXAMINE_FAIL
    private String idCardStatus;        // 个人身份证状态,UN_SUBMIT-未提交,审核中-EXAMINING, 审核通过-EXAMINE_SUCCESS,审核失败-EXAMINE_FAIL
    private String userPhotoStatus;        // 个人扫脸状态状态,UN_SUBMIT-未提交,审核中-EXAMINING, 审核通过-EXAMINE_SUCCESS,审核失败-EXAMINE_FAIL
    private String relationshipStatus;        // 联系人状态,UN_SUBMIT-未提交,审核中-EXAMINING, 审核通过-EXAMINE_SUCCESS,审核失败-EXAMINE_FAIL
    private String alipayAccountStatus;        // 支付宝状态,UN_SUBMIT-未提交,审核中-EXAMINING, 审核通过-EXAMINE_SUCCESS,审核失败-EXAMINE_FAIL
    private String verification;//短信验证码
    private String token;//token
    private Boolean isCanLend;

    private String address;//详细地址

    @Transient
    @TableField(exist = false)
    private List<SdLoanTelephonebook> telephonebookList;

}