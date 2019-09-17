package com.central.common.model.customer;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.central.common.model.SuperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Set;

/**
 * @author zlt
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("cus_menu")
public class CusMenu extends SuperEntity {

	private static final long serialVersionUID = -8653087166717542174L;
	private Long parentId;
	private String title;
	private String key;
	private Integer type;
	private String client;
	private Boolean hidden;
}
