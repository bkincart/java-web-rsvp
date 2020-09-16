import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="rsvps")
public class Rsvp {
  @Id
  @SequenceGenerator(name="rsvp_generator", sequenceName = "rsvps_id_seq", allocationSize = 1)
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="rsvp_generator")
  @Column(name="id", nullable=false, unique=true)
  private Long id;

  @NotEmpty
  @Column(name="first_name", nullable=false)
  private String firstName;

  @NotEmpty
  @Column(name="last_name", nullable = false)
  private String lastName;

  @NotEmpty
  @Column(name="email", nullable=false)
  private String email;

  @NotEmpty
  @Column(name="phone_number", nullable = false)
  private String phoneNumber;

  @NotEmpty
  @Column(name="contact_style", nullable = false)
  private String contactStyle;

  public Long getId() {
    return this.id;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEmail(){
    return this.email;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getPhoneNumber() {
    return this.phoneNumber;
  }

  public void setContactStyle(String contactStyle) {
    this.contactStyle = contactStyle;
  }

  public String getContactStyle() {
    return this.contactStyle;
  }
}