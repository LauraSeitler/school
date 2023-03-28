package org.ironhack.bootcamp.jpt13.school.school.Repository;

import org.ironhack.bootcamp.jpt13.school.school.models.Category;
import org.ironhack.bootcamp.jpt13.school.school.models.Department;
import org.ironhack.bootcamp.jpt13.school.school.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryAndDepartment(Category category, Department department);
    List<Product> findByDepartment(Department department);
}
