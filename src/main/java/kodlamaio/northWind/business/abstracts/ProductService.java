
package kodlamaio.northWind.business.abstracts;

import java.util.List;
import kodlamaio.northWind.core.utilities.results.DataResult;
import kodlamaio.northWind.core.utilities.results.Result;
import kodlamaio.northWind.entities.concretes.Product;
import kodlamaio.northWind.entities.dtos.ProductWithCategoriesDto;
import org.springframework.data.jpa.repository.Query;


public interface ProductService {
    
    DataResult<List<Product>>  getAll();
    DataResult<List<Product>>  getAll(int pageNo,int pageSize);
    DataResult<List<Product>>  getAllSort();
    
    Result add(Product product);
    
    DataResult<Product> getByProductName(String productName);

    DataResult<Product> getByProductNameAndCategoryId(String productName, int cagetoryId);

    DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int cagetoryId);

    DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories);

    DataResult<List<Product>> getByProductNameContains(String productName);

    DataResult<List<Product>> getByProductNameStartsWith(String productName);

 
    DataResult<List<Product>> getByNameAndCategory(String productName,int categoryId);
    
    DataResult<List<ProductWithCategoriesDto>> getProductWithCategoriesDeatils();
}
