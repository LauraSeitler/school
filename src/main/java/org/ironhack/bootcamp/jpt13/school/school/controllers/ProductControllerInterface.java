package org.ironhack.bootcamp.jpt13.school.school.controllers;

import org.ironhack.bootcamp.jpt13.school.school.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductControllerInterface {
    Product getProductById(long productId);
    List<Product> getProductsByCategoryAndDepartment(Optional<String> category, String department);
}