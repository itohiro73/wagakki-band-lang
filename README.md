# wagakki-band-lang

A programming language with 8 commands below that are named after members of [Wagakki Band](http://wagakkiband.jp/wagae/). This language is a deriverable of a programming language called [Brainf*ck](https://en.wikipedia.org/wiki/Brainfuck). 

|Brainf*ck command|wagakki-band-lang command|description|
|---------|-----------------|----------------|
|>|山葵|Increment the data pointer (to point to the next cell to the right).|
|<|黒流|Decrement the data pointer (to point to the next cell to the left).|
|+|いぶくろ聖志|Increment (increase by one) the byte at the data pointer.|
|-|蜷川べに|Decrement (decrease by one) the byte at the data pointer.|
|.|鈴華ゆう子|Output the byte at the data pointer.|
|,|亜沙|Accept one byte of input, storing its value in the byte at the data pointer.|
|[|神永大輔|If the byte at the data pointer is zero, then instead of moving the instruction pointer forward to the next command, jump it forward to the command after the matching ] command.|
|]|町屋|If the byte at the data pointer is nonzero, then instead of moving the instruction pointer forward to the next command, jump it back to the command after the matching [ command.|


## How to build
Bild the project with Gradle wrapper script.

Unix/Mac:
```
./gradlew build
```

Windows:
```
gradlew.bat build
```

After running the command above, archive files will be generated under build/distributions.

```
$PROJECT_DIR/build/distribution
wagakki-band-lang-0.0.1-SNAPSHOT.tar
wagakki-band-lang-0.0.1-SNAPSHOT.zip
```

Extract either file above, then you can find the file structure as below.

```
wagakki-band-lang-0.0.1-SNAPSHOT
├── bin
│   ├── wagakki-band-lang
│   └── wagakki-band-lang.bat
└── lib
    ├── eclipse-collections-7.0.0.jar
    ├── eclipse-collections-api-7.0.0.jar
    └── wagakki-band-lang-0.0.1-SNAPSHOT.jar
```

Then you can execute wagakki-band-lang as below. 

Unix/Mac:
```
bin/wagakki-band-lang source-file-path
```

Windows:
```
bin/wagakki-band-lang.bat source-file-path
```

## Program examples

### Hello World

hello_world.wgb:
```
山葵 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志
神永大輔 黒流 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 山葵
蜷川べに 町屋 黒流 鈴華ゆう子 山葵 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 
いぶくろ聖志 神永大輔 黒流 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 山葵 蜷川べに 町屋 黒流 いぶくろ聖志
鈴華ゆう子 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 鈴華ゆう子 
鈴華ゆう子 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 鈴華ゆう子 神永大輔 蜷川べに 町屋 山葵 いぶくろ聖志 いぶくろ聖志
いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 神永大輔 黒流 いぶくろ聖志 いぶくろ聖志
いぶくろ聖志 いぶくろ聖志 山葵 蜷川べに 町屋 黒流 鈴華ゆう子 山葵 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志
いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 神永大輔 黒流 いぶくろ聖志
いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 山葵 蜷川べに 町屋 黒流 鈴華ゆう子 山葵 いぶくろ聖志 いぶくろ聖志
いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 神永大輔 黒流 いぶくろ聖志 いぶくろ聖志
いぶくろ聖志 山葵 蜷川べに 町屋 黒流 鈴華ゆう子 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 鈴華ゆう子 蜷川べに 蜷川べに 
蜷川べに 蜷川べに 蜷川べに 蜷川べに 鈴華ゆう子 蜷川べに 蜷川べに 蜷川べに 蜷川べに 蜷川べに 蜷川べに 蜷川べに 蜷川べに
鈴華ゆう子 神永大輔 蜷川べに 町屋 山葵 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志
いぶくろ聖志 いぶくろ聖志 神永大輔 黒流 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 山葵 蜷川べに 町屋 黒流
いぶくろ聖志 鈴華ゆう子 神永大輔 蜷川べに 町屋 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 
いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 鈴華ゆう子 
```

Execute the program:
```
$ bin/wagakki-band-lang hello_world.wgb 
Hello World!
```

### Add 2 numeric inputs 

```add.wgb
亜沙 山葵 亜沙 山葵 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 いぶくろ聖志 神永大輔 黒流 
蜷川べに 蜷川べに 蜷川べに 蜷川べに 蜷川べに 蜷川べに 蜷川べに 蜷川べに 山葵 蜷川べに 町屋 黒流 黒流 神永大輔 
山葵 いぶくろ聖志 黒流 蜷川べに 町屋 山葵 鈴華ゆう子 
```

Execute the program:
```
$ bin/wagakki-band-lang add.wgb        
12
3              
$ bin/wagakki-band-lang add.wgb
34 
7
$ bin/wagakki-band-lang add.wgb
45 
9  
```
