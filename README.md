# Spring Data JPA One-to-Many Bi-Directional Mapping

## Introduction
This project demonstrates how to implement **One-to-Many Bi-directional Mapping** using **Spring Data JPA**.

## Technologies Used
- Java 17+
- Spring Boot 3+
- Spring Data JPA
- Hibernate
- Mysql Database (for testing)
- Lombok

## ER Diagram
```
+-------------+       1    *    +--------------+
|   Parent    |----------------|    Child     |
+-------------+                +--------------+
```
A **Parent** entity can have multiple **Child** entities, and each **Child** has a reference back to the **Parent**.


## Concept Overview
In a One-to-Many Bi-Directional relationship, one entity (Parent) can have multiple related entities (Children), and each Child entity maintains a reference back to its Parent. This means you can navigate the relationship from both sides.

Key Annotations & Their Roles
`@OneToMany` (In Parent Entity)

Defines a one-to-many relationship.
Uses mappedBy to indicate that the mapping is controlled by the parent field in the Child entity.
Can include cascade and orphanRemoval to manage the lifecycle of child entities.
`@ManyToOne` (In Child Entity)

Defines the many-to-one side of the relationship.
Uses `@JoinColumn` to specify the foreign key in the child table.

## How the Relationship Works in Hibernate
When a `Parent` entity is saved, all associated Child entities are automatically persisted if `CascadeType.ALL` is set.
When a `Child` entity is accessed, it can retrieve the Parent entity through the parent reference.

If `orphanRemoval = true`, removing a Child from the children list in Parent will delete it from the database.
Lazy loading is the default behavior (fetch = FetchType.LAZY), meaning child entities won't be loaded until explicitly accessed.

## Key Benefits of Bi-Directional Mapping
✅ Allows navigation from both Parent → Child and Child → Parent.

✅ Provides better data consistency and avoids unnecessary joins.

✅ Enables cascading operations for better data management.

## Parent Entity

```
@Entity
@Table(name = "department")
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "department_name")
    private String name;

    @Column(name = "department_code")
    private String departmentCode;


    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Employee> employees = new ArrayList<>();
}
```

## Child Entity

```
@Entity
@Data
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;
}
```

## Video

https://www.youtube.com/watch?v=

<a href="http://www.youtube.com/watch?feature=player_embedded&v=_1BWdyRJNA4
" target="_blank"><img src="http://img.youtube.com/vi/YOUTUBE_VIDEO_ID_HERE/0.jpg" 
alt="IMAGE ALT TEXT HERE" width="240" height="180" border="10" /></a>
