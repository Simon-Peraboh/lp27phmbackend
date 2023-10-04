/**
 * Created By SPC On
 * Date:12/09/2023
 * Time:11:56
 * Project Name:spc.com.rccgphmbackend.contoller
 */

package spc.com.rccgphmbackend.contoller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spc.com.rccgphmbackend.model.SecretaryNote;
import spc.com.rccgphmbackend.service.SecretaryNoteService;

import java.util.List;

@RestController
@RequestMapping("api/v1/secretaryNote")
@AllArgsConstructor
public class SecretaryNoteController {

    //Inject Service Later
    private SecretaryNoteService noteService;

    // Build Create SecretaryNote  REST API
    @PostMapping()
    public ResponseEntity<SecretaryNote> createNotes(@RequestBody SecretaryNote secretaryNote){
        return new ResponseEntity<>(noteService.createNotes(secretaryNote), HttpStatus.CREATED);
    }

    // Build SecretaryNote Get All Notes REST API
    @GetMapping()
    public List<SecretaryNote> getAll(){
        return noteService.getAllNotes();
    }

    // Build SecretaryNote Get a Single Notes By Id REST API
    @GetMapping("/{id}")
    public ResponseEntity<SecretaryNote> getNote(@PathVariable String id){
        return  new ResponseEntity<>(noteService.getNoteById(id), HttpStatus.OK);
    }

    // Build SecretaryNote Update Notes By Id REST API
    @PutMapping("/{id}")
    public ResponseEntity<SecretaryNote> updateNote(@RequestBody SecretaryNote note, @PathVariable String id){
        return new ResponseEntity<>(noteService.updateNotes(note, id), HttpStatus.OK);
    }

    // Build SecretaryNote Delete Notes By Id REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNote(@PathVariable String id){
        noteService.deleteNoteById(id);
        return new ResponseEntity<>("User Delete Successful " + id, HttpStatus.OK);
    }

}
