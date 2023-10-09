package summary.codeModifyHandling.reflectionApi.di;

public class BookService {

    @Inject BookRepository bookRepository;

    public void join(){
        System.out.println("::: BookService ) join ::: ");
        bookRepository.save();
    }

}
