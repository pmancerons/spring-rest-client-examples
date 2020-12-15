package guru.springframework.api.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.TimeZone;

@Getter
@Setter
@NoArgsConstructor
public class Location implements Serializable {
    private String state;
    private String street;
    private String city;
    private TimeZone timeZone;
    private String country;
}
