package spc.com.rccgphmbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "regions")
public class Region {
    @Id
    private String id;
    private String name;
    private List<String> provinces;
    private List<String> userProfileIds; // Add this field

    // Add cascading operations for UserProfile
    @DBRef(lazy = true)
    private List<UserProfile> userProfiles;
}
