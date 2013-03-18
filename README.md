jpa-hibernate-branches
======================

JPA entities which may be branched to have more than one branch of entity (with childs) at time.

Also, custom generator used for @EmbeddedId (because phrase ["You can also generate properties inside an @EmbeddedId class"](http://docs.jboss.org/hibernate/annotations/3.5/reference/en/html_single/#d0e1150)  from hibernate manual is lie).
So, custom sequence generator used instead of @GeneratedValue for @EmbeddedId.