package com.central.common.model.lawyer;

import com.baomidou.mybatisplus.annotation.TableName;
import com.central.common.model.SuperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author zlt
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("law_menu")
public class LawMenu extends SuperEntity {

    private Long parentId;
    private String title;
    private String key;
    private Integer type;
    private String client;
    private Boolean hidden;
}
