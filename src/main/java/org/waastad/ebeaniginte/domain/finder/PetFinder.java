package org.waastad.ebeaniginte.domain.finder;

import io.ebean.Finder;
import org.waastad.ebeaniginte.domain.Pet;
import org.waastad.ebeaniginte.domain.query.QPet;

public class PetFinder extends Finder<Long,Pet> {

  /**
   * Construct using the default EbeanServer.
   */
  public PetFinder() {
    super(Pet.class);
  }

  /**
   * Construct with a given EbeanServer.
   */
  public PetFinder(String serverName) {
    super(Pet.class, serverName);
  }

  /**
   * Start a new typed query.
   */
  public QPet where() {
     return new QPet(db());
  }

  /**
   * Start a new document store query.
   */
  public QPet text() {
     return new QPet(db()).text();
  }
}
