package com.ejie.nbrs.dto;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import com.ejie.nbrs.entity.MortgageHouse;

/**
 * ClassName:SearchCondition
 * 
 * @author zlg
 * @version 版本
 * @since Ver 1.1
 * @Date 2017年7月21日 下午3:34:13
 * @ModifiedBy 修改人
 * @Copyright 公司名称
 * 
 */
public class SearchCondition {
  public static void main(String[] args) {
    SearchCondition sc = new SearchCondition();
    System.out.println(sc.toString());
  }

  private Integer channelCode;
  /**
   * 查询页数
   */
  private int currentPage;
  /**
   * 每页显示条数
   */
  private int pageSize;
  /**
   * 数据库分页查询下标(修改状态的依据guarantee_id)
   */
  private int dataIndex;

  /**
   * （审批，入库；放款日期）起始时间
   */
  private String startTime;
  /**
   * （审批，入库）结束时间
   */
  private String endTime;
  /**
   * 产品名（放款模式）
   */
  private String eProduct;
  /**
   * 贷款客户姓名（抵押人名）
   */
  private String aBaseName;
  /**
   * 审核结果(出入库状态)
   */
  private Integer status;
  /**
   * 贷款编号（授信审核、放款确认执行id、押品编号）
   */
  private Integer loanId;
  /**
   * 出库说明
   */
  private String outRemark;
  /**
   * 当前操作人
   */
  private Integer userId;
  /**
   * 放款凭证/出库证明
   */
  private String loanVoucher;

  /**
   * 出库原因
   */
  private String outReason;
  /**
   * 业务流水号
   */
  private String serialNo;
  /**
   * 用户全局id
   */
  private Integer cUserId;
  /**
   * 入库申请时间
   */
  private String inApplyTime;
  /**
   * 出库申请时间
   */
  private String outApplyTime;

  /**
   * 节点标记码(1001：授信初审；1002：授信复审；1003：放款初审； 1004：放款复审；1005：放款终审；1006：放款确认)
   */
  private Integer nodeStatus;
  /**
   * 流程状态码(0:默认;1:通过;2:拒绝)
   */
  private Integer flowStatus;
  /**
   * 我行评估金额
   */
  private List<MortgageHouse> evaluate;
  /**
   * 实际放款
   */
  private BigDecimal realLoanMoney;
  /**
   * 文档二级分类集合数组
   */
  private String[] docArr;
  
  public String getSerialNo() {
    return serialNo;
  }

  public void setSerialNo(String serialNo) {
    this.serialNo = serialNo;
  }

  /* 以下是get、set方法 */

  public int getCurrentPage() {
    return currentPage;
  }

  public void setCurrentPage(int currentPage) {
    this.currentPage = currentPage;
  }

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  public int getDataIndex() {
    return dataIndex;
  }

  public void setDataIndex(int dataIndex) {
    this.dataIndex = dataIndex;
  }

  public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  public String geteProduct() {
    return eProduct;
  }

  public void seteProduct(String eProduct) {
    this.eProduct = eProduct;
  }

  public String getaBaseName() {
    return aBaseName;
  }

  public void setaBaseName(String aBaseName) {
    this.aBaseName = aBaseName.replace(" ", "");
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Integer getLoanId() {
    return loanId;
  }

  public void setLoanId(Integer loanId) {
    this.loanId = loanId;
  }

  public String getOutRemark() {
    return outRemark;
  }

  public void setOutRemark(String outRemark) {
    this.outRemark = outRemark;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public String getLoanVoucher() {
    return loanVoucher;
  }

  public void setLoanVoucher(String loanVoucher) {
    this.loanVoucher = loanVoucher;
  }

  public String getOutReason() {
    return outReason;
  }

  public void setOutReason(String outReason) {
    this.outReason = outReason;
  }

  public Integer getcUserId() {
    return cUserId;
  }

  public void setcUserId(Integer cUserId) {
    this.cUserId = cUserId;
  }

  public String getInApplyTime() {
    return inApplyTime;
  }

  public void setInApplyTime(String inApplyTime) {
    this.inApplyTime = inApplyTime;
  }

  public String getOutApplyTime() {
    return outApplyTime;
  }

  public void setOutApplyTime(String outApplyTime) {
    this.outApplyTime = outApplyTime;
  }

  public Integer getNodeStatus() {
    return nodeStatus;
  }

  public void setNodeStatus(Integer nodeStatus) {
    this.nodeStatus = nodeStatus;
  }

  public Integer getFlowStatus() {
    return flowStatus;
  }

  public void setFlowStatus(Integer flowStatus) {
    this.flowStatus = flowStatus;
  }

  public List<MortgageHouse> getEvaluate() {
    return evaluate;
  }

  public void setEvaluate(List<MortgageHouse> evaluate) {
    this.evaluate = evaluate;
  }

  public BigDecimal getRealLoanMoney() {
    return realLoanMoney;
  }

  public void setRealLoanMoney(BigDecimal realLoanMoney) {
    this.realLoanMoney = realLoanMoney;
  }

  public Integer getChannelCode() {
    return channelCode;
  }

  public void setChannelCode(Integer channelCode) {
    this.channelCode = channelCode;
  }

  public String[] getDocArr() {
	return docArr;
  }

  public void setDocArr(String[] docArr) {
	this.docArr = docArr;
  }

  @Override
  public String toString() {
	return "SearchCondition [channelCode=" + channelCode + ", currentPage="
			+ currentPage + ", pageSize=" + pageSize + ", dataIndex="
			+ dataIndex + ", startTime=" + startTime + ", endTime=" + endTime
			+ ", eProduct=" + eProduct + ", aBaseName=" + aBaseName
			+ ", status=" + status + ", loanId=" + loanId + ", outRemark="
			+ outRemark + ", userId=" + userId + ", loanVoucher=" + loanVoucher
			+ ", outReason=" + outReason + ", serialNo=" + serialNo
			+ ", cUserId=" + cUserId + ", inApplyTime=" + inApplyTime
			+ ", outApplyTime=" + outApplyTime + ", nodeStatus=" + nodeStatus
			+ ", flowStatus=" + flowStatus + ", evaluate=" + evaluate
			+ ", realLoanMoney=" + realLoanMoney + ", docArr="
			+ Arrays.toString(docArr) + "]";
  }

  
}
