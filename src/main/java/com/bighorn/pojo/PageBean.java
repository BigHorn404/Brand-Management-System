package com.bighorn.pojo;

import java.util.List;

/**
 * @author: lzh
 * @date: 2022/5/12 15:32
 * @description:
 */

/**
 * 分页查询的JavaBean
 * @param <T>
 */
public class PageBean<T> {
    // 当前页数据
    private List<T> rows;
    // 总记录数
    private int totalCount;

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public PageBean() {
    }

    public PageBean(List<T> rows, int totalCount) {
        this.rows = rows;
        this.totalCount = totalCount;
    }
}
