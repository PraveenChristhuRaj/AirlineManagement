package com.example.SampleSpringBootMvc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.SampleSpringBootMvc.entity.BookingRecord;

@Repository
public interface BookingRecordRepository extends JpaRepository<BookingRecord,Integer> {

	@Query(value="select * from booking_record where user_id=?1 and booking_id in (select booking_id from booking_details)",nativeQuery=true)
	List<BookingRecord> findByUsingUserId(Integer userId);
}
