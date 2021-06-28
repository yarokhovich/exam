package ru.urllink.jjd.exam4;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Climber climber1 = new Climber();
        String name = "Иван Григорьев";
        int age = 34;
        climber1.setFullName(name);
        climber1.setAge(age);
        climber1.setEmail("ivan@mail.com");
        climber1.setUuid();

        Climber climber2 = new Climber();
        climber2.setAge(19);
        climber2.setFullName("Елена Михайлова");
        climber2.setEmail("helena@mail.com");
        climber2.setUuid();

        Mountain everest = new Mountain("Эверест", 8000);
        Mountain elbrus = new Mountain("Эльбрус", 6000);

        Mountain defaultMountain = new Mountain();

        ClimbingGroup climbingGroup = new ClimbingGroup(elbrus, 5);
        climbingGroup.addClimber(climber1);
        climbingGroup.start();

     ///////////////////////////////////////////exam4////////////////////////////////
       EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("exam4");
 EntityManager manager = factory.createEntityManager();
 manager.getTransaction().begin();
 manager.persist(elbrus);
 manager.persist(everest);
 manager.persist(defaultMountain);
 manager.persist(climbingGroup);
 manager.persist(climber1);
 manager.persist(climber2);

 manager.getTransaction().commit();

        //2.1 всех гор
 manager=factory.createEntityManager();
 List list=manager.createQuery("FROM Mountain").getResultList();
 list.forEach(o -> System.out.println(o));

        //2.2 гор с высотой от min до max/////////////////////////////////
        list=manager.createQuery("SELECT m FROM Mountain m ORDER BY m.height").getResultList();
        list.forEach(o -> System.out.println(o));

        //2.3 групп, которые еще не начали восхождения но горы/////////////////////////////
        manager=factory.createEntityManager();
        list=manager.createQuery("SELECT cg FROM ClimbingGroup cg WHERE cg.start > :pDate")
                .setParameter("pDate", LocalDateTime.now()).getResultList();
        list.forEach(o -> System.out.println(o.toString()));

        //2.4 альпиниста по имени и email/////////////////////////////////////
        Climber findClimber=
                (Climber) manager.createQuery("SELECT c FROM Climber c WHERE c.fullName='Елена Михайлова' " +
                        "OR c.email='helena@mail.com'").getSingleResult();
        System.out.println(findClimber.toString());
        // 2.5 гору по названию//////////////////////////////////////////////
          Mountain findMountain=
                  (Mountain)  manager.createQuery("SELECT m FROM Mountain m WHERE m.name=:mName")
                          .setParameter("mName","Эльбрус").getSingleResult();
        System.out.println(findMountain.toString());

    }
}
