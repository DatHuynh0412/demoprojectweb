package com.dht.pojo;

import com.dht.pojo.Tourinformation;
import com.dht.pojo.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-04-07T17:01:25")
@StaticMetamodel(Commentinformation.class)
public class Commentinformation_ { 

    public static volatile SingularAttribute<Commentinformation, String> commentTour;
    public static volatile SingularAttribute<Commentinformation, Tourinformation> tourId;
    public static volatile SingularAttribute<Commentinformation, Integer> commentId;
    public static volatile SingularAttribute<Commentinformation, Users> userId;

}