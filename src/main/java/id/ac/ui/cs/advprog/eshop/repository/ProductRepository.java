package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();
    private int globalIndex = 1;

    public Product create(Product product) {
        if (product.getProductId() == null){
            product.setProductId(Integer.toString((globalIndex)));
            globalIndex++;
        }
        productData.add(product);
        return product;
    }

    public Product edit(Product product) {
        if (product == null || product.getProductId() == null) return null;
        for (int i = 0; i < productData.size(); i++) {
            if (product.getProductId().equals(productData.get(i).getProductId())) {
                productData.set(i, product);
                return product;
            }
        }
        return null;
    }

    public Iterator<Product> findAll() {
        return productData.iterator();
    }

    public Optional<Product> findById(String id){
        return productData.stream().filter(product -> id.equals(product.getProductId())).findFirst();
    }
}