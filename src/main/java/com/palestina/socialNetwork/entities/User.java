package com.palestina.socialNetwork.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "USER")
public class User {
  /**
   * The integer representation of the unique identifier for this User.
   */
  @Id
  @GeneratedValue
  @Column(name = "USER")
  private Integer id;

  /**
   * The name of the user, as they’ve defined it. Not necessarily a person’s name.
   * Typically capped at 50 characters, but subject to change.
   * Example:
   * "name": "socialNetwork API"
   */
  @Column(name = "NAME")
  private String name;

  /**
   * The screen name, handle, or alias that this user identifies themselves with.
   * 
   * "screen_name": "posterapi"
   */
  @Column(name = "SCREEN_NAME")
  private String screen_name;

  /**
   * Nullable . The user-defined location for this account’s profile. Not
   * necessarily a location, nor machine-parseable. This field will occasionally
   * be fuzzily interpreted by the Search service.
   * Example:
   * "location": "San Francisco, CA"
   */
  @Column(name = "LOCATION")
  private String location;

  /**
   * Nullable . A URL provided by the user in association with their profile.
   * Example:
   * "url": "https://developer.socialNetwork.com"
   */
  @Column(name = "URL")
  private String url;

  /**
   * Nullable . The user-defined UTF-8 string describing their account.
   * Example:
   * "description": "The Real socialNetwork API."
   */
  @Column(name = "DESCRIPTION")
  private String description;

  /**
   * When true, indicates that this user has chosen to protect their Posts.
   * Example:
   * "protected": true
   */
  @Column(name = "PROTECTED_PROFILE")
  private Boolean protectedProfile;
  /**
   * When true, indicates that the user has a verified account.
   * Example:
   * "verified": false
   */
  @Column(name = "verified")
  private Boolean verified;

  /**
   * The number of followers this account currently has.
   * Example:
   * "followers_count": 21
   * 
   */
  @Column(name = "FOLLOWERS_COUNT")
  private int followers_count;
  /**
   * The number of users this account is following (AKA their “followings”).
   * Example:
   * "friends_count": 32
   */
  @Column(name = "FRIENDS_COUNT")
  private int friends_count;
  /**
   * The number of public lists that this user is a member of.
   * Example:
   * "listed_count": 9274
   */
  @Column(name = "LISTED_COUNT")
  private int listed_count;
  /**
   * The number of Posts this user has liked in the account’s lifetime.
   * Example:
   * "favourites_count": 13
   */
  @Column(name = "FAVOURITES_COUNT")
  private int favourites_count;
  /**
   * The number of Posts (including rePosts) issued by the user.
   * Example:
   * "statuses_count": 42
   */
  @Column(name = "STATUSES_COUNT")
  private int statuses_count;
  /**
   * The UTC datetime that the user account was created on this socialNetwork.
   * Example:
   * "created_at": "Mon Nov 29 21:18:15 +0000 2010"
   */
  //TODO Fix auto set
  @Column(name = "CREATED_AT")
  @CreatedDate
  private String created_at;

  @OneToMany(mappedBy = "user")
  private List<Feed> feeds;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getScreen_name() {
    return screen_name;
  }

  public void setScreen_name(String screen_name) {
    this.screen_name = screen_name;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Boolean getProtectedProfile() {
    return protectedProfile;
  }

  public void setProtectedProfile(Boolean protectedProfile) {
    this.protectedProfile = protectedProfile;
  }

  public Boolean getVerified() {
    return verified;
  }

  public void setVerified(Boolean verified) {
    this.verified = verified;
  }

  public int getFollowers_count() {
    return followers_count;
  }

  public void setFollowers_count(int followers_count) {
    this.followers_count = followers_count;
  }

  public int getFriends_count() {
    return friends_count;
  }

  public void setFriends_count(int friends_count) {
    this.friends_count = friends_count;
  }

  public int getListed_count() {
    return listed_count;
  }

  public void setListed_count(int listed_count) {
    this.listed_count = listed_count;
  }

  public int getFavourites_count() {
    return favourites_count;
  }

  public void setFavourites_count(int favourites_count) {
    this.favourites_count = favourites_count;
  }

  public int getStatuses_count() {
    return statuses_count;
  }

  public void setStatuses_count(int statuses_count) {
    this.statuses_count = statuses_count;
  }

  public String getCreated_at() {
    return created_at;
  }

  public void setCreated_at(String created_at) {
    this.created_at = created_at;
  }

}
