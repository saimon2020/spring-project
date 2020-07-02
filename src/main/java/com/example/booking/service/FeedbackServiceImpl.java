package com.example.booking.service;

import com.example.booking.dto.FeedbackDto;
import com.example.booking.entity.Feedback;
import com.example.booking.exception.ClientException;
import com.example.booking.exception.FeedbackException;
import com.example.booking.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class FeedbackServiceImpl implements FeedbackService {
    private final FeedbackRepository feedbackRepository;
    private final ConversionService conversionService;

    @Autowired
    public FeedbackServiceImpl(FeedbackRepository feedbackRepository, ConversionService conversionService) {
        this.feedbackRepository = feedbackRepository;
        this.conversionService = conversionService;
    }

    @Override
    public FeedbackDto getFeedbackById(int id) {
        Feedback feedback = feedbackRepository.findById(id).orElseThrow(() -> new FeedbackException("Feedback is not found"));
        return conversionService.convert(feedback, FeedbackDto.class);
    }

    @Override
    public List<FeedbackDto> getAll() {
        List<Feedback> feedbacks = feedbackRepository.findAll();
        return feedbacks.stream().map(feedback -> conversionService.convert(feedback, FeedbackDto.class)).collect(Collectors.toList());
    }

    @Override
    public FeedbackDto createFeedback(FeedbackDto feedbackDto) {
        Feedback feedback = conversionService.convert(feedbackDto, Feedback.class);
        return conversionService.convert(feedbackRepository.save(feedback), FeedbackDto.class);
    }

    @Override
    public FeedbackDto updateFeedback(FeedbackDto feedbackDto) {
        Feedback feedback = feedbackRepository.findById(feedbackDto.getId()).orElseThrow(() -> new FeedbackException("Feedback is not found"));
        return conversionService.convert(feedbackRepository.save(feedback), FeedbackDto.class);
    }

    @Override
    public void deleteFeedback(int id) {
        Feedback feedback = feedbackRepository.findById(id).orElseThrow(() -> new ClientException("Feedback is not found"));
        feedbackRepository.delete(feedback);
    }
}
