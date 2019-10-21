package com.buddy.controller;

import com.buddy.channel.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController
{
    @Autowired
    private AddressService addressService;

    private static final Logger LOGGER = LoggerFactory.getLogger( AddressController.class );

    @GetMapping("/myAddress/{number}")
    public String getMyAddress( @PathVariable() int number )
    {
        StopWatch stopWatch = new StopWatch( Integer.toString( number ) );
        stopWatch.start();
        String address = addressService.getAddress( number );
        stopWatch.stop();

        LOGGER.info( "Execution time : {}", stopWatch.getTotalTimeSeconds() );

        return address;
    }

    @GetMapping("/myAddress/removeAll")
    public String removeAllAddersses()
    {
        addressService.removeAllAddresses();
        return "Cache clear !!!";
    }
}
