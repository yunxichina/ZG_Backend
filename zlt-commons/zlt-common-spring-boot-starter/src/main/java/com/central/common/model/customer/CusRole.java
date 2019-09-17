package com.central.common.model.customer;
import	java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("cus_role")
public class CusRole implements Serializable{
    private static final long serialVersionUID = -8099983472941057687L;
    private Long id;
    private String code;
    private String name;
    private Long userId;

}
