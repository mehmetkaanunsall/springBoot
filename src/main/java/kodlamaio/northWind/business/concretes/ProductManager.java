/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kodlamaio.northWind.business.concretes;

import java.util.List;
import kodlamaio.northWind.business.abstracts.ProductService;
import kodlamaio.northWind.core.utilities.results.DataResult;
import kodlamaio.northWind.core.utilities.results.Result;
import kodlamaio.northWind.core.utilities.results.SuccesResult;
import kodlamaio.northWind.core.utilities.results.SuccessDataResult;
import kodlamaio.northWind.dataAccess.abstracts.ProductDao;
import kodlamaio.northWind.entities.concretes.Product;
import kodlamaio.northWind.entities.dtos.ProductWithCategoriesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductManager implements ProductService {

    private ProductDao productDao;

    @Autowired
    public ProductManager(ProductDao productDao) {
        this.productDao = productDao;
    }
    
    
    @Override
    public DataResult<List<Product>>  getAll() {
        return new SuccessDataResult<List<Product>>(this.productDao.findAll(),"Datalar Listelendi.");
                
                
    }

    @Override
    public Result add(Product product) {
        this.productDao.save(product);
       return new SuccesResult("Ürün Eklendi");
    }

    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SuccessDataResult<Product>(this.productDao.getByProductName(productName),"Datalar Listelendi.");
    }

    @Override
    public DataResult<Product> getByProductNameAndCategoryId(String productName, int cagetoryId) {
       return new SuccessDataResult<Product>(this.productDao.getByProductNameAndCategory(productName, cagetoryId),"Datalar ürün adı ve kategori id ye göre Listelendi.");
    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int cagetoryId) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameOrCategory(productName, cagetoryId),"Datalar ürün adı veya kategori id ye göre Listelendi.");
    }

    @Override
    public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByCategoryIn(categories),"Datalar kategori id bilgilerine göre Listelendi.");
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameContains(productName),"Datalar ürün adı var mı diye Listelendi.");
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameStartsWith(productName),"Datalar ürün adı ile başlıyor mu ya göre Listelendi.");
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
       return new SuccessDataResult<List<Product>>(this.productDao.getByNameAndCategory(productName, categoryId),"Datalar ürün adı ve kategori id ye göre SORGU olarak Listelendi.");
    }

    @Override
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return new SuccessDataResult<List<Product>>( this.productDao.findAll(pageable).getContent());
    }

    @Override
    public DataResult<List<Product>> getAllSort() {
         Sort sort = Sort.by(Sort.Direction.DESC,"productName");
        return new SuccessDataResult<List<Product>>( this.productDao.findAll(sort),"Başarılı");
    }

    @Override
    public DataResult<List<ProductWithCategoriesDto>> getProductWithCategoriesDeatils() {
        return new SuccessDataResult<List<ProductWithCategoriesDto>>( this.productDao.getProductWithCategoriesDeatils(),"Joinle çalışıldı");
    }
    
     
  

}
