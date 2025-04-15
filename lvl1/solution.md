1) Extracted the APK (using `apktool d`)

2) Decompiled it `.smali` files (it's like an Android assembly)

3) Found that in verify() it matches user input to hardcoded modified ciphered key

4) Mimicked the Java logic in `scratch.java`

5) Got output of:
```
The password is: I want to believe
```