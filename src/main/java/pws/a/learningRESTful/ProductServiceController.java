/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//define package
package pws.a.learningRESTful;

//define import-->
import model.Product;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//<--define import
/**
 *
 * @author MADD
 */
//define RestController
@RestController
//define class
public class ProductServiceController
{
    //define static method for creating first data
    private static final Map<String, Product> productRepo = new HashMap<>();
    static 
    {
        //define data1
        Product honey = new Product();
        honey.setId("1");
        honey.setName("Honey");
        honey.setPrice(10000.0);
        honey.setDiscount(0.1);
        Double totallhoney = honey.getPrice() - (honey.getPrice() * honey.getDiscount());
        honey.setTotal(totallhoney);
        productRepo.put(honey.getId(), honey);
        
        //define data2
        Product almond = new Product();
        almond.setId("2");
        almond.setName("Almond");
        almond.setPrice(20000.0);
        almond.setDiscount(0.2);
        Double totallalmond = almond.getPrice() - (almond.getPrice() * almond.getDiscount());
        almond.setTotal(totallalmond);
        productRepo.put(almond.getId(), almond);
    }
    
    //define RequestMapping for URL
    @RequestMapping(value = "/products")
    //define class for getProduct
    public ResponseEntity<Object> getProducts()
    {
        //return method with all data value and HttpStatus
        return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
    }
    
    //define RequestMapping for URL and method 
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    //define class for createProduct
    public ResponseEntity<Object> createProduct(@RequestBody Product product)
    {
        //define conditional command, if data already exist (by 'id') can't create data
        if(productRepo.containsKey(product.getId()))
            //return method with message and HttpStatus
            return new ResponseEntity<>("Product is already exist", HttpStatus.CONFLICT);
        
        //define data value
        Double totall = product.getPrice() - (product.getPrice() * product.getDiscount());
        product.setTotal(totall);
        productRepo.put(product.getId(), product);
        //return method with message and HttpStatus
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }
    
    //define RequestMapping for URL and method
    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    //define class for updateProduct
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product)
    {
        //define conditional command, if data not found (by 'id') can't update data
        if(!productRepo.containsKey(id))
            //return method with message and HttpStatus
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        
        //remove data by 'id'
        productRepo.remove(id);
        //define data value
        product.setId(id);
        Double totall = product.getPrice() - (product.getPrice() * product.getDiscount());
        product.setTotal(totall);
        productRepo.put(id, product);
        //return method with message and HttpStatus
        return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
    }
    
    //define RequestMapping for URL and method
    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    //define class for delete
    public ResponseEntity<Object> delete(@PathVariable("id") String id)
    {
        productRepo.remove(id);
        //return method with message and HttpStatus
        return new ResponseEntity<>("Product is deleted successfully", HttpStatus.OK);
    }
}