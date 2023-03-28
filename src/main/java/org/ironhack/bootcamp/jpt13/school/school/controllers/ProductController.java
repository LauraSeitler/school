package org.ironhack.bootcamp.jpt13.school.school.controllers;

import org.ironhack.bootcamp.jpt13.school.school.Repository.ProductRepository;
import org.ironhack.bootcamp.jpt13.school.school.models.Category;
import org.ironhack.bootcamp.jpt13.school.school.models.Department;
import org.ironhack.bootcamp.jpt13.school.school.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController implements ProductControllerInterface {

    @Autowired
    ProductRepository productRepository;
    @GetMapping("/products/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product getProductById(@PathVariable(name="id") long productId) {
        Optional<Product> productMaybe = productRepository.findById(productId);
        if (!productMaybe.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not found product with id" + productId);
        }
        return productMaybe.get();
    }

    @Override
    @GetMapping("/products")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getProductsByCategoryAndDepartment(
       @RequestParam(name= "category", required = false) Optional<String> category,
       @RequestParam(name= "department", required = true) String department){

        Department dep = Department.valueOf(department);
        if (category.isPresent()){
            Category cat = Category.valueOf(category.get());
            return productRepository.findByCategoryAndDepartment(cat , dep);
        }else{
            return productRepository.findByDepartment(dep);
        }
    }
    /// Rest of the code
}
