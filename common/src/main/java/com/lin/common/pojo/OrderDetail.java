package com.lin.common.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 
 * </p>
 *
 * @author linSheng
 * @since 2023-08-28
 */
@Getter
@Setter
@TableName("order_detail")
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "detail_id", type = IdType.AUTO)
    private Integer detailId;

    @TableField("order_id")
    private Integer orderId;

    @TableField("product_id")
    private Integer productId;

    @TableField("product_name")
    private String productName;

    @TableField("product_price")
    private BigDecimal productPrice;

    @TableField("product_quantity")
    private Integer productQuantity;


}
