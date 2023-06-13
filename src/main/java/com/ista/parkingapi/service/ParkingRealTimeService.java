package com.ista.parkingapi.service;

import com.ista.parkingapi.dto.RealTimeDataResponse;
import com.ista.parkingapi.dto.RealTimeParkingRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ParkingRealTimeService {

    @Value("${parking.realtime.url}")
    private String url;

    @Autowired
    private RestTemplate restTemplate;

    public List<RealTimeParkingRecord> getRealTimeDataList() {
        // Retrieve RealTime data
        ResponseEntity<RealTimeDataResponse> realTimeDataResponse = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<RealTimeDataResponse>() {
                }
        );
        // Retrieve real-time data for available spaces

        return realTimeDataResponse.getBody().getRecords();
    }


}
