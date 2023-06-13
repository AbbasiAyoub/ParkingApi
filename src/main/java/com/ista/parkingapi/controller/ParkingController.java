package com.ista.parkingapi.controller;

import com.ista.parkingapi.dto.ParkingRecords;
import com.ista.parkingapi.dto.RealTimeParkingRecord;
import com.ista.parkingapi.service.ParkingDataService;
import com.ista.parkingapi.service.ParkingRealTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
public class ParkingController {

    ParkingDataService parkingDataService;
    ParkingRealTimeService parkingRealTimeService;

    @Autowired
    public ParkingController(ParkingDataService parkingDataService, ParkingRealTimeService parkingRealTimeService){
        this.parkingDataService = parkingDataService ;
        this.parkingRealTimeService = parkingRealTimeService ;
    }

    @GetMapping("/parking")
    public ResponseEntity<List<ParkingRecords>> getParking() {

        // get List of parking
        final List<ParkingRecords> parkingRecords = parkingDataService.getParkings();

        // Retrieve real-time data for available spaces
        final List<RealTimeParkingRecord> realTimeDataList = parkingRealTimeService.getRealTimeDataList();

        // Adding available places count to parking from the realTime data API
        for (ParkingRecords parking : parkingRecords) {
            for (RealTimeParkingRecord realTimeData : realTimeDataList) {
                if (parking.getParking().getName().equals(realTimeData.getRealTimeData().getNom())) {
                    parking.getParking().setAvailableSpaces(realTimeData.getRealTimeData().getAvailableSpaces());
                    break;
                }
                else {
                    // setting -1 value for parking, that doesn't have realTime available spots count
                    parking.getParking().setAvailableSpaces(-1);
                }
            }
        }


        return ResponseEntity.ok(parkingRecords);
    }
}
