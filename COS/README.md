# REST (RESTful Webservices) with JAX-RS (Java API for RESTful Web Services)

For a video of the JAX setup, see the [DAT](../DAT) folder.

## Plan

### Day-1

Remember to install [Postman](https://www.getpostman.com/) 

Slides Used Day-1
- [REST General Intro](https://efif.sharepoint.com/sites/cph/Lyngby/_layouts/15/guestaccess.aspx?docid=07f4825a1d99a46fbb46b67f6eaabf44e&authkey=AaDF9us4PJNJ7Ove4ER5o_0)
- [JAX-RS, Intro](https://efif.sharepoint.com/sites/cph/Lyngby/_layouts/15/guestaccess.aspx?docid=096689c5617a1453786e2401a34858af8&authkey=AUj8EbepY-ohhgVLk3Z2klU) 

**Clone this [repo](https://github.com/Lars-m/restClassDemoDay1.git)** to get what we did in the class

These links cover more or less what I have/will talk about today:

Read [RESTfull Web Services](http://www.drdobbs.com/web-development/restful-web-services-a-tutorial/240169069?pgno=1) or Watch [What is REST](http://www.restapitutorial.com/lessons/whatisrest.html)

Use this [link](http://docs.oracle.com/javaee/6/tutorial/doc/gilik.html) as a quick summary of the most important annotations we will use to create our REST-endpoints

This is the [main resource for jersey](https://jersey.github.io/documentation/latest/index.html) (the implementaion of the JAX-RS interface we are using)

### Day 2 - Same as day one.

We "finish" the demo from yesterday, by adding PUT and DELETE endpoints for the
person resource. We explore our api with postman, the browser, and briefly with
the javascript fetch api.
You can find the fork of day1's demo repo
[here](https://github.com/CphBusCosSem3/restClassDemoDay1)

The fetch api is documented
[here](https://developer.mozilla.org/en/docs/Web/API/Fetch_API).
A pretty indept tutorial can be [found
here](https://developers.google.com/web/updates/2015/03/introduction-to-fetch)
r
#### Exercises

  * Exercise - REST Quotes
  * Exercise - REST Persons

### Day 3 - Errorhandling with REST, and deployment to Digital Ocean
  We map java exceptions to http error responses, as well as create responses
  (errors included) from scratch.

#### Exercises
  * Exercise - REST Quotes ErrorHandling
  * Exercise - REST Persons ErrorHandling

<!--
**Day 4 - Test and testing REST Endpoints**<br>
- Database mocking
- RestAssured

*Exercise - REST RestAssured GettingStarted*<br>
*Exercise - REST RestAssured Continued*<br>

**Day 5 - Study point exercises**<br>
*Study point exercises*

## References 
**REST / JAX-RS / JERSEY**<br>
<a href="https://en.wikipedia.org/wiki/Representational_state_transfer" target="_blank">Wikipedia - REST</a><br>
<a href="http://www.restapitutorial.com/lessons/whatisrest.html" target="_blank">RESTapiTutorial - What Is REST?</a><br>
<a href="https://www.tutorialspoint.com/restful/index.htm" target="_blank">Tutorialspoint - REST Tutorial</a><br>
<a href="https://dzone.com/articles/build-rest-service-netbeans-7" target="_blank">Dzone - REST Example</a><br>
<a href="http://www.drdobbs.com/web-development/restful-web-services-a-tutorial/240169069?pgno=1" target="_blank">Dr.Doobs - REST Tutorial</a><br>
<a href="http://www.mkyong.com/tutorials/jax-rs-tutorials/" target="_blank">Mkyong - JAX-RS Tutorial</a><br>
<a href="http://www.vinaysahni.com/best-practices-for-a-pragmatic-restful-api" target="_blank">VinaySahni - REST Best Practices</a><br>
<a href="https://jersey.github.io/#d0e2822" target="_blank">Github - Jersey</a><br>
<a href="https://jersey.github.io/download.html" target="_blank">Github - JAX-RS & Jersey Download</a><br>
<a href="https://jersey.github.io/documentation/latest/index.html" target="_blank">Github - Jersey User Guide</a><br>
<a href="https://jersey.github.io/apidocs/latest/jersey/index.html" target="_blank">Github - Jersey API</a><br>
<a href="https://jersey.github.io/documentation/latest/getting-started.html" target="_blank">Github - Jersey Getting Started</a><br>

**HTTP**<br>
<a href="http://www.mkyong.com/webservices/jax-rs/get-http-header-in-jax-rs/" target="_blank">Mkyong - HTTP Header</a><br>
<a href="http://www.restapitutorial.com/httpstatuscodes.html" target="_blank">RESTapiTutorial - HTTP Status Codes</a><br>

**POSTMAN**<br>
<a href="https://www.getpostman.com/" target="_blank">Postman - Home page</a><br>
<a href="https://blog.matrix42.com/2016/08/08/api-testing-postman-part-1/" target="_blank">Matrix42 Blog - Postman</a><br>

**EXCEPTIONS**<br>
<a href="http://www.hacktrix.com/checked-and-unchecked-exceptions-in-java" target="_blank">Hacktrix - Exceptions</a><br>
<a href="http://howtodoinjava.com/resteasy/exception-handling-in-jax-rs-resteasy-with-exceptionmapper/" target="_blank">HowToDoInJava - REST Exceptions</a><br>

**TEST**<br>
<a href="https://www.martinfowler.com/bliki/InMemoryTestDatabase.html" target="_blank">Fowler - InMemoryTestDatabase</a><br>
<a href="https://semaphoreci.com/community/tutorials/testing-rest-endpoints-using-rest-assured" target="_blank">Semaphore - RestAssured</a><br>

**EXTRA**<br>
<a href="https://en.wikipedia.org/wiki/SOAP" target="_blank">Wikipedia - SOAP</a><br>
<a href="https://www.w3schools.com/xml/xml_soap.asp" target="_blank">W3schools - SOAP</a><br>
<a href="https://en.wikipedia.org/wiki/Web_Services_Description_Language" target="_blank">Wikipedia - WSDL</a><br>
<a href="https://www.w3schools.com/xml/xml_wsdl.asp" target="_blank">W3schools - WSDL</a><br>
-->
