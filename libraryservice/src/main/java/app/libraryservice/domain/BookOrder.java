package app.libraryservice.domain;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "bookorder")
public class BookOrder {
    @Id
    private Integer id;

    private Date bookOrderDate;

    private Integer bookEndOrderDate = 0;

    public BookOrder(){
    }

    public Integer getId() {
        return id;
      }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Date getBookOrderDate() {
        return bookOrderDate;
      }
    
    public void setBookOrderDate(Date bookOrderDate) {
        this.bookOrderDate = bookOrderDate;
    }

    public Integer getBookEndOrderDate() {
        return bookEndOrderDate;
      }
    
    public void setBookEndOrderDate(Integer bookEndOrderDate) {
        this.bookEndOrderDate = bookEndOrderDate;
    }

    public String toString(){
        return String.format("{id: %s, bookOrderDate: %s, bookEndOrderDate: %s}",
                 id, bookOrderDate, bookEndOrderDate);
    }
}
