package com.example.booking.converter;

import com.example.booking.dto.FeedbackDto;
import com.example.booking.entity.Feedback;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FeedbackDtoToFeedbackConverter implements Converter<FeedbackDto, Feedback> {
    @Override
    public Feedback convert(FeedbackDto feedbackDto) {
        Feedback feedback = new Feedback();
        feedback.setBooking(feedbackDto.getBooking());
        feedback.setComment(feedbackDto.getComment());
        feedback.setId(feedbackDto.getId());
        feedback.setRate(feedbackDto.getRate());
        return feedback;
    }
}
