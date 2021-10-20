# Rick and Morty app

### The Android application is a list of characters, locations and episodes of the animated series Rick and Morty written in Java using the mvvm template.

Characters page             |  Locations page | Episodes page
:-------------------------:|:-------------------------:|:-------------------------:
<img src="https://i.ibb.co/SsG0hX5/1.png" width="300"/>  |  <img src="https://i.ibb.co/2yxBpw7/2.png" width="300"/> |  <img src="https://i.ibb.co/8XLn8GL/3.png" width="300"/>

### The project consists of the following files.
<img src="https://i.ibb.co/FgQxSyW/2021-10-20-161301.png" width="300"/>

### A detailed description of the project will be presented in the table below.

Name             | Image | Description
:-------------------------:|:-------------------------:|:-------------------------:
build.grable  |  <img src="https://i.ibb.co/t4JFcPs/image.png" width="700"/> | Contains all the libraries connected to the project and necessary for correct operation.
activities | <img src="https://i.ibb.co/VmrN56Q/image.png" width="700"/> | Contains all the activity of the application (except fragment activities). The activity class is an abstraction that other activities implement (for example, this is the main activity). changeTabItemListener is an interface required to create a sender-listener.
adapters | <img src="https://i.ibb.co/r6dZTXf/2021-10-20-202357.png" width="700"/> | This package contains adapters. The adapter fragment controls the operation of the tab layout and tab elements used in MainActivity. recycleviewadapters contains the implementation of adapters for recycleview characters, locations and episodes.
fragment_activities | <img src="https://i.ibb.co/Fq9GnjQ/image.png" width="700"/> | fragment_activities contains the implementation of the logic of the character fragment action, location fragment action, character fragment action.
models | <img src="https://i.ibb.co/wdj2bYY/image.png" width="700"/> | Contains low-level classes (they do not contain other classes inside themselves) necessary for obtaining data and deserializing them.
network | <img src="https://i.ibb.co/6NFCXrL/image.png" width="700"/> | network contains work with Retrofit and logic for getting data from the Api. To get data in this application, the RIck And Morty Api was used https://rickandmortyapi.com.
repositories | <img src="https://i.ibb.co/HdLDXwD/image.png" width="700"/> | Contains the implementation of the logic of obtaining and deserializing data for each specific list (characters, locations, episodes).
response | <img src="https://i.ibb.co/CJWcWxW/image.png" width="700"/> | Contains high-level classes (it contains within itself other classes (models classes)) necessary to obtain data and deserialize them.

