package guru.springframework;

/*import com.alex.redgreenrefactory.model.dao.IOrderDao;
import org.junit.Before;*/
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Map;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doThrow;

/**

 See also my project

 Repo: https://github.com/springframeworkguru/testing-junit5-mockito
 My code location
    Repo https://github.com/alexaz99/testing-junit5-mockito
    Project:  C:\IdeaProjects-udemy-courses\testing-junit5-mockito
    Branch: junit-extention

 =============================
 =  Mockito Usage
 =============================
 STRUCTURE THE WAY OF THINKING when write any unit test
    given => when => then

   Always use at least 3 mockito annotations
       @RunWith(MockitoJUnitRunner.class) - use for JUnit 4,
       @ExtendWith(MockitoExtension.class)  use for JUnit 5

       @Mock        - Mock the object instead of real one
       @InjectMocks - use to inject mock fields into the tested object automatically.
                      the best to use for Constructor injection

 @ExtendWith(MockitoExtension.class)
 class SpecialitySDJpaServiceTest {

     @Mock
     SpecialtyRepository specialtyRepository;

     @InjectMocks
     SpecialitySDJpaService service;

     // TestReturning values from Mockito Mocks
     @Test
     void findByIdTest() {

 Mock vs Stub Object.
       1. If we assert on fake object it's a Mock object -> means the object is under the  test.
       2. If any fake object is helping to run a test but not under the test, it's a stubbing and object is stub.
       3. So each object by default is a stub, unless we assert (test) that object.

   Definitions:
        1. A fake object in technical terms calls mock object.
        2. MOCK OBJECT DEFINITION
           If we assert on fake object it's a Mock object.
           IF we ASSERT against this Mock object and not against real system it's a MOCK OBJECT.

           Mock object is a faked object that was inserted into the system
           and later is the one that helps to decide if the system indeed interacted with some other objects

           Use mock objects to check the interaction with other systems.
           In order to use properly need to change some design to make it testable.
           Use composition instead of inheritance and Interfaces. And assemple the object via constructor the best
           approuch, setter methods is second of instant variables the least

       Mockito will try to inject mocks only either by constructor injection,
       setter injection, or property injection

           If we pass an Interface in constructor or in set method or in a call method
            1. We can implement our own manual mock object
            2. Use mock object from Mockito or other mock framework

            Examples of Mock object under the test

               List<Integer> mockList = Mockito.mock(List.class);
               Mockito.when(mockList.get(Matchers.anyInt())).thenReturn(34);
               assertTrue(34 == mockList.get(1));
               assertTrue(34 == mockList.get(90));
               assertThat(34, is(mockList.get(60)));

                List<String> mockStringList = Mockito.mock(List.class);
                Mockito.when(mockStringList.get(Matchers.anyInt())).thenReturn("Hello");
                assertTrue( "Hello".equals(mockStringList.get(1)));
                assertTrue( "Hello".equals(mockStringList.get(78)));

       3. STUB OBJECT DEFINITION
            If we assert on fake object it's a Mock object.
            If any fake object is helping to run a test but not under the test, it's a stubbing.
            So each object by default is a stub, unless we assert (test) that object.

   Good basic tests with mockitoUsage Injection of Interface and METHOD STUBBING
   SUPPORT UNIT TESTING CYCLE:
       Setup => Execution => Verification => Teardown

       Given => When => Then
        or
       setUp => Execution => Verification

   MOCKITO FRAMEWORK
   Mockito object has a bunch of static methods

   1. HowTo create Mocking objects instances in tests
       Create Mock object using
        1. @Mock annotation for objects
           If we use @Mock annotations, we must initialize this mock object with a

           protected @Mock IOrderDao mockOrderDao;

            @Before
           public void setUp() {
             MockitoAnnotations.initMocks(this);
           }

        2. List<Integer> mockList = Mockito.mock(List.class); // mock() sattic method

   ARGUMENT MATCHES FOR STUBBING AND VERIFYING BEHAVIOR

     Mockito.when(mockList.get(Matchers.anyInt())).thenReturn(34);

   2. Stubbing Method Calls

       // to return value when call mock or stub object
       Mockito.when(mockList.get(Matchers.anyInt())).thenReturn(34);
       Mockito.when(mockStringList.get(Matchers.anyInt())).thenReturn("Hello");
       Mockito.when(mockOrderDao.findOrdersByCustomer(CUSTOMER_ID)).thenReturn(orderEntityListFixture);

       // to eliminate a method from being executed, you could do something like this
       Mockito.doNothing().when(tradeMsgListener).onMsgTrade(mockitoUsage.isA(RouterMsfBox.class))

       // Skip the void call with 3 parameters"
       //   Object of type RequestParameters
       // List of Type RequestParameter
       // List of type String
       Mockito.doNothing().when(dynamicViewSpy).validateParameters(any(RequestParameters.class), Mockito.<~>anyList(), Mockito.<~>anyList());

       FixCustomMsg customMsg = Mockito.mock(FixCustomMsg.class);
       when(customMsg.toFix()).thenReturn("");
       Mockito.doReturn(customMsg).when(customMsg).append(customMsg);

   3. Verification
            see OrderServiceImplTest.java

            UserManager userManager = Mockito.mock(UserManager.class);

            // Execution. Make a call to a Mock object during a test.
            // Can call only one time or multiple times
            userManager.save("Alex");

            or other method List<OrderSummary> result = target.getOrderSummary(CUSTOMER_ID);

            // Now this is a verification call, to verify that we had already called
            Mockito.verify(userManager).save("Alex");

            userManager.save("Peter");
            Mockito.verify(userManager, times(2)).save(Mockito.anyString());

            Mockito.verify(target).getOrderSummary(CUSTOMER_ID);

       assertThat(Integer.MIN_VALUE, is(businessImpl.findTheGreatestFromAllData()) );

       List<Integer> mockList = Mockito.mock(List.class);
       Mockito.when(mockList.get(Matchers.anyInt())).thenReturn(34);
       assertThat(34, is(mockList.get(60)));

   See practical Mockto test example
    @see com.alex.redgreenrefactory.service.OrderServiceImplTest
    @see com.alex.redgreenrefactory.businessServices.SomeBusinessImplTest

    mockitoUsage.anyXXX - methods
         mockitoUsage.anyInt()

  4. Spy

     List list = new LinkedList();
     List spy = spy(list);

     // Impossible: real method is called so spy.get(0)
     // throws IndexOutOfBoundsException (the list is yet empty)
     when(spy.get(0)).thenReturn("foo");

     // You have to use doReturn() for stubbing
     doReturn("foo").when(spy).get(0);



 */
public class _2_MockingConcepts {

    /** Mock the object, the same as mockitoUsage.mock(Map.class); */
    @Mock
    Map<String, String> wordMap;

/*    @Mock
    IOrderDao oderDao;

    @Before
    public void setUp() {
        // mock the object
        //this.mockOrderDao = mockitoUsage.mock(IOrderDao.class);
        // or better this will mock the OrderDao
        MockitoAnnotations.initMocks(this);
    }*/

}

