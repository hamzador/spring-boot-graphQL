# spring-boot-graphQL
# server Url in local for graphQL query:
   http://localhost:8000/graphiql
# Application.properties file configuration:
	server.port=8000

	spring.datasource.url=jdbc:mysql://localhost:3306/graphql?createDatabaseIfNotExist=true&userSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
	spring.datasource.username=root
	spring.datasource.password=
	spring.jpa.hibernate.ddl-auto=update
	spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

	## Hibernate Properties
	# The SQL dialect makes Hibernate generate better SQL for the chosen database
	spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect

	spring.graphql.graphiql.enabled=true
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
