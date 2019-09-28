package com.sky.manon.community.controller;

import com.sky.manon.community.dto.AccessTokenDto;
import com.sky.manon.community.provider.GitHubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizationController {
    @Autowired
    private GitHubProvider provider;

    @GetMapping("/callback")
    public String callback(@RequestParam(value = "code") String code, @RequestParam(value = "state") String state) {
        AccessTokenDto accessTokenDto = new AccessTokenDto();
        accessTokenDto.setCode(code);
        accessTokenDto.setState(state);
        accessTokenDto.setClient_id("82cdb1fbafdcf5927d41");
        accessTokenDto.setClient_secret("d6fff13e7810577a7edc3620920b7fa1d38b2a8e");
        accessTokenDto.setRedirect_uri("http://localhost:8887/callback");
        String accessToken = provider.getAccessToken(accessTokenDto);
        provider.getUser(accessToken);
        return "index";
    }
}
