package com.ista.parkingapi.service;

import com.ista.parkingapi.dto.ParkingDataResponse;
import com.ista.parkingapi.dto.ParkingRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParkingDataService {


    @Value("${parking.data.url}")
    private String url;

    @Autowired
    private RestTemplate restTemplate;

    public List<ParkingRecords> getParkings() {
        // Retrieve parking data
        ResponseEntity<ParkingDataResponse> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<ParkingDataResponse>() {
                }
        );

        // Access the list of entities from the response body
        final ParkingDataResponse parkingDataResponse = response.getBody();


        return parkingDataResponse != null ? parkingDataResponse.getRecords() : new ArrayList<>();
    }
}
