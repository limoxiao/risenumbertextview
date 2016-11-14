# RiseNumberTextView
 
[![](https://jitpack.io/v/czy1121/risenumbertextview.svg)](https://jitpack.io/#czy1121/risenumbertextview)
 
动画数值变化的文本  
 

## Gradle

``` groovy
repositories { 
    maven { url "https://jitpack.io" }
}
```  
    
``` groovy
dependencies {
    compile 'com.github.czy1121:risenumbertextview:1.0.0'
}
```
    
## Usage
    
**XML**

``` xml 
<com.github.czy1121.view.RiseNumberTextView
    android:id="@+id/rise"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_gravity="center"
    android:text="NUMBER"
    android:textColor="#FF0000"
    android:textSize="20dp"
    app:rntPattern="0.0"
    />
``` 

**Java**

``` 
final RiseNumberTextView rise = (RiseNumberTextView) findViewById(R.id.rise);

rise.riseTo(5f);
rise.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        rise.rise(0, 9.9f);
    }
});
```

**属性**
``` 
<declare-styleable name="RiseNumberTextView">
    <!-- 显示格式，默认 0.00 -->
    <attr name="rntPattern" format="string"/>
    <!-- 动画时长，默认 1000 毫秒 -->
    <attr name="rntDuration" format="integer"/>
</declare-styleable>
```
 

## License

```
Copyright 2016 czy1121

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```