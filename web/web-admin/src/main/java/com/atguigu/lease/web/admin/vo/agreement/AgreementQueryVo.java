package com.atguigu.lease.web.admin.vo.agreement;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Rental Agreement Query Entity
 */
@Data
@Schema(description = "Rental Agreement Query Entity")
public class AgreementQueryVo {

    @Schema(description = "Province ID where the apartment is located")
    private Long provinceId;

    @Schema(description = "City ID where the apartment is located")
    private Long cityId;

    @Schema(description = "District ID where the apartment is located")
    private Long districtId;

    @Schema(description = "Apartment ID")
    private Long apartmentId;

    @Schema(description = "Room number")
    private String roomNumber;

    @Schema(description = "User's name")
    private String name;

    @Schema(description = "User's phone number")
    private String phone;

}
