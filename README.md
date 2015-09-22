# Open Layers 3 wrapper for Vaadin 7
## Introduction

This project provides GWT and Vaadin 7 wrappers for a subset of features in the OpenLayers 3 JavaScript api. The project is a multi module Maven project with separate modules for the GWT and Vaadin wrapper.

The GWT wrapper uses JavaScript overlays to integrate with the underlying OpenLayers JavaScript library. The api provided by the GWT wrapper is in turn utilized by the Vaadin wrapper.

As said, only a subset of the features of the OpenLayers 3 library is wrapped. It should be relatively easy to add support for more features, though.

 If you need some features that are not supported at the moment or find a bug in the wrapper, please let me know. Patches and pull requests are also very welcome.

License: Apache License 2.0

## wiki

An in-detail guide will be provided on the local wiki:
https://github.com/VOL3/v-ol3/wiki

## build v-ol3

The v-ol3 is a maven handled project. It can be build easily:
```shell
mvn clean install
```
In some cases it is usefull to give the compiler a Java version constraint:
```shell
mvn -Dmaven.compiler.source=1.6 -Dmaven.compiler.target=1.6 clean install
```

