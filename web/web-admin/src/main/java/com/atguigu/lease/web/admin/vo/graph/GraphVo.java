package com.atguigu.lease.web.admin.vo.graph;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Image Information Value Object
 */
@Data
@Schema(description = "Image Information")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GraphVo {

    @Schema(description = "Image name")
    private String name;

    @Schema(description = "Image URL")
    private String url;
}
