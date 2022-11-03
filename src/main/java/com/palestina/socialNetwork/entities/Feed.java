package com.palestina.socialNetwork.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name="FEED")
public class Feed {
  /*
   * The integer representation of the unique identifier for this Feed. 
   * 
   * Example:
   * "id":1050118621198921728
   */
  @Id
  @GeneratedValue
  @Column(name="FEED")
  private Integer id;
  /*
   * UTC time when this Feed was created. Example:
   * "created_at": "Wed Oct 10 20:19:24 +0000 2018"
   */
  @Column(name="CREATED_AT")
  private String created_at;
  /**
   * The actual UTF-8 text of the status update. Example:
   * 
   * "text":"To make room for more expression, we will now count all emojis as
   * equal—including those with gender‍‍‍ ‍‍and skin t… https://t.co/MkGjXf9aXm"
   */
  @Column(name="TEXT")
  private String text;
  /**
   * Utility used to post the Feed, as an HTML-formatted string.
   * 
   * Example:
   * 
   * "source":"Feed Web Client"
   */
  @Column(name="SOURCE")
  private String source;
  /** The user who posted this Feed. */
  @ManyToOne
  @JoinColumn(name = "USER")
  private User user;

  // /**
  //  * Entities which have been parsed out of the text of the Feed. 
  //  */
  // @OneToOne
  // @JoinColumn(name = "entities_id")
  // private Entities entities;
  
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public String getCreated_at() {
    return created_at;
  }
  public void setCreated_at(String created_at) {
    this.created_at = created_at;
  }
  public String getText() {
    return text;
  }
  public void setText(String text) {
    this.text = text;
  }
  public String getSource() {
    return source;
  }
  public void setSource(String source) {
    this.source = source;
  }
  public User getUser() {
    return user;
  }
  public void setUser(User user) {
    this.user = user;
  }
  // public Entities getEntities() {
  //   return entities;
  // }
  // public void setEntities(Entities entities) {
  //   this.entities = entities;
  // }  
}
