package com.palestina.socialNetwork.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.palestina.socialNetwork.entities.Feed;
import com.palestina.socialNetwork.repositories.FeedRepository;

@RestController
public class FeedController {
  private final FeedRepository feedPRepository;

  public FeedController(final FeedRepository feedPRepository) {
    this.feedPRepository = feedPRepository;
  }

  @GetMapping("/feeds")
  public Iterable<Feed> getAllFeeds() {
    return this.feedPRepository.findAll();
  }

  @GetMapping("/feeds/{id}")
  public Optional<Feed> getFeedById(@PathVariable("id") Integer id) {
    return this.feedPRepository.findById(id);
  }

  @PostMapping("/feeds")
  public Feed createNewFeed(@RequestBody Feed feed) {
    Feed newFeed = this.feedPRepository.save(feed);
    return newFeed;
  }

  @PutMapping("/feeds/{id}")
  public Feed updateFeed(
      @PathVariable("id") Integer id,
      @RequestBody Feed p) {
    Optional<Feed> feedToUpdateOptional = this.feedPRepository.findById(id);
    if (!feedToUpdateOptional.isPresent()) {
      return null;
    }
    Feed feedToUpdate = feedToUpdateOptional.get();
    if (p.getText() != null) {
      feedToUpdate.setText(p.getText());
    }
    if (p.getSource() != null) {
      feedToUpdate.setSource(p.getSource());
    }
    Feed updatedFeed = this.feedPRepository.save(feedToUpdate);
    return updatedFeed;
  }

  @DeleteMapping("/feeds/{id}")
  public Feed deleteFeed(@PathVariable("id") Integer id) {
    Optional<Feed> feedToDeleteOptional = this.feedPRepository.findById(id);
    if (!feedToDeleteOptional.isPresent()) {
      return null;
    }
    Feed feedToDelete = feedToDeleteOptional.get();
    this.feedPRepository.delete(feedToDelete);
    return feedToDelete;
  }
}
