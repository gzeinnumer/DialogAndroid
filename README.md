<p align="center">
  <img src="https://github.com/gzeinnumer/DialogAndroid/blob/master/preview/MyLibDialog_3.png"/>
</p>

<h1 align="center">
  DialogAndroid - Easy Dialog
</h1>

<div align="center">
    <a><img src="https://img.shields.io/badge/Version-3.3.8-brightgreen.svg?style=flat"></a>
    <a><img src="https://img.shields.io/badge/ID-gzeinnumer-blue.svg?style=flat"></a>
    <a><img src="https://img.shields.io/badge/Java-Suport-green?logo=java&style=flat"></a>
    <a><img src="https://img.shields.io/badge/Kotlin-Suport-green?logo=kotlin&style=flat"></a>
    <a href="https://github.com/gzeinnumer"><img src="https://img.shields.io/github/followers/gzeinnumer?label=follow&style=social"></a>
    <br>
    <p>Simple way to use Dialog Fragment</p>
</div>

---
# Content List
* [Download](#download)
* [Feature List](#feature-list)
* [Tech stack and 3rd library](#tech-stack-and-3rd-library)
* [Usage](#usage)
* [Example Code/App](#example-codeapp)
* [Version](#version)
* [Contribution](#contribution)

---
# Download

Add maven `jitpack.io` and `dependencies` in `build.gradle (Project)` :
```gradle
// build.gradle project
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}

// build.gradle app/module
dependencies {
  ...
  implementation 'com.google.android.material:material:1.3.0'
  implementation 'com.github.gzeinnumer:DialogAndroid:version'

  implementation 'com.github.gzeinnumer:SimpleMaterialStyle:last-vesion'
  //check on https://github.com/gzeinnumer/SimpleMaterialStyle
}
```

---
# Feature List
- [x] [ConfirmDialog](#confirmdialog)
- [x] [InfoDialog](#infodialog)
- [x] [NumberPickerDialog](#numberpickerdialog)
- [x] [LoadingDialog](#loadingdialog)
- [x] [SingleDatePickerDialog](#singledatepickerdialog)
- [x] [MultiDatePickerDialog](#multidatepickerdialog)
- [x] [TimeDialog](#timeDialog)
- [x] [DebugDialog](#debugDialog)

---
# Tech stack and 3rd library
- Material.io ([docs](https://material.io/develop/android/docs/getting-started))
- agrawalsuneet/DotLoadersPack-Android ([docs](https://github.com/agrawalsuneet/DotLoadersPack-Android))
- DialogFragment ([docs](https://developer.android.com/reference/android/app/DialogFragment))

---
# Usage

**First Step**. Use `MaterialComponents` in your style :

```xml
<style name="AppTheme" parent="Theme.MaterialComponents.Light.NoActionBar">
    <!-- Customize your theme here. -->
</style>

<style name="CustomDialogStyle" parent="Theme.MaterialComponents.Light.Dialog">
    <item name="colorPrimary">@color/colorPrimary</item>
    <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
    <item name="colorAccent">@color/colorAccent</item>
    <item name="android:windowMinWidthMajor">80%</item>
    <item name="android:windowMinWidthMinor">80%</item>
    <item name="android:windowEnterAnimation">@anim/anim_in</item>
    <item name="android:windowExitAnimation">@anim/anim_out</item>
</style>
```

Add This Line to `res/color.xml`. **Important**
```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <color name="colorPrimary">#6200EE</color>
    <color name="colorPrimaryDark">#3700B3</color>
    <color name="colorAccent">#03DAC5</color>
</resources>
```

If you want to change default font, add `custom_font.ttf` to your `res` directory `res->font`.
Than add this `style` to your `style.xml`/`themes.xml`
- [**Change Default Font**](https://github.com/gzeinnumer/DialogAndroid/blob/master/README_font.md)

If you want to change default margin in dialog, add `dimens.xml` to your `res` directory `res->value->dimens.xml`.
- [**Change Default Margin**](https://github.com/gzeinnumer/DialogAndroid/blob/master/README_margin.md)


#
### ConfirmDialog
Dialog with **1 Title, 1 Content, 1 Negative Button, 1 Positive Button**.
```java
new ConfirmDialog(getSupportFragmentManager())
    .setTitle("ini title")
    .setContent("ini content")
    .onCancelPressedCallBack(new ConfirmDialog.OnCancelPressed() {
        @Override
        public void onCancelPressed() {
            Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
        }
    })
    .onOkPressedCallBack(new ConfirmDialog.OnOkPressed() {
        @Override
        public void onOkPressed() {
            Toast.makeText(MainActivity.this, "Ok", Toast.LENGTH_SHORT).show();
        }
    })
    .show();
```

or you can write code like this :

```java
ConfirmDialog dialog = new ConfirmDialog(getSupportFragmentManager())
    .setTitle("ini title")
    .setContent("ini content");

dialog.onCancelPressedCallBack(new ConfirmDialog.OnCancelPressed() {
    @Override
    public void onCancelPressed() {
        Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
    }
});

dialog.onOkPressedCallBack(new ConfirmDialog.OnOkPressed() {
    @Override
    public void onOkPressed() {
        Toast.makeText(MainActivity.this, "Ok", Toast.LENGTH_SHORT).show();
    }
});

dialog.show();
```

To enable `CanceledOnTouchOutside` :

```java
new ConfirmDialog(getSupportFragmentManager())
    .setCanceledOnTouchOutside(true)
```

#
**Preview** :

<p align="center">
  <img src="https://github.com/gzeinnumer/DialogAndroid/blob/master/preview/MyLibDialog_3.png" width="500"/>
</p>

#
#### ConfirmDialog -> Customize

<p align="center">
  <img src="https://github.com/gzeinnumer/DialogAndroid/blob/master/preview/MyLibDialog_1.png" width="500"/>
</p>

You can Customize your dialog UI. [**ReadMore**](https://github.com/gzeinnumer/DialogAndroid/blob/master/README_1.md).

---

### InfoDialog
Dialog with **1 Title, 1 Content, 1 Positif Button**.

**Code** :

```java
new InfoDialog(getSupportFragmentManager())
    .setDialogType(DialogType.DialogSuccess)
    .setTitle("ini title")
    .setContent("ini content")
    .onOkPressedCallBack(new InfoDialog.OnOkPressed() {
        @Override
        public void onOkPressed() {
            Toast.makeText(MainActivity.this, "Ok", Toast.LENGTH_SHORT).show();
        }
    })
    .show();
```

To enable `CanceledOnTouchOutside` :

```java
new InfoDialog(getSupportFragmentManager())
    .setCanceledOnTouchOutside(true)
```

To set auto Click Button Ok :

```java
new InfoDialog(getSupportFragmentManager())
    .autoDismisOnSecond(10)
```

#
**Preview** :

<p align="center">
  <img src="https://github.com/gzeinnumer/DialogAndroid/blob/master/preview/MyLibDialog_6.png" width="500"/>
</p>

#
#### InfoDialog -> Customize

<p align="center">
  <img src="https://github.com/gzeinnumer/DialogAndroid/blob/master/preview/MyLibDialog_8.png" width="500"/>
</p>

You can Customize your dialog UI. [**ReadMore**](https://github.com/gzeinnumer/DialogAndroid/blob/master/README_2.md).

---

### NumberPickerDialog

Dialog with **1 Title, 1 Content, 1 Positif Button, 1 Negatif Button, 1 EditText, 1 Add Button, 1 Substract Button**.

**Code** :

```java
new NumberPickerDialog(getSupportFragmentManager())
    .setLastValue(12)
    .setTitle("ini title")
    .setContent("ini content")
    .onOkPressedCallBack(new NumberPickerDialog.OnOkPressed() {
        @Override
        public void onOkPressed(int value) {
            Toast.makeText(MainActivity.this, "Nilai nya " + value, Toast.LENGTH_SHORT).show();
        }
    })
    .onCancelPressedCallBack(new NumberPickerDialog.OnCancelPressed() {
        @Override
        public void onCancelPressed() {
            Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
        }
    })
    .show();
```

To enable `CanceledOnTouchOutside` :

```java
new NumberPickerDialog(getSupportFragmentManager())
    .setCanceledOnTouchOutside(true)
```

#
**Preview** :

<p align="center">
  <img src="https://github.com/gzeinnumer/DialogAndroid/blob/master/preview/MyLibDialog_10.png" width="500"/>
</p>

#
#### NumberPickerDialog -> Customize

<p align="center">
  <img src="https://github.com/gzeinnumer/DialogAndroid/blob/master/preview/MyLibDialog_13.png" width="500"/>
</p>

You can Customize your dialog UI. [**ReadMore**](https://github.com/gzeinnumer/DialogAndroid/blob/master/README_3.md).

---

### LoadingDialog

Dialog with **1 Title, 1 Animation Loading** that you can use.

**Code** :

```java
LoadingDialog loadingDialog = new LoadingDialog(getSupportFragmentManager())
    .setContent("ini content");

loadingDialog.show();

loadingDialog.dismis();
```

#
**Preview** :

<p align="center">
  <img src="https://github.com/gzeinnumer/DialogAndroid/blob/master/preview/MyLibDialog_15.png" width="500"/>
</p>

#
#### LoadingDialog -> Customize

<p align="center">
  <img src="https://github.com/gzeinnumer/DialogAndroid/blob/master/preview/MyLibDialog_14.png" width="500"/>
</p>

You can Customize your dialog UI. [**ReadMore**](https://github.com/gzeinnumer/DialogAndroid/blob/master/README_4.md).

---

### SingleDatePickerDialog

Dialog with **Calender like in material.io** that you can use to pick `single` date.

**Code** :

```java
new SingleDatePickerDialog(getSupportFragmentManager())
    .setTimeZone("GMT")
    .setTitle("Pilih tanggal")
    .setSelectedToday(true)
    .setTimeFormat("dd/MM/yyyy") //pastikan polanya sama
    .setStartDate("1/08/2020") //pastikan polanya sama
    .setEndDate("31/12/2020") //pastikan polanya sama
    .onOkPressedCallBack(new SingleDatePickerDialog.OnOkPressed() {
        @Override
        public void onOkPressed(String value) {
            Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
        }
    })
    .build()
    .show();
```

- `setTimeZone()` optional . default value `GMT`.
- `setTimeFormat()` optional. default value `dd-MM-yyyy`.
- `setStartDate()` optional.
- `setEndDate()` optional.

#
**Preview** :

|<img src="https://github.com/gzeinnumer/DialogAndroid/blob/master/preview/MyLibDialog_18.png"/>|<img src="https://github.com/gzeinnumer/DialogAndroid/blob/master/preview/MyLibDialog_19.png"/>|
|--|--|

|<img src="https://github.com/gzeinnumer/DialogAndroid/blob/master/preview/MyLibDialog_20.png" width="400"/>|
|--|

#
#### SingleDatePickerDialog -> Customize

<p align="center">
  <img src="https://github.com/gzeinnumer/DialogAndroid/blob/master/preview/MyLibDialog_21.png" width="300"/>
</p>

You can Customize your dialog UI. [**ReadMore**](https://github.com/gzeinnumer/DialogAndroid/blob/master/README_5.md).

---

### MultiDatePickerDialog

Dialog with **Calender like in material.io** that you can use to pick date with range.

**Code** :

```java
new MultiDatePickerDialog(getSupportFragmentManager())
    .setTimeZone("GMT")
    .setTitle("Pilih tanggal")
    .setTimeFormat("dd/MM/yyyy") //pastikan 3 pola ini sama
    .setStartDate("1/08/2020") //pastikan 3 pola ini sama
    .setEndDate("31/12/2020") //pastikan 3 pola ini sama
    .onOkPressedCallBack(new MultiDatePickerDialog.OnOkPressed() {
        @Override
        public void onOkPressed(String firstDate, String secondDate) {
            Toast.makeText(MainActivity.this, firstDate + " - " + secondDate, Toast.LENGTH_SHORT).show();
        }
    })
    .build()
    .show();
```

- `setTimeZone()` optional . default value `GMT`.
- `setTimeFormat()` optional. default value `dd-MM-yyyy`.
- `setStartDate()` optional.
- `setEndDate()` optional.

#
**Preview** :

|<img src="https://github.com/gzeinnumer/DialogAndroid/blob/master/preview/MyLibDialog_22.png"/>|<img src="https://github.com/gzeinnumer/DialogAndroid/blob/master/preview/MyLibDialog_23.png"/>|
|--|--|

|<img src="https://github.com/gzeinnumer/DialogAndroid/blob/master/preview/MyLibDialog_24.png" width="400"/>|
|--|

#
#### MultiDataPickerDialog -> Customize

<p align="center">
  <img src="https://github.com/gzeinnumer/DialogAndroid/blob/master/preview/MyLibDialog_25.png" width="300"/>
</p>

You can Customize your dialog UI. [**ReadMore**](https://github.com/gzeinnumer/DialogAndroid/blob/master/README_6.md).

---

### TimeDialog

Dialog with **Calender like in material.io** that you can use to pick date with range.

**Code** :

```java
new TimeDialog(getSupportFragmentManager())
        .setTitle("Time")
        .setHour(17)
        .setMinute(17)
        .setTimeFormat(TimeFormat.CLOCK_24H) //TimeFormat.CLOCK_12H
        .addOnPositiveButtonClickListener(new TimeDialogPositiveCallBack() {
            @Override
            public void timeResult(int hours, int minutes) {
                Toast.makeText(MainActivity.this, hours+":"+minutes, Toast.LENGTH_SHORT).show();
            }
        })
        .build()
        .show();
```

- `setTitle()` optional . default value `Pick Time`.
- `setHour()` optional. default value `0`.
- `setMinute()` optional. default value `0`.
- `setTimeFormat()` optional. default value `TimeFormat.CLOCK_12H`.

#
**Preview** :

|<img src="https://github.com/gzeinnumer/DialogAndroid/blob/master/preview/MyLibDialog_30.jpg" width="400"/>|<img src="https://github.com/gzeinnumer/DialogAndroid/blob/master/preview/MyLibDialog_31.jpg" width="400"/>|
|--|--|
|`TimeFormat.CLOCK_12H`|`TimeFormat.CLOCK_24H`|

---

### DebugDialog
Dialog for debug.

**Code** :

```java
new DebugDialog(getSupportFragmentManager())
    .setAnimationStyle(R.style.CustomDialogStyle)
    .setContent(DumpJSON.msg1)
    .onOkPressedCallBack(() -> {
        //ok action
    })
    .show();
```

---
# Example Code/App

[Sample Code And App](https://github.com/gzeinnumer/MyLibDialogExample)

---
# Version
- **1.0.5**
  - First Release
- **1.0.6**
  - Add Custom Animation
- **1.0.7**
  - SetDefault Animation
- **1.0.9**
  - Fix Animation
- **2.0.0**
  - Enable or disable TextAllCaps
- **2.0.1**
  - Bugs Fixing
- **2.0.2**
  - add enable `CanceledOnTouchOutside`
- **2.0.3**
  - Bugs Fixing Style
- **2.0.4**
  - Color
- **2.1.1**
  - Add Auto Click
- **2.1.2**
  - Bug Fixing
- **2.1.5**
  - Bug Fixing
- **2.1.6**
  - Bug Fixing
- **2.1.9**
  - Bug Fixing
- **2.2.1**
  - Bug Fixing
- **2.2.2**
  - Change color method
- **3.0.0**
  - Support SDK 16
- **3.1.0**
  - Spesial Button Color Contained
- **3.1.1**
  - More Space Button Parent
- **3.2.0**
  - Time Picker
- **3.2.1**
  - Bug Fixing
- **3.2.2**
  - Bug Fixing
- **3.2.3**
  - Bug Fixing
- **3.2.4**
  - Remove Default Animation and Color
- **3.2.5**
  - Bug Color
- **3.2.6**
  - Bug Color
- **3.2.7**
  - Bug Color
- **3.2.8**
  - Bug Fixing
- **3.2.9**
  - Bug Fixing
- **3.3.0**
  - Remove Space From Button
- **3.3.1**
  - Add CharSequence to Title and Content
- **3.3.2**
  - Improve Space Between TextButton
- **3.3.3**
  - Spesial For Debug Dialog
- **3.3.4**
  - New Space
- **3.3.5**
  - Space
- **3.3.7**
  - Copy Text From DebugDialog
- **3.3.8**
  - Remove Dot

---
# Contribution

You can sent your constibution to `branch` `open-pull`.

---

```
Copyright 2020 M. Fadli Zein
```
