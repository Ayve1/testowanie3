package story;

import domain.Product;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;


public class ProductSteps {

    private Product product;

    //add product
    @Given("a input field")
    public void addProductStart(){
        product = new Product();
    }

    @When("I write name $text")
    public void iWriteName(String text){
        product.setName(text);
    }

    @Then("product should look like $text")
    public void productShouldLookLike(String text) {
        assertThat(product.toString(), equalTo(text));
    }

    @When("I write price $text")
    public void iWriteAmount(String text){
        product.setPrice(new BigDecimal(text));
    }

    //change product
    @Given("a product with parameters ($name,$price)")
    public void changeProductStart(String name, BigDecimal price){
        product = new Product();
        product.setName(name);
        product.setPrice(price);
    }

    @When("I change product name to $newName")
    public void iChangeName(String newName){
        product.setName(newName);
    }

    @When("I change product price to $price")
    public void iChangePrice(String price){
        product.setPrice(new BigDecimal(price));
    }

    @When("I remove this product")
    public void iRemoveProduct(){
       product = null;
    }

    @Then("product should be removed")
    public void productShouldBeRemoved(){
        assertNull(product);
    }
}
