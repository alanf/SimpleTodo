# Pre-work - *SimpleTodo*

**SimpleTodo** is an android app that allows building a todo list and basic todo items management functionality including adding new items, editing and deleting an existing item.

Submitted by: **Alan Fineberg**

Time spent: **4** hours spent in total

## User Stories

The following **required** functionality is completed:

* [✓] User can **successfully add and remove items** from the todo list
* [✓] User can **tap a todo item in the list and bring up an edit screen for the todo item** and then have any changes to the text reflected in the todo list.
* [✓] User can **persist todo items** and retrieve them properly on app restart

The following **optional** features are implemented:

* [ ] Persist the todo items [into SQLite](http://guides.codepath.com/android/Persisting-Data-to-the-Device#sqlite) instead of a text file
* [ ] Improve style of the todo items in the list [using a custom adapter](http://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView)
* [ ] Add support for completion due dates for todo items (and display within listview item)
* [ ] Use a [DialogFragment](http://guides.codepath.com/android/Using-DialogFragment) instead of new Activity for editing items
* [ ] Add support for selecting the priority of each todo item (and display in listview item)
* [ ] Tweak the style improving the UI / UX, play with colors, images or backgrounds

The following **additional** features are implemented:

* [ ] List anything else that you can get done to improve the app functionality!

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='https://media.giphy.com/media/3ohk2D2kbg1JYJxjzO/giphy.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />

GIF created with GIPHY.

## Project Analysis

As part of your pre-work submission, please reflect on the app and answer the following questions below:

**Question 1:** "What are your reactions to the Android app development platform so far? Compare and contrast Android's approach to layouts and user interfaces in past platforms you've used."

**Answer:** 

My reactions to Android are contrasted below with my experience writing iOS apps using Xcode:

IDE:

Android Studio is an IDE based on IntelliJ IDEA, and far more sophisticated than Xcode when in terms of refactoring and language support, as well as project organization, stability and debug tooling. Xcode is a long-standing source of complaints from iOS engineers, and time spent in IntelliJ-based editors highlights how much room for improvement Xcode has.

Layout:

The layout editor is one area where IntelliJ does not necessarily outshine Xcode (and InterfaceBuilder). The XML editing is fine because the autocomplete works well, but Interface Builder appears more powerful and intuitive, and does not require as much programmatic setup when it comes to setting up constraints, viewing the screen in other screen sizes, and managing relationships between views and their outlets, plus `@IBDesignable` support is nice. 

`Activity`s:

I strongly prefer the flexibility of `UIViewControllers` on iOS to `Activity`s. Android seems to reinforce the "Massive View Controller" anti-pattern with weighty `Activity`s that breath life into other `Activity`s. In iOS, I would separate these responsibilities into `Coordinator` and `View Controller` objects so that view controllers would not push other view controllers. That does not seem as feasible in Android because `Activity`s are wedded to `Layout`s, although they also are expected to host application business logic. Because it's not possible to get a reference to an `Activity` object, it reduces the potential ways in which they can be used or managed, and pushes too much responsibility into a single object.

I've written a bit about app architecture, more thoughts are [here](https://medium.com/square-corner-blog/ziggurat-ios-app-architecture-b54b3f7132f0). 

Dependency Management:

Support for external dependencies through Gradle is nice, and something I'll miss when writing iOS code.

Programming Language:

Java is a perfectly fine strongly-typed language. I do enjoy writing Swift, which is less verbose and has nice support for enums and pattern matching, as well as other modern conveniences. I would be interested in learning/writing Kotlin, which I've heard is similar to Swift, plus has excellent IDE support.

**Question 2:** "Take a moment to reflect on the `ArrayAdapter` used in your pre-work. How would you describe an adapter in this context and what is its function in Android? Why do you think the adapter is important? Explain the purpose of the `convertView` in the `getView` method of the `ArrayAdapter`."

**Answer:** 

Since scrollable list views are lingua franca on mobile, it's nice to have a convenient way to map commonly-used data structures such as the `ArrayList` to reduce errors and relieve application code from managing this complexity. The equivalent on iOS is conforming to the `UITableViewDataSource` protocol.

The adapter design pattern is an intermediary API to bridge user-created objects into a form that can be easily displayed in a `ListView`. The `ArrayAdapter` uses the indices of the array to represent each row, so the object at index `0` corresponds to the first list item that is displayed.

`getView()` is invoked when a new section of the `ListView` is going to be displayed. `convertView` is an existing view that can be reconfigured with the new data, which saves memory, since only a few views need to be stored and re-used in memory, and time is saved as well, since continually creating and tearing down view objects is slow.

## Notes

The interface building instructions were a bit out of date. The grid-snapping behavior that was described therein is no longer applicable.

## License

    Copyright 2017 Alan Fineberg

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
