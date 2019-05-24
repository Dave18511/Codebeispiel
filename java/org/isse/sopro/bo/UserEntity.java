package org.isse.sopro.bo;


import com.lambdaworks.crypto.SCryptUtil;
import javax.persistence.*;

/**
 *
 * Represents the User
 * Persitence with Hibernate
 *
 */
@Entity
@Table(name="osca_user")
public class UserEntity {

  // Id only for database, mail is unique
  @Id
  @GeneratedValue
  private int id;
  @Column
  private String name;
  @Column
  private String mail;
  @Column
  private String organisation;
  @Column
  private String password;
  @Column
  private boolean admin;

  public String getMail() {
    return mail;
  }

  public String getName() {
    return name;
  }

  public UserEntity(String name, String mail, String unhashedPassword, String organisation, boolean admin) {
    this.name = name;
    this.mail = mail;
    this.organisation = organisation;
    this.admin = admin;
    setUnhashedPassword(unhashedPassword);
  }

  public UserEntity() {}

  public void setName(String name) {
    this.name = name;
  }

  public String getOrganisation() {
    return organisation;
  }

  public void setOrganisation(String organisation) {
    this.organisation = organisation;
  }

  public String getPassword() {
    return password;
  }

  public void setUnhashedPassword(String password) {
    this.password = SCryptUtil.scrypt(password, 16, 16, 16);
  }

  public void setPassword(String hashedPassword) {
    this.password = hashedPassword;
  }

  public boolean isAdmin() {
    return admin;
  }

  public void setAdmin(boolean admin) {
    this.admin = admin;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

}
