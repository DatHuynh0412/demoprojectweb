package com.dht.pojo;

import com.dht.pojo.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-04-07T17:01:25")
@StaticMetamodel(Tourinformation.class)
public class Tourinformation_ { 

    public static volatile SingularAttribute<Tourinformation, String> image;
    public static volatile SingularAttribute<Tourinformation, Integer> tourId;
    public static volatile SingularAttribute<Tourinformation, String> nameTour;
    public static volatile SingularAttribute<Tourinformation, Long> price;
    public static volatile SingularAttribute<Tourinformation, String> bookingDate;
    public static volatile SingularAttribute<Tourinformation, Users> userId;

}