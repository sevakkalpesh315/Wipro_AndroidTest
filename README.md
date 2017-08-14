# Wipro_AndroidTest
Get the weather information for five days test

# Technologies Used<b></br>
1 Mockito: Test presenters/interactions in MVP design pattern</br>
2 Espresso UI Test: Test fragments/ recyclerviee data loading. The Espresso testing framework, provided by the Android Testing Support Library, provides APIs for writing UI tests to simulate user interactions within a single target app.</br>
3 Dependency injection: Used dagger to inject presenters into the fragments and inject RequestInterface(Retrofit/offline caching in okhttpi)in Interactor_Impl class </br> 
4 RxJava 2: Used reactive programming for concurrency / asynchronous data streams/ chain async operations / Multi threading using schedulers/ Disposable to avoid memory leaks in the apps
5 Retrofit2/okhttp: Connection to external API
6 MVP Design pattern: Divided the application into at least three different layers, which let us test them independently. With MVP we are able to take most of logic out from the activities so that we can test it without using instrumentation tests.</br> 
7 Material Design: Used Recyclerview and cardview to load five days weather information.</br> 
8 Offline Caching: Cache network requests for offline access with Retrofit2 and OkHTTP3 tags.</br> 

# Instrctions to run app- Android API</br>
1 minimum API: 15</br>
2 target API: 26 </br>
3 In Android Studio, click in File menu, then import project, browse to code location and then ok</br>

# Future Improvements<b></br>
1 Include more unit test/ have maximum (80%) test code coverage </br>
2 Add more automated UI testing using espresso/calabash and cucumber </br>
3 Polish/ refine the User interface to diplay weather information in a better way using coordination layouts</br>
4 Allow used to add city name in the search bar option using toolbar</br>
5 Get the location of the used by dafault, to display weather information on app launch.</br>


![image](https://ibb.co/hLOpWa)
