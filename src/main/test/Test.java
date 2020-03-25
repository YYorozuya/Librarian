import com.example.entity.Book;
import com.example.repository.BookRepository;
import com.example.service.BookService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        int status;

        //status = BookService.addBook("阿迪斯","刘波","艺术",98,1,1,2,100);
        //status = BookService.delBook(4);
        //status = BookService.moveBook(1,2,2,2);
        //System.out.println(status);
        status = BookService.editBook(9,"hhh","hhh","hhh",999.56,2,6,4,60);
        for (Book book:BookService.findAll())
            System.out.println(book);

    }
}
