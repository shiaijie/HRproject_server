package pojo;

import com.baomidou.mybatisplus.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

@Data
public class PageAo extends Model<PageAo> {
    // 当前页码（从1开始）
    private String current;
    // 每页数据行数
    private String pageSize;
    // 排序字段名
    private String sortName;
    // 排序值
    private String sortValue;

    @Override
    protected Serializable pkVal() {
        return null;
    }

    public String getSortValue() {
        return this.sortValue;
    }
    public void setSortValue(String sortValue) {
        this.sortValue = sortValue;
    }

    public String getSortName() {
        return sortName;
    }
    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getPageSize() {
        return pageSize;
    }
    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getCurrent() {
        return current;
    }
    public void setCurrent(String current) {
        this.current = current;
    }
}
