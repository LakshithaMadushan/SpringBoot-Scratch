package com.buddy.controller;

import com.buddy.channel.MemberDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("members")
public class MembersController
{
    @Autowired MemberDetailService memberDetailService;

    @GetMapping("/dog")
    public ResponseEntity<String> DogRoleAuthorization()
    {
        return ResponseEntity.ok().header( "Custom-Header", "foo" ).body( memberDetailService.getDogName() );
    }
}
