package com.sweethome.BookingService.service;

import com.sweethome.BookingService.entities.BookingInfoEntity;
import com.sweethome.BookingService.DTO.BookingDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public interface BookingService {
    public BookingInfoEntity saveBookingDetails(BookingDTO bookingInfo);

    public BookingInfoEntity getBookingDetailsById(int id);

    public List<BookingInfoEntity> getAllBookings();

    public int calculatePrice(int noOfRooms, int noOfDays);

    public ArrayList<String> getRoomNumbers(int noOfRooms);
}
