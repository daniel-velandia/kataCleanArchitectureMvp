# Movies-Android-Kata Part2
Movies Android kata for practice Best Practices in Android implemented by Jorge Sánchez (Xurxodev)

Kata 2

- We are here to practice Model View Presenter.
- We are going to practice pair programming.

## Considerations 

Master branch contains already solved katas, exists a branch for every kata.

## Getting started

This repository contains an Android application to show movies information:

![](/art/movies.gif)

Initial state in this branch is without presenter is ready for refactoring to mvp.

## Tasks

Your task as Android Developer is to **refactoring presentation layer to Model View Presenter**.
The recommendation for this exercise is:

  * Before starting
    1. Fork this repository and Checkout `kata-mvp-movies` branch or download zip.
    3. Execute the application, explore it manually and make yourself familiar with the code.

  * To help you get started:
    1. Identify presentation and view logic
    2. Create presenter for current view and its view abstraction.
    3. Refactoring activity or fragment for implement view abstraction
    4. Play with delay presenter response and verify not exists memory leak to rotate in loading process 
    5. Execute the app and verify that all is right
    
  * Estra task if you feel with force :)
    1. Create movies detail screen according to mvp pattern
    2. Create navigator for navigate from movies to movie
  

## Documentation

There are some links which can be useful to finish these tasks:

* [Model-View-Presenter Architecture in Android Applications](http://macoscope.com/blog/model-view-presenter-architecture-in-android-applications/)

##Developed By

* Jorge Sánchez Fernández aka [xurxodev](https://twitter.com/xurxodev)

##License


    Copyright 2017 Jorge Sánchez Fernández

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
