package com.example.booking.controller;

import com.example.booking.dto.FeedbackDto;
import com.example.booking.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {
    private final FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping
    public FeedbackDto createFeedback(@RequestBody FeedbackDto feedbackDto) {
        return feedbackService.createFeedback(feedbackDto);
    }

    @PutMapping
    public FeedbackDto updateFeedback(@RequestBody FeedbackDto feedbackDto) {
        return feedbackService.updateFeedback(feedbackDto);
    }

    @DeleteMapping
    public void deleteFeedback(@PathParam("id") Integer id) {
        feedbackService.deleteFeedback(id);
    }
}
