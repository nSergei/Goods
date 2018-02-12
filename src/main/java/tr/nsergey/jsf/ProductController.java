package tr.nsergey.jsf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import tr.nsergey.Persistence.Product;
import tr.nsergey.Persistence.ProductRepository;

@Controller
@Scope(value = "session")
public class ProductController {
    private ProductRepository productRepository;

    private Product product = new Product();

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public String save() {
        productRepository.save(product);
        product = new Product();
        return "/product-list.xhtml?faces-redirect=true";
    }
    public String cancel(){
        product = new Product();
        return "/product-list.xhtml?faces-redirect=true";
    }

    public Product getProduct() {
        return product;
    }
}
