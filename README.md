jpa-hibernate-branches
======================

JPA entities which may be branched to have more than one branch of entity (with children) at time.

Also, custom generator used for @EmbeddedId (because phrase ["You can also generate properties inside an @EmbeddedId class"](http://docs.jboss.org/hibernate/orm/4.1/manual/en-US/html_single/#d5e2776)  from hibernate manual is lie).
So, custom sequence generator used instead of @GeneratedValue for @EmbeddedId.