package com.ejie.nbrs.util;

import java.util.List;

/**
 * 
 * @author zlg
 * 分页封装
 *
 * @param <T>
 */
public class ZPageUtil<T> {
    /**
     *分页查询到的数据集合
     */
    private List<T> list;
    /**
     * 查询页码
     */
    private int currentPage;
    /**
     * 总页数
     */
    private int totalPage;
    /**
     * 每页显示条数
     */
    private int  pageSize;
    /**
     * 总条数
     */
    private int count;
    
    public ZPageUtil(List<T> list, int currentPage, int pageSize,int count) {

        this.list = list;
        this.currentPage = currentPage;
        this.totalPage = count%pageSize==0?count/pageSize:(count/pageSize)+1;
        this.pageSize = pageSize;
    }


    public int getCount() {
        return count;
    }



    public void setCount(int count) {
        this.count = count;
    }



    public int getTotalPage() {
        return totalPage;
    }
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    public List<T> getList() {
        return list;
    }
    public void setList(List<T> list) {
        this.list = list;
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
    public ZPageUtil() {

    }


	@Override
	public String toString() {
		return "ZPageUtil [list=" + list + ", currentPage=" + currentPage
				+ ", totalPage=" + totalPage + ", pageSize=" + pageSize
				+ ", count=" + count + "]";
	}

    
}
