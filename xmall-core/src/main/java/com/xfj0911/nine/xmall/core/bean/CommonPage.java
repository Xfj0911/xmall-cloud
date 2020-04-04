package com.xfj0911.nine.xmall.core.bean;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.util.List;

/**
 * 分页数据封装类
 */
@Data
public class CommonPage<T> {
    private Integer pageNum;
    private Integer PageSize;
    private Integer totalPage;
    private Long total;
    private List<T> list;


}
