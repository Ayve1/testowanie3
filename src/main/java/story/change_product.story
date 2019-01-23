Given a product with parameters (Book,20)
Then product should look like
Product[Book,20]
When I change product name to newName
Then product should look like
Product[newName,20]
When I change product price to 10
Then product should look like
Product[newName,10]

