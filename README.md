# spring-boot-graphQL
# get All product
				query{
				productList{
					idProduct,
					name,
					price,
					category{
						id
					}
				}
			}

# get product by ID
			query{
				productById(id: 11){
					name,
					category {
						name, 
						products {
							name
						}
					}
				}
			}

# get All category 
			query{
				categoryList{
					name
				}
			}

# Save Prodcut
			mutation{
				saveProduct(productRequestDTO: {
					name : "p11", price: 1235, quantity: 152, categoryId: 3
				}){
					idProduct, name, price,quantity ,category {
						id, name
					}
				}
			}
# update product 
			mutation{
				updateProduct (idProduct : 1, productRequestDTO : {
					name: "BBB",
					price: 1000,
					quantity: 1500,
					categoryId:1
				})
				{
				 name,price
				}
			}

# delete product
			mutation{
				deleteProduct(id:305)
			}
