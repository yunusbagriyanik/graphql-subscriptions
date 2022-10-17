### GraphQL Subscription

### Requirements

* JDK 17(openjdk-17)
* Spring Boot 2.7.4
* Maven 3.6.3 or newer
* Spring Webflux
* GraphQL

### Build App

    $ mvn clean install

### Run App

    $ mvn spring-boot:run

#### Subscription

```
subscription {
  widgetEvents {
    id
    data
    action
  }
}
```

#### Queries

```
query {
  widgets {id name}
  widgetById(id: 4) {id name}
}
```

#### Mutations
```
mutation {
  createWidget(request: {id:98430432 name:"test"}) {id name}
  deleteWidget
}
```
#### GraphQL Explorer

     http://localhost:8080/graphiql?path=/graphql
