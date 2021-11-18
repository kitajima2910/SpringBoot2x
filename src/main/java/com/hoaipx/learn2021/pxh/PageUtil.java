package com.hoaipx.learn2021.pxh;

import com.hoaipx.learn2021.common.exception.PXHException;
import com.hoaipx.learn2021.common.utils.PageHelper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import cn.hutool.core.util.StrUtil;
import org.springframework.data.domain.Sort;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.ArrayList;
import java.util.List;

public class PageUtil {

    private final static String[] KEYWORDS = {"master", "truncate", "insert", "select",
            "delete", "update", "declare", "alter", "drop", "sleep"};

    private PageUtil() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * JPA pagination package
     * @param pageHelper pageHelper
     * @return Pageable
     */
    public static Pageable initPage(PageHelper pageHelper) {

        Pageable pageable = null;
        int pageNumber = pageHelper.getPageNumber();
        int pageSize = pageHelper.getPageSize();
        String sort = pageHelper.getSortField();
        String order = pageHelper.getSortBy();

        if (pageNumber < 1) {
            pageNumber = 1;
        }
        if (pageSize < 1) {
            pageSize = 10;
        }
        if (pageSize > 100) {
            pageSize = 100;
        }
        if (StrUtil.isNotBlank(sort)) {
            Sort.Direction direction;
            if (StrUtil.isBlank(order)) {
                direction = Sort.Direction.DESC;
            } else {
                direction = Sort.Direction.valueOf(order.toUpperCase());
            }
            Sort s = Sort.by(direction, sort);
            pageable = PageRequest.of(pageNumber - 1, pageSize, s);
        } else {
            pageable = PageRequest.of(pageNumber - 1, pageSize);
        }
        return pageable;
    }

    /**
     * Mybatis-Plus page package
     * @param pageHelper pageHelper
     * @return Page
     */
    public static Page initMapperPage(PageHelper pageHelper) {

        Page page = null;
        int pageNumber = pageHelper.getPageNumber();
        int pageSize = pageHelper.getPageSize();
        String sort = pageHelper.getSortField();
        String order = pageHelper.getSortBy();

        SQLInject(sort);

        if (pageNumber < 1) {
            pageNumber = 1;
        }
        if (pageSize < 1) {
            pageSize = 10;
        }
        if (pageSize > 100) {
            pageSize = 100;
        }
        if (StrUtil.isNotBlank(sort)) {
            Boolean isAsc = false;
            if (StrUtil.isBlank(order)) {
                isAsc = false;
            } else {
                if ("desc".equals(order.toLowerCase())) {
                    isAsc = false;
                } else if ("asc".equals(order.toLowerCase())) {
                    isAsc = true;
                }
            }
            page = new Page(pageNumber, pageSize) {
            };
            if (isAsc) {
                page.addOrder(OrderItem.asc(camel2Underline(sort)));
            } else {
                page.addOrder(OrderItem.desc(camel2Underline(sort)));
            }

        } else {
            page = new Page(pageNumber, pageSize);
        }
        return page;
    }

    /**
     * List manual paging
     * @param pageHelper pageHelper
     * @param list list
     * @return
     */
    public static List listToPage(PageHelper pageHelper, List list) {

        int pageNumber = pageHelper.getPageNumber() - 1;
        int pageSize = pageHelper.getPageSize();

        if (pageNumber < 0) {
            pageNumber = 0;
        }
        if (pageSize < 1) {
            pageSize = 10;
        }
        if (pageSize > 100) {
            pageSize = 100;
        }

        int fromIndex = pageNumber * pageSize;
        int toIndex = pageNumber * pageSize + pageSize;

        if (fromIndex > list.size()) {
            return new ArrayList();
        } else if (toIndex >= list.size()) {
            return list.subList(fromIndex, list.size());
        } else {
            return list.subList(fromIndex, toIndex);
        }
    }

    /**
     * Hump method to underline
     */
    public static String camel2Underline(String str) {

        if (StrUtil.isBlank(str)) {
            return "";
        }
        if (str.length() == 1) {
            return str.toLowerCase();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                sb.append("_" + Character.toLowerCase(str.charAt(i)));
            } else {
                sb.append(str.charAt(i));
            }
        }
        return (str.charAt(0) + sb.toString()).toLowerCase();
    }

    /**
     * Prevent Mybatis-Plus order by injection
     * @param param
     */
    public static void SQLInject(String param) {

        if (StrUtil.isBlank(param)) {
            return;
        }

        // Convert to lowercase
        param = param.toLowerCase();
        // Determine whether it contains illegal characters
        for (String keyword : KEYWORDS) {
            if (param.contains(keyword)) {
                throw new PXHException(param + " contains illegal characters");
            }
        }
    }

}
