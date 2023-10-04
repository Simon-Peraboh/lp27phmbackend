package spc.com.rccgphmbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileCreationResponse {
    private String message;
    private UserProfile userProfile;

    // Constructors, getters, and setters
}
