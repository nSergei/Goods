package tr.nsergey.jsf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import tr.nsergey.Persistence.Product;
import tr.nsergey.Persistence.ProductRepository;

import java.util.List;

@Controller
@Scope(value = "session")
public class ProductListController {
    private ProductRepository productRepository;

    private List<Product> products;

    @Autowired
    ProductListController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    public void loadData() {
        products = productRepository.findAll();
    }

    public List<Product> getProducts() {
        return products;
    }
}
