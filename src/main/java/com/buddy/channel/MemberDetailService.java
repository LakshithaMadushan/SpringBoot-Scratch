package com.buddy.channel;

import com.buddy.service.IMemberDetailService;
import org.springframework.stereotype.Service;

@Service
public class MemberDetailService implements IMemberDetailService
{
    @Override public String getDogName()
    {
        return "Dog Role \uD83E\uDD23";
    }
}
