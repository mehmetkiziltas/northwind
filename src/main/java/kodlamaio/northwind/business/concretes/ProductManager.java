package kodlamaio.northwind.business.concretes;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.ProductDao;
import kodlamaio.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {

    private ProductDao productDao;

    @Autowired
    public ProductManager(final ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<List<Product>>(productDao.findAll(), "Data Listelendi..");
    }

    @Override
    public Result add(final Product product) {
        productDao.save(product);
        return new SuccessResult("Ürün Eklemdi");
    }

    @Override
    public DataResult<Product> getByProductName(final String productName) {
        return new SuccessDataResult<Product>(productDao.getByProductName(productName), "Data Listelendi..");
    }

    @Override
    public DataResult<Product> getByProductNameAndCategory(final String productName, final int categoryId) {
        return new SuccessDataResult<Product>(productDao.getByProductNameAndCategory(productName, categoryId), "Data Listelendi..");
    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategory(final String productName, final int categoryId) {
        return new SuccessDataResult<List<Product>>(productDao.getByProductNameOrCategory(productName, categoryId), "Data Listelendi..");
    }

    @Override
    public DataResult<List<Product>> getByCategoryIn(final List<Integer> categories) {
        return new SuccessDataResult<List<Product>>(productDao.getByCategoryIn(categories), "Data Listelendi..");
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(final String productName) {
        return new SuccessDataResult<List<Product>>(productDao.getByProductNameContains(productName), "Data Listelendi..");
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(final String productName) {
        return new SuccessDataResult<List<Product>>(productDao.getByProductNameStartsWith(productName), "Data Listelendi..");
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategory(final String productName, final int categoryId) {
        return new SuccessDataResult<List<Product>>(productDao.getByNameAndCategory(productName, categoryId), "Data Listelendi..");
    }

}
