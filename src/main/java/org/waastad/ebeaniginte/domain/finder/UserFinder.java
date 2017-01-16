package org.waastad.ebeaniginte.domain.finder;

import io.ebean.Finder;
import org.waastad.ebeaniginte.domain.User;
import org.waastad.ebeaniginte.domain.query.QUser;

public class UserFinder extends Finder<Long,User> {

  /**
   * Construct using the default EbeanServer.
   */
  public UserFinder() {
    super(User.class);
  }

  /**
   * Construct with a given EbeanServer.
   */
  public UserFinder(String serverName) {
    super(User.class, serverName);
  }

  /**
   * Start a new typed query.
   */
  public QUser where() {
     return new QUser(db());
  }

  /**
   * Start a new document store query.
   */
  public QUser text() {
     return new QUser(db()).text();
  }
}
