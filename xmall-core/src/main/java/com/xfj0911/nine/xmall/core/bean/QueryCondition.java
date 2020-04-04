package com.xfj0911.nine.xmall.core.bean;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

/**
 * 查询条件封装器
 */
@Data
public class QueryCondition<T> {

    @ApiModelProperty(name= "page", value = "页码", required = false)
    private Long page;

    @ApiModelProperty(name= "limit", value = "每页大小", required = false)
    private Long limit;

    @ApiModelProperty(name= "sortFiled", value = "排序字段", required = false)
    private String sortFiled;

    @ApiModelProperty(name= "sortOrder", value = "排序顺序", required = false)
    private String sortOrder;

    @ApiModelProperty(name= "asc", value = "默认排序", required = false)
    @Value("")
    private String asc = "asc";
}
