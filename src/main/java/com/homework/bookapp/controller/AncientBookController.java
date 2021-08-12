package com.homework.bookapp.controller;

import com.homework.bookapp.model.AncientBook;
import com.homework.bookapp.model.AncientBookDTO;
import com.homework.bookapp.service.AncientBookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/ancient-book")
@RestController
public class AncientBookController {

    private final AncientBookService ancientBookService;

    public AncientBookController(AncientBookService ancientBookService) {
        this.ancientBookService = ancientBookService;
    }


    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public AncientBook ancientBookRegistration(@RequestBody AncientBookDTO ancientBookDTO) {
        return ancientBookService.ancientBookRegistration(ancientBookDTO);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<AncientBook> getAllAncientBooks() {
        return ancientBookService.getAllAncientBooks();
    }

  /*  @GetMapping("/{barcode}")
    public ResponseEntity<AncientBook> getAncientBookByBarcode(@PathVariable String barcode) {
        if (ancientBookService.findAncientBookByBarcode(barcode) != null)
            return new ResponseEntity(ancientBookService.findAncientBookByBarcode(barcode), HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update/{barcode}")
    public ResponseEntity<AncientBook> updateAncientBookByBarcode(@PathVariable String barcode,
                                                                 @RequestBody AncientBookDTO ancientBookDTO) {
        if (ancientBookService.findAncientBookByBarcode(barcode)  != null)
            return new ResponseEntity(ancientBookService.updateAncientBookByBarcode(barcode, ancientBookDTO),
                    HttpStatus.OK);
        else
            return new ResponseEntity(ancientBookService.ancientBookRegistration(ancientBookDTO), HttpStatus.CREATED);
    }
}
   */
}
