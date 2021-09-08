package kodlamaio.northWind.dataAccess.abstracts;

import java.util.List;
import kodlamaio.northWind.entities.concretes.Product;
import kodlamaio.northWind.entities.dtos.ProductWithCategoriesDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//JpaRepository hangi tablo ile çalışılıcak -> Product
//primarykey olan alanın veri türü ne -> id -> integer
public interface ProductDao extends JpaRepository<Product, Integer> {

    //getBy yapısı önemli burada where productName e göre getir demek
    Product getByProductName(String productName);

    Product getByProductNameAndCategory(String productName, int cagetoryId);

    List<Product> getByProductNameOrCategory(String productName, int cagetoryId);

    List<Product> getByCategoryIn(List<Integer> categories);

    List<Product> getByProductNameContains(String productName);

    List<Product> getByProductNameStartsWith(String productName);

    //@Query SQL sorgusu yazmamızı kolaylaştırır.
    //Burada fromdan sonraki tablolar veritabanında olanlar DEĞİL Entity olanlar yukarıda tanımlananlar
    // : parametre olarak almamızı sağlar.
    @Query("From Product Where productName=:productName and category.categoryId=:categoryId")
    List<Product> getByNameAndCategory(String productName,int categoryId);
    
    @Query("SELECT new kodlamaio.northWind.entities.dtos.ProductWithCategoriesDto(p.id,p.productName,c.categoryName) FROM Category c Inner Join c.products p ")
    List<ProductWithCategoriesDto> getProductWithCategoriesDeatils();
}
