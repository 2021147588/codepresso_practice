package com.msa.post.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record PostDto(

        @Schema(description = "게시물 제목", defaultValue = "디폴트 제목")
        String title,

        @Schema(description = "내용")
        String content
) {

}
