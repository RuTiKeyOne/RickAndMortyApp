# Description files

Here is a detailed description of the project files, this will help you better understand the architecture.

Name             |Description
:-------------------------:|:-------------------------:
build.grable  | Contains all the libraries connected to the project and necessary for correct operation.
activities | Contains all the activity of the application (except fragment activities). The activity class is an abstraction that other activities implement (for example, this is the main activity). changeTabItemListener is an interface required to create a sender-listener.
adapters | This package contains adapters. The adapter fragment controls the operation of the tab layout and tab elements used in MainActivity. recycleviewadapters contains the implementation of adapters for recycleview characters, locations and episodes.
fragment_activities |fragment_activities contains the implementation of the logic of the character fragment action, location fragment action, character fragment action.
models | Contains low-level classes (they do not contain other classes inside themselves) necessary for obtaining data and deserializing them.
network | network contains work with Retrofit and logic for getting data from the Api. To get data in this application, the RIck And Morty Api was used https://rickandmortyapi.com.
repositories |Contains the implementation of the logic of obtaining and deserializing data for each specific list (characters, locations, episodes).
response | Contains high-level classes (it contains within itself other classes (models classes)) necessary to obtain data and deserialize them.
utilities |A class with a picasso implementation and set image logic.
viewmodels | Contains the viewmodel classes needed to implement the mvvm pattern.
res | Contains markup and other resources necessary for displaying the view.
