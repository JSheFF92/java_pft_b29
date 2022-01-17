package ru.stqa.pft.soap;

import com.lavasoft.GeoIPService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GeoIpServiceTests {

    @Test
    public void testMyIp(){
        String geoIp = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("2a00:1370:8111:4ad2:dd5d:99bf:a6f9:1c1e");
        assertEquals(geoIp, "<GeoIP><Country>CN</Country><State>30</State></GeoIP>");
    }


    @Test
    public void testInvalidIp(){
        String geoIp = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("2a00:1370:8111:4ad2:dd5d:99bf:a6f9:ччч");
        assertEquals(geoIp, "<GeoIP><Country>CN</Country><State>30</State></GeoIP>");
    }
}