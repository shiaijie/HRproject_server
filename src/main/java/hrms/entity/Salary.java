package hrms.entity;


import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 薪资信息管理表
 */
@Data
@TableName("salary")
public class Salary extends Model<Salary> {

    private static final long serialVersionUID = 1L;

    /**
     * 工资id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 员工工号
     */
    private String jobCode;
    /**
     * 基本工资
     */
    private Float basicSalary;
    /**
     * 津补贴
     */
    private Float subsidy;
    /**
     * 社保
     */
    private Float socialInsurance;
    /**
     * 公积金
     */
    private Float accumulationFund;
    /**
     * 其他附加
     */
    private Float otherAdd;
    /**
     * 其他扣除
     */
    private Float otherMinus;
    /**
     * 总工资
     */
    private Float totalWage;
    /**
     * 工资单年月
     */
    private Date yearMonth;
    /**
     * 是否归档，0否，1是
     */
    private Integer isFile;

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }
    public String getJobCode() {
        return jobCode;
    }

    public void setBasicSalary(Float basicSalary) {
        this.basicSalary = basicSalary;
    }
    public Float getBasicSalary() {
        return basicSalary;
    }

    public void setSubsidy(Float subsidy) {
        this.subsidy = subsidy;
    }
    public Float getSubsidy() {
        return subsidy;
    }

    public void setSocialInsurance(Float socialInsurance) {
        this.socialInsurance = socialInsurance;
    }
    public Float getSocialInsurance() {
        return socialInsurance;
    }

    public void setAccumulationFund(Float accumulationFund) {
        this.accumulationFund = accumulationFund;
    }
    public Float getAccumulationFund() {
        return accumulationFund;
    }

    public void setOtherAdd(Float otherAdd) {
        this.otherAdd = otherAdd;
    }
    public Float getOtherAdd() {
        return otherAdd;
    }

    public void setOtherMinus(Float otherMinus) {
        this.otherMinus = otherMinus;
    }
    public Float getOtherMinus() {
        return otherMinus;
    }

    public void setTotalWage(Float totalWage) {
        this.totalWage = totalWage;
    }
    public Float getTotalWage() {
        return totalWage;
    }

    public void setYearMonth(Date yearMonth) {
        this.yearMonth = yearMonth;
    }
    public Date getYearMonth() {
        return yearMonth;
    }

    public void setIsFile(Integer isFile) {
        this.isFile = isFile;
    }
    public Integer getIsFile() {
        return isFile;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", jobCode=" + jobCode +
                ", basicSalary=" + basicSalary +
                ", subsidy=" + subsidy +
                ", socialInsurance=" + socialInsurance +
                ", accumulationFund=" + accumulationFund +
                ", otherAdd=" + otherAdd +
                ", otherMinus=" + otherMinus +
                ", totalWage=" + totalWage +
                ", yearMonth=" + yearMonth +
                ", isFile=" + isFile +
                "}";
    }
}
