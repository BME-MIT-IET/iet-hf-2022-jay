# Unit tests for viewmodels

Author of the document:

-   Bálint Dolla

Responsible for the writing the unit tests for viewmodels:

-   Bálint Dolla

## Main ideas

The architecture of the application makes the viewmodels very important as these handle the state for each of the screens. Therefore it seemed logical to write unit tests for these classes and thankfully the rainbowCake framework gives plenty of support for this.

### Dependeny Injection and Mocking

One of the main ideas that make testing very easy is dependency injection because it allows us to pass mock objects to the class we want to test. In case of the view models we always need to pass a presenter instance which gets used heavily throughout each of the methods of the viewmodel. This required a mocking tool and our team decided on [mockk](https://mockk.io/). It is easy to use and it is designed for kotlin specifically which was a nice bonus for us.

Initially we tried using mockito but it lacked some of the static mocking capabilities that we needed. Static mocking had to be used for some third party libraries such as Firebase because these were referenced directly in the application.

### Verification

The main thing that needed to be verified in the tests was the state of the viewmodel during a specific method call. For example when the user logs in then the state goes from Initial to Loading to LoggedIn in one method call. The framework provides a nice way of verifying these state changes. The test class must inherit from their specific ViewModelTest class which provides a method to do these state verifications. An other tricky thing was testing asyncronous methods because it requires the unit test to wait until the method completes its asynchronous behaviour and all variables are set to their correct values. We used the [kotlin-coroutines-test](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-test/) for this.

## Conclusion

Writing these tests ensures that the methods currently work as expected and that developers will be aware if they break in the future and will have the chance to fix the issues.

I personally learnt a lot about the kotlin language as well as how to mock objects for unit tests.
