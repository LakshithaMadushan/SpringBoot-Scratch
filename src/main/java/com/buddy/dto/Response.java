package com.buddy.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response<E>
{
    private int no;

    @JsonProperty("returnData")
    private E returnData;

    public int getNo()
    {
        return this.no;
    }

    public void setNo( int no )
    {
        this.no = no;
    }

    public E getReturnData()
    {
        return this.returnData;
    }

    public void setReturnData( E returnData )
    {
        this.returnData = returnData;
    }
}
