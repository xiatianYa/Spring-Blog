package com.hncpu.blog.dto;

import lombok.Data;

@Data
public class TbBlogCountDTO {
    private Integer blogCount;
    private Integer classifyCount;
    private Integer tagsCount;

    public TbBlogCountDTO(Integer blogCount, Integer classifyCount, Integer tagsCount) {
        this.blogCount = blogCount;
        this.classifyCount = classifyCount;
        this.tagsCount = tagsCount;
    }
}
