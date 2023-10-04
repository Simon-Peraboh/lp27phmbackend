/**
 * Created By SPC On
 * Date:12/09/2023
 * Time:00:48
 * Project Name:spc.com.rccgphmbackend.service
 */

package spc.com.rccgphmbackend.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import spc.com.rccgphmbackend.model.SecretaryNote;
import spc.com.rccgphmbackend.repository.SecretaryNoteRepository;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class SecretaryNoteServiceImpl implements SecretaryNoteService{

    //Inject DB interaction
    private SecretaryNoteRepository noteRepository;

    @Override
    public SecretaryNote createNotes(SecretaryNote secretaryNote) {
        secretaryNote.setId(UUID.randomUUID().toString().split("-")[0]);
        return noteRepository.save(secretaryNote);
    }

    @Override
    public List<SecretaryNote> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public SecretaryNote getNoteById(String id) {
        //Check if Id exist with Optional method or lambda
        return noteRepository.findById(id).orElseThrow(() ->
                new RuntimeException("User With ID " + id + " Doesn't Exit"));
    }

    @Override
    public SecretaryNote updateNotes(SecretaryNote secretaryNote, String id) {
        //Check if Id exist with Optional method or lambda
        SecretaryNote noteExist = noteRepository.findById(id).orElseThrow(() ->
                new RuntimeException("User With ID " + id + " Doesn't Exit"));
        noteExist.setMeetingVenue(secretaryNote.getMeetingVenue());
        noteExist.setMeetingAnchor(secretaryNote.getMeetingAnchor());
        noteExist.setAttendanceMen(secretaryNote.getAttendanceMen());
        noteExist.setAttendanceWomen(secretaryNote.getAttendanceWomen());
        noteExist.setAttendanceChildren(secretaryNote.getAttendanceChildren());
        noteExist.setAttendanceTotal(secretaryNote.getAttendanceTotal());
        noteExist.setMinuteOfMeeting(secretaryNote.getMinuteOfMeeting());
        noteExist.setTodoList(secretaryNote.getTodoList());
        noteExist.setReminders(secretaryNote.getReminders());
        noteExist.setDate(secretaryNote.getDate());

        //Save Update to db
        return noteRepository.save(noteExist);
    }

    @Override
    public void deleteNoteById(String id) {
        //Check if Id exist with Optional method or lambda
        noteRepository.findById(id).orElseThrow(() ->
                new RuntimeException("User With ID " + id + " Doesn't Exit"));
        noteRepository.deleteById(id);
    }
}
