#### Environment variables

- NODE_BINARY_PATH
- APPIUM_BINARY_PATH
- APPIUM_TESTS_APP_PLATFORM
- APPIUM_TESTS_APP_PATH
- APPIUM_TESTS_HOST
- APPIUM_TESTS_PORT
- APPIUM_LOG_PATH


#### Install appium
```
npm install -g appium
npm install -g appium-doctor
```

#### Verify appium install

```
appium-doctor --ios
appium-doctor --android
```

##### iOS:
```
git clone https://github.com/appium/sample-apps
cd sample-apps
npm install
export APPIUM_TESTS_APP_PATH=$(pwd)/node_modules/ios-uicatalog/build/Release-iphonesimulator/UICatalog-iphonesimulator.app
```
