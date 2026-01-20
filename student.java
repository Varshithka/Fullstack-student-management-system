package com.studentjpa.entity;



//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "students")
//public class student {
//
//        @Id
//        @GeneratedValue(strategy = GenerationType.IDENTITY)
//        private Integer id;   // ✅ AUTO_INCREMENT PRIMARY KEY
//
//        @Column(nullable = false)
//        private String name;  // ✅ normal column
//
//        private String email;
//        private int age;
//
//        public student() {}
//
//        // getters & setters
//        public Integer getId() {
//                return id;
//        }
//
//        public void setId(Integer id) {
//                this.id = id;
//        }
//
//        public String getName() {
//                return name;
//        }
//
//        public void setName(String name) {
//                this.name = name;
//        }
//
//        public String getEmail() {
//                return email;
//        }
//
//        public void setEmail(String email) {
//                this.email = email;
//        }
//
//        public int getAge() {
//                return age;
//        }
//
//        public void setAge(int age) {
//                this.age = age;
//        }
//}


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "students")
public class student{

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;

        private String email;

        @Column(nullable = false)
        private Integer age;   // ✅ Added age

        // Getters and Setters

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public Integer getAge() {   // ✅ Getter
                return age;
        }

        public void setAge(Integer age) {   // ✅ Setter
                this.age = age;
        }
}
