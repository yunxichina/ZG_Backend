package com.central.common.model.lawyer;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("law_role")
public class LawRole {
    private static final long serialVersionUID = -8099983472941057687L;
    private Long id;
    private String code;
    private String name;
    private Long userId;
}
