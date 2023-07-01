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
public class BlogDto implements Serializable {
    public static final Long serialVersionUID=1L;

    private Long blogId;
    private String header;
    private String content;
    private Date createdDate;

    // Parametresiz constructor
    public BlogDto() {
        createdDate=new Date(System.currentTimeMillis());
    }
}
