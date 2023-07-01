package com.hamitmizrak.business.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;
import java.util.Date;

// LOMBOK
@Data
@AllArgsConstructor
@Log4j2
@Builder
public class RolesDto  implements Serializable {
    public static final Long serialVersionUID=1L;

    private Long rolesId;
    private String rolesName;
    private Date createdDate;
}
