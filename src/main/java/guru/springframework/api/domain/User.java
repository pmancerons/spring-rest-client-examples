package guru.springframework.api.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class User implements Serializable {

    private String id;
    private String phone;
    private String firstName;
    private String lastName;
    private Location location;
    private String email;
    private Gender gender;
    private String title;
    private Date registerDate;
    private String picture;
    private Date dateOfBirth;
}
