package com.palestina.socialNetwork.service;

import com.palestina.socialNetwork.entities.Feed;
import com.palestina.socialNetwork.repositories.FeedRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FeedService {

    private final FeedRepository feedRepository;

    public FeedService(final FeedRepository feedRepository) {
        this.feedRepository = feedRepository;
    }

    public <S extends Feed> S save(S entity) {
        return this.feedRepository.save(entity);
    }

    public <S extends Feed> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    public Optional<Feed> findById(Integer integer) {
        return feedRepository.findById(integer);
    }

    public boolean existsById(Integer integer) {
        return false;
    }

    public Iterable<Feed> findAll() {
        return feedRepository.findAll();
    }

    public Iterable<Feed> findAllById(Iterable<Integer> integers) {
        return null;
    }

    public long count() {
        return 0;
    }

    public void deleteById(Integer integer) {

    }

    public void delete(Feed entity) {
        feedRepository.delete(entity);
    }

    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    public void deleteAll(Iterable<? extends Feed> entities) {

    }

    public void deleteAll() {

    }
}
