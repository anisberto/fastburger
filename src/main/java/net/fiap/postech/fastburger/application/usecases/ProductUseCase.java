package net.fiap.postech.fastburger.application.usecases;

import net.fiap.postech.fastburger.application.domain.Product;
import net.fiap.postech.fastburger.application.domain.enums.CategoryEnum;
import net.fiap.postech.fastburger.application.ports.inputports.product.*;
import net.fiap.postech.fastburger.application.ports.outputports.client.SaveClientOutPutPort;
import net.fiap.postech.fastburger.application.ports.outputports.product.DeleteProductOutPutPort;
import net.fiap.postech.fastburger.application.ports.outputports.product.FindProductByCategoryOutPutPort;
import net.fiap.postech.fastburger.application.ports.outputports.product.SaveProductOutPutPort;
import net.fiap.postech.fastburger.application.ports.outputports.product.UpdateProductOutPutPort;

import java.util.ArrayList;
import java.util.List;

public class ProductUseCase implements SaveProductGateway, UpdateProductGateway, DeleteProductGateway, FindProductByCategoryGateway {

    private final SaveProductOutPutPort saveProduct;
    private final UpdateProductOutPutPort updateProduct;
    private final DeleteProductOutPutPort deleteProduct;
    private final FindProductByCategoryOutPutPort findProductByCategory;

    public ProductUseCase(SaveProductOutPutPort saveProduct, UpdateProductOutPutPort updateProduct, DeleteProductOutPutPort deleteProduct, FindProductByCategoryOutPutPort findProductByCategory) {
        this.saveProduct = saveProduct;
        this.updateProduct = updateProduct;
        this.deleteProduct = deleteProduct;
        this.findProductByCategory = findProductByCategory;
    }

    @Override
    public Void delete(String id) {
        return this.deleteProduct.delete(id);
    }

    @Override
    public Product save(Product product) {
        return this.saveProduct.save(product);
    }

    @Override
    public Product update(String id, Product product) {
        return this.updateProduct.update(id, product);
    }

    @Override
    public List<Product> find(CategoryEnum categoryEnum) {
        return this.findProductByCategory.find(categoryEnum);
    }
}
