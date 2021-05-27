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

    private ProductService productService;

    @Autowired
    public ProductsController(final ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getall")
    public DataResult<List<Product>> getAll() {
        return  productService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Product product) {
        return productService.add(product);
    }
}
