package summary.codeModifyHandling.reflectionApi.di;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class ContainerServiceTest {

    @Test
    @DisplayName("인스턴스_생성_테스트_BookRepository")
    public void getObject_BookRepository() {
        // when
        BookRepository bookRepository = ContainerService.getObject(BookRepository.class);
        // then
        assertNotNull(bookRepository);
    }

    @Test
    @DisplayName("인스턴스_생성_테스트_BookService")
    public void getObject_BookService() {
        //give
        BookService bookService = ContainerService.getObject(BookService.class);

        // when
        bookService.join();

        // then
        assertNotNull(bookService);
        assertNotNull(bookService.bookRepository); // BookService가 BookRespositoy를 필드 주입 받으므로  BookRepository에 접근 가능

    }


}