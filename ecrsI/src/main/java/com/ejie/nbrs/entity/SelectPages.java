package com.ejie.nbrs.entity;

/**
 * 查询条件封装实体
 * @author zlg
 *
 * @param <T>
 */
public class SelectPages<T> {
	
    /**
     *查询类的集合
     */
    private T t;
    /**
     * 查询页数
     */
    private int currentPage;
    /**
     * 每页显示条数
     */
    private int pageSize;
    /**
     * 起始时间
     */
    private String startTime;
    /**
     * 结束时间
     */
    private String endTime;
    
    /*以下是get、set方法*/




	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}



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

	@Override
	public String toString() {
		return "SelectPages [t=" + t + ", currentPage=" + currentPage
				+ ", pageSize=" + pageSize + ", startTime=" + startTime
				+ ", endTime=" + endTime + "]";
	}



    

    
    
    
}
