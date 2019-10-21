package com.buddy.channel;

import com.buddy.service.IAddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class AddressService implements IAddressService
{
    private static final Logger LOGGER = LoggerFactory.getLogger( AddressService.class );

    @Cacheable("addresses")
    @Override public String getAddress( int number )
    {
        try
        {
            Thread.sleep( 5000 );
        }
        catch( InterruptedException e )
        {
            LOGGER.warn( e.toString() );
        }
        LOGGER.info( "Getting my address" );
        return "*" + number + "*" + "'Lakshan', Batawalakanda, Weligama.";
    }

    @CacheEvict(value = "addresses", allEntries = true)
    @Override public void removeAllAddresses()
    {
        LOGGER.info( "Clear cache" );
    }
}
