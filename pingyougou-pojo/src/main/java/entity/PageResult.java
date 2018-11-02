package entity;

import java.io.Serializable;
import java.util.List;

/**
 *    分页结果类 : 封装着分页信息
 *
 * */
public  class PageResult implements Serializable {

    private Long total;  //总记录数

    private List rows;  //当前页记录结果

    private int pageNum;//当前页数

    private int pageSize;  //每页显示的记录数

    public PageResult() {
    }

    public PageResult(Long total, List rows) {
        this.total = total;
        this.rows = rows;
    }

    public PageResult(Long total, List rows, int pageNum, int pageSize) {
        this.total = total;
        this.rows = rows;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
