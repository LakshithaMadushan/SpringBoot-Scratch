package com.buddy.dto;

public class MyResponse<T>
{
    private int page;
    private int perPage;
    private int total;
    private int totalPages;
    private T data;

    public MyResponse()
    {
    }

    public MyResponse( int page, int perPage, int total, int totalPages, T data )
    {
        this.page = page;
        this.perPage = perPage;
        this.total = total;
        this.totalPages = totalPages;
        this.data = data;
    }

    public int getPage()
    {
        return this.page;
    }

    public void setPage( int page )
    {
        this.page = page;
    }

    public int getPerPage()
    {
        return this.perPage;
    }

    public void setPerPage( int perPage )
    {
        this.perPage = perPage;
    }

    public int getTotal()
    {
        return this.total;
    }

    public void setTotal( int total )
    {
        this.total = total;
    }

    public int getTotalPages()
    {
        return this.totalPages;
    }

    public void setTotalPages( int totalPages )
    {
        this.totalPages = totalPages;
    }

    public T getData()
    {
        return this.data;
    }

    public void setData( T data )
    {
        this.data = data;
    }
}
