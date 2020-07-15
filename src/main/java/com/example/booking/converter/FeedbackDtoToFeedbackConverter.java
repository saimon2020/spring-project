package com.example.booking.converter;

import com.example.booking.dto.FeedbackDto;
import com.example.booking.entity.Feedback;
import com.example.booking.repository.BookingRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FeedbackDtoToFeedbackConverter implements Converter<FeedbackDto, Feedback> {

    private final BookingRepository bookingRepository;

    public FeedbackDtoToFeedbackConverter(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Feedback convert(FeedbackDto feedbackDto) {
        Feedback feedback = new Feedback();
        feedback.setBooking(bookingRepository.findByBookingId(feedbackDto.getBookingId()));
        feedback.setComment(feedbackDto.getComment());
        feedback.setFeedbackId(feedbackDto.getId());
        feedback.setRate(feedbackDto.getRate());
        return feedback;
    }
}
