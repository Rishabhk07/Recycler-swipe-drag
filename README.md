# Recycler-swipe-drag
 [ ![Download](https://api.bintray.com/packages/rishabhk07/RecyclerviewSwipeDrag/RecyclerviewSwipeDrag/images/download.svg) ](https://bintray.com/rishabhk07/RecyclerviewSwipeDrag/RecyclerviewSwipeDrag/_latestVersion)
[![Build Status](https://travis-ci.org/Rishabhk07/Recycler-swipe-drag.svg?branch=master)](https://travis-ci.org/Rishabhk07/Recycler-swipe-drag)
[![codebeat badge](https://codebeat.co/badges/e788401f-828e-4b18-a1cb-43a6ca6621f6)](https://codebeat.co/projects/github-com-rishabhk07-recycler-swipe-drag-master)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/cd69e4e6889f4c4dbe4b9600b0aa4e10)](https://www.codacy.com/app/Rishabhk07/Recycler-swipe-drag?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Rishabhk07/Recycler-swipe-drag&amp;utm_campaign=Badge_Grade)


Yet another recycler view drag and swipe library, this library provides long press drag and swipe for recycler view items, based on the awesome explanation by [Paul Burk](https://medium.com/@ipaulpro/drag-and-swipe-with-recyclerview-b9456d2b1aaf) & implemented in kotlin

# How to use 
### Include the library 
Add the following lines in your app level dependencies

```groovy
dependencies {
    compile 'me.rishabhkhanna:RecyclerviewSwipeDrag:1.2.1'
}
```

since all the android support libraries need to have a same version, you have export your projects support library version in project level `buil.gradle`, hence add these lines in your project level dependencies

```groovy
buildscript {
    ext.supportsdk_version = "25.3.1"
// here instead of 25.3.1 add your android support library version        
}
```

### Usage
 To use Recyclerview Swipe and Drag in your project, add the following lines and attach `ItemTouchHelper` with your `Recyclerview` object
   
```java
        RecyclerHelper touchHelper = new RecyclerHelper<T>(dataArrayList, (RecyclerView.Adapter) recyclerAdapter);
        touchHelper.setRecyclerItemDragEnabled(true);
        touchHelper.setRecyclerItemSwipeEnabled(true);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(touchHelper);
        itemTouchHelper.attachToRecyclerView(recyclerView);
```

 - here T is the generic, pass your arrayList model class here like String, Integer or Students
 - you have to cast your Recyclerview custom adapter in `Recyclerview.Adapter`, while passing it in RecyclerHelper
 - you can select if you want to enable your recycler view to have dragging items or swiping items or both , you can do this by passing boolean, in `touchHelper.setRecyclerItemDragEnabled(true);` or `touchHelper.setRecyclerItemSwipeEnabled(true);`, default is false for both.
 - if you want to do some tasks like storing the list in db or sending a network request after swiping or dragging the recyclerview item then you can this with these 2 callbacks
 ```java
//  callback for recyclerview item dragged from one position to other
 touchHelper.setOnDragItemListener(new OnDragListener() {
             @Override
             public void onDragItemListener(int fromPosition, int toPosition) {
                 Log.d(TAG, "onDragItemListener: callback after dragging recycler view item");
             }
         });
         
// callback for recyclerview item swiped left or right        
         touchHelper.setOnSwipeItemListener(new OnSwipeListener() {
             @Override
             public void onSwipeItemListener() {
                 Log.d(TAG, "onSwipeItemListener: callback after swiping recycler view item");
             }
         });
 ```
 
 - you can also use this library in fluid api like this
 
 ```java
        RecyclerHelper touchHelper = new RecyclerHelper<String>(dataArrayList, (RecyclerView.Adapter) recyclerAdapter);
         touchHelper
                 .setRecyclerItemDragEnabled(true)
                 .setRecyclerItemSwipeEnabled(true)
                 .setOnDragItemListener(new OnDragListener() {
                     @Override
                     public void onDragItemListener(int fromPosition, int toPosition) {
                         Log.d(TAG, "onDragItemListener: callback after dragging recycler view item");
                     }
                 })
                 .setOnSwipeItemListener(new OnSwipeListener() {
                     @Override
                     public void onSwipeItemListener() {
                         Log.d(TAG, "onSwipeItemListener: callback after swiping recycler view item");
                     }
                 });
 ```
- Example usage of library with model class for arraylist as Students
```java
        RecyclerHelper touchHelper = new RecyclerHelper<Students>(dataArrayList, (RecyclerView.Adapter) recyclerAdapter);
        touchHelper.setRecyclerItemDragEnabled(true).setOnDragItemListener(new OnDragListener() {
            @Override
            public void onDragItemListener(int fromPosition, int toPosition) {
                Log.d(TAG, "onDragItemListener: callback after dragging recycler view item");
            }
        });
        touchHelper.setRecyclerItemSwipeEnabled(true).setOnSwipeItemListener(new OnSwipeListener() {
            @Override
            public void onSwipeItemListener() {
                Log.d(TAG, "onSwipeItemListener: callback after swiping recycler view item");
            }
        });
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(touchHelper);
        itemTouchHelper.attachToRecyclerView(recyclerView);
```

# License 
This software is licensed under the Apache License V2.0 A copy can be found (here)[./LICENSE.md]