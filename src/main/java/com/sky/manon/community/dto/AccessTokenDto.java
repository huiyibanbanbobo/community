package com.sky.manon.community.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccessTokenDto {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
