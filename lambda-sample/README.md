
# Java-Lambda-Sample

## 概要

* Java-lambdaを理解するために作成したサンプルコード用プロジェクトです
* 実際に実行、場合に応じてコード改変を行い挙動を確認してみてください
* 基本的な部分を確認したい場合は以下も参考にして下さい
  * [lambda式について](doc/lambda-guide.md)

## 実行方法について

ルートプロジェクト直下(java-sample-code)にて以下コマンドを入力してください  
(もちろんIDEを通しての実行でもOK)  

その際、実行時引数にて実行したいLambdaサンプルの区分値を指定すること

※ 引数を指定せずに実行する場合は[こちら](doc/lambda-execution-change.md)を参照のこと

```
"1"を指定: Runnable型ラムダサンプル(引数なし 戻り値なし)
"2"を指定: Consumer型ラムダサンプル(引数あり 戻り値なし)
"3"を指定: Supplier型ラムダサンプル(引数なし 戻り値あり)
"4"を指定: Function型ラムダサンプル(引数あり 戻り値あり)
```

* gradleコマンドがインストール済みである場合
```
gradle lambda-sample:run --args="1"
```

* gradleコマンドがインストール済みでない場合
```
[mac/Linux]
./gradlew lambda-sample:run --args="1"

[windows]
./gradlew.bat lambda-sample:run --args="1" 
```
