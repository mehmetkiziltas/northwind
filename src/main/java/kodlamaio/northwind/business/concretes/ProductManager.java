package kodlamaio.northwind.business.concretes;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.ProductDao;
import kodlamaio.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public DataResult<List<Product>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.ASC, "productName");
        return new SuccessDataResult<List<Product>>(productDao.findAll(sort), "Data Listelendi..");
    }

    @Override
    public DataResult<List<Product>> getAll(final int pageNo, final int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return new SuccessDataResult<List<Product>>(productDao.findAll(pageable).getContent());
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
        return new SuccessDataResult<Product>(productDao.getByProductNameAndCategory_CategoryId(productName, categoryId), "Data Listelendi..");
    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategory(final String productName, final int categoryId) {
        return new SuccessDataResult<List<Product>>(productDao.getByProductNameOrCategory_CategoryId(productName, categoryId), "Data Listelendi..");
    }

    @Override
    public DataResult<List<Product>> getByCategoryIn(final List<Integer> categories) {
        return new SuccessDataResult<List<Product>>(productDao.getByCategory_CategoryIdIn(categories), "Data Listelendi..");
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
        return new SuccessDataResult<List<Product>>(productDao.getByNameAndCategory_CategoryId(productName, categoryId), "Data Listelendi..");
    }

}
