package com.example.booking.converter;

import com.example.booking.dto.FeedbackDto;
import com.example.booking.entity.Feedback;
import org.springframework.core.convert.converter.Converter;

public class FeedbackToFeedbackDtoConverter implements Converter<Feedback, FeedbackDto> {
    @Override
    public FeedbackDto convert(Feedback feedback) {
        FeedbackDto target = new FeedbackDto();
        target.setBookingId(feedback.getBooking().getBookingId());
        target.setComment(feedback.getComment());
        target.setId(feedback.getFeedbackId());
        target.setRate(feedback.getRate());
        return target;
    }
}
