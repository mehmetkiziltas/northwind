package kodlamaio.northwind.api.controllers;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductsController {

    private final ProductService productService;

    @Autowired
    public ProductsController(final ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getall")
    public DataResult<List<Product>> getAll() {
        return productService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Product product) {
        return productService.add(product);
    }

    @GetMapping("/getByProductName")
    public DataResult<Product> getByProductName(@RequestParam String productName) {
        return productService.getByProductName(productName);
    }

    @GetMapping("/getByProductNameAndCategoryId")
    public DataResult<Product> getByProductNameAndCategory(@RequestParam("productName") String productName, @RequestParam("categoryId") int categoryId) {
        return productService.getByProductNameAndCategory(productName, categoryId);
    }

    @GetMapping("/getByProductNameContains")
    public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName) {
        return productService.getByProductNameContains(productName);
    }

    @GetMapping("/getAllByPage")
    DataResult<List<Product>> getAll(final int pageNo, final int pageSize) {
        return productService.getAll(pageNo, pageSize);
    }

    @GetMapping("/getAllAsc")
    public DataResult<List<Product>> getAllSorted(){
        return productService.getAllSorted();
    }

}
