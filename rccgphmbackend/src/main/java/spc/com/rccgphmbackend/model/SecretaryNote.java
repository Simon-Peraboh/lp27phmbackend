/**
 * Created By SPC On
 * Date:08/09/2023
 * Time:15:01
 * Project Name:spc.com.rccgphmbackend.model
 */

package spc.com.rccgphmbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "SecretaryNote")
public class SecretaryNote {

    @Id
    private String id;
    private String meetingVenue;
    private String meetingAnchor;
    private String attendanceMen;
    private String attendanceWomen;
    private String attendanceChildren;
    private String attendanceTotal;
    private String minuteOfMeeting;
    private String todoList;
    private String reminders;
    private String date;
}
