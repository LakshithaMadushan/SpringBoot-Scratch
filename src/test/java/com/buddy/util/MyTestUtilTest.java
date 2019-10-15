package com.buddy.util;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class MyTestUtilTest
{

    @Test
    public void getMyFullName()
    {
        // MyTestUtil myTestUtil = Mockito.mock( MyTestUtil.class ); --> myTestUtil.getMyFullName() is getting null
        MyTestUtil myTestUtil = Mockito.spy( MyTestUtil.class );

        Mockito.doReturn( "buddy" ).when( myTestUtil ).getMyFirstName();
        Mockito.doReturn( "bu buuu" ).when( myTestUtil ).getMyLastName();

        assertEquals( myTestUtil.getMyFullName(), "buddy bu buuu" );
    }

    @Test
    public void whenNotUseMockAnnotation_thenCorrect()
    {
        List mockList = Mockito.mock( ArrayList.class );

        mockList.add( "one" );
        Mockito.verify( mockList ).add( "one" );
        assertEquals( 0, mockList.size() );

        Mockito.when( mockList.size() ).thenReturn( 100 );
        assertEquals( 100, mockList.size() );
    }
}