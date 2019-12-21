package hrms.entity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 系统常量类
 */

public class SystemConstants {

    /**
     * 验证码保留时间
     */
    public static final int CAPTCHA_INTERVAL = 15 * 60 * 1000;

    /**
     * 同IP access有效间隔时间
     */
    public static final Long ACCESS_INTERVAL = 5000L;

    /**
     * deleteflag: delete
     */
    public static final int DELETED = 1;

    /**
     * deleteflag: normal
     */
    public static final int NORMAL = 0;

    /**
     * ng-zorro paging constants
     */
    public static final String CURRENT = "current";
    public static final String PAGE_SIZE = "pageSize";
    public static final String SORT_NAME = "sortName";
    public static final String SORT_VALUE = "sortValue";
    public static final String SORT_END = "end";

    /**
     * 代理申请角色名
     */
    public static final String PROXY_ROLE = "代理申请";

    /**
     * solr引擎需要用到但是不需要输出到页面的公告字段
     */
    public static final String SOLR_COMMON = "solr-common";

    /**
     * 权限值100，大于等于的为超级管理员
     */
    public static final int AUTH_POWER = 100;

    // public final static Map<String, String> STAFF_SEARCH_COLUMN_SQL = Collections.unmodifiableMap(new HashMap<>());
    private static Map<String, String> columnMap = new HashMap<>();

