package com.zlt.lawyer.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.central.common.model.SuperEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.util.Date;

/**
 *
 *
 * @author cyq
 * @date 2019-07-18 18:01:50
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@TableName("cus_org_lawyer")
public class OfficeLawyer {
    private static final long serialVersionUID=1L;
        private Integer orgId;
        private Integer cusId;
    }
