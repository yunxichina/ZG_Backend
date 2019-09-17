package com.central.common.model.sysuser;

import com.baomidou.mybatisplus.annotation.TableName;
import com.central.common.model.SuperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author zlt
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_menu")
public class SysMenu extends SuperEntity {
	private static final long serialVersionUID = 749360940290141180L;

	private Long parentId;
	private String title;
	private String key;
	private Integer type;
	private String client;
	private Boolean hidden;


}
