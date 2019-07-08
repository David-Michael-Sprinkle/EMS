package com.Sprinkle.EMS;

import java.io.Serializable;

public abstract class Person implements Serializable {

	    private Address address;

        private int age;

        private String name;

        private Long phoneNumber;

        private int ssn;

        private int gender;
        
        private String email;
        

        public enum genders{

            NotSpecified,Male,Female,Other;

        }

        public void setGender(int gender) {

        this.gender=gender;

        }

        public genders getGender() {

            genders[] g=genders.values();

            System.out.println(g[this.gender]);

            return g[this.gender];

        }

        public int getAge() {

            return age;

        }

        public void setAge(int age) {

            this.age = age;

        }

        public Address getAddress() {
        	return this.address;
        }

        public void setAddress(Address address) {

            this.address = address;

        }

        public String getName() {

            return name;

        }

        public void setName(String name) {

            this.name = name;

        }

        public Long getPhoneNumber() {

            return phoneNumber;

        }

        public void setPhoneNumber(long i) {

            this.phoneNumber = i;

        }

        public int getSsn() {

            return ssn;

        }

        public void setSsn(int ssn) {

            this.ssn = ssn;

        }
        
        public String getEmail() {
        	return this.email;
        }
        
        public void setEmail(String email) {
        	this.email=email;
        }

}