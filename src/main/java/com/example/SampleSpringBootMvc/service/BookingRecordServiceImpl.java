package com.example.SampleSpringBootMvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SampleSpringBootMvc.dao.BookingRecordRepository;
import com.example.SampleSpringBootMvc.entity.BookingRecord;
@Service
public class BookingRecordServiceImpl implements BookingRecordService {
    @Autowired
	private BookingRecordRepository bookingRecordRepository;
	@Override
	public void save(BookingRecord bookingRecord) {
         bookingRecordRepository.save(bookingRecord);
	}
	@Override
	public BookingRecord getBookingRecord(Integer id) {
		Optional<BookingRecord> res = bookingRecordRepository.findById(id);
		BookingRecord bookingRecord = null;
		if(res.isPresent())
		{
			bookingRecord = res.get();
		}
		return bookingRecord;
	}
	@Override
	public List<BookingRecord> findByUserId(Integer userId) {
		return bookingRecordRepository.findByUsingUserId(userId);
	}

}