    static {

        columnMap.put("id", "b.id");
        columnMap.put("jobCode", "b.jobCode");
        columnMap.put("name", "b.name");
        columnMap.put("status", "b.status");
        columnMap.put("avatar", "b.avatar");
        columnMap.put("docNo", "b.docNo");
        columnMap.put("employeeType", "b.employeeType");
        columnMap.put("birthday", "b.birthday");
        columnMap.put("age", "b.birthday AS age");
        columnMap.put("gender", "b.gender");
        columnMap.put("maritalStatus", "b.maritalStatus");
        columnMap.put("idType1", "b.IDType1 AS idType1");
        columnMap.put("idNum1", "b.IDNum1 AS idNum1");
        columnMap.put("idExpiryDate1", "b.IDExpiryDate1 AS idExpiryDate1");
        columnMap.put("idType2", "b.IDType2 AS idType2");
        columnMap.put("idNum2", "b.IDNum2 AS idNum2");
        columnMap.put("idExpiryDate2", "b.IDExpiryDate2 AS idExpiryDate2");
        columnMap.put("homeAddr", "b.homeAddr");
        columnMap.put("postAddr", "b.postAddr");
        columnMap.put("persPhone", "b.persPhone");
        columnMap.put("persEmail", "b.persEmail");
        columnMap.put("corpPhone", "b.corpPhone");
        columnMap.put("corpPhoneShort", "b.corpPhoneShort");
        columnMap.put("corpInnerPhone", "b.corpInnerPhone");
        columnMap.put("corpEmail", "b.corpEmail");
        columnMap.put("wechat", "b.wechat");
        columnMap.put("qq", "b.qq");
        columnMap.put("emergencyContact1", "b.emergencyContact1");
        columnMap.put("emergencyRelation1", "b.emergencyRelation1");
        columnMap.put("emergencyContact1Phone", "b.emergencyContact1Phone");
        columnMap.put("emergencyContact2", "b.emergencyContact2");
        columnMap.put("emergencyRelation2", "b.emergencyRelation2");
        columnMap.put("emergencyContact2Phone", "b.emergencyContact2Phone");
        columnMap.put("tempResidencePermitNum", "b.tempResidencePermitNum");
        columnMap.put("tempResidencePermitAddr", "b.tempResidencePermitAddr");
        columnMap.put("tempResidenceExpiryDate", "b.tempResidenceExpiryDate");
        columnMap.put("nationality", "b.nationality");
        columnMap.put("ethnicGroup", "b.ethnicGroup");
        columnMap.put("nativePlace", "b.nativePlace");
        columnMap.put("houseHolderType", "b.houseHolderType");
        columnMap.put("houseHolderAddr", "b.houseHolderAddr");
        columnMap.put("politicalStatus", "b.politicalStatus");
        columnMap.put("remark01", "b.remark1 AS remark01");
        columnMap.put("remark02", "b.remark2 AS remark02");
        columnMap.put("attendanceExemption", "b.attendanceExemption");
        columnMap.put("isIntroduced", "b.isIntroduced");
        columnMap.put("introducerType", "i.introducerType");
        columnMap.put("introducerStr", "case when b1.name is null then i.introducerStr else b1.name end AS introducerStr");
        columnMap.put("introducerContactType", "i.introducerContactType");
        columnMap.put("introducerContactNum", "i.introducerContactNum");
        columnMap.put("rewardType", "i.rewardType");
        columnMap.put("rewardBankName", "i.rewardBankName");
        columnMap.put("rewardBankCardNum", "i.rewardBankCardNum");
        columnMap.put("paymentAmount1", "i.paymentAmount1");
        columnMap.put("paymentDate1", "i.paymentDate1");
        columnMap.put("actualPaymentDate1", "i.actualPaymentDate1");
        columnMap.put("alreadyPay1", "i.alreadyPay1");
        columnMap.put("paymentAmount2", "i.paymentAmount2");
        columnMap.put("paymentDate2", "i.paymentDate2");
        columnMap.put("actualPaymentDate2", "i.actualPaymentDate2");
        columnMap.put("alreadyPay2", "i.alreadyPay2");
        columnMap.put("paymentAmount3", "i.paymentAmount3");
        columnMap.put("paymentDate3", "i.paymentDate3");
        columnMap.put("actualPaymentDate3", "i.actualPaymentDate3");
        columnMap.put("alreadyPay3", "i.alreadyPay3");
        columnMap.put("topEducation", "b.topEducation");
        columnMap.put("graduateSchool", "b.graduateSchool");
        columnMap.put("topEnterDate", "b.topEnterDate");
        columnMap.put("graduateTime", "b.graduateTime");
        columnMap.put("major", "b.major");
        columnMap.put("topGotDegree", "b.topGotDegree");
        columnMap.put("enterDate", "b.enterDate");
        columnMap.put("retirementTime", "b.retirementTime");
        columnMap.put("workAgeInThisCompany", "b.enterDate AS workAgeInThisCompany");

        columnMap.put("workedYears", "b.workedYears");
        columnMap.put("beRegularDate", "b.beRegularDate");
        columnMap.put("forwardDate", "b.forwardDate");
        columnMap.put("trialPeriod", "b.trialPeriod");
        columnMap.put("trialPeriodText", "bc2.fieldvalue AS trialPeriodText");
        columnMap.put("trialStatus", "b.trialStatus");
        columnMap.put("bakStatus", "b.bakStatus");
        columnMap.put("bakStart", "r.startDate AS bakStart");
        columnMap.put("reserveDeptName", "r.reserveDeptName");
        columnMap.put("reservePostName", "r.reservePostName");
        columnMap.put("returnStatus", "b.returnStatus");
        columnMap.put("lastWorkDay", "l.lastWorkDay AS lastWorkDay");
        columnMap.put("willLeavingDate", "wl.lastWorkDay AS willLeavingDate");
        columnMap.put("leaveType", "l.leaveType AS leaveType");
        columnMap.put("leaveRemark", "l.leaveRemark AS leaveRemark");
        columnMap.put("socialInsuranceLastMonth", "l.socialInsuranceLastMonth");
        columnMap.put("housingFundLastMonth", "l.housingFundLastMonth");
        columnMap.put("reward", "c.reward");
        columnMap.put("contractType", "c.contractType");
        columnMap.put("signingDate", "c.signingDate");
        columnMap.put("signContract", "c.signContract");
        columnMap.put("contractTime", "c.contractTime");
        columnMap.put("contractTimeText", "bc1.fieldvalue AS contractTimeText");
        columnMap.put("contractStartDate", "c.contractStartDate");
        columnMap.put("contractFinishDate", "c.contractFinishDate");
        columnMap.put("signNumber", "c.signNumber");
        columnMap.put("contractCompany", "c.company AS contractCompany");
        columnMap.put("contractPost", "CONCAT(md1.name,\"-\",mp1.name) AS contractPost");
        columnMap.put("contractWage", "c.contractWage");
        columnMap.put("contractRemark", "c.remark AS contractRemark");
        columnMap.put("socialInsuranceType", "s.socialInsuranceType");
        columnMap.put("socialInsuranceId", "s.socialInsuranceId");
        columnMap.put("socialInsuranceBase", "s.socialInsuranceBase");
        columnMap.put("socialInsurancePayLocation", "CONCAT(s.socialInsurancePayLocationProvince,s.socialInsurancePayLocationCity,s.socialInsurancePayLocationDistrict) AS socialInsurancePayLocation");
        columnMap.put("socialInsuranceStartMonth", "s.socialInsuranceStartMonth");
        columnMap.put("socialInsuranceEndMonth", "s.socialInsuranceEndMonth");
        columnMap.put("socialInsurancePers", "s.socialInsurancePers");
        columnMap.put("socialInsuranceCorp", "s.socialInsuranceCorp");
        columnMap.put("socialInsuranceRatePers", "s.socialInsuranceRatePers");
        columnMap.put("socialInsuranceRateCorp", "s.socialInsuranceRateCorp");
        columnMap.put("socialRemark", "s.remark AS socialRemark");
        columnMap.put("socialCompany", "s.company AS socialCompany");
        columnMap.put("housingFundId1", "h.housingFundId1");
        columnMap.put("housingFundPayLocation", "CONCAT(h.housingFundPayLocationProvince,h.housingFundPayLocationCity,h.housingFundPayLocationDistrict) AS housingFundPayLocation");
        columnMap.put("housingFundBase", "h.housingFundBase");
        columnMap.put("housingFundRate", "h.housingFundRate");
        columnMap.put("housingFundId2", "h.housingFundId2");
        columnMap.put("housingFundPayLocation2", "CONCAT(h.housingFundPayLocationProvince2, h.housingFundPayLocationCity2, h.housingFundPayLocationDistrict2) AS housingFundPayLocation2");
        columnMap.put("housingFundBase2", "h.housingFundBase2");
        columnMap.put("housingFundRate2", "h.housingFundRate2");
        columnMap.put("housingFundStartMonth", "h.housingFundStartMonth");
        columnMap.put("housingFundEndMonth", "h.housingFundEndMonth");
        columnMap.put("housingFundPers", "h.housingFundPers");
        columnMap.put("housingFundCorp", "h.housingFundCorp");
        columnMap.put("housingFund2", "h.housingFund2");
        columnMap.put("housingCompany", "h.company AS housingCompany");
        columnMap.put("housingRemark", "h.remark AS housingRemark");
        columnMap.put("majorStartDate", "m.startDate AS majorStartDate");
        columnMap.put("majorFinishDate", "m.finishDate AS majorFinishDate");
        columnMap.put("departId", "m.departId");
        columnMap.put("departName", "md.fullName AS departName");
        columnMap.put("postId", "m.postId");
        columnMap.put("postName", "mp.name AS postName");
        columnMap.put("dutyId", "m.dutyId");
        columnMap.put("dutyName", "mdu.name AS dutyName");
        columnMap.put("calendarId", "m.calendarId");
        columnMap.put("calendarName", "mc.name AS calendarName");
        columnMap.put("workRank", "m.workRank");
        columnMap.put("rank", "bc4.fieldvalue AS rank");
        columnMap.put("specialWork", "m.specialWork");
        columnMap.put("majorRemark", "m.remark AS majorRemark");
        columnMap.put("companies", "GROUP_CONCAT(distinct j.corpName SEPARATOR '||') AS companies");
        columnMap.put("beRegularReason", "bc3.fieldvalue AS beRegularReason");
    }

    // fix map to unmodifiableMap
    public static final Map<String, String> STAFF_SEARCH_COLUMN_SQL = Collections.unmodifiableMap(columnMap);

}
