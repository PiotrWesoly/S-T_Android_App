package com.example.st;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Vector;


public class UserData {
        private String name, desc, longDesc, lastName, username, email, password, location;
        private ArrayList<String> schedule;
        private int image, age;
        String price, type;
        int rating;

        public UserData(String name, String desc, int image, int rating, int age) {
            this.name = name;
            this.image = image;
            this.rating = rating;
            this.age = age;
            this.desc = desc;
        }

        public UserData(String name, String lastName, String username, String email ,String password ){
            this.name = name;
            this.lastName = lastName;
            this.username = username;
            this.email = email;
            this.password = password;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getImage() {
            return image;
        }
        public void setImage(int image) {
            this.image = image;
        }
        public int getAge() { return age;}
        public int getRating(){return rating;}
        public String getDesc() { return desc; }
        public void setSchedule(ArrayList<String> schedule) {
        this.schedule = schedule;
    }
        public String getLongDesc() {
        return longDesc;
    }
        public void setLongDesc(String longDesc) { this.longDesc = longDesc; }
        public void setDesc(String desc) {
        this.desc = desc;
    }
        public void setPrice(String price) { this.price = price; }
        public String getPrice() { return price; }
        public void setType(String type) { this.type = type; }
        public String getType() { return type; }
        public String getLocation() { return location; }

    public void setLocation(String location) {
        this.location = location;
    }

    public static  final Comparator<UserData> By_Name_Asc = new Comparator<UserData>() {
        @Override
        public int compare(UserData o1, UserData o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };
    public static  final Comparator<UserData> By_Name_Desc = new Comparator<UserData>() {
        @Override
        public int compare(UserData o1, UserData o2) {
            return o2.getName().compareTo(o1.getName());
        }
    };
    public static final Comparator<UserData> By_Rating_Desc = new Comparator<UserData>() {
        @Override
        public int compare(UserData o1, UserData o2) {
            if(o2.getRating()>o1.getRating())
            return 1;
            else if(o1.getRating()>o2.getRating())
                return -1;
            else return 0;
        }
    };
    public static final Comparator<UserData> By_Rating_Asc = new Comparator<UserData>() {
        @Override
        public int compare(UserData o1, UserData o2) {
            if(o2.getRating()>o1.getRating())
                return -1;
            else if(o1.getRating()>o2.getRating())
                return 1;
            else return 0;
        }
    };
    public static final Comparator<UserData> By_Price_Desc = new Comparator<UserData>() {
        @Override
        public int compare(UserData o1, UserData o2) {
            float p1 = Float.parseFloat(o1.getPrice());
            float p2 = Float.parseFloat(o2.getPrice());
            if(p2>p1)
                return 1;
            else if(p1>p2)
                return -1;
            else return 0;
        }
    };
    public static final Comparator<UserData> By_Price_Asc = new Comparator<UserData>() {
        @Override
        public int compare(UserData o1, UserData o2) {
            float p1 = Float.parseFloat(o1.getPrice());
            float p2 = Float.parseFloat(o2.getPrice());
            if(p2>p1)
                return -1;
            else if(p1>p2)
                return 1;
            else return 0;
        }
    };




}
