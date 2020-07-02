package com.example.booking.service;

import com.example.booking.dto.FeedbackDto;

import java.util.List;

public interface FeedbackService {
    FeedbackDto getFeedbackById(int id);

    List<FeedbackDto> getAll();

    FeedbackDto createFeedback(FeedbackDto feedbackDto);

    FeedbackDto updateFeedback(FeedbackDto feedbackDto);

    void deleteFeedback(int id);
}
