package com.sweethome.BookingService.service;

import com.sweethome.BookingService.entities.BookingInfoEntity;
import com.sweethome.BookingService.DTO.BookingDTO;
import com.sweethome.BookingService.DAO.BookingDAO;
import com.sweethome.BookingService.exception.InvalidBooking;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    BookingDAO bookingDAO;



    @Override
    public BookingInfoEntity saveBookingDetails(BookingDTO bookingInfo) {

        // gets the room numbers list
        // calculate total price
        // then we convert the dto to entity
        // save the entity to db

        ArrayList<String> bookedRooms = getRoomNumbers(bookingInfo.getNumOfRooms());
        String roomNumbers = String.join(", ", bookedRooms);
        bookingInfo.setRoomNumbers(roomNumbers);

        long noOfDays = ChronoUnit.DAYS.between(bookingInfo.getFromDate(), bookingInfo.getToDate());
        int roomPrice = calculatePrice(bookingInfo.getNumOfRooms(), (int) noOfDays);
        bookingInfo.setRoomPrice(roomPrice);


        System.out.println(bookingInfo.toString());

        BookingInfoEntity bookingInfoEntityDetails = modelMapper.map(bookingInfo, BookingInfoEntity.class);

        System.out.println(bookingInfoEntityDetails.toString());

       return bookingDAO.save(bookingInfoEntityDetails);






    }


    @Override
    public BookingInfoEntity getBookingDetailsById(int id) {

        if (bookingDAO.findById(id).isPresent()){

            return bookingDAO.findById(id).get();
        }

        throw new InvalidBooking( "Invalid Payment Id", 400 );


    }

    @Override
    public List<BookingInfoEntity> getAllBookings() {
        return null;
    }

    @Override
    public int calculatePrice(int noOfRooms, int noOfDays) {
        return 1000 * noOfRooms * noOfDays;
    }

    @Override
    public ArrayList<String> getRoomNumbers(int noOfRooms) {
        Random random = new Random();
        int upperBound = 100;

        ArrayList<String> roomsList = new ArrayList<String>();

        for (int i= 0; i<noOfRooms; i++){
            roomsList.add(String.valueOf((random.nextInt(upperBound))));
        }



        return roomsList;
    }
}
