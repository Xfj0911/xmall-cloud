package com.xfj0911.nine.xmall.core.bean;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xfj0911.nine.xmall.core.utils.SQLFilter;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;

/**
 * 查询参数
 */
public class Query<T> {


    public IPage<T> getPage(QueryCondition quryCondition){
        return this.getPage(quryCondition);
    }

    public IPage<T> getPage(QueryCondition quryCondition, String defaultOrderField, boolean isAsc){
        //分页参数
        long curPage = 1;
        long limit = 10;
        if(quryCondition.getPage() != null){
            curPage = quryCondition.getPage();
        }
        if(quryCondition.getLimit() != null){
            limit = quryCondition.getLimit();
        }

        //分页对象
        Page<T> page = new Page<T>(curPage, limit);

        //分页参数
        //quryCondition.put(Constant.PAGE, page);

        //排序字段
        //防止SQL注入（因为sidx、order是通过拼接SQL实现排序的，会有SQL注入风险）
        String orderField = SQLFilter.sqlInject(quryCondition.getSortFiled());
        String order = quryCondition.getSortOrder();

        //前端字段排序
        if(StringUtils.isNotEmpty(orderField) && StringUtils.isNotEmpty(order)){
            if("asc".equalsIgnoreCase(order)) {
                return page.setAsc(orderField);
            }else {
                return page.setDesc(orderField);
            }
        }

        //默认排序
        if(isAsc) {
            page.setAsc(defaultOrderField);
        }else {
            page.setDesc(defaultOrderField);
        }

        return page;
    }
}
