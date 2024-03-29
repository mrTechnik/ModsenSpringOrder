package app.libraryservice.repos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import app.libraryservice.domain.BookOrder;

@RepositoryRestResource
public interface BookOrderRepo extends JpaRepository<BookOrder, Integer>{
    @Query(value = "select b.* from bookorder b Where Extract(day from CURRENT_DATE - b.book_order_date) < b.book_end_order_date",
    nativeQuery = true)
List<BookOrder> getAllUnorderedBooks();
}
