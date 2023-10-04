package spc.com.rccgphmbackend.service;

import spc.com.rccgphmbackend.model.SecretaryNote;

import java.util.List;

public interface SecretaryNoteService {

    //Create & save Secretary Notes
    SecretaryNote createNotes(SecretaryNote secretaryNote);

    //Get All Secretary Notes As List
    List<SecretaryNote> getAllNotes();

    //Get a single Secretary Note By Id
    SecretaryNote getNoteById(String id);

    //Update Secretary Note By Id
    SecretaryNote updateNotes(SecretaryNote secretaryNote, String id);

    //Delete Note By Id
    void deleteNoteById(String id);
}
