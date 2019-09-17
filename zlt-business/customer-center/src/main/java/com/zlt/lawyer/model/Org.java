package com.zlt.lawyer.model;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.central.common.model.SuperEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 *
 *
 * @author cyq
 * @date 2019-07-18 12:03:08
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@TableName("cus_org")
public class Org extends SuperEntity {
    private static final long serialVersionUID=1L;

        private String orgName;
        private Integer pId;
        private Date createTime;
        private Date updateTime;
        private Integer sort;
        private Integer level;
        @TableLogic
        private Boolean isDel;
    }
