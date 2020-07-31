package com.example.SampleSpringBootMvc.service;

import java.util.List;

import com.example.SampleSpringBootMvc.entity.BookingRecord;

public interface BookingRecordService {

	public void save(BookingRecord bookingRecord);
	public BookingRecord getBookingRecord(Integer id);
	public List<BookingRecord> findByUserId(Integer userId);
}
