package com.palestina.socialNetwork.controllers;

import java.util.Optional;

import com.palestina.socialNetwork.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.palestina.socialNetwork.entities.Feed;

@RestController
public class FeedController {

  @Autowired
  private FeedService feedService;

  @GetMapping("/feeds")
  public Iterable<Feed> getAllFeeds() {
    return feedService.findAll();
  }

  @GetMapping("/feeds/{id}")
  public Optional<Feed> getFeedById(@PathVariable("id") Integer id) {
    return feedService.findById(id);
  }

  @PostMapping("/feeds")
  public Feed createNewFeed(@RequestBody Feed feed) {
    Feed newFeed = feedService.save(feed);
    return newFeed;
  }

  @PutMapping("/feeds/{id}")
  public Feed updateFeed(
      @PathVariable("id") Integer id,
      @RequestBody Feed p) {
    Optional<Feed> feedToUpdateOptional = feedService.findById(id);
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
    Feed updatedFeed = feedService.save(feedToUpdate);
    return updatedFeed;
  }

  @DeleteMapping("/feeds/{id}")
  public Feed deleteFeed(@PathVariable("id") Integer id) {
    Optional<Feed> feedToDeleteOptional = feedService.findById(id);
    if (!feedToDeleteOptional.isPresent()) {
      return null;
    }
    Feed feedToDelete = feedToDeleteOptional.get();
    feedService.delete(feedToDelete);
    return feedToDelete;
  }
}
