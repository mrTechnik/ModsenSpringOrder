package app.libraryservice.webservice;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.libraryservice.domain.BookOrder;
import app.libraryservice.repos.BookOrderRepo;

@RestController
@RequestMapping(path="/orderservice")
public class MainController {
    
    @Autowired
    private BookOrderRepo bookOrderRepo;

    private final Integer DEFAULT_BOOK_END_ORDER_DATE = 7;

    @PostMapping(path="/add")
    public void addNewBook(@RequestBody BookOrder bookOrder) {       
        bookOrder.setBookOrderDate(new Date());
        if(bookOrder.getBookEndOrderDate() == 0 || bookOrder.getBookEndOrderDate() == null){
            bookOrder.setBookEndOrderDate(DEFAULT_BOOK_END_ORDER_DATE);
        }
        System.out.println(bookOrder);
        bookOrderRepo.save(bookOrder);
    }

    @GetMapping(path="/get/all_unordered")
    public ResponseEntity<String> getAllUnorderedBooks() {
        List<BookOrder> AllUnorderedBooks = null;
        try {
            AllUnorderedBooks = bookOrderRepo.getAllUnorderedBooks();
            if(AllUnorderedBooks != null){
                String response = "";
                for(BookOrder tempBookOrder: AllUnorderedBooks){
                    if(tempBookOrder == null) {
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("\nRequest error");
                    }
                    response = response + tempBookOrder.toString();
                }
                return ResponseEntity.status(HttpStatus.OK).body(response);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("\nBad request");
            }
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("\nRequest error");
        }  

        
    }

    @PutMapping(path="/update/{id}")
    public ResponseEntity<String> updateBookOrder(@PathVariable String id, @RequestBody BookOrder newBook) {       
        try{
            BookOrder bookOrder = bookOrderRepo.findById(Integer.parseInt(id)).get();
            if(newBook != null && bookOrder != null){
                newBook.setId(Integer.parseInt(id));;
                bookOrderRepo.save(newBook);
                return ResponseEntity.status(HttpStatus.OK).body("\nUpdated");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("\nBad request");
            }
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("\nBad BookOrder id");
        }


    }
}
